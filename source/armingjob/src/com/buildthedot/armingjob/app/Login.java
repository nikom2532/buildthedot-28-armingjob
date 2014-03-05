package com.buildthedot.armingjob.app;

import com.buildthedot.armingjob.R;
import com.buildthedot.armingjob.function.DialogProcess;
import com.buildthedot.armingjob.request.RequestAuthen;
import com.buildthedot.armingjob.response.ResponseAuthen;
import com.buildthedot.armingjob.service.ConnectApi;
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
		Log.v("login", "1");
	}
	void setView(){
		armingjob_mainmenu_email = (EditText) findViewById(R.id.armingjob_mainmenu_email);
		armingjob_mainmenu_password = (EditText) findViewById(R.id.armingjob_mainmenu_password);
		armingjob_mainmenu_login = (Button) findViewById(R.id.armingjob_mainmenu_login);
		armingjob_mainmenu_login.setOnClickListener(this);
		armingjob_mainmenu_email.setText("emailtext");
		armingjob_mainmenu_password.setText("passwordtext");
	}
	
	@Override
	public void onClick(View v){
		if(armingjob_mainmenu_login.equals(v)){
			Log.v("login", "click");
			new requestLogin().execute();
		}
	}
	
	private class requestLogin extends AsyncTask<String, Void, ResponseAuthen>{

		
		DialogProcess dialog = new DialogProcess(Login.this);
		ConnectApi connApi = new ConnectApi(Login.this);
		RequestAuthen requestAuthen = new RequestAuthen();
		String JSONObjSend;
		
		public requestLogin(){
			requestAuthen.email = armingjob_mainmenu_email.getText().toString();
			requestAuthen.password = armingjob_mainmenu_password.getText().toString();
			
			Log.v("password", requestAuthen.password);
		}
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog.show();
			
			Log.v("login", "pass2");
		}
		
		@Override
		protected ResponseAuthen doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			
			JSONObjSend = new Gson().toJson(requestAuthen);
			ResponseAuthen responseAuthen = connApi.requestLogin(JSONObjSend);
			return responseAuthen;
		}
		
		@Override
		protected void onPostExecute(ResponseAuthen result) {
			super.onPostExecute(result);
			dialog.dismiss();
			
			Log.v("login", "pass3");
			Log.v("json", result.toString());
//			Log.v("email", result.password.toString());
		}
		
	}
}