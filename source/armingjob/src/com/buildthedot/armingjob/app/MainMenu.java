package com.buildthedot.armingjob.app;

import com.buildthedot.armingjob.R;
import com.buildthedot.armingjob.R.layout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainMenu extends Activity {
	
	Button armingjob_mainmenu_login;
	Button armingjob_mainmenu_register;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu);
		setView();
	}
	void setView(){
		armingjob_mainmenu_login = (Button) findViewById(R.id.armingjob_mainmenu_login);
		armingjob_mainmenu_register = (Button) findViewById(R.id.armingjob_mainmenu_register);
	}
	public void onclick(View v) {
		// TODO Auto-generated method stub
		if(armingjob_mainmenu_login.equals(v)){
			Intent intent = new Intent(this, Login.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			startActivity(intent);
		}
		else if(armingjob_mainmenu_register.equals(v)){
			Intent intent = new Intent(this, Login.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			startActivity(intent);
		}
	}

}
