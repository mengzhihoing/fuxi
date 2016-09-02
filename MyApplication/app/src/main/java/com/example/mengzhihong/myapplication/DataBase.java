package com.example.mengzhihong.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by mengzhihong on 2016/8/31.
 */
public class DataBase extends SQLiteOpenHelper {
    private static final String DBNAME = "chinese.db";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "t_chinese";
    private static final String CHINESE = "chinese";
    private static final String ID = "_id";
    private SQLiteDatabase myDB;


    public DataBase(Context context) {
        super(context, DBNAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
//         执行时，若表不存在，则创建之，注意SQLite数据库中必须有一个_id的字段作为主键，否则查询时将报错
        String sql = "create table "+TABLE_NAME+" ("+ID+" integer primary key autoincrement,"+ CHINESE+" text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//         数据库被改变时，将原先的表删除，然后建立新表
        String sql = "drop table if exists t_chinese";
        db.execSQL(sql);
        onCreate(db);
    }

    public void openDB(){
        myDB=getWritableDatabase();
    }

    public void closeDB(){
        if (myDB!=null&&myDB.isOpen()){
            myDB.close();
        }
    }

    public long insert(String chinese){
        ContentValues value=new ContentValues();
        value.put(CHINESE,chinese);
        return  myDB.insert(TABLE_NAME,null,value);

    }

    public Cursor getAllRecords(){

        String query= "select * from"+TABLE_NAME;
        return myDB.rawQuery(query,null);

    }


}
