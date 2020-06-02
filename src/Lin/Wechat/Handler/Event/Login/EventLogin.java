package Lin.Wechat.Handler.Event.Login;

import Lin.Wechat.WXBot.WXBot;
import cn.hutool.json.JSONObject;

public class EventLogin {
	public EventLogin(JSONObject json, WXBot bot) {
		System.out.println("µÇÂ½³É¹¦ ...");
		//bot.getInfo().getJf().dispose();
		String wxid = new JSONObject(json.getStr("data")).getStr("wxid");
		bot.getInfo().setWxid(wxid);
		new ExtendsExpireDate(bot).start();;
	}
}