package com.example.niall.coursework2app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "UserData.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null, " +
                    "username text not null , age text not null , email text not null, password text not null)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
        public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertUserDetails(UserDetails c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID , count);
        values.put(COLUMN_USERNAME, c.getUsername());
        values.put(COLUMN_AGE, c.getAge());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_PASSWORD, c.getPassword());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPass(String username) {
        db = this.getReadableDatabase();
        String query = "SELECT username, password FROM contacts";
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "Not Found";

        if (cursor.moveToFirst())
        {
            do {

                a = cursor.getString(0);
                if (a.equals(username))
                {
                    b = cursor.getString(1);
                    break;
                }
            }

            while (cursor.moveToNext());
        }

        return b;
    }






    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query;
        query = "DROP TABLE IF EXISTS" +TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}