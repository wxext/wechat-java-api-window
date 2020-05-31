package Lin.Wechat.WXBot;

import java.net.InetSocketAddress;
import com.sun.net.httpserver.*;

import Lin.Wechat.Handler.WXMsgHandler;
import Lin.Wechat.Handler.Event.Interface.EventHandler;
import Lin.Wechat.Sender.XTMAC;
import Lin.Wechat.Sender.Command.WechatLoginQR;
import Lin.Wechat.Sender.Command.WechatOpener;
import cn.hutool.json.JSONObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WXBot {
	//小天Token
	String token;
	EventHandler MsgHandler;
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
		JSONObject wxOpenResult = new WechatOpener(this).send(true);
		// 如果已经启动 获取登陆QR code
		if (wxOpenResult.getInt("pid") == 0) {
			int pid = Integer.parseInt(wxOpenResult.getStr("msg").replace("微信[", "").replace("]已经运行过了", ""));
			info.setPid(pid);
			while(new WechatLoginQR(this).send().getStr("msg").equals("get fail"));
		} else {
			info.setPid(wxOpenResult.getInt("pid"));
		}
		String data = new XTMAC(this).send().getStr("data");
		this.info.setMac(data);
		return this;
	}
}
