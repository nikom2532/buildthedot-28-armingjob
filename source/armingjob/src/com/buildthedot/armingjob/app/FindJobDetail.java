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
import android.content.DialogInterface;
import android.content.Intent;

import com.buildthedot.armingjob.function.DialogProcess;
import com.buildthedot.armingjob.function.FindjobListAdapter;
import com.buildthedot.armingjob.function.PopupDialog;
import com.buildthedot.armingjob.request.RequestFindJobDetail;
import com.buildthedot.armingjob.response.ResponseAuthen;
import com.buildthedot.armingjob.response.ResponseFindJobDefault;
import com.buildthedot.armingjob.response.ResponseFindJobDetail;
import com.buildthedot.armingjob.service.ConnectApi;
import com.buildthedot.armingjob.service.SharedPref;
import com.buildthedot.armingjob.service.SharedPref2;

public class FindJobDetail extends Activity  {
	
//	String DB_job_jobID = null;
//	String DB_job_CompanyID = null;
//	String DB_job_position_thai = null;
//	String DB_job_position_eng = null;
//	String DB_job_salary = null;
//	String DB_job_job_description = null;
//	String DB_job_date_start = null;
//	String DB_job_date_end = null;
//	String DB_job_job_type = null;
	
	TextView armingjob_findjob_value_titlejob;
	TextView armingjob_findjob_value_companyName;
	TextView armingjob_findjob_value_address;
	TextView armingjob_findjob_value_time;
	
	PopupDialog popup = new PopupDialog(FindJobDetail.this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.findjobdetail);
		setView();
	}
	
	public void setView(){
		armingjob_findjob_value_titlejob = (TextView) findViewById(R.id.armingjob_findjob_value_titlejob);
		armingjob_findjob_value_companyName = (TextView) findViewById(R.id.armingjob_findjob_value_companyName);
		armingjob_findjob_value_address = (TextView) findViewById(R.id.armingjob_findjob_value_address);
		armingjob_findjob_value_time = (TextView) findViewById(R.id.armingjob_findjob_value_time);
		
		new getFindJob().execute();
	}
	
	//############# Class 
	private class getFindJob extends AsyncTask<String, Void, ResponseFindJobDetail>{

		DialogProcess dialog = new DialogProcess(FindJobDetail.this);
		ConnectApi connApi = new ConnectApi(FindJobDetail.this);
		RequestFindJobDetail requestFindJobDetail = new RequestFindJobDetail();
		
		public getFindJob(){
			SharedPref pref = new SharedPref(FindJobDetail.this);
//			Log.v("DB_job_jobID", pref.get_DB_job_jobID());
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
			
			if(result.message.equals("1")){
				
				Log.v("result_findjobdetail", result.jobID);
				armingjob_findjob_value_titlejob.setText(result.position_thai);
				armingjob_findjob_value_companyName.setText(result.CompanyName);
				armingjob_findjob_value_address.setText(result.CompanyAddress);
				armingjob_findjob_value_time.setText(result.date_start);
				
				
			}
			else if(result.message.equals("0")){
				popup.show(
					"Error occur, please type again", 
					"OK",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							finish();
						}
					}
				);
			}
			
		}
	}
}