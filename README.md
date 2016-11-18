

#前言
对于 Facechat的视讯服务，多数情况下可直接使用 iOS和 Android提供的 SDK进行完整的业务开发，不需要服务端的接入，
但是如果你需要定制某次用户的通话（eg.视频画质，连接策略，路由节点....）, 又或者你需要通过 Facechat视讯服务的
长连接向指定用户推送系统消息。

#1.配置
在调用服务端之前，需要配置开发者自己的 AppID等信息:
```java
PlanetConfig.appId = "{appId}";
PlanetConfig.appToken = "{appToken}";//重要信息，请认真保管
PlanetConfig.rsaKey = "{rsaKey}";//重要信息，请认真保管
PlanetConfig.signType = "{signType}";//签名类型，目前支持MD5和RSA(1024)
PlanetConfig.url = "http://srv.api.facechat.im/";业务请求根路径地址
```
#2.业务参数封装
开发者在调用Facechat-server的接口时，需对传递的参数进行组装签名，参数组装规则如下：将要传递的方法参数以key,value的形式添加到Map中
(如果value是复杂对象，请将该对象json序列化为字符串，当然如果复杂对象为空，则不需要将该key,value添加到Map中)，同时添加当前服务器
时间ctime:{当前时间毫秒数}，签名方式sign_type:{MD5 or RSA}，appId:{appId}到Map中:
```java
Map map = ....
map.put("appId","$!{appId}")
map.put("ctime","$!{ctime}")
map.put("param1","$!{param1}");
map.put("param2","$!{param2}");
....
```
#3.参数签名

**⚠sign_type不参与签名**

MD5签名：将Map中组装好的参数，以key进行从小到大字母排序，然后进行key1=value1&key2=value2&….形式的组装,得到一个长字符串，
然后用MD5对该字符串进行签名得到sign,分别将sign和sign_type(MD5)放入Map中，作为post提交参数的一部分；

RSA签名：将Map中组装好的参数，以key进行从小到大字母排序，然后进行key1=value1&key2=value2&…形式的组装,得到一个长字符串
，然后用MD5对该字符串进行签名得到sign1,用RSA加密私钥对sign1进行签名得到sign,分别将sign和sign_type(RSA)放入Map中，
作为post提交参数的一部分；

```java
map.put("sign","$!{sign}");
map.put("sign_type","$!{sign_type}");
```

#4.请求和返回
请求：请map中的参数以form表单的方式提交到服务器，请求地址为PlanetConfig.url+"/{serverletPath}"

返回：Facechat-Server的返回结果是一串json,形式为{code:0,result:xxx,msg:xxxx}，如果code等于0,则result就是对应接口需要获得的
最终数据，如果code不为0，则可以从json串中获取对应的msg错误信息，以提供调试；

#5.指定通话策略
可以向服务器请求定制某个房间的高级通话策略,请求地址:http://srv.api.facechat.im/api/rtc/add_room ，JavaSDK调用代码如下：
请求参数说明：
|| *参数* || *是否必须* || *参数类型* || *说明* ||
|| appId || 是 || string || 应用appId ||
|| quality || 是 || int || 画质,1:高清,2:标清,3:普通,默认为0 ||
|| disableP2P || 是 || boolean || 是否禁用P2P，默认false ||
|| members || 否 || string[] || 限定用户可以进入该房间 ||
|| sign_type || 是 || string || 签名类型:MD5或RSA ||
|| sign || 是 || string || 签名串 ||
|| ctime || 是 || long || 当前服务器时间毫秒数 ||

```java
RoomPolicy policy = new RoomPolicy();
policy.setDisableP2P(true);
policy.setMembers(new String[]{"token1","token2"});//限定用户进行通话
policy.setDisableP2P(true);//是否禁用P2P通话
policy.setQuality(Planets.RTC.Quality.HIGH); //通话画质
String roomId = PlanetSDK.createRoom(policy);//roomId需下发到客户端
```
#6.向用户发送消息
该消息非Apns推送，走的是facechat的长连接消息,请求地址：http://srv.api.facechat.im/api/chat/sendIM ,JavaSDK调用代码如下：
```java
PlanetSDK.sendIM("$!{token}","$!{message}");
```

#7.查询用户通话
sessions是会话标示的数组(从客户端SDK的onRoomSession中获得，用于唯一标示用户的一次通话)，该接口支持批量查询，最大支持300条，同时该通话记录
只保留7天，7天以前的数据暂不支持查询；
请求地址：http://srv.api.facechat.im/api/rtc/get_chats ,JavaSDK调用代码如下：
```java
PlanetSDK.getChats(sessions);
```
