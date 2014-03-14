package com.buildthedot.armingjob.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPref {
	private static String PREF_PROFILE = "PREF_Profile";
	private static String PREF_LANG = "PREF_LANG";
	
	private static String RegisterNewUserNid = "RegisterNewUserNid";
	private static String RegisterNewUserThaiFlag = "RegisterNewUserThaiFlag";
	private static String LoginEFillingNid = "LoginEFillingNid";
	private static String ResetPasswordStep1_email = "ResetPasswordStep1_email";
	
	Context context;
	SharedPreferences mPref;

	public SharedPref(Context context) {
		this.context = context;
		mPref = context.getSharedPreferences(PREF_LANG, Context.MODE_PRIVATE);
	}

	public Boolean setLang(String value) {
		SharedPreferences.Editor editor = mPref.edit();
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

	public void setString(String variable, String value) {
		SharedPreferences.Editor editor = mPref.edit();
		editor.putString(variable, value);
		editor.commit();
	}

	public String getString(String variable) {
		String value = mPref.getString(variable, "");
		return value;
	}
	
	public Boolean delString(String variable) {
		if (mPref != null) {
			Editor edit = mPref.edit();
			edit.remove(variable);
			edit.commit();
		}
		return true;
	}

	public Boolean setProfile(String value) {
		SharedPreferences.Editor editor = mPref.edit();
		editor.putString(PREF_PROFILE, value);
		editor.commit();
		return true;
	}

	public String getProfile() {
		String value = mPref.getString(PREF_PROFILE, "");
		return value;
	}
	
	//register
	
	public Boolean setRegisterNewUserNid(String value) {
		SharedPreferences.Editor editor = mPref.edit();
		editor.putString(RegisterNewUserNid, value);
		editor.commit();
		return true;
	}
	public String getRegisterNewUserNid() {
		String value = mPref.getString(RegisterNewUserNid, "");
		return value;
	}
	public Boolean setRegisterNewUserThaiFlag(String value) {
		SharedPreferences.Editor editor = mPref.edit();
		editor.putString(RegisterNewUserThaiFlag, value);
		editor.commit();
		return true;
	}
	public String getRegisterNewUserThaiFlag() {
		String value = mPref.getString(RegisterNewUserThaiFlag, "");
		return value;
	}
	
	//forget Password
	public Boolean setLoginEFillingNid(String value) {
		SharedPreferences.Editor editor = mPref.edit();
		editor.putString(LoginEFillingNid, value);
		editor.commit();
		return true;
	}
	public String getLoginEFillingNid() {
		String value = mPref.getString(LoginEFillingNid, "");
		return value;
	}
	
	public Boolean setResetPasswordStep1_email(String value) {
		SharedPreferences.Editor editor = mPref.edit();
		editor.putString(ResetPasswordStep1_email, value);
		editor.commit();
		return true;
	}
	public String getResetPasswordStep1_email() {
		String value = mPref.getString(ResetPasswordStep1_email, "");
		return value;
	}
}