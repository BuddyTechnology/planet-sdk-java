package im.facechat.planet.tool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestBuilder {

	public static Map<String,String> filtParams(Map<String,String> map) {
        Map<String,String> result = new HashMap<String, String>();
        if(map == null || map.size() <= 0) {
            return result;
        }
        for(String key : map.keySet()){
            String value = map.get(key);
            if(value == null || value.equals("") || key.equalsIgnoreCase("sign") || key.equalsIgnoreCase("sign_type")) {
                continue;
            }
            result.put(key, value);
        }
        return result;
    }

	public static String createLinkString(Map<String,String> params){
		params = filtParams(params);
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        String prestr = "";
        for(int i = 0; i < keys.size(); i++){
            String key = keys.get(i);
            String value = params.get(key);
            if(i == keys.size() - 1){//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            }else{
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
    }
}
