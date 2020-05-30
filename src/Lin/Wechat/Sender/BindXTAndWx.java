package Lin.Wechat.Sender;

import java.util.HashMap;

import Lin.Wechat.WXBot.WXBot;
import cn.hutool.json.JSONObject;

public class BindXTAndWx extends Sender{
	public BindXTAndWx(WXBot bot) {
		super(bot);
	}

	public JSONObject send() {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "auth");
		map.put("token", bot.getToken());
		map.put("pid", bot.getInfo().getPid());
		JSONObject result = send(map);
		return result;
	}
}