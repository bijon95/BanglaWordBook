package com.appstcit.banglawordbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Bj on 13-11-17.
 */

public class DatabaseFunction extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydb";
    private static final String TABLE_NAME = "mytab";

    private static final String col_ID = "id";
    private static final String col_Bangla = "bangla";
    private static final String col_English = "english";

    public DatabaseFunction(Context c){
        super(c,DATABASE_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      String s = "CREATE TABLE "+TABLE_NAME+"( "+col_ID+" INTIGER PRIMARY KEY, "
              + col_Bangla+" TEXT UNIQUE, "+col_English+" TEXT)";
        db.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void AddDataToTable(DataTemp dt){
    SQLiteDatabase  sql = this.getWritableDatabase();
        ContentValues  cv = new ContentValues();

        cv.put(col_English,dt.getName());
        cv.put(col_Bangla,dt.getPhone());

       sql.insert(TABLE_NAME,null,cv);
        sql.close();
    }

    void AddData(DataTemp dt){


    }



    public String[] viewDataEnglish (){

            SQLiteDatabase sq =this.getReadableDatabase();
            String q="SELECT * FROM "+TABLE_NAME;
            Cursor c= sq.rawQuery(q,null);

        String[] english = new String[c.getCount()];
            c.moveToFirst();

            if(c.moveToFirst()){
                int count = 0;
                do{
                    english[count] = c.getString(c.getColumnIndex(col_English+""));


                    count=count+1;
                }while (c.moveToNext());

            }

        return english;
    }
    public String[] viewDataBangla (){

        SQLiteDatabase sq =this.getReadableDatabase();
        String q="SELECT * FROM "+TABLE_NAME;
        Cursor c= sq.rawQuery(q,null);
        String[] bangla = new String[c.getCount()];

        c.moveToFirst();

        if(c.moveToFirst()){
            int count = 0;
            do{
                bangla[count] = c.getString(c.getColumnIndex(col_Bangla+""));


                count=count+1;
            }while (c.moveToNext());

        }

        return bangla;
    }

    public void Delete_Raw(String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME+" WHERE "+col_Bangla+"='"+name+"'");
        db.close();
    }


}
