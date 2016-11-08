package im.facechat.planet.tool;

import java.security.MessageDigest;
import java.util.Random;


public class MD5Helper {
	
	public static String getMD5(String message){
		return getMD5(message.getBytes());
	}

	public static String getRandomMD5(){
		Random ran=new Random();
		String mix=""+ran.nextDouble()+System.currentTimeMillis()+ran.nextDouble();
		return getMD5(mix.getBytes());
	}
	
	public static String getMD5(byte[] buffer) {
 		MessageDigest mdAlgorithm =null;
		try{
			mdAlgorithm=MessageDigest.getInstance("MD5");	
		}catch(Exception e){}
		mdAlgorithm.update(buffer);
		byte[] digest = mdAlgorithm.digest();
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < digest.length; i++) {
			String plainText = Integer.toHexString(0xFF & digest[i]);
			if (plainText.length() < 2) {
				plainText = "0" + plainText;
			}
			hexString.append(plainText);
		}
		return hexString.toString();
	}
}
