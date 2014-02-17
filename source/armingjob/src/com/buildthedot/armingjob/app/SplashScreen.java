package com.buildthedot.armingjob.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {
	int SPLASH_TIME_OUT = 2000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setView();
		
		// For View in another activity for development

		// Intent intent = new Intent(this, ResetPasswordForgetquestionInternational.class);
		// intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		// startActivity(intent);
		// finish();

//		new Handler().postDelayed(new Runnable() {
//
//			@Override
//			public void run() {
////				Intent i = new Intent(SplashScreen.this, MainEFilling.class);
////				Intent i = new Intent(SplashScreen.this, TermsAndConditions.class);
////				Intent i = new Intent(SplashScreen.this, InstructionsList.class);
////				Intent i = new Intent(SplashScreen.this, RegisterStep1.class);
////				Intent i = new Intent(SplashScreen.this, RegisterStep3.class);
////				Intent i = new Intent(SplashScreen.this, ResetPasswordStep1.class);
////				Intent i = new Intent(SplashScreen.this, ResetPasswordHaveEmailRequest.class);
////				Intent i = new Intent(SplashScreen.this, ResetPasswordNoHaveEmailRequest.class);
////				Intent i = new Intent(SplashScreen.this, ResetPasswordNoHaveEmailRequestStep2.class);
////				Intent i = new Intent(SplashScreen.this, ResetPasswordForgetquestionThai.class);
////				Intent i = new Intent(SplashScreen.this, ResetPasswordWithNid.class);
////				Intent i = new Intent(SplashScreen.this, ResultFilling.class);
////				Intent i = new Intent(SplashScreen.this, UpdateProfile.class);
////				Intent i = new Intent(SplashScreen.this, Login_E_Filing.class);
//				startActivity(i);
//				finish();
//			}
//		}, SPLASH_TIME_OUT);
		
	}

	void setView() {
//		setContentView(R.layout.splashscreen);
	}
}