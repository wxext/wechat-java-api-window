package Lin.Wechat.WXBot;

import java.util.Date;

import javax.swing.JFrame;

import Lin.Wechat.Handler.Event.Interface.*;
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
//	文本消息
	TextMsgEventListener textMsgEventListener;
//	图片消息
	ImgMsgEventListener imgMsgEventListener;
//	语音消息
//	好友确认消息
//	视频消息
//	动画表情
//	位置消息
//	分享链接
//	群成员信息更新
//	群成员增加
//	群成员减少
//	联系人信息更新
//	收款结果
//	好友验证结果
//	创建群聊结果
//	xml图片地址
//	登录信息-授权
//	登录信息-连接
//	登录信息-登录二维码变化
//	登录信息-微信登录
//	登录信息-微信退出
//	发起语音通过
//	拒绝语音通话
//	接受语音通话
//	插件连接断开
//	微信连接断开
//	系统提示点击确定
//	系统消息


}
