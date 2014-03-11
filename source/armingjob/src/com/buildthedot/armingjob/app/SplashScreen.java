package com.buildthedot.armingjob.app;

import com.buildthedot.armingjob.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {
	int SPLASH_TIME_OUT = 2000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setView();
		
		// For View in another activity for development

		// Intent intent = new Intent(this, ResetPasswordForgetquestionInternational.class);
		// intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		// startActivity(intent);
		// finish();
		
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				Intent i = new Intent(SplashScreen.this, HomePage.class);
				startActivity(i);
				finish();
			}
		}, SPLASH_TIME_OUT);
		
	}

	void setView() {
		setContentView(R.layout.splashscreen);
	}
}