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
	EventListener textMsgEventListener;
//	图片消息
	EventListener imgMsgEventListener;
//	语音消息
	EventListener voiceMsgEventListener;
//	好友确认消息
	EventListener friendConfirmEventListener;
//	视频消息
	EventListener videoMsgEventListener;
//	动画表情
	EventListener animationImgEventListener;
//	位置消息
	EventListener locationMsgEventListener;
//	分享链接
	EventListener shareLinkEventListener;
//	群成员信息更新
	EventListener groupMemberInfoUpdateEventListener;
//	群成员增加
	EventListener groupMemberIncreaseEventListener;
//	群成员减少
	EventListener groupMemberDecreaseEventListener;
//	联系人信息更新
	EventListener friendInfoUpdateEventListener;
//	收款结果
	EventListener receivePaymentEventListener;
//	好友验证结果
	EventListener friendAuthEventListener;
//	创建群聊结果
	EventListener createGroupEventListener;
//	xml图片地址
	EventListener XMLImgPathEventListener;
//	登录信息-授权
//	登录信息-连接
//	登录信息-登录二维码变化
//	登录信息-微信登录
//	登录信息-微信退出
//	发起语音通过
	EventListener voiceCallEventListener;
//	拒绝语音通话
	EventListener voiceCallRejectEventListener;
//	接受语音通话
	EventListener voiceCallAcceptEventListener;
//	插件连接断开
//	微信连接断开
//	系统提示点击确定
//	系统消息


}
