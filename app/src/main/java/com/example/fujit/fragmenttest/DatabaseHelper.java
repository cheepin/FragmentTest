package com.example.fujit.fragmenttest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * SQLiteの使用方法
 * 1.SQLiteOpenHelperを継承したクラスを作成する。
 * 2.onCreateを実装する。
 * 3.onCreate内でテーブルの初期化などを行う。
 * 4.getReadableDatabase()及びgetWritableDatabase()でSQLを実行する。
 */
public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "studentDB";
    public static final String TABLE_NAME = "student";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "List";
    private static final String COL_3 = "ButtonText";


    /**
     * コンストラクタ
     * 親のコンストラクタにcontext、データベースの名前などを渡す。
     * @param context Activityのcontext
     */
    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 2);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    public void exeSQL(String sql)
    {
        this.getWritableDatabase().execSQL(sql);
    }

    public Cursor readSQL(String sql)
    {
        return this.getReadableDatabase().rawQuery(sql, null);
    }

    public int getMaxListCount()
    {
        Cursor cursor = getReadableDatabase().rawQuery("SELECT max("+ COL_2 +") FROM student",null);
        cursor.moveToFirst();
        int max = cursor.getInt(0);
        cursor.close();

        return max;
    }

    public List<String> getTextFromList(int listIndex)
    {
        Cursor cursor =  getReadableDatabase().rawQuery("select " + COL_3 + " from " + TABLE_NAME
                + " Where " + COL_2 + " = " + listIndex,null);
        List<String> result = new ArrayList<>();

        while(cursor.moveToNext())
        {
            result.add(cursor.getString(0));
        }
        cursor.close();
        return result;
    }

    public void deleteList(int index)
    {
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + COL_2 +" = " + index;
        Cursor cursor = getWritableDatabase().rawQuery(query, null);
        cursor.moveToFirst();
        cursor.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String query = "CREATE TABLE " + TABLE_NAME ;
        String nextQuery = " (ID INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " INT,"
                + COL_3 + " TEXT" + ")";
        db.execSQL(query + nextQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

    }


}
