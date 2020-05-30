package Lin.Wechat.Handler.Event.Login;

import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import Lin.Wechat.Sender.XTAuth;
import Lin.Wechat.Sender.XTMAC;
import Lin.Wechat.WXBot.WXBot;
import cn.hutool.json.JSONObject;

public class EventLogin {
	@SuppressWarnings("deprecation")
	public EventLogin(JSONObject json, WXBot bot) {
		System.out.println("登陆成功  QR自动删除中...");
		bot.getInfo().getJf().dispose();
		String data = new XTMAC(null).send().getStr("data");
		String wxid = new JSONObject(json.getStr("data")).getStr("wxid");
		String url = "https://api.wxext.cn/auth?";
		url += "wxid=" + wxid;
		url += "&";
		url += "data=" + URLEncoder.encode(data);
		JSONObject authResult = new XTAuth(null).send(url);
		bot.getInfo().setAuthDate(authResult.getDate("auth"));
		bot.getInfo().setExpireDate(authResult.getDate("expire"));
		bot.getInfo().setNickName(authResult.getStr("nickName"));

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String str = "获取信息 " + " Auth:";
		str += df.format(bot.getInfo().getAuthDate());
		str += " Expire:";
		str += df.format(bot.getInfo().getExpireDate());
		System.out.println(str);
		System.out.println(json.toString());
		
		//System.out.println(new WechatAddFriend("igggggg","你好 请求添加好友").send().toString());
	}
}