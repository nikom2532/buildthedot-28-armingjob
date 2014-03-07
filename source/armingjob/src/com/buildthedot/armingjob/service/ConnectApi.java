package com.buildthedot.armingjob.service;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.buildthedot.armingjob.function.writeLog;
import com.buildthedot.armingjob.response.ResponseAuthen;
import com.google.gson.Gson;

public class ConnectApi {
	Context context;
	String responseText;

	public ConnectApi(Context context) {
	}

	public ConnectApi() {
	}
	
	public static int getJsonInt(JSONObject obj, String name) {
		try {
			return obj.get(name) != null ? obj.getInt(name) : 0;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static boolean hasElement(JSONObject obj, String name) {
		if (obj.has(name))
			return true;
		return false;
	}

	public static String getJsonString(JSONObject obj, String name) {
		try {
			if (hasElement(obj, name)) {
				writeLog.LogD(writeLog.TAG, (obj.get(name) != null ? obj.getString(name) : ""));
				return (obj.get(name) != null ? obj.getString(name) : "");
			} else {
				writeLog.LogD(writeLog.TAG, "");
				return "";
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static boolean getJsonBoolean(JSONObject obj, String name) {
		try {
			return obj.get(name) != null ? obj.getBoolean(name) : false;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ResponseAuthen requestLogin(String mJsonRequest) {
		HttpRequestPost post = new HttpRequestPost();
		String responseText = post.httpQuery("http://i-ming.com/20140306.imingjob/json/authen/test.php", mJsonRequest);
//		String responseText = post.httpQuery("http://pipes.yahoo.com/pipes/pipe.run?_id=953cf8d83df81a7bafcde079568e0eeb&_render=json&mindigg=1000", mJsonRequest);
//		String responseText = post.httpQuery("http://i-ming.com/20140306.imingjob/json/authen/test.json", mJsonRequest);
		
//		String responseText = post.httpQuery("http://api.androidsmith.com/capitals.php", mJsonRequest);
		
		if (responseText != null && !responseText.equals("")) {
			ResponseAuthen rs = new Gson().fromJson(responseText, ResponseAuthen.class);
			return rs;
		}
		return null;
	}
}
