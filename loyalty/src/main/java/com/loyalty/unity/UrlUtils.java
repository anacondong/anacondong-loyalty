package com.loyalty.unity;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UrlUtils {
	
	public static Map<String, List<String>> getQueryParams(String url) {
	    try {
	        Map<String, List<String>> params = new HashMap<String, List<String>>();
	            for (String param : url.split("&")) {
	                String[] pair = param.split("=");
	                String[] subParams = pair[1].split(",");
	                String key = URLDecoder.decode(pair[0], "UTF-8");
	                
	                List<String> values = new ArrayList<String>();
	                	for(String subParam : subParams){
	                		values.add(URLDecoder.decode(subParam, "UTF-8"));
	                	}	                	
	                	params.put(key, values);
	            }
	        return params;
	    } catch (UnsupportedEncodingException ex) {
	        throw new AssertionError(ex);
	    }
	}
	
	
	public static List<Map<String, Object>> getSplitData(List<Map<String, Object>> data, int loopNum, int maxNum){
		
		List<Map<String, Object>> split = data;
		
		return split;
	}

}
