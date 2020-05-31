package Lin.Wechat.Handler.Event.Interface;

import java.util.HashMap;

import Lin.Wechat.Sender.Sender;
import Lin.Wechat.WXBot.WXBot;
import cn.hutool.json.JSONObject;
import lombok.Getter;

@Getter
public class Event {
	JSONObject result;
	WXBot bot;

	public Event(JSONObject result, WXBot bot) {
		this.result = result;
		this.bot = bot;
	}

	public JSONObject sendTextMessage(String to_wxid, String msg, String at) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "sendText");
		map.put("wxid", to_wxid);
		map.put("msg", msg);
		map.put("atid", at);
		map.put("pid", getBot().getInfo().getPid());
		return new Sender(bot).send(map);
	}

	public JSONObject sendImgMessage(String to_wxid, String img_path, boolean isLocalFile) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "sendImage");
		map.put("wxid", to_wxid);
		map.put("img", img_path);
		map.put("imgType", isLocalFile ? "file" : "url");
		map.put("pid", getBot().getInfo().getPid());
		return new Sender(bot).send(map);
	}

	public JSONObject forwardEmotion(String to_wxid, Event event) {
		int type = event.getResult().getInt("type");
		if (type != 47) {
			System.out.println("you can only forward the message if type is equals 47");
			return null;
		}
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "sendEmojiForward");
		map.put("wxid", to_wxid);
		map.put("xml", event.getResult().getJSONObject("data").getStr("msg"));
		map.put("pid", getBot().getInfo().getPid());
		return new Sender(bot).send(map);
	}

	public JSONObject forwardMiniApp(String to_wxid, Event event) {
		int type = event.getResult().getInt("type");
		if (type != 49) {
			System.out.println("you can only forward the message if type is equals 49");
			return null;
		}
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "sendAppmsgForward");
		map.put("wxid", to_wxid);
		map.put("xml", event.getResult().getJSONObject("data").getStr("msg"));
		map.put("pid", getBot().getInfo().getPid());
		return new Sender(bot).send(map);
	}

	public JSONObject sendVoiceCall(String friend_wxid) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "callVoipAudio");
		map.put("wxid", friend_wxid);
		map.put("pid", getBot().getInfo().getPid());
		return new Sender(bot).send(map);
	}

	public JSONObject setGroupAnnouncement(String group_wxid, String msg) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "setRoomAnnouncement");
		map.put("wxid", group_wxid);
		map.put("msg", msg);
		map.put("pid", getBot().getInfo().getPid());
		return new Sender(bot).send(map);
	}

	public JSONObject setRemark(String friend_wxid, String msg) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "setRemark");
		map.put("wxid", friend_wxid);
		map.put("msg", msg);
		map.put("pid", getBot().getInfo().getPid());
		return new Sender(bot).send(map);
	}

	public JSONObject addGroupMember(String group_wxid, String friend_wxid) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "addGroupMember");
		map.put("wxid", group_wxid);
		map.put("msg", friend_wxid);
		map.put("pid", getBot().getInfo().getPid());
		return new Sender(bot).send(map);
	}

	public JSONObject delGroupMember(String group_wxid, String friend_wxid) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "delRoomMember");
		map.put("wxid", group_wxid);
		map.put("msg", friend_wxid);
		map.put("pid", getBot().getInfo().getPid());
		return new Sender(bot).send(map);
	}

	public JSONObject setGroupName(String group_wxid, String msg) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "setRoomName");
		map.put("wxid", group_wxid);
		map.put("msg", msg);
		map.put("pid", getBot().getInfo().getPid());
		return new Sender(bot).send(map);
	}

	public JSONObject quitGroup(String group_wxid) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "quitChatRoom");
		map.put("wxid", group_wxid);
		map.put("pid", getBot().getInfo().getPid());
		return new Sender(bot).send(map);
	}

	public JSONObject sendGroupInvite(String group_wxid, String friend_wxid) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "sendGroupInvite");
		map.put("wxid", group_wxid);
		map.put("msg", friend_wxid);
		map.put("pid", getBot().getInfo().getPid());
		return new Sender(bot).send(map);
	}

	public JSONObject getUserImg(String user_wxid) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "getUserImg");
		map.put("wxid", user_wxid);
		map.put("pid", getBot().getInfo().getPid());
		return new Sender(bot).send(map);
	}
	
	public JSONObject sendFriendCard(String to_wxid, String user_id) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "sendCard");
		map.put("wxid", to_wxid);
		map.put("userid", user_id);
		map.put("pid", getBot().getInfo().getPid());
		return new Sender(bot).send(map);
	}

	private JSONObject userUpdate(String user_wxid) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "netUpdateUser");
		map.put("wxid", user_wxid);
		map.put("pid", getBot().getInfo().getPid());
		return new Sender(bot).send(map);		
	}
	public JSONObject getUserInfo(String user_wxid) {
		System.out.println(userUpdate(user_wxid).toString());
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "getUserInfo");
		map.put("wxid", user_wxid);
		map.put("pid", getBot().getInfo().getPid());
		return new Sender(bot).send(map);
	}

	public JSONObject createGroup(String members[]) {
		if (members.length < 2) {
			System.out.println("at lease 2 or more friends to create group");
			return null;
		}
		String users = "";
		for (String tmp : members) {
			users += tmp + "|";
		}
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "createRoom");
		map.put("msg", users.substring(0, users.length() - 1));
		map.put("pid", getBot().getInfo().getPid());
		return new Sender(bot).send(map);
	}

	public JSONObject addFriendByWXID(String user_wxid, String msg) {
		System.out.println(getUserInfo(user_wxid).toString());

		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "addUser");
		map.put("wxid", user_wxid);
		map.put("msg", msg);
		map.put("pid", getBot().getInfo().getPid());
		return new Sender(bot).send(map);
	}
}

