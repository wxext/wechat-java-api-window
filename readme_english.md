# Stat
This java api program is developed based on httpapi from other program named '[wxext(e小天)](https://www.wxext.cn "e小天")'
Which is an external program to hocking wechat. 

# Installaion
+ [wxext(e小天)](https://www.wxext.cn/app/install.html "安装e小天")
+ [jdk1.8+](https://www.oracle.com/java/technologies/ "Java")
+ [Wechat PC ](https://pc.weixin.qq.com/ "微信 PC 版") support any version of wechat
+ [wxext(e小天) runtime](https://www.wxext.cn/app/install.html "")

# Running
Right click the wxext(e小天) and run as administrator.
After the program GUI show. press the button named 'start service'(启动服务).
OK, you can close the wxext(e小天) now.

click this link --> [Setting Page](https://www.wxext.cn/app/settings.html "") 

Setting the following

receive address(通知地址)=http://127.0.0.1:12345

tick all checkbox

press setting(设置) button

# Java demo

# StartPoint.java
```java
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

```

# onReceiveMessage.java
```java
package Test.Listener;

package Test.Listener;

import Lin.Wechat.Handler.Event.Interface.Event;
import Lin.Wechat.Handler.Event.Interface.EventHandler;

public class MessageHandler implements EventHandler {

	public void onTextMessage(Event event) {
		// TODO Auto-generated method stub
	}

	public void onImgMessage(Event event) {
		// TODO Auto-generated method stub

	}

	public void onVoiceMessage(Event event) {
		// TODO Auto-generated method stub

	}

	public void onFriendConfirmMessage(Event event) {
		// TODO Auto-generated method stub

	}

	public void onVideoMessage(Event event) {
		// TODO Auto-generated method stub

	}

	public void onEmotionMessage(Event event) {
		// TODO Auto-generated method stub

	}

	public void onLocationMessage(Event event) {
		// TODO Auto-generated method stub

	}

	public void onLinkShareMessage(Event event) {
		// TODO Auto-generated method stub

	}

	public void onGroupMemberInfoUpdateMessage(Event event) {
		// TODO Auto-generated method stub

	}

	public void onGroupMemberIncreaseMessage(Event event) {
		// TODO Auto-generated method stub

	}

	public void onGroupMemberDecreaseMessage(Event event) {
		// TODO Auto-generated method stub

	}

	public void onFriendInfoUpdateMessage(Event event) {
		// TODO Auto-generated method stub

	}

	public void onReceivePaymentMessage(Event event) {
		// TODO Auto-generated method stub

	}

	public void onFriendAuthMessage(Event event) {
		// TODO Auto-generated method stub

	}

	public void onCreateGroupMessage(Event event) {
		// TODO Auto-generated method stub

	}

	public void onXMLImgPathMessage(Event event) {
		// TODO Auto-generated method stub

	}

	public void onVoiceCallMessage(Event event) {
		// TODO Auto-generated method stub

	}

	public void onVoiceCallRejectMessage(Event event) {
		// TODO Auto-generated method stub

	}

	public void onVoiceCallAcceptMessage(Event event) {
		// TODO Auto-generated method stub

	}
}
```

# Last
Program is continue updating at this moment. Welcome all developers join our QQ group 666736222
