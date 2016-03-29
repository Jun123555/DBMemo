package com.lifeistech.android.dbmemo;

import com.activeandroid.Model;
import com.activeandroid.annotation.Table;
import com.activeandroid.annotation.Column;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/**
 * Created by t80 on 2016/03/28.
 */
@Table(name="memo_table")
public class MemoDB extends Model {
    @Column(name="title")
    public String title;
    @Column(name="memo")
    public String memo;
    @Column(name="date")
    public String date;
    @Override
    public String toString(){
        return title;
    }
}
