package im.facechat.planet.core;

import im.facechat.planet.cons.PlanetConfig;
import im.facechat.planet.cons.Planets;
import im.facechat.planet.exp.PlanetException;
import im.facechat.planet.tool.Base64Helper;
import im.facechat.planet.tool.MD5Helper;
import im.facechat.planet.tool.RSAHelper;

import java.security.PrivateKey;

public class SignUtil {

	public static PrivateKey rsaKey;
	
	public static String sign(String signType,String link) throws Exception{
		if(signType.equals(Planets.Sign.MD5)){
			return MD5Helper.getMD5(link + PlanetConfig.appToken);
		}else if(signType.equals(Planets.Sign.RSA)){
			initRSAKey();
			String md5 = MD5Helper.getMD5(link);
			return Base64Helper.encode(RSAHelper.privateEncrypt(rsaKey,md5));
		}else{
			throw new PlanetException(-1,"don't support " + signType + " sign_type");
		}
	}

	private static void initRSAKey() throws Exception{
		if(rsaKey != null){
			return;
		}
		rsaKey = RSAHelper.getPrivateKey(PlanetConfig.rsaKey);
	}
}
