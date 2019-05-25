package com.example.saba.finalproject.prefrances;

import android.content.Context;
import android.content.SharedPreferences;

public class UtilClipsCode {
    final  static String FileName="myFiileName";
    public static String readSharedSetting(Context ctx, String settingName, String defaultValue){
        SharedPreferences sharedpref =ctx.getSharedPreferences(FileName, Context.MODE_PRIVATE);
        return  sharedpref.getString(settingName,defaultValue);
    }
    public static void savesharedSetting(Context ctx, String settingName, String settingValue){
        SharedPreferences sharedpref =ctx.getSharedPreferences(FileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedpref.edit();
        editor.putString(settingName,settingValue);
        editor.apply();
    }
}
