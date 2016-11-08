package im.facechat.planet.cons;

public class Planets {

	public interface RTC{
		public interface Quality{
			public static final int HIGH = 1;//640*480-ios
			public static final int STANDARD = 2;//480*277-ios
			public static final int LOW = 3;//199*144-ios
		}
		public interface Media{
			public static final int VIDEO = 1;
			public static final int TEXT = 2;
			public static final int AUDIO = 3;
		}
	}
	
	public interface Sign{
		public static final String MD5 = "MD5";
		public static final String RSA = "RSA";
	}
}
