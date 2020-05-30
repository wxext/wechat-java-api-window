package Lin.Wechat.Sender.Command;

import java.util.HashMap;

import Lin.Wechat.Sender.Sender;
import Lin.Wechat.WXBot.WXBot;
import cn.hutool.json.JSONObject;

public class WechatLoginQR extends Sender{
	public WechatLoginQR(WXBot bot) {
		super(bot);
	}

	public JSONObject send() {
		System.out.println("动态二维码生成");
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "gotoQr");
		map.put("pid", getBot().getInfo().getPid());
		return send(map);
	}
}