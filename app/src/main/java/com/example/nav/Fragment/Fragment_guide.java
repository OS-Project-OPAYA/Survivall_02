package com.example.nav.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nav.R;

public class Fragment_guide extends Fragment {

    private View view;
    private String TAG = "프래그먼트";
    private String val = ""; // val 변수 선언 및 초기화

    private TextView resultTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        view = inflater.inflate(R.layout.frag_guide, container, false);
        resultTextView = view.findViewById(R.id.result_textview);

        getVal();
        return view;
    }

    public void getVal() {

        DataBaseHelper dbHelper = new DataBaseHelper(getContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM social",null);
        //" and name = ?",new String[]{"홍길동"});
        while (cursor.moveToNext())
        {
            val += cursor.getString(2)+", ";

        }

        //sqlresult.setText("결과: "+ val);
        cursor.close();
        dbHelper.close();

        resultTextView.setText("결과: " + val);
    }

}


