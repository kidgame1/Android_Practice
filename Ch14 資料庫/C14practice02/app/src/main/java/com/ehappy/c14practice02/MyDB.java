package com.ehappy.c14practice02;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class MyDB {
    public SQLiteDatabase db=null; // 資料庫類別
    private final static String	DATABASE_NAME= "mydb.db";
    private final static String	TABLE_NAME="mytable";
    private final static String	_ID	= "_id";
    private final static String	NO = "no";
    private final static String	NAME = "name";

    private final static String	CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + _ID
            + " INTEGER PRIMARY KEY," + NO + " INTEGER,"+ NAME + " TEXT)";

    private Context mCtx = null;
    public MyDB(Context ctx){
        this.mCtx = ctx;
    }

    public void open() throws SQLException {
        db = mCtx.openOrCreateDatabase(DATABASE_NAME, 0, null);
        try	{
            db.execSQL(CREATE_TABLE);
        }catch (Exception e) {
        }
    }

    public void close() {
        db.close();
    }

    public void droptable() {
        db.execSQL("DROP TABLE " + TABLE_NAME);
    }

    public Cursor getAll() {
        return db.query(TABLE_NAME,
                new String[] {_ID, NO, NAME},
                null, null, null, null, NO,null);
    }

    public Cursor get(long rowId) throws SQLException {
        Cursor mCursor = db.query(TABLE_NAME,
                new String[] {_ID, NO, NAME},
                NO +"=" + rowId, null, null, null, null,null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public long append(int no,String name) {
        ContentValues args = new ContentValues();
        args.put(NO, no);
        args.put(NAME, name);
        return db.insert(TABLE_NAME, null, args);
    }
}