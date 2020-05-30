package Lin.Wechat.Handler;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.IOUtils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import Lin.Wechat.Handler.Event.Login.EventGetQrCode;
import Lin.Wechat.Handler.Event.Login.EventLogin;
import Lin.Wechat.Handler.Event.Login.EventLoginAuth;
import Lin.Wechat.Sender.Command.WechatLoginQR;
import Lin.Wechat.WXBot.WXBot;
import cn.hutool.json.JSONObject;

public class WXMsgHandler implements HttpHandler {
	WXBot bot;

	public WXMsgHandler(WXBot bot) {
		this.bot = bot;
	}

	public void handle(HttpExchange exchange) throws UnsupportedEncodingException, IOException {
		// 接收来自e小天的推送
		String response = IOUtils.toString(new InputStreamReader(exchange.getRequestBody(), "UTF-8"));
		// 打印接收回来的json
		//System.out.println(response);
		JSONObject rep = new JSONObject(response);
		switch (rep.getInt("type")) {
		case 1:
			// 文本消息;
			bot.getInfo().getTextMsgEventListener().process(rep, bot);
			break;
		case 3:
			// 图片消息;
			bot.getInfo().getImgMsgEventListener().process(rep, bot);
			break;
		case 34:
			// 语音消息;
			bot.getInfo().getVoiceMsgEventListener().process(rep, bot);
			break;
		case 37:
			// 好友确认消息;
			bot.getInfo().getFriendConfirmEventListener().process(rep, bot);
			break;
		case 43:
			// 视频消息;
			bot.getInfo().getVideoMsgEventListener().process(rep, bot);
			break;
		case 47:
			// 动画表情;
			bot.getInfo().getAnimationImgEventListener().process(rep, bot);
			break;
		case 48:
			// 位置消息;
			bot.getInfo().getLocationMsgEventListener().process(rep, bot);
			break;
		case 49:
			// 分享链接;
			bot.getInfo().getShareLinkEventListener().process(rep, bot);
			break;
		case 701:
			// 群成员信息更新;
			bot.getInfo().getGroupMemberInfoUpdateEventListener().process(rep, bot);
			break;
		case 702:
			// 群成员增加;
			bot.getInfo().getGroupMemberIncreaseEventListener().process(rep, bot);
			break;
		case 703:
			// 群成员减少;
			bot.getInfo().getGroupMemberDecreaseEventListener().process(rep, bot);
			break;
		case 704:
			// 联系人信息更新;
			bot.getInfo().getFriendInfoUpdateEventListener().process(rep, bot);
			break;
		case 705:
			// 收款结果;
			bot.getInfo().getReceivePaymentEventListener().process(rep, bot);
			break;
		case 706:
			// 好友验证结果;
			bot.getInfo().getFriendAuthEventListener().process(rep, bot);
			break;
		case 707:
			// 创建群聊结果;
			bot.getInfo().getCreateGroupEventListener().process(rep, bot);
			break;
		case 708:
			// xml图片地址;
			bot.getInfo().getXMLImgPathEventListener().process(rep, bot);
			break;
		case 720:
			// 登录信息-授权;
			new EventLoginAuth(rep, bot);
			break;
		case 721:
			// 登录信息-连接;
			new EventGetQrCode(new WechatLoginQR(bot).send(), bot);
			break;
		case 723:
			// 登录信息-登录二维码变化;
			new EventGetQrCode(rep, bot);
			break;
		case 724:
			// 登录信息-微信登录;
			new EventLogin(rep, bot);
			break;
		case 725:
			// 登录信息-微信退出;
			System.exit(0);
			break;
		case 726:
			// 发起语音通过;
			bot.getInfo().getVoiceCallEventListener().process(rep, bot);
			break;
		case 727:
			// 拒绝语音通话;
			bot.getInfo().getVoiceCallRejectEventListener().process(rep, bot);
			break;
		case 728:
			// 接受语音通话;
			bot.getInfo().getVoiceCallAcceptEventListener().process(rep, bot);
			break;
		case 802:
			// 插件连接断开;
			break;
		case 803:
			// 微信连接断开;
			break;
		case 810:
			// 系统提示点击确定;
			break;
		case 10000:
			// 系统消息;
			break;
		}
	}
}