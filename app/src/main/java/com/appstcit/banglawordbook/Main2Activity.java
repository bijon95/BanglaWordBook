package com.appstcit.banglawordbook;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {
     private int[] list = {132,1231,32131,234123,1231};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView) findViewById(R.id.listview);
        String[] english = getIntent().getStringArrayExtra("english");
        String[] bangla = getIntent().getStringArrayExtra("bangla");
        CustomListAdapter adapter = new CustomListAdapter(Main2Activity.this,english,bangla);
        listView.setAdapter(adapter);

    }
}