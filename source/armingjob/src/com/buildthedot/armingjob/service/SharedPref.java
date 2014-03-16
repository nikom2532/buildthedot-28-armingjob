package com.buildthedot.armingjob.service;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPref {
	private static String PREF_LANG = "PREF_LANG";
	
	private static String DB_job_jobID = "DB_job_jobID";
	
	Context context;
	SharedPreferences mPref;

	public SharedPref(Context context) {
		this.context = context;
		mPref = context.getSharedPreferences(PREF_LANG, Context.MODE_PRIVATE);
	}

	//#######################################################
	
	public Boolean set_DB_job_jobID(String value) {
		Editor editor = mPref.edit();
		editor.putString(DB_job_jobID, value);
		editor.commit();
		return true;
	}
	
	public String get_DB_job_jobID() {
		String value = mPref.getString(DB_job_jobID, "TH");
		return value;
	}
	
	public Boolean del_DB_job_jobID() {
		if (mPref != null) {
			Editor edit = mPref.edit();
			edit.remove(DB_job_jobID);
			edit.commit();
		}
		return true;
	}
	
	//########################################################
	
	public Boolean setLang(String value) {
		Editor editor = mPref.edit();
		editor.putString(PREF_LANG, value);
		editor.commit();
		return true;
	}
	
	public String getLang() {
		String value = mPref.getString(PREF_LANG, "TH");
		return value;
	}
	
	public Boolean delLang() {
		if (mPref != null) {
			Editor edit = mPref.edit();
			edit.remove(PREF_LANG);
			edit.commit();
		}
		return true;
	}
	
	//########################################################
	
	public void setString(String variable, String value) {
		SharedPreferences.Editor editor = mPref.edit();
		editor.putString(variable, value);
		editor.commit();
	}

	public String getString(String variable) {
		String value = mPref.getString(variable, "");
		return value;
	}
	
	public Boolean deleteString(String variable) {
		if (mPref != null) {
			Editor edit = mPref.edit();
			edit.remove(variable);
			edit.commit();
		}
		return true;
	}
}