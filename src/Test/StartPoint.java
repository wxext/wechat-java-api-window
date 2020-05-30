package Test;

import Lin.Wechat.WXBot.WXBot;
import Test.Listener.onReceiveMessage;

public class StartPoint {

	public static void main(String[] arg) throws Exception {
		WXBot bot1 = new WXBot(12345);
		bot1.setTextMsgEventListener(new onReceiveMessage());
		bot1.run();
		//new WXBot(12345).run();
	}
}
