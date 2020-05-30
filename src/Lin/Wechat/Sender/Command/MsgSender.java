package Lin.Wechat.Sender.Command;

import java.util.HashMap;

import Lin.Wechat.Sender.Sender;
import Lin.Wechat.WXBot.WXBot;
import cn.hutool.json.JSONObject;

public class MsgSender extends Sender{
	public MsgSender(WXBot bot) {
		super(bot);
	}

	public JSONObject send(String to, String msg, String at) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "sendText");
		map.put("wxid", to);
		map.put("msg", msg);
		map.put("atid", at);
		map.put("pid", getBot().getInfo().getPid());
		return send(map);
	}
}