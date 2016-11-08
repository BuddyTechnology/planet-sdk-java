package im.facechat.planet.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.ByteArrayPartSource;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpCore {
	
	public static String post(String baseurl,Map<String,String> params,String ua){
		HttpClient client = new HttpClient();
		if(ua != null){
			client.getParams().setParameter(HttpMethodParams.USER_AGENT,ua);
		}
		PostMethod post = new PostMethod(baseurl);
		List<NameValuePair> pairs = null;
		try {
			pairs = getNameValuePairs(params);
			NameValuePair[] requestParams = new NameValuePair[pairs.size()];
			pairs.toArray(requestParams);
			
			post.addRequestHeader("Content-Type",PostMethod.FORM_URL_ENCODED_CONTENT_TYPE + ";charset=utf-8");
			post.setRequestBody(requestParams);
			client.executeMethod(post);
			BufferedReader reader = new BufferedReader(new InputStreamReader(post.getResponseBodyAsStream()));  
			StringBuilder sb = new StringBuilder();  
			String str = "";  
			while((str = reader.readLine())!=null){  
			    sb.append(str);  
			}  
			return sb.toString();
		}catch(Exception e){
			
		}
		return null;
	}
	
	public static String postData(String baseurl,byte[] data,Map<String,String> params,String ua){
		try{
			List<NameValuePair> pairs = getNameValuePairs(params);
			
			List<Part> fps = new ArrayList<Part>();
			for (NameValuePair field : pairs) {
				fps.add(new StringPart(field.getName(),field.getValue(),"utf-8"));
			}
			if(data != null){
				FilePart filePart = new FilePart("data", new ByteArrayPartSource("data",data));
				filePart.setCharSet("utf-8");
				fps.add(filePart);	
			}
			
			HttpClient client = new HttpClient();
			client.getParams().setParameter(HttpMethodParams.USER_AGENT,ua);
			PostMethod post = new PostMethod(baseurl);
			
			MultipartRequestEntity mre = new MultipartRequestEntity(fps.toArray(new Part[fps.size()]),post.getParams());
			
			post.setRequestEntity(mre);
			post.getParams().setContentCharset("utf-8");
			
			client.executeMethod(post);
			
			return post.getResponseBodyAsString();
		}catch(Exception e){
			
		}
		return null;
	}
	
	private static List<NameValuePair> getNameValuePairs(Map<String,String> paramsMap) throws UnsupportedEncodingException {
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		for(String key : paramsMap.keySet()) {
			Object value = paramsMap.get(key);
			if (null == value) {
				continue;
			}
			NameValuePair nameValuePair = new NameValuePair();
			nameValuePair.setName(key);
			nameValuePair.setValue(value.toString());
			pairs.add(nameValuePair);
		}
		return pairs;
	}
}
