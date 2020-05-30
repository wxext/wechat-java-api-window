package Lin.Wechat.Sender.Command;

import java.util.HashMap;

import Lin.Wechat.Sender.Sender;
import cn.hutool.json.JSONObject;

public class WechatAddFriend extends Sender{
	String wxid, msg;
	public WechatAddFriend(String wxid, String msg) {
		super(null);
		this.wxid = wxid;
		this.msg = msg;
	}

	public JSONObject send() {

		HashMap<Object, Object> map1 = new HashMap<>();
		map1.put("method", "netUpdateUser");
		map1.put("wxid", wxid);
		map1.put("pid", 0);
		System.out.println(send(map1).toString());
		
		System.out.println("发送添加好友请求给WXID " + wxid);
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "addUser");
		map.put("wxid", wxid);
		map.put("msg", msg);
		map.put("pid", getBot().getInfo().getPid());
		System.out.println(send(map).toString());
		return send(map);
	}
}