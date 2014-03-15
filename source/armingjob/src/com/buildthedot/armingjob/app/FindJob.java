package com.buildthedot.armingjob.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

public class FindJob extends Activity  {
	
	SharedPref2 pref = new SharedPref2(FindJob.this);
	ArrayList<String> DB_job_jobID = new ArrayList<String>();
	ArrayList<String> DB_job_CompanyID = new ArrayList<String>();
	ArrayList<String> DB_job_position_thai = new ArrayList<String>();
	ArrayList<String> DB_job_position_eng = new ArrayList<String>();
	ArrayList<String> DB_job_salary = new ArrayList<String>();
	ArrayList<String> DB_job_job_description = new ArrayList<String>();
	ArrayList<String> DB_job_date_start = new ArrayList<String>();
	ArrayList<String> DB_job_date_end = new ArrayList<String>();
	ArrayList<String> DB_job_job_type = new ArrayList<String>();
	
	TextView date_start2;
	
	public class codeLeanChapter {
		String titlejob;
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
		new getFindJob().execute();
//		setView();
//		setRunable();
		setRunable2();
	}
	void setView2(){
		date_start2 = (TextView)findViewById(R.id.armingjob_findjob_value_time);
	}
	void setView(){
		
		date_start2 = (TextView)findViewById(R.id.armingjob_findjob_value_time);
		
		chapterListAdapter = new CodeLearnAdapter();
        
        ListView codeLearnLessons = (ListView)findViewById(R.id.listView1);
        codeLearnLessons.setAdapter(chapterListAdapter);
        
        codeLearnLessons.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				codeLeanChapter chapter = chapterListAdapter.getCodeLearnChapter(arg2);
				
				Toast.makeText(FindJob.this, chapter.titlejob,Toast.LENGTH_LONG).show();
				
			}
		});
	}
	
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
			
			if(arg1==null)
			{
				LayoutInflater inflater = (LayoutInflater) FindJob.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				arg1 = inflater.inflate(R.layout.findjoblist, arg2,false);
			}
			
			TextView titlejob = (TextView)arg1.findViewById(R.id.armingjob_findjob_value_titlejob);
			TextView companyName = (TextView)arg1.findViewById(R.id.armingjob_findjob_value_companyName);
			TextView address = (TextView)arg1.findViewById(R.id.armingjob_findjob_value_address);
			TextView date_start = (TextView)arg1.findViewById(R.id.armingjob_findjob_value_time);
			
			codeLeanChapter chapter = codeLeanChapterList.get(arg0);
			
			titlejob.setText(chapter.titlejob);
			companyName.setText(chapter.companyName);
			address.setText(chapter.address);
			date_start.setText(chapter.date_start);
			
			return arg1;
		}
		
		public codeLeanChapter getCodeLearnChapter(int position)
		{
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
				DB_job_CompanyID.add(result.data.get(i).CompanyID);
				DB_job_date_start.add(result.data.get(i).date_start);
			}
			
//			Log.v("result.data.size()", String.valueOf(result.data.size()));
			
//			pref.setString("DB_job_id", result.data.get(0).CompanyID);
//			Log.v("constant_test", pref.getString("DB_job_id"));
			setView();
		}
		
	}
	
	public void setRunable2(){
//		
//	  new Thread() {
//	        public void run() {
//	            int i = 0;
//				while(i > 0) {
//	                try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//	                date_start2.post(new Runnable() {
//	                    public void run() {
//	                    	date_start2.setText(Integer.toString(5));
//	                    	Log.v("5", "5");
//	                    }
//	                });
//	                i--;
//	            }
//	        }
//	    }.start();
	    Log.v("5", "5");
		
//		int i=1;
//		while(i==1){
//			setRunable();
//		}
	}
	
	public void setRunable(){
//		int i;
//		for(i=1; i<10; i++){
//				new Handler().postDelayed(new Runnable() {
//					@Override
//					public void run() {
//						for(int i=0; i<DB_job_date_start.size(); i++){
//							Log.v("delay_value_0", DB_job_date_start.get(i));
//							DB_job_date_start.set(i, String.valueOf(Integer.parseInt(DB_job_date_start.get(i)) + 1000));
//		//					date_start2.setText(DB_job_date_start.get(i));
//							Log.v("delay_i", String.valueOf(i));
//							Log.v("delay_value", DB_job_date_start.get(i));
//						}
//					}
//				}, 1000);
//		}
//		Log.v("DB_job_date_start", DB_job_date_start.get(0));
		
		
		
//		Handler handler = new Handler();
//	    Runnable runnable = new Runnable() {
//	        public long startTime = System.currentTimeMillis();
//	        public void run() {
//                try {
//                    Thread.sleep(1000);
//                }    
//                catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                handler.post(new Runnable(){
//                    public void run() {
//                       tvTime.setText("" + ((System.currentTimeMillis() - this.startTime) / 1000));
//                    }
//	            });
//	        }
//	    };
//	    new Thread(runnable).start();
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
    		chapter.titlejob = DB_job_jobID.get(i);
    		chapter.companyName = DB_job_CompanyID.get(i);
    		chapter.address = "" + i;
    		chapter.date_start = DB_job_date_start.get(i);
    		codeLeanChaptersList.add(chapter);
    	}
    	return codeLeanChaptersList;
    }
}
