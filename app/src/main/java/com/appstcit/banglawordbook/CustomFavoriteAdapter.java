package com.appstcit.banglawordbook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Bj on 07-12-17.
 */

public class CustomFavoriteAdapter  extends ArrayAdapter<Product> {


    ArrayList<Product> products;
    private CustomFavoriteAdapter adapter;
    Context context;
    int resource;
    TextToSpeech textToSpeech;

    public CustomFavoriteAdapter(Context context, int resource, ArrayList<Product> products) {
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
            convertView = layoutInflater.inflate(R.layout.fav_list_item, null, true);

        }
        final Product product = getItem(position);


        TextView text1 = (TextView) convertView.findViewById(R.id.englishid);
        TextView text2 = (TextView) convertView.findViewById(R.id.banglaid);
        Button btn = (Button) convertView.findViewById(R.id.volume);
        Button shareBtn = (Button) convertView.findViewById(R.id.share);
        Button love = (Button) convertView.findViewById(R.id.love);
        text2.setText(product.getEnglish());
        text1.setText(product.getBangla());


        textToSpeech=new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = product.getEnglish();
                textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                Toast.makeText(getContext(),product.getEnglish(),Toast.LENGTH_LONG).show();
            }
        });
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, product.getEnglish()+"-"+product.getBangla());
                sendIntent.setType("text/plain");
                context.startActivity(sendIntent);
            }
        });
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseFunction df = new DatabaseFunction(getContext());
                df.Delete_Raw(product.getEnglish());
                df.viewDataEnglish();
                Toast.makeText(getContext(),product.getEnglish()+"\nDeleted",Toast.LENGTH_SHORT).show();

                products.remove(product);
                adapter.notifyDataSetChanged();

            }
        });




        return convertView;
    }


}
