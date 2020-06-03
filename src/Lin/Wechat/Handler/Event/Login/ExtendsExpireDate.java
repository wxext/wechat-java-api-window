package Lin.Wechat.Handler.Event.Login;

import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import Lin.Wechat.Sender.BindXTAndWx;
import Lin.Wechat.Sender.XTAuth;
import Lin.Wechat.WXBot.Global;
import Lin.Wechat.WXBot.WXBot;
import cn.hutool.json.JSONObject;

public class ExtendsExpireDate extends Thread {
	WXBot bot;

	public ExtendsExpireDate(WXBot bot) {
		this.bot = bot;
	}

	@SuppressWarnings("deprecation")
	public void run() {
		String url = "https://api.wxext.cn/auth?";
		url += "wxid=" + bot.getInfo().getWxid();
		url += "&";
		url += "data=" + URLEncoder.encode(bot.getInfo().getMac());
		//System.out.println(url);
		JSONObject authResult = new XTAuth(bot).send(url);
		bot.getInfo().setAuthDate(authResult.getDate("auth"));
		bot.getInfo().setExpireDate(authResult.getDate("expire"));
		bot.getInfo().setNickName(authResult.getStr("nickName"));
		bot.setToken(authResult.getStr("token"));
		//System.out.println(bot.getToken());
		//System.out.println(new BindXTAndWx(bot).send());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String str = "获取信息 " + " Auth:";
		str += df.format(bot.getInfo().getAuthDate());
		str += " Expire:";
		str += df.format(bot.getInfo().getExpireDate());
		System.out.println(str);
		if (!bot.getInfo().isLogin())
			Global.login.run();
		bot.getInfo().setLogin(true);
		long sleep = bot.getInfo().getExpireDate().getTime() - bot.getInfo().getAuthDate().getTime() - 3600 * 1000;
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
		}
		new ExtendsExpireDate(bot);
	}
}
