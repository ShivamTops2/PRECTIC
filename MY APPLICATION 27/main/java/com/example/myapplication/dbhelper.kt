package com.example.sqliteex

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.DatabaseErrorHandler
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION)
{
    companion object
    {
        var DB_NAME="user.db"
        var TABLE_NAME="info"
        var ID="id"
        var NAME="name"
        var NUM="num"
        var DB_VERSION=1
    }



    override fun onCreate(p0: SQLiteDatabase?)
    {
        val query = ("CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"
                + NUM + " TEXT" + ")")
        p0!!.execSQL(query)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int)
    {
        var query2="drop table if exists "+ TABLE_NAME
        p0!!.execSQL(query2)
        onCreate(p0)
    }

    fun addata(m:Model):Long
    {
        var db=this.writableDatabase
        var values=ContentValues()
        values.put(NAME,m.name)
        values.put(NUM,m.num)
        var id=db.insert(TABLE_NAME,ID,values)

        return id

    }
    fun viewdata():List<Model>
    {

        var list:MutableList<Model> = ArrayList()
        var db=readableDatabase
        val col = arrayOf(ID, NAME, NUM)
        var cursor:Cursor=db.query(TABLE_NAME,col,null,null,null,null,null)

        while(cursor.moveToNext())
        {
            var id=cursor.getInt(0)
            var name=cursor.getString(1)
            var num=cursor.getString(2)

            var m=Model()
            m.id=id
            m.name=name
            m.num=num

            list.add(m)


        }





        return list

    }
    fun deletedata(id:Int)
    {
        var db=this.writableDatabase
        var deletequery= ID+"="+id
        db.delete(TABLE_NAME,deletequery,null)
    }

    fun updatedata(m:Model)
    {
        var db=this.writableDatabase
        var values=ContentValues()
        values.put(ID,m.id)
        values.put(NAME,m.name)
        values.put(NUM,m.num)
        var updatequery= ID+"="+m.id
        db.update(TABLE_NAME,values,updatequery,null)


    }
}



