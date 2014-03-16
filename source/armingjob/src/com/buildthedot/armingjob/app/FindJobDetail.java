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
import com.buildthedot.armingjob.request.RequestFindJobDetail;
import com.buildthedot.armingjob.response.ResponseAuthen;
import com.buildthedot.armingjob.response.ResponseFindJobDefault;
import com.buildthedot.armingjob.response.ResponseFindJobDetail;
import com.buildthedot.armingjob.service.ConnectApi;
import com.buildthedot.armingjob.service.SharedPref;
import com.buildthedot.armingjob.service.SharedPref2;

public class FindJobDetail extends Activity  {
	
	SharedPref pref = new SharedPref(FindJobDetail.this);
	String DB_job_jobID = null;
	String DB_job_CompanyID = null;
	String DB_job_position_thai = null;
	String DB_job_position_eng = null;
	String DB_job_salary = null;
	String DB_job_job_description = null;
	String DB_job_date_start = null;
	String DB_job_date_end = null;
	String DB_job_job_type = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.findjobdetail);
		setView();
	}
	
	public void setView(){
		new getFindJob().execute();
	}
	
	//############# Class 
	private class getFindJob extends AsyncTask<String, Void, ResponseFindJobDetail>{

		DialogProcess dialog = new DialogProcess(FindJobDetail.this);
		ConnectApi connApi = new ConnectApi(FindJobDetail.this);
		RequestFindJobDetail requestFindJobDetail = new RequestFindJobDetail();
		
		public getFindJob(){
			Log.v("DB_job_jobID", pref.get_DB_job_jobID());
			requestFindJobDetail.jobID = pref.get_DB_job_jobID();
		}
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog.show();
		}
		
		@Override
		protected ResponseFindJobDetail doInBackground(String... params) {
			// TODO Auto-generated method stub
			
	    	ResponseFindJobDetail responseFindJobDetail = connApi.requestFindJobDetail(requestFindJobDetail.jobID);
			return responseFindJobDetail;
		}
		
		@Override
		protected void onPostExecute(ResponseFindJobDetail result) {
			super.onPostExecute(result);
			dialog.dismiss();
			
//			Log.v("result_findjobdetail", result.position_eng);
			
			 
		}
		
	}
}