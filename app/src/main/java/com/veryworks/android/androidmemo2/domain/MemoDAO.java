package com.veryworks.android.androidmemo2.domain;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.veryworks.android.androidmemo2.DBHelper;

/**
 * DAO Data Access Object
 * 데이터 조작을 담당
 *
 * 사용 예)
 * MemoDAO dao = new DAO();              1. DAO 객체를 생성
 * String query = "insert into...()";    2. Query 생성
 * dao.create(query);                    3. 쿼리 실행
 *
 */
public class MemoDAO {
    DBHelper helper;
    // DBHelper 생성
    public MemoDAO(Context context){
        helper = new DBHelper(context);
    }
    // C 생성
    public void create(String query){
        // 1. 데이터베이스에 연결
        SQLiteDatabase con = helper.getWritableDatabase();
        // 2. 조작
        con.execSQL(query);  // query = "insert into....";
        // 3. 연결을 해제
        con.close();
    }
    // R 읽기
    public void read(String query){
        // 1. 데이터베이스에 연결
        SQLiteDatabase con = helper.getReadableDatabase();
        // 2. 조작
        Cursor cursor = con.rawQuery(query, null);  // query = "insert into....";
        // 반복문...

        // 3. 연결을 해제
        con.close();
    }
    // U 수정
    public void update(String query){
        SQLiteDatabase con = helper.getWritableDatabase();
        con.execSQL(query);
        con.close();
    }
    // D 삭제
    public void delete(String query){
        SQLiteDatabase con = helper.getWritableDatabase();
        con.execSQL(query);
        con.close();
    }
    // 사용한 DAO를 닫는다.
    public void close(){
        helper.close();
    }
}
