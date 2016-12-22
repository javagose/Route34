package com.dahmani.javagose.cameratest.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class SessionManager {
    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";
    private static final String PREF_NAME = "AndroidHiveLogin";
    private static String TAG;
    int PRIVATE_MODE;
    Context _context;
    Editor editor;
    SharedPreferences pref;

    static {
        TAG = SessionManager.class.getSimpleName();
    }

    public SessionManager(Context context) {
        this.PRIVATE_MODE = 0;
        this._context = context;
        this.pref = this._context.getSharedPreferences(PREF_NAME, this.PRIVATE_MODE);
        this.editor = this.pref.edit();
    }

    public void setLogin(boolean isLoggedIn) {
        this.editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);
        this.editor.commit();
        Log.d(TAG, "User login session modified!");
    }

    public boolean isLoggedIn() {
        return this.pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }
}
