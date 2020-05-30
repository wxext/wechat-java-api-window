package Lin.Wechat.WXBot;

import java.net.InetSocketAddress;
import com.sun.net.httpserver.*;

import Lin.Wechat.Handler.WXMsgHandler;
import Lin.Wechat.Handler.Event.Interface.EventListener;
import Lin.Wechat.Handler.Event.Login.EventGetQrCode;
import Lin.Wechat.Sender.XTMAC;
import Lin.Wechat.Sender.Command.WechatLoginQR;
import Lin.Wechat.Sender.Command.WechatOpener;
import cn.hutool.json.JSONObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WXBot {
	//小天Token
	String token;
	// 文本消息
	EventListener textMsgEventListener;
	// 图片消息
	EventListener imgMsgEventListener;
	// 语音消息
	EventListener voiceMsgEventListener;
	// 好友确认消息
	EventListener friendConfirmEventListener;
	// 视频消息
	EventListener videoMsgEventListener;
	// 动画表情
	EventListener animationImgEventListener;
	// 位置消息
	EventListener locationMsgEventListener;
	// 分享链接
	EventListener shareLinkEventListener;
	// 群成员信息更新
	EventListener groupMemberInfoUpdateEventListener;
	// 群成员增加
	EventListener groupMemberIncreaseEventListener;
	// 群成员减少
	EventListener groupMemberDecreaseEventListener;
	// 联系人信息更新
	EventListener friendInfoUpdateEventListener;
	// 收款结果
	EventListener receivePaymentEventListener;
	// 好友验证结果
	EventListener friendAuthEventListener;
	// 创建群聊结果
	EventListener createGroupEventListener;
	// xml图片地址
	EventListener XMLImgPathEventListener;
	// 登录信息-授权
	// 登录信息-连接
	// 登录信息-登录二维码变化
	// 登录信息-微信登录
	// 登录信息-微信退出
	// 发起语音通过
	EventListener voiceCallEventListener;
	// 拒绝语音通话
	EventListener voiceCallRejectEventListener;
	// 接受语音通话
	EventListener voiceCallAcceptEventListener;
	// 插件连接断开
	// 微信连接断开
	// 系统提示点击确定
	// 系统消息
	BotInfo info = new BotInfo();

	public WXBot(int port) {
		info.setPort(port);
	}

	public WXBot run() throws Exception {
		HttpServer server = HttpServer.create(new InetSocketAddress(info.getPort()), 0);
		// 定义WXMsgHandler为接收消息的处理器
		server.createContext("/", new WXMsgHandler(this));
		// 开启服务器
		server.start();
		JSONObject wxOpenResult = new WechatOpener(this).send(true);
		// 如果已经启动 获取登陆QR code
		if (wxOpenResult.getInt("pid") == 0) {
			int pid = Integer.parseInt(wxOpenResult.getStr("msg").replace("微信[", "").replace("]已经运行过了", ""));
			info.setPid(pid);
			while(new WechatLoginQR(this).send().getStr("msg").equals("get fail"));
		} else {
			info.setPid(wxOpenResult.getInt("pid"));
		}
		String data = new XTMAC(this).send().getStr("data");
		this.info.setMac(data);
		return this;
	}
}
