package Lin.Wechat.Sender.Command;

import java.util.HashMap;

import Lin.Wechat.Sender.Sender;
import Lin.Wechat.WXBot.WXBot;
import cn.hutool.json.JSONObject;

public class WechatOpener extends Sender{
	public WechatOpener(WXBot bot) {
		super(bot);
	}

	public JSONObject send(boolean isNew) {
		System.out.println("打开一个WX");
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "run");
		map.put("pid", (isNew ? -1 : 0));
		return send(map);
	}
}