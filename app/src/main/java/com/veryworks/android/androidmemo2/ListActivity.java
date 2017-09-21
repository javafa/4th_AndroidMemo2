package com.veryworks.android.androidmemo2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 안드로이드 sqlite 사용하기
 * 1. db파일을 직접 코드로 생성
 * 2. 로컬에서 만든 파일을 assets에 담은후 복사 붙여넣기
 *    > 우편번호처럼 기반 데이터가 필요한 db일 경우
 */
public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // 1. 데이터베이스 연결
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase con = helper.getWritableDatabase();

        // 2. 데이터 넣기
//        long now = System.currentTimeMillis();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
//        String date = sdf.format(now);
        String insertQuery = " insert into memo(title,content,n_date)" +
                " values('제목테스트', '내용입니다', datetime())";
        con.execSQL(insertQuery);

        // 3. 데이터 읽기
        String selectQuery = "select * from memo";
        Cursor cursor = con.rawQuery(selectQuery, null);

        while(cursor.moveToNext()){
            // 컬럼 인덱스를 가져오는 명령어
            int c_index = cursor.getColumnIndex("id");
            int    id      = cursor.getInt(c_index);

            c_index = cursor.getColumnIndex("title");
            String title   = cursor.getString(c_index);

            c_index = cursor.getColumnIndex("content");
            String content = cursor.getString(c_index);

            c_index = cursor.getColumnIndex("n_date");
            String n_date  = cursor.getString(c_index);

            System.out.printf("id=%d, title=%s, content=%s, n_date=%s \n", id, title, content, n_date);
        }

    }
}
