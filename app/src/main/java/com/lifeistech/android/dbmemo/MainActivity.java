package com.lifeistech.android.dbmemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.activeandroid.query.Select;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListView = (ListView) findViewById(R.id.memo_list);
    }

    private void setMemoList() {
        List<MemoDB> memoList = new Select().from(MemoDB.class).execute();
        ArrayAdapter<MemoDB> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, memoList);
        myListView.setAdapter(adapter);
    }

    public void creatNewMemo(View v) {
        Intent i = new Intent(this, MemoCreateActivity.class);
        startActivity(i);
    }

    @Override
    public void onResume() {
        super.onResume();
        setMemoList();
    }
}
