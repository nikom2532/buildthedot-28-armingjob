package com.buildthedot.armingjob.app;

import com.buildthedot.armingjob.R;

import android.os.Bundle;
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
	}
	
	@Override
	public void onClick(View v){
		if(armingjob_mainmenu_login.equals(v)){
			
		}
	}
}