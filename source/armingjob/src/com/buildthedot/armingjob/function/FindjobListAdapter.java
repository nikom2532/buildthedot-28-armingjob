package com.buildthedot.armingjob.function;

import com.buildthedot.armingjob.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FindjobListAdapter extends BaseAdapter{

	private final LayoutInflater mInflater;
	private final String[] mItems;
	
	public FindjobListAdapter(Activity c,String[] objects) {
		mInflater = c.getLayoutInflater();
		mItems = objects;
	}
	
	public int getCount() {
		return mItems.length;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.findjoblist, null);
		}
		((TextView)convertView).setText(mItems[position]);

		return convertView;
	}

	@Override
	public Object getItem(int position) {
		return mItems[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

}
