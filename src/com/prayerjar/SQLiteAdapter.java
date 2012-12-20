package com.prayerjar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SQLiteAdapter {

 public static final String MYDATABASE_NAME = "MY_DATABASE";
 public static final String MYDATABASE_TABLE = "MY_TABLE";
 public static final int MYDATABASE_VERSION = 1;
 public static final String KEY_CONTENT = "Content";
 public static final String DATE = "Date";
 public static final String ANSWERED = "Prayed";

 //create table MY_DATABASE (ID integer primary key, Content text not null);
 private static final String SCRIPT_CREATE_DATABASE =
  "create table " + MYDATABASE_TABLE + " ("+DATE+" text not null, "+KEY_CONTENT+" text not null, "+ANSWERED+" text not null);";
 
 private SQLiteHelper sqLiteHelper;
 private SQLiteDatabase sqLiteDatabase;

 private Context context;
 
 public SQLiteAdapter(Context c){
  context = c;
 }
 
 public SQLiteAdapter openToRead() throws android.database.SQLException {
  sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
  sqLiteDatabase = sqLiteHelper.getReadableDatabase();
  return this; 
 }
 
 public SQLiteAdapter openToWrite() throws android.database.SQLException {
  sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
  sqLiteDatabase = sqLiteHelper.getWritableDatabase();
  return this; 
 }
 
 public void close(){
  sqLiteHelper.close();
 }
 
 public long insert(String content, String date, String answered){
  
  ContentValues contentValues = new ContentValues();
  contentValues.put(KEY_CONTENT, content);
  contentValues.put(DATE, date);
  contentValues.put(ANSWERED, answered);
  return sqLiteDatabase.insert(MYDATABASE_TABLE, null, contentValues);
 }
 
 public int deleteAll(){
  return sqLiteDatabase.delete(MYDATABASE_TABLE, null, null);
 }

 public void delete_byRow(String date){
	 sqLiteDatabase.delete(MYDATABASE_TABLE, DATE+"='"+date+"'", null);
}
 
 public void updateValue(String key, String value, String position){
	 
	ContentValues contentValues = new ContentValues();
	contentValues.put(key, value);
	sqLiteDatabase.update(MYDATABASE_TABLE, contentValues, DATE+"='"+position+"'", null);
	 
 }

 
 public Cursor queueAll(){
  String[] columns = new String[]{KEY_CONTENT, DATE, ANSWERED};
  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
    null, null, null, null, DATE+" DESC");
  return cursor;
 }
 
 public class SQLiteHelper extends SQLiteOpenHelper {

  public SQLiteHelper(Context context, String name,
    CursorFactory factory, int version) {
   super(context, name, factory, version);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
   // TODO Auto-generated method stub
	 
	  
   db.execSQL(SCRIPT_CREATE_DATABASE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
   // TODO Auto-generated method stub

  }
  
  
  

 }
 
}