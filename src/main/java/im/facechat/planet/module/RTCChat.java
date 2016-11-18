package im.facechat.planet.module;

import java.util.List;


public class RTCChat {
	
	public String session;

	public String roomId;
	
	public String appId;
	
	public long start;//开始聊天的时间
	
	public long end;//最后一次聊天的时间
	
	public boolean finished;//是否已经结束
	
	public List<String> members;//通话的两个人

	public int[] qualities;
	
	public int[] linkTypes;

	public int[] getQualities() {
		return qualities;
	}

	public void setQualities(int[] qualities) {
		this.qualities = qualities;
	}

	public int[] getLinkTypes() {
		return linkTypes;
	}

	public void setLinkTypes(int[] linkTypes) {
		this.linkTypes = linkTypes;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public List<String> getMembers() {
		return members;
	}

	public void setMembers(List<String> members) {
		this.members = members;
	}
	
	
}
