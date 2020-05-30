package Lin.Wechat.Sender.Command;

import java.util.HashMap;

import Lin.Wechat.Sender.Sender;
import Lin.Wechat.WXBot.WXBot;
import cn.hutool.json.JSONObject;

public class WechatSharker extends Sender{
	public WechatSharker(WXBot bot) {
		super(bot);
	}

	public JSONObject send() {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "show");
		map.put("pid", getBot().getInfo().getPid());
		return send(map);
	}
}