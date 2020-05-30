package Lin.Wechat.Handler.Event.Login;

import Lin.Wechat.QRCode.QRCode;
import Lin.Wechat.WXBot.WXBot;
import cn.hutool.json.JSONObject;

public class EventGetQrCode {
	public EventGetQrCode(JSONObject json, WXBot bot) {
		String data = json.getStr("data");
		System.out.println(data);
		String qr = new JSONObject(data).get("qr").toString();
		try {
			if (bot.getInfo().getJf() != null) bot.getInfo().getJf().dispose();
			bot.getInfo().setJf(new QRCode().show("http://weixin.qq.com/x/" + qr, bot.getInfo().getQRPath()));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}