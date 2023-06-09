package com.example.nav.Fragment;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper{
    private final static String TAG = "DataBaseHelper"; // Logcat에 출력할 태그이름
    // database 의 파일 경로
    private static String DB_PATH = "";
    private static String DB_NAME = "survivall.db";
    private SQLiteDatabase mDataBase;
    private Context mContext;

    public DataBaseHelper(Context context) {
        super(context,DB_NAME,null,1);


        DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        this.mContext = context;
        dataBaseCheck();
    }

    private void dataBaseCheck() {
        File dbFile = new File(DB_PATH + DB_NAME);
        if (!dbFile.exists()) {
            dbCopy();
            Log.d(TAG,"Database is copied.");
        }
    }


    @Override
    public synchronized void close() {
        if (mDataBase != null) {
            mDataBase.close();
        }
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 테이블 구조 생성로직
        Log.d(TAG,"onCreate()");
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        //Toast.makeText(mContext,"onOpen()",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onOpen() : DB Opening!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 테이블 삭제하고 onCreate() 다시 로드시킨다.
        Log.d(TAG,"onUpgrade() : DB Schema Modified and Excuting onCreate()");
    }

    // db를 assets에서 복사해온다.
    private void dbCopy() {

        try {
            File folder = new File(DB_PATH);
            if (!folder.exists()) {
                folder.mkdir();
            }

            InputStream inputStream = mContext.getAssets().open(DB_NAME);
            String out_filename = DB_PATH + DB_NAME;
            OutputStream outputStream = new FileOutputStream(out_filename);
            byte[] mBuffer = new byte[1024];
            int mLength;
            while ((mLength = inputStream.read(mBuffer)) > 0) {
                outputStream.write(mBuffer,0,mLength);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            Log.d("dbCopy","IOException 발생함");
        }
    }

    public List<String> searchData(String query) {
        List<String> results = new ArrayList<>();

        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = null;
        try {
            String[] tables = {"natural", "social"};

            for (String table : tables) {
                String[] columns = null; // 모든 열을 대상으로 검색
                String selection = null;
                String[] selectionArgs = null;

                cursor = database.query(table, columns, selection, selectionArgs, null, null, null);
                addResultsToList(cursor, results, query);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            database.close();
        }

        return results;
    }




    private void addResultsToList(Cursor cursor, List<String> results, String query) {
        if (cursor != null && cursor.moveToFirst()) {
            int columnCount = cursor.getColumnCount();
            do {
                for (int i = 0; i < columnCount; i++) {
                    String result = cursor.getString(i);
                    if (result != null && result.contains(query) && !result.equalsIgnoreCase("null")) {
                        results.add(result);
                    }
                }
            } while (cursor.moveToNext());
        }
    }






}