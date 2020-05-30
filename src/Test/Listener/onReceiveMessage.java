package Test.Listener;

import Lin.Wechat.Handler.Event.Interface.EventListener;
import Lin.Wechat.WXBot.WXBot;
import cn.hutool.json.JSONObject;

public class onReceiveMessage implements EventListener{
	@Override
	public void process(JSONObject result, WXBot bot) {
		System.out.println("LISTENER SUCCESS");
		System.out.println(result.toString());
	}	
}