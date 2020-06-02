package Lin.Wechat.Sender.Command;

import java.util.HashMap;

import Lin.Wechat.Sender.Sender;
import Lin.Wechat.WXBot.WXBot;
import cn.hutool.json.JSONObject;

public class WechatOpener extends Sender{
	public WechatOpener(WXBot bot) {
		super(bot);
	}

	public JSONObject send(int pid) {
		System.out.print(pid == -1 ? "打开一个WX" : "获取pid " + pid + "\n");
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "run");
		map.put("pid", pid);
		return send(map);
	}
}