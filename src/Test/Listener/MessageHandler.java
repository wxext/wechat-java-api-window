package Test.Listener;

import Lin.ExtraFunction.DatConvertor;
import Lin.Wechat.Handler.Event.Interface.Event;
import Lin.Wechat.Handler.Event.Interface.EventHandler;
import Lin.Wechat.WXBot.Global;

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

	public void onFriendMessage(Event event) {
		// TODO Auto-generated method stub
		String v1 = "";
		String v2 = "";
		String wxid = "";
		String str = event.getResult().getStr("msg");
		String[] msg = str.split(" ");
		for (String s : msg) {
			if (s.indexOf("fromusername=") != -1) {
				wxid = s.replace("fromusername=", "");
				wxid = wxid.replace("\"", "");
			}
			if (s.indexOf("encryptusername=") != -1) {
				v1 = s.replace("encryptusername=", "");
				v1 = v1.replace("\"", "");
			}
			if (s.indexOf("ticket=") != -1) {
				if (s.indexOf("qrticket") == -1) {
					v2 = s.replace("ticket=", "");
					v2 = v2.replace("\"", "");
				}
			}
		}
		System.out.println(wxid);
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(event.agreeFriend(v1, v2).toString());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		event.sendTextMessage(wxid, "Welcome to add me friend", "");
		//event.sendGroupInvite("17771809858@chatroom", wxid);
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
		System.out.println("path " + event.getResult().getStr("path"));
		String datCon = new DatConvertor().convert(event.getResult().getStr("path"),Global.outputPath);
		System.out.println(datCon);
		event.sendImgMessage("filehelper", datCon, true);
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

	public void onSystemMessage(Event event) {
		// TODO Auto-generated method stub

	}
}