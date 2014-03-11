package com.buildthedot.armingjob.app;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import com.buildthedot.armingjob.R;
import com.buildthedot.armingjob.function.DialogProcess;
import com.buildthedot.armingjob.request.RequestAuthen;
import com.buildthedot.armingjob.response.ResponseAuthen;
import com.buildthedot.armingjob.service.ConnectApi;
import com.buildthedot.armingjob.service.HttpRequestPost;
import com.google.gson.Gson;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;

public class Login extends Activity implements OnClickListener {
	
	EditText armingjob_mainmenu_email;
	EditText armingjob_mainmenu_password;
	Button armingjob_mainmenu_login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		setView();
	}
	void setView(){
		armingjob_mainmenu_email = (EditText) findViewById(R.id.armingjob_mainmenu_email);
		armingjob_mainmenu_password = (EditText) findViewById(R.id.armingjob_mainmenu_password);
		armingjob_mainmenu_login = (Button) findViewById(R.id.armingjob_mainmenu_login);
		armingjob_mainmenu_login.setOnClickListener(this);
		armingjob_mainmenu_email.setText("nikom2532@gmail.com");
//		armingjob_mainmenu_password.setText("77de54ccf56eb6f7dbf99e4d3be949ab6f9b0a55df8ac28564cb9f63a10be8af6ab3f7c2");
		armingjob_mainmenu_password.setText("a");
	}
	
	@Override
	public void onClick(View v){
		if(armingjob_mainmenu_login.equals(v)){
			new requestLogin().execute();
		}
	}
	
	private class requestLogin extends AsyncTask<String, Void, ResponseAuthen>{
		
		DialogProcess dialog = new DialogProcess(Login.this);
		ConnectApi connApi = new ConnectApi(Login.this);
		RequestAuthen requestAuthen = new RequestAuthen();
		String JSONObjSend;
		
		public requestLogin() {
			requestAuthen.email = armingjob_mainmenu_email.getText().toString();
			requestAuthen.password = armingjob_mainmenu_password.getText().toString();
		}
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog.show();
		}
		
		@Override
		protected ResponseAuthen doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			
			JSONObjSend = new Gson().toJson(requestAuthen);
//			ResponseAuthen responseAuthen = connApi.requestLogin2(JSONObjSend);
			
			ResponseAuthen responseAuthen = null;
			try {
				responseAuthen = connApi.requestLogin(requestAuthen.email, requestAuthen.password);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return responseAuthen;
		}
		
		@Override
		protected void onPostExecute(ResponseAuthen result) {
			super.onPostExecute(result);
			dialog.dismiss();
			
			Log.v("result.email", result.email.toString());
			Log.v("result.password", result.message.toString());
			
			if(result.message.toString().equals("Authened")){
				
			}
			else if(result.message.toString().equals("wrongPassword")){
				
			}
			else if(result.message.toString().equals("wrongUser")){
				
			}
			else if(result.message.toString().equals("notAuthened")){
				
			}
		}
	}
}