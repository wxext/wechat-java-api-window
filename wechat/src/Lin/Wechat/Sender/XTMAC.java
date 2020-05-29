package Lin.Wechat.Sender;

import java.util.HashMap;

import Lin.Wechat.WXBot.WXBot;
import cn.hutool.json.JSONObject;

public class XTMAC extends Sender{
	public XTMAC(WXBot bot) {
		super(bot);
	}

	public JSONObject send() {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "mac");
		return send(map);
	}
}