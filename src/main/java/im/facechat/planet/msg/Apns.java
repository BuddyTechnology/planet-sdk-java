package im.facechat.planet.msg;

import java.util.HashMap;
import java.util.Map;

public class Apns {
	
	private int channel;
	private int deviceType;
	private String to;
	private int badges = 0;
	private String content;
	private String token;
	private String sound;
	private String title;
	private String appId;//是属于哪个业务模块，此参数将决定使用哪个推送证书
	private boolean backgroud;
	private Map<String,String> params;//include 'keywords'
	private String logo;
	private boolean awake;
	
	public Apns(){}
	
	public Apns(String content,Map<String,String> params,String appId){
		this.content = content;
		this.params = params;
		this.appId = appId;
	}
	
	public boolean isAwake() {
		return awake;
	}

	public void setAwake(boolean awake) {
		this.awake = awake;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(int deviceType) {
		this.deviceType = deviceType;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public boolean isBackgroud() {
		return backgroud;
	}

	public Apns setBackgroud(boolean backgroud) {
		this.backgroud = backgroud;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public Map<String,String> getParams() {
		if(params == null){
			params = new HashMap<String,String>();
		}
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	public int getBadges() {
		return badges;
	}

	public void setBadges(int badges) {
		this.badges = badges;
	}
}
