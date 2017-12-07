package com.appstcit.banglawordbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Favorite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        TextView tv = (TextView) findViewById(R.id.textView2);
        DatabaseFunction df = new DatabaseFunction(Favorite.this);


        String s="";
        String[] dataList = df.viewData();

        for( int i = 0; i<dataList.length; i++) {
            s=s+dataList[i]+"\n";

        }
        tv.setText(s);
    }
}

