package com.buildthedot.armingjob.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.buildthedot.armingjob.R;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.buildthedot.armingjob.function.DialogProcess;
import com.buildthedot.armingjob.function.FindjobListAdapter;
import com.buildthedot.armingjob.response.ResponseAuthen;
import com.buildthedot.armingjob.response.ResponseFindJobDefault;
import com.buildthedot.armingjob.service.ConnectApi;
import com.buildthedot.armingjob.service.SharedPref2;

public class FindJobDetail extends Activity  {
	
	SharedPref2 pref = new SharedPref2(FindJobDetail.this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.findjob);
		setView();
	}
	
	public void setView(){
		
	}
	
	//############# Class 
	private class getFindJob extends AsyncTask<String, Void, ResponseFindJobDefault>{

		DialogProcess dialog = new DialogProcess(FindJobDetail.this);
		ConnectApi connApi = new ConnectApi(FindJobDetail.this);
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog.show();
		}
		
		@Override
		protected ResponseFindJobDefault doInBackground(String... params) {
			// TODO Auto-generated method stub
			
	    	ResponseFindJobDefault responseFindJob = connApi.requestFindJobDefault();
			return responseFindJob;
		}
		
		@Override
		protected void onPostExecute(ResponseFindJobDefault result) {
			super.onPostExecute(result);
			dialog.dismiss();
		}
		
	}
}