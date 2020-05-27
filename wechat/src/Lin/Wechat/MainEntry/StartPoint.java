package Lin.Wechat.MainEntry;

import java.net.InetSocketAddress;
import com.sun.net.httpserver.*;
import Lin.Wechat.MainEntry.Handler.WXMsgHandler;

public class StartPoint {

	public static void main(String[] arg) throws Exception {
		// 创建服务器接收来自e小天的推送
		HttpServer server = HttpServer.create(new InetSocketAddress(GlobalConfig.receivePort), 0);
		// 定义WXMsgHandler为接收消息的处理器
		server.createContext("/", new WXMsgHandler());
		// 开启服务器
		server.start();
	}
}
