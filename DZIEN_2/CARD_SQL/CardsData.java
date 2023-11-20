package com.marcin.cardssql;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class CardsData {
    public static final String DEBUG_TAG = "CardsData";
    private SQLiteDatabase db;
    private SQLiteOpenHelper cardDGHelper;

    private static final String[] COLUMNS = {
            CardsDBHelper.COLUMN_ID,
            CardsDBHelper.COLUMN_NAME,
            CardsDBHelper.COLUMN_COLOR_RESOURCE,
    };

    public CardsData(Context context) {
        this.cardDGHelper = new CardsDBHelper(context);
    }
    
    public void close(){
        if(cardDGHelper != null){
            cardDGHelper.close();
            Log.d(DEBUG_TAG,"carDBHelper zamknięto!");
        }
    }
    @SuppressLint("Range")
    public ArrayList<Card> getAll() {
        ArrayList<Card> cards = new ArrayList<>();
        Cursor cursor = null;
        
        try{
            cursor = db.query(CardsDBHelper.TABLE_CARDS, COLUMNS,null,null,null,null,null);
            if(cursor.getCount()>0){
                while (cursor.moveToNext()){
                    Card card = new Card();
                    card.setId(cursor.getLong(cursor.getColumnIndex(CardsDBHelper.COLUMN_ID)));
                    card.setName(cursor.getString(cursor.getColumnIndex(CardsDBHelper.COLUMN_NAME)));
                    card.setColor_resources(cursor.getInt(cursor.getColumnIndex(CardsDBHelper.COLUMN_COLOR_RESOURCE)));
                    cards.add(card);
                }
            }
            Log.d(DEBUG_TAG,"Sumaryczna liczba wierszy = " + cursor.getCount());
            
        }catch (Exception e){
            Log.d(DEBUG_TAG,"zgłoszono wyjątek.." + e);
        }
        finally {
            if(cursor!=null){
                cursor.close();
            }
        }
        return cards;
    } 
    
    public Card create(Card card){
        ContentValues values = new ContentValues();
        values.put(CardsDBHelper.COLUMN_NAME,card.getName());
        values.put(CardsDBHelper.COLUMN_COLOR_RESOURCE,card.getColor_resources());
        long id = db.insert(CardsDBHelper.TABLE_CARDS,null,values);
        card.setId(id);
        Log.d(DEBUG_TAG,"Identyfikator wstawionej karty to: " + String.valueOf(card.getId()));
        return card;
    }
    public void update(long position, String name){
        String whereClause = CardsDBHelper.COLUMN_ID + "=" + position;
        Log.d(DEBUG_TAG,"zaktualizowano kartę na pozycji: " + String.valueOf(position));
        ContentValues values = new ContentValues();
        values.put(CardsDBHelper.COLUMN_NAME,name);
        db.update(CardsDBHelper.TABLE_CARDS,values,whereClause,null);
    }
    
    public void delete(long cardId){
        String whereClause = CardsDBHelper.COLUMN_ID + "=" + cardId;
        Log.d(DEBUG_TAG,"Usunięto kartę na pozycji: " + String.valueOf(cardId));
        db.delete(CardsDBHelper.TABLE_CARDS,whereClause,null);
    }

}
