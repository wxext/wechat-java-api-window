# 语言(Language)

[English](https://github.com/wxext/wechat-java-api-window/blob/master/readme_english.md "English") version about the readme.md

# 声明
此程序是基于[e小天](https://www.wxext.cn "e小天")的httpapi开发的java api
并非独立开发的java wechat api

# 安装
+ [e小天](https://www.wxext.cn/app/install.html "安装e小天")
+ [jdk1.8+](https://www.oracle.com/java/technologies/ "Java")
+ [PC微信安装](https://pc.weixin.qq.com/ "微信 PC 版")支持最新版微信（每个人最新版不一样咋办呀?那就都支持）
+ [e小天运行库](https://www.wxext.cn/app/install.html "")

# 运行
右键管理员身份打开e小天 点击启动服务 (管理员身份！！管理员身份！！管理员身份！！重要事情说三次 ) 然后可以关闭了

打开浏览器 进入[设置页面](https://www.wxext.cn/app/settings.html "") 

设置如下

通知地址http://127.0.0.1:12345

勾选事件那里全部勾选 因为有一些事件就算你用不上 javaapi也需求用上

最后点设置

# Java 程序调试demo
由于本人使用eclipse 请手动导入library文件夹内jar文件 

# StartPoint.java
```java
package Test;

import Lin.Wechat.WXBot.WXBot;
import Test.Listener.onReceiveMessage;

public class StartPoint {
	public static void main(String[] arg) throws Exception {
		WXBot bot1 = new WXBot(12345); // this port is above image port1
		bot1.getInfo().setTextMsgEventListener(new onReceiveMessage());
		bot1.run();
	}
}
```

# onReceiveMessage.java
```java
package Test.Listener;

import Lin.Wechat.Handler.Event.Interface.TextMsgEventListener;
import Lin.Wechat.WXBot.WXBot;
import cn.hutool.json.JSONObject;

public class onReceiveMessage implements TextMsgEventListener{
	@Override
	public void process(JSONObject result, WXBot bot) {
		System.out.println("LISTENER SUCCESS");
		System.out.println(result.toString());
	}	
}
```

# 后话
程序还在编写阶段 将会陆续更新接口 欢迎大家一起讨论 Q群666736222
