package com.buildthedot.armingjob.service;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.buildthedot.armingjob.app.FindJob;
import com.buildthedot.armingjob.function.computeSecurity;
import com.buildthedot.armingjob.function.writeLog;
import com.buildthedot.armingjob.response.ResponseAuthen;
import com.buildthedot.armingjob.response.ResponseFindJobDefault;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	
	public ResponseAuthen requestLogin2(String mJsonRequest) {
		HttpRequestPost post = new HttpRequestPost();
		
//		String responseText = post.httpQuery("http://pipes.yahoo.com/pipes/pipe.run?_id=953cf8d83df81a7bafcde079568e0eeb&_render=json&mindigg=1000", mJsonRequest);
//		String responseText = post.httpQuery("http://api.androidsmith.com/capitals.php", mJsonRequest);
//		String responseText = post.httpQuery("http://i-ming.com/20140306.imingjob/json/authen/test3.php", mJsonRequest);
		
		String url = "http://i-ming.com/20140306.imingjob/json/authen/test3.php";
//		String responseText = post.httpQuery(url, mJsonRequest);
		
		HttpParameter mHttpParameter = new HttpParameter();
		mHttpParameter.setParam("email", "test");
		
		String responseText = post.httpQuery(url, mHttpParameter);
		
		Log.v("responseTextLogin", responseText);
		
		if (responseText != null && !responseText.equals("")) {
			ResponseAuthen rs = new Gson().fromJson(responseText, ResponseAuthen.class);
			return rs;
		}
		return null;
	}
	
	public ResponseAuthen requestLogin(String email, String password) throws NoSuchAlgorithmException, IOException {
		HttpRequestPost post = new HttpRequestPost();
		String url = "http://i-ming.com/20140306.imingjob/json/authen/user.php";
//		String url = "http://arming/buildthedot/27.farmseller/buildthedot-28-armingjob/source/armingjob_server/json/authen/test6.php";
		
		HttpParameter mHttpParameter = new HttpParameter();
		
		computeSecurity mConvert = new computeSecurity();
		mHttpParameter.setParam("email", email);
		
//		String convertPassword = mConvert.convertToMd5(mConvert.convertToSha1(password))+mConvert.convertToSha1(mConvert.convertToMd5(password));
		mHttpParameter.setParam("password", password);
//		mHttpParameter.setParam("password", convertPassword);
		
		String responseText = post.httpQuery(url, mHttpParameter);
		
		if (responseText != null && !responseText.equals("")) {
			ResponseAuthen rs = new Gson().fromJson(responseText, ResponseAuthen.class);
			return rs;
		}
		return null;
	}
	
	public ResponseFindJobDefault requestFindJobDefault(){
		HttpRequestPost post = new HttpRequestPost();
		String url = "http://i-ming.com/20140306.imingjob/json/content/findjob.php";
		HttpParameter mHttpParameter = new HttpParameter();
		String responseText = post.httpQuery(url, mHttpParameter);
		if (responseText != null && !responseText.equals("")) {
			ResponseFindJobDefault rs = new Gson().fromJson(responseText, ResponseFindJobDefault.class);
			return rs;
		}
		else{
			return null;
		}
	}
}