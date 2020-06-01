package Lin.Wechat.Handler.Event.Interface;

public interface EventHandler {
	// 文本消息 1
	public void onTextMessage(Event event);

	// 图片消息 3
	public void onImgMessage(Event event);

	// 语音消息 34
	public void onVoiceMessage(Event event);

	// 好友确认消息 37
	public void onFriendMessage(Event event);

	// 视频消息 43
	public void onVideoMessage(Event event);

	// 动画表情 47
	public void onEmotionMessage(Event event);

	// 位置消息 48
	public void onLocationMessage(Event event);

	// 分享链接 49
	public void onLinkShareMessage(Event event);

	// 群成员信息更新 701
	public void onGroupMemberInfoUpdateMessage(Event event);

	// 群成员增加 702
	public void onGroupMemberIncreaseMessage(Event event);

	// 群成员减少 703
	public void onGroupMemberDecreaseMessage(Event event);

	// 联系人信息更新 704
	public void onFriendInfoUpdateMessage(Event event);

	// 收款结果 705
	public void onReceivePaymentMessage(Event event);

	// 好友验证结果 706
	public void onFriendAuthMessage(Event event);

	// 创建群聊结果 707
	public void onCreateGroupMessage(Event event);

	// xml图片地址 708
	public void onXMLImgPathMessage(Event event);

	// 登录信息-授权 720
	// 登录信息-连接 721
	// 登录信息-登录二维码变化 723
	// 登录信息-微信登录 724
	// 登录信息-微信退出 725
	// 发起语音通过 726
	public void onVoiceCallMessage(Event event);

	// 拒绝语音通话 727
	public void onVoiceCallRejectMessage(Event event);

	// 接受语音通话 728
	public void onVoiceCallAcceptMessage(Event event);

	// 插件连接断开 802
	// 微信连接断开 803
	// 系统提示点击确定 810
	// 系统消息 10000
	public void onSystemMessage(Event event);

}