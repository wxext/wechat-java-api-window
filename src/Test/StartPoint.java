package Test;

import Lin.Wechat.WXBot.WXBot;
import Test.Listener.MessageHandler;

public class StartPoint {

	public static void main(String[] arg) throws Exception {
		WXBot bot = new WXBot(12345);
		bot.setMsgHandler(new MessageHandler());
		bot.run();
	}
}
