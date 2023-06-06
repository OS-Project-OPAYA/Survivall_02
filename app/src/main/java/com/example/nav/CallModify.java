package com.example.nav;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CallModify extends AppCompatActivity {

    private Map<String, String> contactMap;

    private EditText contact1EditText, contact2EditText, contact3EditText, contact4EditText, contact5EditText, contact6EditText;
    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_modify);

        contactMap = (Map<String, String>) getIntent().getSerializableExtra("contactMap");

        contact1EditText = findViewById(R.id.contact1);
        contact2EditText = findViewById(R.id.contact2);
        contact3EditText = findViewById(R.id.contact3);
        contact4EditText = findViewById(R.id.contact4);
        contact5EditText = findViewById(R.id.contact5);
        contact6EditText = findViewById(R.id.contact6);

        confirmButton = findViewById(R.id.modifyupdate);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 수정된 전화번호를 업데이트
                String updatedContact1 = contact1EditText.getText().toString();
                String updatedContact2 = contact2EditText.getText().toString();
                String updatedContact3 = contact3EditText.getText().toString();
                String updatedContact4 = contact4EditText.getText().toString();
                String updatedContact5 = contact5EditText.getText().toString();
                String updatedContact6 = contact6EditText.getText().toString();

                contactMap.put("num1", updatedContact1);
                contactMap.put("num2", updatedContact2);
                contactMap.put("num3", updatedContact3);
                contactMap.put("num4", updatedContact4);
                contactMap.put("num5", updatedContact5);
                contactMap.put("num6", updatedContact6);

                // 수정된 전화번호를 저장한 후 액티비티 종료
                Intent intent = new Intent();
                intent.putExtra("contactMap", (Serializable) contactMap);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });


        // Set the initial values for the EditText fields from the contactMap
        contact1EditText.setText(contactMap.get("num1"));
        contact2EditText.setText(contactMap.get("num2"));
        contact3EditText.setText(contactMap.get("num3"));
        contact4EditText.setText(contactMap.get("num4"));
        contact5EditText.setText(contactMap.get("num5"));
        contact6EditText.setText(contactMap.get("num6"));
    }


}
