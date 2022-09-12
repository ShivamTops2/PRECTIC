package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    public static String DB_NAME = "shivu.db";
    public static String TABLE_NAME = "nasit";
    public static String ID = "id";
    public static String NAME = "name";
    public static String NUMBER = "number";
    public static int DB_VERSION = 1;


    //database
    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //table
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"
                + NUMBER + " TEXT" + ") ";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String upquery = "drop table if exists " + TABLE_NAME;
        sqLiteDatabase.execSQL(upquery);

    }

    public Long Savedata(Model m) {
        long id = 0;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, m.getName());
        values.put(NUMBER, m.getNumber());


        id = db.insert(TABLE_NAME, ID, values);

        return id;

    }

    public List<Model> Viewdata() {
        ArrayList<Model> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String col[] = {ID, NAME, NUMBER};
        Cursor cursor = db.query(TABLE_NAME, col, null, null, null, null, null, null);


        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String number = cursor.getString(2);


            Model m = new Model();
            m.setId(id);
            m.setName(name);
            m.setNumber(number);

            arrayList.add(m);
        }

        return arrayList;
    }

    public void deletedata(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String deletequery = ID + "=" + id;
        db.delete(TABLE_NAME, deletequery, null);

    }

    public void updatedata(Model m) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, m.getId());
        values.put(NAME, m.getName());
        values.put(NUMBER, m.getNumber());
        String updatequery = ID + "=" + m.getId();
        db.update(TABLE_NAME, values, updatequery, null);

    }
}
