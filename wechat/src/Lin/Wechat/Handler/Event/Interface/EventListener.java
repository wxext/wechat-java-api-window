package Lin.Wechat.Handler.Event.Interface;

import Lin.Wechat.WXBot.WXBot;
import cn.hutool.json.JSONObject;

public interface EventListener{
	public void process(JSONObject result, WXBot bot);
}