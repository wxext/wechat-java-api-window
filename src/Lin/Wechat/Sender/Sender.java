package Lin.Wechat.Sender;

import java.util.HashMap;

import com.vdurmont.emoji.EmojiParser;

import Lin.Wechat.WXBot.Global;
import Lin.Wechat.WXBot.WXBot;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.Getter;
@Getter
public class Sender {
	WXBot bot;
	public Sender(WXBot bot) {
		this.bot = bot;
	}
	public JSONObject send(HashMap<Object, Object> map) {
		// json封装
		String json = (new JSONObject(map)).toString();
		json = EmojiParser.parseToUnicode(json);
		//System.out.println(json);
		// 请求发送
		HttpRequest request = HttpRequest.post(Global.apiHttp).body(json);
		// 回传结果
		JSONObject result = JSONUtil.parseObj(request.execute().body());
		return result;
	}
}