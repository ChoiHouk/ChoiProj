package com.example.acer.login.Login_Related;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPrefManager {
    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME = "mysharedpref12";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_USER_EMAIL = "useremail";
    private static final String KEY_USER_BIRTHDAY = "userbirth";
    private static final String KEY_USER_EXP = "userexp";
    private static final String KEY_USER_LEVEL = "userlevel";
    private static final String KEY_TOGETHER_SWITCH = "userWith_cntisChecked";


    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public boolean userLogin(String email,String name,String birthday,int exp, int level ){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_USER_EMAIL,email);
        editor.putString(KEY_USERNAME,name);
        editor.putString(KEY_USER_BIRTHDAY,birthday);
        editor.putInt(KEY_USER_EXP,exp);
        editor.putInt(KEY_USER_LEVEL,level);

        editor.apply();

        return true;
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_USERNAME,null) != null){
            return true;
        }
        return false;
    }

    public boolean logout(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }

    public String getUsername(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME,null);

    }
    public String getUserEmail(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_EMAIL,null);
    }
    public boolean isKeyTogetherSwitch(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(KEY_TOGETHER_SWITCH,false);
    }

}