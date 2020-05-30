package Lin.Wechat.WXBot;

import java.net.InetSocketAddress;
import com.sun.net.httpserver.*;

import Lin.Wechat.Handler.WXMsgHandler;
import Lin.Wechat.Sender.Command.WechatLoginQR;
import Lin.Wechat.Sender.Command.WechatOpener;
import cn.hutool.json.JSONObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WXBot {
	BotInfo info = new BotInfo();

	public WXBot(int port) {
		info.setPort(port);
	}

	public WXBot run() throws Exception {
		HttpServer server = HttpServer.create(new InetSocketAddress(info.getPort()), 0);
		// 定义WXMsgHandler为接收消息的处理器
		server.createContext("/", new WXMsgHandler(this));
		// 开启服务器
		server.start();
		JSONObject wxOpenResult = new WechatOpener(this).send(false);
		// 如果已经启动 获取登陆QR code
		System.out.println(wxOpenResult.toString());
		if (wxOpenResult.getInt("pid") == 0) {
			int pid = Integer.parseInt(
					wxOpenResult.getStr("msg")
					.replace("微信[", "")
					.replace("]已经运行过了", "")
				);
			info.setPid(pid);
			new WechatLoginQR(this).send();
		} else {
			info.setPid(wxOpenResult.getInt("pid"));
		}
		System.out.println(info.getPid());
		return this;
	}
}
