package com.dr.rui.sotired.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.dr.rui.sotired.Entity.Instrument;

/**
 * Created by rui on 2015/7/24.
 */
public class DBHelper extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "INSTRUMENTS.db";
    private final static String INFO_TABLE_NAME = "instrument_info";
    private final static String NATION_TABLE_NAME = "instrument_nation";
    private final static String OCCIDENT_TABLE_NAME = "instrument_occident";
    private final static int DATABASE_VERSION = 1;
    private static DBHelper db_instance = null;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DBHelper getInstance(Context context) {
        if (db_instance == null) {
            db_instance = new DBHelper(context);
        }
        return db_instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("DataBase:", "------------Create!");
        //String sql = "CREATE TABLE " + INFO_TABLE_NAME + "(instrument_id INTEGER autoincrement,instrument_name text primary key,instrument_class text,instrument_type text,image_icon text,text_brief text,image_struct text,text_history text,text_position text,image_position text,single_text text,single_1_name text,single_1_url text,single_2_name text,single_2_url text,ensemble_1_name text,ensemble_1_url text,ensemble_1_content text,ensemble_2_name text,ensemble_2_url text,ensemble_2_content text,image_skill text,video_url text,skill_content text);";
        String sql = "CREATE TABLE IF NOT EXISTS " + INFO_TABLE_NAME + "(instrument_name text,instrument_class text,pic_spe integer,pic_struct integer,brief0 text,brief1 text,content text,pic_position integer,music_url1 text,music_url2 text,music_url3 text,music_url4 text,music_name1 text,music_name2 text,music_name3 text,music_name4 text,music_content text,video_url text,skill text);";
        db.execSQL(sql);
        //
        Instrument[] instruments = new InstrumentsInfo().AllInstrumentsInfo();
        for (int i = 0; i < instruments.length; i++) {
            Instrument instrument = instruments[i];
            //String insert = "INSERT INTO " + INFO_TABLE_NAME + " (instrument_name,pic_spe,pic_struct,brief0,brief1,content,pic_position,music_url1,music_url2,music_url3,music_url4,music_name1,music_name2,music_name3,music_name4,music_content,video_url,skill) VALUES (" + instrument.getName() + "," + instrument.getPic_spe() + ",'" + instrument.getPic_struct() + "','" + instrument.getBrief0() + "','" + instrument.getBrief1() + "','" + instrument.getContent() + "'," + instrument.getPic_position() + "," + instrument.getMusic_url1() + "," + instrument.getMusic_url2() + "," + instrument.getMusic_url3() + "," + instrument.getMusic_url4() + "," + instrument.getMusic_name1() + "," + instrument.getMusic_name2() + "," + instrument.getMusic_name3() + "," + instrument.getMusic_name4() + ",'" + instrument.getMusic_content() + "'," + instrument.getVideo_url() + ",'" + instrument.getSkill() + "')";
            db.execSQL("INSERT INTO " + INFO_TABLE_NAME + " (instrument_name,instrument_class,pic_spe,pic_struct,brief0,brief1,content,pic_position,music_url1,music_url2,music_url3,music_url4,music_name1,music_name2,music_name3,music_name4,music_content,video_url,skill) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[]{instrument.getName(), "", instrument.getPic_spe(), instrument.getPic_struct(), instrument.getBrief0(), instrument.getBrief1(), instrument.getContent(), instrument.getPic_position(), instrument.getMusic_url1(), instrument.getMusic_url2(), instrument.getMusic_url3(), instrument.getMusic_url4(), instrument.getMusic_name1(), instrument.getMusic_name2(), instrument.getMusic_name3(), instrument.getMusic_name4(), instrument.getMusic_content(), instrument.getVideo_url(), instrument.getSkill()});
        }
        Log.i("DBHelper:", "Insert " + instruments.length + " data!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS instrument_info";
        db.execSQL(sql);
    }

    //
    public boolean deleteDatabase(Context context) {
        Log.i("Delete Database ", DATABASE_NAME);
        return context.deleteDatabase(DATABASE_NAME);
    }
}
