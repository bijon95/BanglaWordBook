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
    String[] viewSts;
    String[] datalist ;
    ListView listView;
    ArrayList<Productitem> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle(getIntent().getStringExtra("titlebar"));
        arrayList = new ArrayList<>();

        DatabaseFunction df = new DatabaseFunction(Main2Activity.this);
        datalist=df.viewDataBangla();

        listView = (ListView) findViewById(R.id.listview);
        String[] english = getIntent().getStringArrayExtra("english");
        String[] bangla = getIntent().getStringArrayExtra("bangla");
      viewSts = new String[english.length];

        for (int i = 0 ; i<english.length;i++){
            viewSts[i]="0";
        }


        for(int i = 0; i<english.length;i++){
            for(int j = 0; j<datalist.length;j++){
                if(english[i].equals(datalist[j])){
                    viewSts[i]="1";
                    break;
                }

            }

        }
        for(int i = 0;i<english.length;i++){
            arrayList.add(new Productitem(english[i],bangla[i],viewSts[i]));
        }

        final CustomListAdapter adapter = new CustomListAdapter(Main2Activity.this,R.layout.list_item,arrayList);
        listView.setAdapter(adapter);



    }
}