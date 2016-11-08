package im.facechat.planet.module;

public class RoomPolicy {
	
	private String[] members;
	private int quality;//建议的清晰度
	private boolean disableP2P;
	
	public String[] getMembers() {
		return members;
	}
	public void setMembers(String[] members) {
		this.members = members;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public boolean isDisableP2P() {
		return disableP2P;
	}
	public void setDisableP2P(boolean disableP2P) {
		this.disableP2P = disableP2P;
	}
}
