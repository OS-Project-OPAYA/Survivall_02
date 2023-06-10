package com.example.nav.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
                Popup();
                resultTextView.setText("");
            }
        });

        typhoonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettyphoonData();
                Popup();
                resultTextView.setText("");
            }
        });

        floodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getfloodData();
                Popup();
                resultTextView.setText("");
            }
        });

        hotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gethotData();
                Popup();
                resultTextView.setText("");
            }
        });

        galeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getgaleData();
                Popup();
                resultTextView.setText("");
            }
        });

        coldButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getcoldData();
                Popup();
                resultTextView.setText("");
            }
        });

        dustButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getdustData();
                Popup();
                resultTextView.setText("");
            }
        });

        landslideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getlandslideData();
                Popup();
                resultTextView.setText("");
            }
        });

        volcanoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getvolcanoData();
                Popup();
                resultTextView.setText("");
            }
        });

        fireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getfireData();
                Popup();
                resultTextView.setText("");
            }
        });

        collapseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getcollapseData();
                Popup();
                resultTextView.setText("");
            }
        });

        trafficaccidentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettrafficaccidentData();
                Popup();
                resultTextView.setText("");
            }
        });

        explosionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getexplosionData();
                Popup();
                resultTextView.setText("");
            }
        });

        trainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettrainData();
                Popup();
                resultTextView.setText("");
            }
        });

        concertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getconcertData();
                Popup();
                resultTextView.setText("");
            }
        });

        return view;
    }

    public void Popup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("행동 가이드");
        builder.setMessage(resultTextView.getText().toString());
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
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
            if (earthquakeData != null) {
                resultData.append(earthquakeData).append("\n");
            }
        }

        cursor.close();
        resultTextView.setText(resultData.toString());

    }

    public void gettyphoonData() {
        Cursor cursor = db.rawQuery("SELECT typhoon FROM natural", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String typhoonData = cursor.getString(cursor.getColumnIndexOrThrow("typhoon"));
            if (typhoonData != null) {
                resultData.append(typhoonData).append("\n");
            }
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void getfloodData() {
        Cursor cursor = db.rawQuery("SELECT flood FROM natural", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String floodData = cursor.getString(cursor.getColumnIndexOrThrow("flood"));
            if (floodData != null) {
                resultData.append(floodData).append("\n");
            }
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void gethotData() {
        Cursor cursor = db.rawQuery("SELECT hot FROM natural", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String hotData = cursor.getString(cursor.getColumnIndexOrThrow("hot"));
            if (hotData != null) {
                resultData.append(hotData).append("\n");
            }
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void getgaleData() {
        Cursor cursor = db.rawQuery("SELECT gale FROM natural", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String galeData = cursor.getString(cursor.getColumnIndexOrThrow("gale"));
            if (galeData != null) {
                resultData.append(galeData).append("\n");
            }
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void getcoldData() {
        Cursor cursor = db.rawQuery("SELECT cold FROM natural", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String coldData = cursor.getString(cursor.getColumnIndexOrThrow("cold"));
            if (coldData != null) {
                resultData.append(coldData).append("\n");
            }
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void getdustData() {
        Cursor cursor = db.rawQuery("SELECT dust FROM natural", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String dustData = cursor.getString(cursor.getColumnIndexOrThrow("dust"));
            if (dustData != null) {
                resultData.append(dustData).append("\n");
            }
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void getlandslideData() {
        Cursor cursor = db.rawQuery("SELECT landslide FROM natural", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String landslideData = cursor.getString(cursor.getColumnIndexOrThrow("landslide"));
            if (landslideData != null) {
                resultData.append(landslideData).append("\n");
            }
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void getvolcanoData() {
        Cursor cursor = db.rawQuery("SELECT volcano FROM natural", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String volcanoData = cursor.getString(cursor.getColumnIndexOrThrow("volcano"));
            if (volcanoData != null) {
                resultData.append(volcanoData).append("\n");
            }
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void getfireData() {
        Cursor cursor = db.rawQuery("SELECT fire FROM social", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String fireData = cursor.getString(cursor.getColumnIndexOrThrow("fire"));
            if (fireData != null) {
                resultData.append(fireData).append("\n");
            }
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void getcollapseData() {
        Cursor cursor = db.rawQuery("SELECT collapse FROM social", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String collapseData = cursor.getString(cursor.getColumnIndexOrThrow("collapse"));
            if (collapseData != null) {
                resultData.append(collapseData).append("\n");
            }
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void gettrafficaccidentData() {
        Cursor cursor = db.rawQuery("SELECT trafficaccident FROM social", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String trafficaccidentData = cursor.getString(cursor.getColumnIndexOrThrow("trafficaccident"));
            if (trafficaccidentData != null) {
                resultData.append(trafficaccidentData).append("\n");
            }
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void getexplosionData() {
        Cursor cursor = db.rawQuery("SELECT explosion FROM social", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String explosionData = cursor.getString(cursor.getColumnIndexOrThrow("explosion"));
            if (explosionData != null) {
                resultData.append(explosionData).append("\n");
            }
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void gettrainData() {
        Cursor cursor = db.rawQuery("SELECT train FROM social", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String trainData = cursor.getString(cursor.getColumnIndexOrThrow("train"));
            if (trainData != null) {
                resultData.append(trainData).append("\n");
            }
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }

    public void getconcertData() {
        Cursor cursor = db.rawQuery("SELECT concert FROM social", null);

        StringBuilder resultData = new StringBuilder();
        while (cursor.moveToNext()) {
            String concertData = cursor.getString(cursor.getColumnIndexOrThrow("concert"));
            if (concertData != null) {
                resultData.append(concertData).append("\n");
            }
        }

        cursor.close();
        resultTextView.setText(resultData.toString());
    }


}