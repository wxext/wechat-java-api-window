package Lin.Wechat.Sender;

import Lin.Wechat.WXBot.WXBot;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class XTAuth extends Sender {
	public XTAuth(WXBot bot) {
		super(bot);
	}

	public JSONObject send(String url) {
		HttpRequest request = HttpRequest.get(url);
		return JSONUtil.parseObj(request.execute().body());
	}
}