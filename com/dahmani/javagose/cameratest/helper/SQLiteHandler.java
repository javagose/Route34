package com.dahmani.javagose.cameratest.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.HashMap;

public class SQLiteHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "android_api";
    private static final int DATABASE_VERSION = 1;
    private static final int ID = 0;
    private static final String KEY_CREATED_AT = "created_at";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_UID = "uid";
    private static final String TABLE_USER = "user";
    private static final String TAG;

    static {
        TAG = SQLiteHandler.class.getSimpleName();
    }

    public SQLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user(id INTEGER PRIMARY KEY,name TEXT,email TEXT UNIQUE,uid TEXT,created_at TEXT)");
        Log.d(TAG, "Database tables created");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }

    public void addUser(String name, String email, String uid, String created_at) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_EMAIL, email);
        values.put(KEY_UID, uid);
        values.put(KEY_CREATED_AT, created_at);
        long id = db.insert(TABLE_USER, null, values);
        db.close();
        Log.d(TAG, "New user inserted into sqlite: " + id);
    }

    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM user", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            user.put(KEY_NAME, cursor.getString(DATABASE_VERSION));
            user.put(KEY_EMAIL, cursor.getString(2));
            user.put(KEY_UID, cursor.getString(3));
            user.put(KEY_CREATED_AT, cursor.getString(4));
        }
        cursor.close();
        db.close();
        Log.d(TAG, "Fetching user from Sqlite: " + user.toString());
        return user;
    }

    public String getUserUid() {
        String uuid = (String) getUserDetails().get(KEY_UID);
        return uuid != null ? uuid : " ";
    }

    public String getUserNmae() {
        String name = (String) getUserDetails().get(KEY_NAME);
        return name != null ? name : null;
    }

    public void deleteUsers() {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_USER, null, null);
        db.close();
        Log.d(TAG, "Deleted all user info from sqlite");
    }
}
