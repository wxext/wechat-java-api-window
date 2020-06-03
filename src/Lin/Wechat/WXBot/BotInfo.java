package Lin.Wechat.WXBot;

import java.util.Date;

import javax.swing.JFrame;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BotInfo {
	int port;
	Date authDate, expireDate;
	JFrame jf;
	String nickName, wxid, mac;
	String QRPath = "C:\\QRGenerate\\";
	int pid;
	boolean isLogin = false;
}
