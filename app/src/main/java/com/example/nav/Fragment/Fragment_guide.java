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
    private Button floodButton;
    private Button hotButton;
    private Button galeButton;
    private Button coldButton;
    private Button dustButton;
    private Button landslideButton;
    private Button volcanoButton;
    private Button fireButton;
    private Button collapseButton;
    private Button trafficaccidentButton;
    private Button explosionButton;
    private Button trainButton;
    private Button concertButton;

    private DataBaseHelper dbHelper;
    private SQLiteDatabase db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        view = inflater.inflate(R.layout.frag_guide, container, false);

        resultTextView = view.findViewById(R.id.result_textview);


        //버튼버튼버튼버튼
        earthquakeButton = view.findViewById(R.id.button_earthquake);
        typhoonButton = view.findViewById(R.id.button_typhoon);
        floodButton = view.findViewById(R.id.button_flood);
        hotButton = view.findViewById(R.id.button_hot);
        galeButton = view.findViewById(R.id.button_gale);
        coldButton = view.findViewById(R.id.button_cold);
        dustButton = view.findViewById(R.id.button_dust);
        landslideButton = view.findViewById(R.id.button_landslide);
        volcanoButton = view.findViewById(R.id.button_volcano);

        fireButton = view.findViewById(R.id.button_fire);
        collapseButton = view.findViewById(R.id.button_collapse);
        trafficaccidentButton = view.findViewById(R.id.button_trafficaccident);
        explosionButton = view.findViewById(R.id.button_explosion);
        trainButton = view.findViewById(R.id.button_train);
        concertButton = view.findViewById(R.id.button_concert);



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

        floodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getfloodData();
            }
        });

        hotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gethotData();
            }
        });

        galeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getgaleData();
            }
        });

        coldButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getcoldData();
            }
        });

        dustButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getdustData();
            }
        });

        landslideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getlandslideData();
            }
        });

        volcanoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getvolcanoData();
            }
        });

        fireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getfireData();
            }
        });

        collapseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getcollapseData();
            }
        });

        trafficaccidentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettrafficaccidentData();
            }
        });

        explosionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getexplosionData();
            }
        });

        trainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettrainData();
            }
        });

        concertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getconcertData();
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

    public void getfloodData() {
        Cursor cursor = db.rawQuery("SELECT flood FROM natural", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String floodData = cursor.getString(cursor.getColumnIndexOrThrow("flood"));
            resultData.append("flood Data: ").append(floodData).append("\n");
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void gethotData() {
        Cursor cursor = db.rawQuery("SELECT hot FROM natural", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String hotData = cursor.getString(cursor.getColumnIndexOrThrow("hot"));
            resultData.append("hot Data: ").append(hotData).append("\n");
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void getgaleData() {
        Cursor cursor = db.rawQuery("SELECT hot FROM natural", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String galeData = cursor.getString(cursor.getColumnIndexOrThrow("gale"));
            resultData.append("gale Data: ").append(galeData).append("\n");
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void getcoldData() {
        Cursor cursor = db.rawQuery("SELECT cold FROM natural", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String coldData = cursor.getString(cursor.getColumnIndexOrThrow("cold"));
            resultData.append("gale Data: ").append(coldData).append("\n");
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void getdustData() {
        Cursor cursor = db.rawQuery("SELECT dust FROM natural", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String dustData = cursor.getString(cursor.getColumnIndexOrThrow("dust"));
            resultData.append("gale Data: ").append(dustData).append("\n");
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void getlandslideData() {
        Cursor cursor = db.rawQuery("SELECT landslide FROM natural", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String landslideData = cursor.getString(cursor.getColumnIndexOrThrow("landslide"));
            resultData.append("gale Data: ").append(landslideData).append("\n");
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void getvolcanoData() {
        Cursor cursor = db.rawQuery("SELECT volcano FROM natural", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String volcanoData = cursor.getString(cursor.getColumnIndexOrThrow("volcano"));
            resultData.append("volcano Data: ").append(volcanoData).append("\n");
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void getfireData() {
        Cursor cursor = db.rawQuery("SELECT fire FROM social", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String fireData = cursor.getString(cursor.getColumnIndexOrThrow("fire"));
            resultData.append("volcano Data: ").append(fireData).append("\n");
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void getcollapseData() {
        Cursor cursor = db.rawQuery("SELECT collapse FROM social", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String collapseData = cursor.getString(cursor.getColumnIndexOrThrow("collapse"));
            resultData.append("volcano Data: ").append(collapseData).append("\n");
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void gettrafficaccidentData() {
        Cursor cursor = db.rawQuery("SELECT trafficaccident FROM social", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String trafficaccidentData = cursor.getString(cursor.getColumnIndexOrThrow("trafficaccident"));
            resultData.append("volcano Data: ").append(trafficaccidentData).append("\n");
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void getexplosionData() {
        Cursor cursor = db.rawQuery("SELECT explosion FROM social", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String explosionData = cursor.getString(cursor.getColumnIndexOrThrow("explosion"));
            resultData.append("volcano Data: ").append(explosionData).append("\n");
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void gettrainData() {
        Cursor cursor = db.rawQuery("SELECT train FROM social", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String trainData = cursor.getString(cursor.getColumnIndexOrThrow("train"));
            resultData.append("train Data: ").append(trainData).append("\n");
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void getconcertData() {
        Cursor cursor = db.rawQuery("SELECT concert FROM social", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String concertData = cursor.getString(cursor.getColumnIndexOrThrow("concert"));
            resultData.append("volcano Data: ").append(concertData).append("\n");
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }



}
