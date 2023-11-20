package com.marcin.cardssql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class CardsDBHelper extends SQLiteOpenHelper {

    private static final String DEBUG_TAG = "CardsDBHelper";
    private static final String DB_NAME = "cards.db";
    private static final int DB_VERSION = 1;

    private static final String TABLE_CARDS = "CARDS";
    private static final String COLUMN_ID = "_ID";
    private static final String COLUMN_NAME = "NAME";
    private static final String COLUMN_COLOR_RESOURCE = "COLOR_RESOURCE";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_CARDS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_COLOR_RESOURCE + " INTEGER" +
                    ")";


    public CardsDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        Log.i(DEBUG_TAG,"Utworzono tabelę.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARDS);
        onCreate(db);
    }
}
