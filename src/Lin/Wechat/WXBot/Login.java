package Lin.Wechat.WXBot;

import java.util.LinkedList;

import lombok.Getter;

public class Login {
	@Getter
	LinkedList<WXBot> queue = new LinkedList<WXBot>();
	LinkedList<WXBot> loginQueueTemp = new LinkedList<WXBot>();

	public Login Add(WXBot bot) {
		queue.add(bot);
		loginQueueTemp.add(bot);
		return this;
	}

	public void run() {
		if (loginQueueTemp.size() > 0)
			loginQueueTemp.removeFirst().start();
	}
}
