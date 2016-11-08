package im.facechat.planet.tool;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;


/**
 * 
 * @author Geek范
 * @mailTo bruce.shaoheng@gmail.com
 * @date   2013年9月8日
 */
public class RSAHelper {

	 //公钥加密  
    public static byte[] publicEncrypt(PublicKey key,String str)throws Exception {  
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.ENCRYPT_MODE, key);  
        return cipher.doFinal(str.getBytes("UTF8"));  
    }  
      
    //公钥解密  
    public static byte[] publicDecrypt(PublicKey key,byte[] data)throws Exception {  
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.DECRYPT_MODE,key);  
        return cipher.doFinal(data);  
    }  
      
    //私钥加密
    public static byte[] privateEncrypt (PrivateKey key,String str)throws Exception {  
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.ENCRYPT_MODE, key);  
        return cipher.doFinal(str.getBytes("UTF8"));  
    }  
      
    //私钥解密  
    public static byte[] privateDecrypt(PrivateKey key,byte[]  data)throws Exception  {  
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.DECRYPT_MODE, key);  
        return cipher.doFinal(data);  
    } 
    

    /** 
     * 得到公钥 
     * @param key 密钥字符串（经过base64编码） 
     * @throws Exception 
     */  
    public static PublicKey getPublicKey(String key) throws Exception {  
         byte[] keyBytes;  
         keyBytes = Base64Helper.decode(key);  
 
         X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);  
         KeyFactory keyFactory = KeyFactory.getInstance("RSA");  
         PublicKey publicKey = keyFactory.generatePublic(keySpec);  
         return publicKey;  
    }  
    /** 
     * 得到私钥 
     * @param key 密钥字符串（经过base64编码） 
     * @throws Exception 
     */  
    public static PrivateKey getPrivateKey(String key) throws Exception {  
         byte[] keyBytes;  
         keyBytes = Base64Helper.decode(key);  
 
         PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);  
         KeyFactory keyFactory = KeyFactory.getInstance("RSA");  
         PrivateKey privateKey = keyFactory.generatePrivate(keySpec);  
         return privateKey;  
    }  
}
