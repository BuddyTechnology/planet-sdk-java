package im.facechat.planet.cons;


public class IReturnCode {
	
	/**
	 * ok
	 */
	public static final int OK = 0;
	
	public static final int NOT_FOUND_METHOD = -100;
	
	public static final int INVOKE_ERROR = -99;
	
	public static final int BUS_PARAM_INVALID = -98;
	
	public static final int NETWORK_ERROR = -97;
	
	public static final int UNKOWN_SERVICE = -96;
	
	public static final int UNKOWN_ERROR = -95;
	
	public static final int SESSION_TIMEOUT = -94;
	
	public static final int SESSION_ERROR = - 93;
	
	public static final int ACTION_FAILED = -91;
	
	public static final int NOT_FOUND_SERVICE = -90;
	
	public static final int SECREQ_VERIFY_NOTPASSED = -89;
	
	public static final int NO_PERMISSIONS = -88;
	
	public static final int ERROR_DATA_FORMAT = -87;
	
	public static final int INCLUDE_SENSITIVE_WORDS = -86;

	public static final int PLANET_INVALID_SIGN = -999;//错误的签名
	
	public static final int PLANET_INVALID_APPID = -998;//错误的appId
	
	public static final int PLANET_ACCOUNT_BLOCKED = -997;//账号被冻结
	
	public static final int PLANET_ACCOUNT_NO_MONEY = -996;//金钱不足
	
	public static final int PLANET_INVALID_SERVER_CLOCK = -995;//第三方服务端时间钟偏离太大，需要调整时间钟
	
	public static final int PLANET_INVALID_SIGN_TYPE = -994;//
	
	public static final int PLANET_NETWORK_ERROR = -993;//
	
	public static final int PLANET_ACTION_FAILED = -992;//
}

