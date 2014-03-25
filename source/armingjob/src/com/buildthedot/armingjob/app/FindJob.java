package com.buildthedot.armingjob.app;

import java.util.ArrayList;
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
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.buildthedot.armingjob.function.DialogProcess;
import com.buildthedot.armingjob.response.ResponseFindJobDefault;
import com.buildthedot.armingjob.service.ConnectApi;
import com.buildthedot.armingjob.service.SharedPref;

public class FindJob extends Activity  {
	
	ArrayList<String> DB_job_jobID = new ArrayList<String>();
	ArrayList<String> DB_job_CompanyName = new ArrayList<String>();
	ArrayList<String> DB_job_position_thai = new ArrayList<String>();
	ArrayList<String> DB_job_position_eng = new ArrayList<String>();
	ArrayList<String> DB_job_short_address = new ArrayList<String>();
	ArrayList<String> DB_job_salary = new ArrayList<String>();
	ArrayList<String> DB_job_job_description = new ArrayList<String>();
	ArrayList<String> DB_job_date_start = new ArrayList<String>();
	ArrayList<String> DB_job_date_end = new ArrayList<String>();
	ArrayList<String> DB_job_job_type = new ArrayList<String>();
	
	TextView date_start2;
	
	int i=0;
	TextView tv;
	final Handler myHandler = new Handler();
	
	public class codeLeanChapter {
		String jobID;
		String position_thai;
		String companyName;
		String address;
		String date_start;
	}
	CodeLearnAdapter chapterListAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.findjob);
		setView2();
	}
	void setView2(){
		date_start2 = (TextView)findViewById(R.id.armingjob_findjob_value_time);
		new getFindJob().execute();
	}
	
	void TextTimer(){
		Timer myTimer = new Timer();
		myTimer.schedule(new TimerTask() {
			@Override
			public void run() {UpdateGUI();}
		}, 0, 1000);
	}
	
	void UpdateGUI() {
		i++;
		myHandler.post(myRunnable);
	}

	final Runnable myRunnable = new Runnable() {
		public void run() {
			date_start2 = (TextView)findViewById(R.id.armingjob_findjob_value_time);
			for(int i=0; i<DB_job_date_start.size(); i++){
				DB_job_date_start.set(i, String.valueOf(Integer.parseInt(DB_job_date_start.get(i)) + 1000));
				date_start2.setText(String.valueOf(DB_job_date_start.get(i)));
			}
		}
	};
	
	public void setView(){
		
		chapterListAdapter = new CodeLearnAdapter();
        
        ListView codeLearnLessons = (ListView)findViewById(R.id.listView1);
        codeLearnLessons.setAdapter(chapterListAdapter);
        
        codeLearnLessons.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				codeLeanChapter chapter = chapterListAdapter.getCodeLearnChapter(arg2);
				
//				Toast.makeText(FindJob.this, chapter.position_thai,Toast.LENGTH_LONG).show();
				
				SharedPref pref = new SharedPref(FindJob.this);
				pref.del_DB_job_jobID();
				pref.set_DB_job_jobID(chapter.jobID);
				Log.v("----------------------", pref.get_DB_job_jobID());
				Intent i = new Intent(FindJob.this, FindJobDetail.class);
				startActivity(i);
			}
		});
	}
	
	//#################################
	
	public class CodeLearnAdapter extends BaseAdapter {

    	List<codeLeanChapter> codeLeanChapterList = getDataForListView();
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return codeLeanChapterList.size();
		}

		@Override
		public codeLeanChapter getItem(int arg0) {
			// TODO Auto-generated method stub
			return codeLeanChapterList.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			if(arg1==null){
				LayoutInflater inflater = (LayoutInflater) FindJob.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				arg1 = inflater.inflate(R.layout.findjoblist, arg2,false);
			}
			TextView position_thai = (TextView)arg1.findViewById(R.id.armingjob_findjob_value_titlejob);
			TextView companyName = (TextView)arg1.findViewById(R.id.armingjob_findjob_value_companyName);
			TextView address = (TextView)arg1.findViewById(R.id.armingjob_findjob_value_address);
			TextView date_start = (TextView)arg1.findViewById(R.id.armingjob_findjob_value_time);
			
			codeLeanChapter chapter = codeLeanChapterList.get(arg0);
			
			position_thai.setText(chapter.position_thai);
			companyName.setText(chapter.companyName);
			address.setText(chapter.address);
			date_start.setText(chapter.date_start);
			
			return arg1;
		}
		
		public codeLeanChapter getCodeLearnChapter(int position){
			return codeLeanChapterList.get(position);
		}
		
    }
	
	//############# Class 
	private class getFindJob extends AsyncTask<String, Void, ResponseFindJobDefault>{

		DialogProcess dialog = new DialogProcess(FindJob.this);
		ConnectApi connApi = new ConnectApi(FindJob.this);
		
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
//			Log.v("response", result.data.get(0).jobID);
			
			for(int i=0; i<result.data.size(); i++){
				DB_job_jobID.add(result.data.get(i).jobID);
				DB_job_CompanyName.add(result.data.get(i).CompanyName);
				DB_job_date_start.add(result.data.get(i).date_start);
				DB_job_position_thai.add(result.data.get(i).position_thai);
				DB_job_position_eng.add(result.data.get(i).position_eng);
				
				DB_job_short_address.add(result.data.get(i).short_address);
				
				DB_job_salary.add(result.data.get(i).salary);
				DB_job_job_description.add(result.data.get(i).job_description);
				DB_job_date_end.add(result.data.get(i).date_end);
				DB_job_job_type.add(result.data.get(i).job_type);
			}
			setView();
			TextTimer();
		}
	}
	
	//#################################
	//Add list of job in this List
	public List<codeLeanChapter> getDataForListView()
    {
    	List<codeLeanChapter> codeLeanChaptersList = new ArrayList<codeLeanChapter>();
    	
//    	ResponseFindJobDefault result = new ResponseFindJobDefault();
//    	Log.v("response", result.data.get(0).jobID);
    	
    	for(int i=0; i<DB_job_jobID.size(); i++) {
    		codeLeanChapter chapter = new codeLeanChapter();
    		chapter.jobID = DB_job_jobID.get(i);
    		chapter.position_thai = DB_job_position_thai.get(i);
    		chapter.companyName = DB_job_CompanyName.get(i);
    		chapter.address = "" + DB_job_short_address.get(i);
    		chapter.date_start = DB_job_date_start.get(i);
    		codeLeanChaptersList.add(chapter);
    	}
    	return codeLeanChaptersList;
    }
}
