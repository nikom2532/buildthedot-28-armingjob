package com.buildthedot.armingjob.app;

import com.buildthedot.armingjob.R;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainMenu extends Activity implements OnClickListener {
	
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
		armingjob_mainmenu_login.setOnClickListener(this);
		armingjob_mainmenu_register.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		if(armingjob_mainmenu_login.equals(v)){
			Log.v("login label", armingjob_mainmenu_login.getText().toString());
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
