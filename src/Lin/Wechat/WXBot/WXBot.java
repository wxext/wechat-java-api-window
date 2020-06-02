package Lin.Wechat.WXBot;

import java.io.IOException;
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
public class WXBot extends Thread {
	// 小天Token
	String token;
	EventHandler MsgHandler;
	BotInfo info = new BotInfo();

	public WXBot setMsgHandler(EventHandler MsgHandler) {
		this.MsgHandler = MsgHandler;
		return this;
	}

	public void run() {
		if (!Global.isServerStarted) {
			HttpServer server;
			try {
				server = HttpServer.create(new InetSocketAddress(Global.receivePushServerPort), 0);
				// 定义WXMsgHandler为接收消息的处理器
				server.createContext("/", new WXMsgHandler());
				// 开启服务器
				server.start();
				Global.isServerStarted = true;
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		JSONObject wxOpenResult = new WechatOpener(this).send(-1);
		// 如果已经启动 获取登陆QR code
		if (wxOpenResult.getInt("pid") == 0) {
			int pid = Integer.parseInt(wxOpenResult.getStr("msg").replace("微信[", "").replace("]已经运行过了", ""));
			info.setPid(pid);
			while (new WechatLoginQR(this).send().getStr("msg").equals("get fail"))
				;
		} else {
			info.setPid(wxOpenResult.getInt("pid"));
			new WechatOpener(this).send(info.getPid());
		}
		String data = new XTMAC(this).send().getStr("data");
		this.info.setMac(data);
	}
}
