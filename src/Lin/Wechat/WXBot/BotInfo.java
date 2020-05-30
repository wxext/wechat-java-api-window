package Lin.Wechat.WXBot;

import java.util.Date;

import javax.swing.JFrame;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BotInfo {
	int port;
	String apiHttp = "http://127.0.0.1:8203/api?json";
	Date authDate, expireDate;
	JFrame jf;
	String nickName, wxid;
	String QRPath = "C:\\QRGenerate\\";
	int pid;
}
