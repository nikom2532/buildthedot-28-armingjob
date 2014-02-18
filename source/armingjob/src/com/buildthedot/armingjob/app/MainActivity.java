package com.buildthedot.armingjob.app;

import com.buildthedot.armingjob.R;
import com.buildthedot.armingjob.R.layout;
import com.buildthedot.armingjob.R.menu;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {
	int SPLASH_TIME_OUT = 2000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Intent intent = new Intent(this, ResetPasswordForgetquestionInternational.class);
		// intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		// startActivity(intent);
		// finish();
		
//		new Handler().postDelayed(new Runnable() {
//
//			@Override
//			public void run() {
//				Intent i = new Intent(MainActivity.this, MainMenu.class);
//				startActivity(i);
//				finish();
//			}
//		}, SPLASH_TIME_OUT);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
