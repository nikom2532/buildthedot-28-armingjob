package com.buildthedot.armingjob.app;

import com.buildthedot.armingjob.R;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.app.Activity;
import android.content.Intent;
import com.buildthedot.armingjob.function.FindjobListAdapter;

public class FindJob extends Activity  {
	
	final static int ELEMENT_COUNT = 400;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.findjob);
		setView();
	}
	void setView(){
		String[] elements = new String[ELEMENT_COUNT];
        
        for (int i = 0; i< ELEMENT_COUNT; i++) {
        	elements[i] = String.valueOf(i);
        }
        
        FindjobListAdapter adapter = new FindjobListAdapter(this,elements);

        final ListView list = (ListView) findViewById(R.id.list);
        list.setDivider( null ); 
        list.setAdapter(adapter);
	}
	

}
