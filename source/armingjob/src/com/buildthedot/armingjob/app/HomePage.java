package com.buildthedot.armingjob.app;

import com.buildthedot.armingjob.R;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class HomePage extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);
		setView();
	}
	void setView(){
	}
	
	@Override
	public void onClick(View v) {
	}

}
