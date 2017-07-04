package com.dr.rui.sotired.DataBase;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by rui on 2016/9/13.
 */

public class OpData {
    public void LoadData(DBHelper db) {
        SQLiteDatabase read_db = db.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("instrument_name", "箫");
        read_db.insert("instrument_info", null, cv);
    }
}
