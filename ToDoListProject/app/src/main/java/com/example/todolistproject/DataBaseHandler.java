package com.example.todolistproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler extends SQLiteOpenHelper {
    public DataBaseHandler(@Nullable Context context) {
        super(context, "PROJECT_DATABASE", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="CREATE TABLE TO_DO_LIST (DESCRIPTION TEXT)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query="DROP TABLE IF EXISTS PERSONAL_DATABASE";
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }

    public List<String> getToDo() {
        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT * FROM TO_DO_LIST";
        Cursor cr=db.rawQuery(query,null);
        cr.moveToFirst();
        List<String> toDoList = new ArrayList<>();
        do {
            if(cr.getCount()>0){
                toDoList.add(cr.getString(0));}
        }while (cr.moveToNext());
        return toDoList;
    }

    public void addTodo(String description) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("DESCRIPTION",description);
        db.insert("TO_DO_LIST",null,values);
        db.close();
    }

    public void doneToDo(String description) {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="DELETE FROM TO_DO_LIST WHERE DESCRIPTION='"+description+"'";
        db.execSQL(query);
        db.close();
    }
}
