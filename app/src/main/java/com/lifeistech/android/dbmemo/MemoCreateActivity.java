package com.lifeistech.android.dbmemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MemoCreateActivity extends AppCompatActivity {
    MemoDB myMemoDB;
    EditText myTitle,myMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_creat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myTitle = (EditText) findViewById(R.id.creat_title);
        myMemo = (EditText) findViewById(R.id.creat_memo);
        myMemoDB = new MemoDB();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void saveMemo(){
        myMemoDB.title=myTitle.getText().toString();
        myMemoDB.memo=myMemo.getText().toString();
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm;ss", Locale.JAPANESE);
        myMemoDB.date=sdf.format(date);
        myMemoDB.save();
    }
    public void saveData(View v){
        saveMemo();
    }
    public void back(View v){
        Intent i=new Intent(MemoCreateActivity.this, MemoCreateActivity.class);
        startActivity(i);
    }

}
