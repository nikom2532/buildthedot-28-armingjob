package com.buildthedot.armingjob.app;

import com.buildthedot.armingjob.R;
import com.buildthedot.armingjob.function.DialogProcess;
import com.buildthedot.armingjob.response.ResponseLogin;
import com.buildthedot.armingjob.service.ConnectApi;

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
	}
	
	@Override
	public void onClick(View v){
		if(armingjob_mainmenu_login.equals(v)){
			Log.v("login", "click");
			new requestLogin().execute();
		}
	}
	
	private class requestLogin extends AsyncTask<String, Void, ResponseLogin>{

		
		DialogProcess dialog = new DialogProcess(Login.this);
		ConnectApi connApi = new ConnectApi(Login.this);
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog.show();
			
			Log.v("login", "pass2");
		}
		
		@Override
		protected ResponseLogin doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		protected void onPostExecute(ResponseLogin result) {
			super.onPostExecute(result);
			dialog.dismiss();
			
			Log.v("login", "pass3");
			//Log.v("email", result.email);
		}
		
	}
}