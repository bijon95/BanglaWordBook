package com.appstcit.banglawordbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Favorite extends AppCompatActivity {

    EditText editText;
    ListView listView;
    String[] bangla;
    String[] english;
    ArrayList<Product> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
  editText = (EditText) findViewById(R.id.editText);
        arrayList = new ArrayList<>();
        DatabaseFunction df = new DatabaseFunction(Favorite.this);
        bangla = df.viewDataBangla();
     english = df.viewData();
        for(int i = 0;i<english.length;i++){
            arrayList.add(new Product(english[i],bangla[i]));
        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ArrayList<Product> temp = new ArrayList<Product>();
                int textlength = editText.getText().length();
                temp.clear();
                for (int i = 0; i < arrayList.size(); i++)
                {
                    if (textlength <= arrayList.get(i).getEnglish().length()) {

                        if (editText.getText().toString().equalsIgnoreCase((String) arrayList.get(i).getEnglish().subSequence(0,textlength))) {
                            temp.add(arrayList.get(i));
                        }
                    }

                }
                final CustomFavoriteAdapter adapter = new CustomFavoriteAdapter(Favorite.this,R.layout.fav_list_item,temp);
                listView.invalidateViews();
                listView.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        listView = (ListView) findViewById(R.id.listview);


       CustomFavoriteAdapter adapter  = new CustomFavoriteAdapter(Favorite.this,R.layout.fav_list_item,arrayList);
        listView.setAdapter(adapter);

    }
}

