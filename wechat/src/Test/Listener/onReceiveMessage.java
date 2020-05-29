package Test.Listener;

import Lin.Wechat.Handler.Event.Interface.TextMsgEventListener;
import Lin.Wechat.WXBot.WXBot;
import cn.hutool.json.JSONObject;

public class onReceiveMessage implements TextMsgEventListener{

	@Override
	public void process(JSONObject result, WXBot bot) {
		System.out.println("LISTENER SUCCESS");
		System.out.println(result.toString());
	}
	
}