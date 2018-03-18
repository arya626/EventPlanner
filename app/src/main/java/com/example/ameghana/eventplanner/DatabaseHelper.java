package com.example.ameghana.eventplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.id;

/**
 * Created by Arya Gowda on 11-03-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMNS_ID = "id";
//    private static final String COLUMNS_NAME = "name";
    private static final String COLUMNS_EMAIL = "email";
    private static final String COLUMNS_UNAME = "uname";
    private static final String COLUMNS_PASS = "pass";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null ,"+
            "uname text not null, email text not null, pass text not null)";

    public DatabaseHelper(Context context) {
        super(context , DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(TABLE_CREATE);
        this.db=db;
    }

    public void insertContact(Contact c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();
        values.put(COLUMNS_ID, count);
        values.put(COLUMNS_UNAME, c.getUname());
        values.put(COLUMNS_EMAIL, c.getEmail());
        values.put(COLUMNS_PASS, c.getPass());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
     public String searchPass(String email1){
         db = this.getReadableDatabase();
         String query = "select email, pass from " +TABLE_NAME;
         Cursor cursor = db.rawQuery(query, null);
         String a,b;
         b= "not found";
         if(cursor.moveToFirst()){
             do{
                 a= cursor.getString(cursor.getColumnIndex("email"));


                 if (a.equals(email1)){
                     b = cursor.getString(cursor.getColumnIndex("pass"));
                     break;
                 }
             }while(cursor.moveToNext());
         }
         return b;
     }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String query = "DROP TABLE IF EXISTS"+ TABLE_CREATE;
        db.execSQL(query);
        this.onCreate(db);
    }
}
