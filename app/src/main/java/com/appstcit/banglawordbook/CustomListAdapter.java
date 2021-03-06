package com.appstcit.banglawordbook;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Bj on 30-11-17.
 */

public class CustomListAdapter extends ArrayAdapter<Productitem> {

    ArrayList<Productitem> products;
private TextToSpeech textoSpeech;
    private Context context;
    private CustomListAdapter adapter;
    int resource;

    public CustomListAdapter(Context context, int resource, ArrayList<Productitem> products) {
        super(context, resource, products);
        this.products = products;
        this.context = context;
        this.resource = resource;
        this.adapter=this;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null, true);

        }
        final Productitem product = getItem(position);

        TextView text2 = (TextView) convertView.findViewById(R.id.englishid);
        TextView text1 = (TextView) convertView.findViewById(R.id.banglaid);
        Button btn = (Button) convertView.findViewById(R.id.volume);
        Button shareBtn = (Button) convertView.findViewById(R.id.share);
        Button love = (Button) convertView.findViewById(R.id.love);
        Button copyBtn = (Button) convertView.findViewById(R.id.copy);


        if(product.getViewStatus().equals("1")) {
            love.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
        }
        else if(product.getViewStatus().equals("0")){
            love.setBackgroundResource(R.drawable.ic_favorite_border_black_24dp);  }


        text2.setText(product.getEnglish());
        text1.setText(product.getBangla());
        textoSpeech=new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textoSpeech.setLanguage(Locale.UK);
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = product.getBangla();
                textoSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, product.getBangla()+"-"+product.getEnglish());
                sendIntent.setType("text/plain");
                context.startActivity(sendIntent);
            }
        });
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DataTemp dt = new DataTemp(product.getEnglish(),product.getBangla());

                DatabaseFunction df = new DatabaseFunction(getContext());

            if(product.getViewStatus().equals("0")){
                product.setViewStatus("1");
                df.AddDataToTable(dt);
                Toast.makeText(getContext(),product.getBangla()+"\nAdded To Favorite",Toast.LENGTH_SHORT).show();
            }
                else if (product.getViewStatus().equals("1")){
                 product.setViewStatus("0");
                df.Delete_Raw(product.getBangla());
                Toast.makeText(getContext(),product.getBangla()+"\nDelete From Favorite",Toast.LENGTH_SHORT).show();

            }

                adapter.notifyDataSetChanged();

            }
        });

        copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager _clipboard = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                _clipboard.setText(product.getBangla()+"-"+product.getEnglish());
                Toast.makeText(getContext(),"Copied",Toast.LENGTH_SHORT).show();
            }
        });




        return convertView;
    }


}
