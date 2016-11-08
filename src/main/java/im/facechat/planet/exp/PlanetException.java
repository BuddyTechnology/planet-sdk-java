package im.facechat.planet.exp;

public class PlanetException extends Exception{
	/**
	 */
	private static final long serialVersionUID = 1L;
	
	private int code;
	private String msg;
	private Exception e;
	
	public PlanetException(){}
	
	public PlanetException(int code,String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public PlanetException(int code,String msg,Exception e){
		this.code = code;
		this.msg = msg;
		this.e = e;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "PlanetException [code=" + code + ", msg=" + msg + "]" + (e != null ? e.toString() : "");
	}
}
