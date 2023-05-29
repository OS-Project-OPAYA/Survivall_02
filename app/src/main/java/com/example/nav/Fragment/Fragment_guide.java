package com.example.nav.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;
import android.widget.LinearLayout;
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
    //버튼 위치
    private Button earthquakeButton;
    private Button typhoonButton;

    private DataBaseHelper dbHelper;
    private SQLiteDatabase db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        view = inflater.inflate(R.layout.frag_guide, container, false);

        resultTextView = view.findViewById(R.id.result_textview);
        earthquakeButton = view.findViewById(R.id.button_earthquake);
        typhoonButton = view.findViewById(R.id.button_typhoon);

        dbHelper = new DataBaseHelper(getContext());
        db = dbHelper.getReadableDatabase();

        earthquakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getearthquakeData();
            }
        });

        typhoonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettyphoonData();
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // dbHelper와 db 리소스 정리
        if (dbHelper != null) {
            dbHelper.close();
        }
        if (db != null) {
            db.close();
        }
    }
    public void getearthquakeData() {
        Cursor cursor = db.rawQuery("SELECT earthquake FROM natural", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String earthquakeData = cursor.getString(cursor.getColumnIndexOrThrow("earthquake"));
            resultData.append("Earthquake Data: ").append(earthquakeData).append("\n");
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void gettyphoonData() {
        Cursor cursor = db.rawQuery("SELECT typhoon FROM natural", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String typhoonData = cursor.getString(cursor.getColumnIndexOrThrow("typhoon"));
            resultData.append("Typhoon Data: ").append(typhoonData).append("\n");
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

}
