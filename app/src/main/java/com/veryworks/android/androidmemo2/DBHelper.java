package com.veryworks.android.androidmemo2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pc on 9/21/2017.
 */

public class DBHelper extends SQLiteOpenHelper{
    private static final String DB_NAME = "sqlite.db";
    private static final int DB_VERSION = 1;

    public DBHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
        // super 에서 넘겨받은 데이터베이스가 생성되어 있는지 확인한후
        // 1. 없으면 onCreate를 호출
        // 2. 있으면 버전을 체크해서 생성되어 있는 DB보다 버전이 높으면
        //    opUpgrade를 호출해준다.
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // 최초 생성할 테이블을 정의
        String createQuery = "CREATE TABLE `memo` ( \n" +
                "`id` INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                "`title` TEXT, \n" +
                "`content` TEXT, \n" +
                "`n_date` TEXT )";
        // 쿼리를 실행해서 테이블을 생성한다.
        sqLiteDatabase.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
