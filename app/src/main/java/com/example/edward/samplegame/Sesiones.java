package com.example.edward.samplegame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import static android.content.Context.MODE_PRIVATE;
import java.util.HashMap;

public class Sesiones{

    public static SharedPreferences pref;
    public static SharedPreferences.Editor editor;
    public static Context _context;

    public static final String PREFER_NAME = "account";
    int PRIVATE_MODE = MODE_PRIVATE;

    public static final String IS_USER_LOGIN = "IsUserLoggedIn";
    public static final String TOKEN = "token";

    private static Sesiones sessionConfig;


    public Sesiones(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public static Sesiones getSessionConfig(Context c) {
        if(sessionConfig == null){
            sessionConfig= new Sesiones(c);
        }
        return sessionConfig;
    }

    public void iniciarConfig(String token) {
        editor.putBoolean(IS_USER_LOGIN, true);
        editor.putString(TOKEN, token);
        editor.commit();
    }

    public boolean checkLogin() {
        // Check login status
        if (!this.isUserLoggedIn()) {

            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(i);

            return true;
        }
        return false;
    }

    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(TOKEN, pref.getString(TOKEN, null));
        return user;
    }

    public String getValue(String key) {
        return pref.getString(key, null);
    }

    public void logoutUser() {

        // Clearing all user data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to MainActivity
        Intent i = new Intent(_context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);
    }

    public boolean isUserLoggedIn() {
        return pref.getBoolean(IS_USER_LOGIN, false);
    }
}
