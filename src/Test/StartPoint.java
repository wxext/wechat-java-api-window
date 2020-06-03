package Test;

import Lin.Wechat.WXBot.Global;
import Lin.Wechat.WXBot.WXBot;
import Test.Listener.MessageHandler;

public class StartPoint {
	public static void main(String[] arg) throws Exception {
		// Global.java is a config file for the global setting
		Global.setupPushEventServer();
		int numWxOpen = 1;
		for (int i = 0; i < numWxOpen; i++)
			Global.login.Add(new WXBot().setMsgHandler(new MessageHandler()));
		Global.login.run();
	}
}
