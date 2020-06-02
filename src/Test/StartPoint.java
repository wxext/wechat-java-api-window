package Test;

import Lin.Wechat.WXBot.Global;
import Lin.Wechat.WXBot.WXBot;
import Test.Listener.MessageHandler;

public class StartPoint {
	public static void main(String[] arg) throws Exception {
		int numWxOpen = 2;
		for (int i = 0; i < numWxOpen; i++)
			Global.login.Add(new WXBot().setMsgHandler(new MessageHandler()));
		Global.login.run();
	}
}
