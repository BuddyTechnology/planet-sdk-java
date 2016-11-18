

#前言
	对于 Facechat的视讯服务，多数情况下可直接使用 iOS和 Android提供的 SDK进行完整的业务开发，不需要服务端的接入，
	但是如果你需要定制某次用户的通话（eg.视频画质，连接策略，路由节点....）, 又或者你需要通过 Facechat视讯服务
	的长连接向指定用户推送系统消息。

#1.配置
在调用服务端之前，需要配置开发者自己的 AppID等信息:
```java
PlanetConfig.appId = "{appId}";
PlanetConfig.appToken = "{appToken}";//重要信息，请认真保管
PlanetConfig.rsaKey = "{rsaKey}";//重要信息，请认真保管
PlanetConfig.signType = "{signType}";//签名类型，目前支持MD5和RSA(1024)
```

#2.指定通话策略
可以向服务器请求定制某个房间的高级通话策略
```java
RoomPolicy policy = new RoomPolicy();
policy.setDisableP2P(true);
policy.setMembers(new String[]{"token1","token2"});//限定用户进行通话
policy.setDisableP2P(true);//是否禁用P2P通话
policy.setQuality(Planets.RTC.Quality.HIGH); //通话画质
String roomId = PlanetSDK.createRoom(policy);//roomId需下发到客户端
```
#3.向用户发送消息
该消息非Apns推送，走的是facechat的长连接消息:
```java
PlanetSDK.sendIM("$!{token}","$!{message}");
```

