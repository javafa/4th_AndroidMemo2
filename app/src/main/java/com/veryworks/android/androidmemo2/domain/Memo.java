package com.veryworks.android.androidmemo2.domain;

/**
 * Created by pc on 9/21/2017.
 */

public class Memo {
    int id;
    String title;
    String content;
    String n_date;

    @Override
    public String toString() {
        return id+"|"+title+"|"+content+"|"+n_date+"\n";
    }
}
