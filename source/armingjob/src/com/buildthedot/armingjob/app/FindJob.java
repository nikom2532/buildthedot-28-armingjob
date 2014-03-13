package com.buildthedot.armingjob.app;

import java.util.ArrayList;
import java.util.List;

import com.buildthedot.armingjob.R;

import android.os.Bundle;
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
import com.buildthedot.armingjob.function.FindjobListAdapter;

public class FindJob extends Activity  {
	
	public class codeLeanChapter {
		String titlejob;
		String companyName;
		String address;
	}
	CodeLearnAdapter chapterListAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.findjob);
		setView();
	}
	void setView(){
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
			
			codeLeanChapter chapter = codeLeanChapterList.get(arg0);
			
			titlejob.setText(chapter.titlejob);
			companyName.setText(chapter.companyName);
			address.setText(chapter.address);
			
			return arg1;
		}
		
		public codeLeanChapter getCodeLearnChapter(int position)
		{
			return codeLeanChapterList.get(position);
		}

    }
	
	//#################################
	//Add list of job in this List
	public List<codeLeanChapter> getDataForListView()
    {
    	List<codeLeanChapter> codeLeanChaptersList = new ArrayList<codeLeanChapter>();
    	
    	for(int i=0;i<10;i++)
    	{
    		
    		codeLeanChapter chapter = new codeLeanChapter();
    		chapter.titlejob = "Chapter "+i;
    		chapter.companyName = "This is chapter "+i;
    		chapter.address = "This is address "+i;
    		codeLeanChaptersList.add(chapter);
    	}
    	
    	return codeLeanChaptersList;
    	
    }
}
