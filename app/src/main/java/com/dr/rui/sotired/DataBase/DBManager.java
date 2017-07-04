package com.dr.rui.sotired.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.dr.rui.sotired.Entity.Instrument;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by rui on 2017-03-02.
 * Load data from pre-created database
 */

public class DBManager {
    private String DataBase_Name = "instrument.db";
    private Context context;

    public DBManager(Context context) {
        this.context = context;
    }

    //
    public SQLiteDatabase DBManager(String packageName) {
        Log.i("PackageName:", packageName);
        String database_path = "/data/data/" + packageName + "/database/" + DataBase_Name;
        //String database_path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/databases/" + DataBase_Name;
        if (!new File(database_path).exists()) {
            try {
                //boolean flag = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/databases/").mkdirs();
                //boolean newFile = new File(database_path).createNewFile();

                FileOutputStream out = new FileOutputStream(database_path);
                InputStream in = context.getAssets().open(DataBase_Name);
                byte[] buffer = new byte[1024];
                int readBytes = 0;
                while ((readBytes = in.read()) != -1)
                    out.write(buffer, 0, readBytes);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return SQLiteDatabase.openOrCreateDatabase(database_path, null);
    }

    //
    public Instrument query(SQLiteDatabase sqLiteDatabase, String[] columns, String selection, String[] selectionArgs) {
        String table_name = "instrument_info";
        Instrument instrument = null;
        Cursor cursor = sqLiteDatabase.query(table_name, columns, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {
            instrument = new Instrument();
            instrument.setName(cursor.getString(cursor.getColumnIndex("instrument_name")));
            instrument.setType(cursor.getString(cursor.getColumnIndex("instrument_class")));
            instrument.setBrief0(cursor.getString(cursor.getColumnIndex("instrument_brief0")));
            instrument.setBrief1(cursor.getString(cursor.getColumnIndex("instrument_brief1")));
            instrument.setMusic_url1(cursor.getString(cursor.getColumnIndex("music_url1")));
            instrument.setMusic_name1(cursor.getString(cursor.getColumnIndex("music_name1")));
            instrument.setMusic_url2(cursor.getString(cursor.getColumnIndex("music_url2")));
            instrument.setMusic_name2(cursor.getString(cursor.getColumnIndex("music_name2")));
            instrument.setMusic_content(cursor.getString(cursor.getColumnIndex("content")));
            instrument.setVideo_url(cursor.getString(cursor.getColumnIndex("video_url")));
            instrument.setSkill(cursor.getString(cursor.getColumnIndex("skill")));
            //cursor.moveToNext();
            cursor.close();
        }
        return instrument;
    }
}
