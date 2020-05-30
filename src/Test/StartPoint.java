package Test;

import Lin.Wechat.WXBot.WXBot;
import Test.Listener.onTextMessageReceive;

public class StartPoint {

	public static void main(String[] arg) throws Exception {
		WXBot bot = new WXBot(12345);
		bot.setTextMsgEventListener(new onTextMessageReceive());
		bot.run();
	}
}
