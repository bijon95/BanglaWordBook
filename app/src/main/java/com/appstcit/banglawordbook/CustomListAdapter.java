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
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by Bj on 30-11-17.
 */

public class CustomListAdapter extends ArrayAdapter {

private TextToSpeech textoSpeech;
    private Activity context;
    private String[] english;
    private String[] bangla;
    private String[] viewSts;

    int resource;
    public CustomListAdapter(Activity context, String[] english,String[] bangla, String[] viewStd) {
        super(context, R.layout.list_item, english);
        this.context = context;
        this.english = english;
        this.bangla = bangla;
        this.viewSts=viewStd;

    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View itemView = inflater.inflate(R.layout.list_item, null, true);

        TextView text1 = (TextView) itemView.findViewById(R.id.englishid);
        TextView text2 = (TextView) itemView.findViewById(R.id.banglaid);
        Button btn = (Button) itemView.findViewById(R.id.volume);
        Button shareBtn = (Button) itemView.findViewById(R.id.share);
        final Button love = (Button) itemView.findViewById(R.id.love);
        text2.setText(english[position]);
        text1.setText(bangla[position]);
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
                String toSpeak = english[position];
                textoSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, english[position]+"-"+bangla[position]);
                sendIntent.setType("text/plain");
                context.startActivity(sendIntent);
            }
        });
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewSts[position].equals("1")) {
                    love.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.favorite_yellow));
                }
                else if(viewSts[position].equals("0")){
                    love.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
                }
                else {
                    love.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
                }
                DataTemp dt = new DataTemp(english[position],bangla[position]);

                DatabaseFunction df = new DatabaseFunction(getContext());
                df.AddDataToTable(dt);


            }
        });




        return itemView;
    }


}
