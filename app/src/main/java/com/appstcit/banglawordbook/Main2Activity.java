package com.appstcit.banglawordbook;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ListView listView;
    ArrayList<Productitem> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        arrayList = new ArrayList<>();


        listView = (ListView) findViewById(R.id.listview);
        String[] english = getIntent().getStringArrayExtra("english");
        String[] bangla = getIntent().getStringArrayExtra("bangla");
        String[] viewStd = getIntent().getStringArrayExtra("viewStd");

        for(int i = 0;i<english.length;i++){
            arrayList.add(new Productitem(english[i],bangla[i],viewStd[i]));
        }

        CustomListAdapter adapter = new CustomListAdapter(Main2Activity.this,R.layout.list_item,arrayList);
        listView.setAdapter(adapter);

    }
}