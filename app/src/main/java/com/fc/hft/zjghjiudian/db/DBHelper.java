package com.fc.hft.zjghjiudian.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库创建工具类
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "common.db";

    private String CREATE_TABLE = "create table account(bizID integer,bizAccount integer,bizAddress" +
            " varchar(100),bizImagePath varchar(100))";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (newVersion){
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
        }

    }
}
