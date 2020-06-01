package Lin.Wechat.Handler;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.IOUtils;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.vdurmont.emoji.EmojiParser;

import Lin.Wechat.Handler.Event.Interface.Event;
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
		String response = EmojiParser
				.parseToAliases(IOUtils.toString(new InputStreamReader(exchange.getRequestBody(), "UTF-8")));
		//System.out.println(alias);
		// 打印接收回来的json
		//System.out.println(response);
		JSONObject rep = new JSONObject(response);
		if (bot.getInfo().getPid() != rep.getInt("pid")) {
			// System.out.println("PID incorrect");
			return;
		}
		Event event = new Event(rep, bot);
		switch (rep.getInt("type")) {
		case 1:
			// 文本消息;
			bot.getMsgHandler().onTextMessage(event);
			break;
		case 3:
			// 图片消息;
			bot.getMsgHandler().onImgMessage(event);
			break;
		case 34:
			// 语音消息;
			bot.getMsgHandler().onVoiceMessage(event);
			break;
		case 37:
			// 好友确认消息;
			bot.getMsgHandler().onFriendMessage(event);
			break;
		case 43:
			// 视频消息;
			bot.getMsgHandler().onVideoMessage(event);
			break;
		case 47:
			// 动画表情;
			bot.getMsgHandler().onEmotionMessage(event);
			break;
		case 48:
			// 位置消息;
			bot.getMsgHandler().onLocationMessage(event);
			break;
		case 49:
			// 分享链接;
			bot.getMsgHandler().onLinkShareMessage(event);
			break;
		case 701:
			// 群成员信息更新;
			bot.getMsgHandler().onGroupMemberInfoUpdateMessage(event);
			break;
		case 702:
			// 群成员增加;
			bot.getMsgHandler().onGroupMemberIncreaseMessage(event);
			break;
		case 703:
			// 群成员减少;
			bot.getMsgHandler().onGroupMemberDecreaseMessage(event);
			break;
		case 704:
			// 联系人信息更新;
			bot.getMsgHandler().onFriendInfoUpdateMessage(event);
			break;
		case 705:
			// 收款结果;
			bot.getMsgHandler().onReceivePaymentMessage(event);
			break;
		case 706:
			// 好友验证结果;
			bot.getMsgHandler().onFriendAuthMessage(event);
			break;
		case 707:
			// 创建群聊结果;
			bot.getMsgHandler().onCreateGroupMessage(event);
			break;
		case 708:
			// xml图片地址;
			bot.getMsgHandler().onXMLImgPathMessage(event);
			break;
		case 720:
			// 登录信息-授权;
			new EventLoginAuth(rep, bot);
			break;
		case 721:
			// 登录信息-连接;
			String qrRequestResult;
			do {
				qrRequestResult = new WechatLoginQR(bot).send().getStr("msg");
				// System.out.println("MSG " + str);
			} while (qrRequestResult.equals("get fail") || qrRequestResult.equals("InitWaiting"));
			break;
		case 723:
			// 登录信息-登录二维码变化;
			new EventGetQrCode().result(rep, bot);
			break;
		case 724:
			// 登录信息-微信登录;
			new EventLogin(rep, bot);
			break;
		case 725:
			// 登录信息-微信退出;
			// System.exit(0);
			break;
		case 726:
			// 发起语音通过;
			bot.getMsgHandler().onVoiceCallMessage(event);
			break;
		case 727:
			// 拒绝语音通话;
			bot.getMsgHandler().onVoiceCallRejectMessage(event);
			break;
		case 728:
			// 接受语音通话;
			bot.getMsgHandler().onVoiceCallAcceptMessage(event);
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
			bot.getMsgHandler().onSystemMessage(event);
			break;
		}
	}
}