package Lin.Wechat.Handler.Event.Login;

import Lin.ExtraFunction.QRCode;
import Lin.Wechat.WXBot.Global;
import Lin.Wechat.WXBot.WXBot;
import cn.hutool.json.JSONObject;

public class EventGetQrCode {

	public boolean result(JSONObject json, WXBot bot) {
		if (json == null) return false;
		String data = json.getStr("data");
		String qr = new JSONObject(data).get("qr").toString();
		try {
			if (bot.getInfo().getJf() != null) bot.getInfo().getJf().dispose();
			bot.getInfo().setJf(new QRCode().show("http://weixin.qq.com/x/" + qr, Global.QRPath));
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}