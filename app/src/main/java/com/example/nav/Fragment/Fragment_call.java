package com.example.nav.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nav.CallModify;
import com.example.nav.R;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Fragment_call extends Fragment {

    private View view;
    private String TAG = "프래그먼트";

    private static final int MODIFY_REQUEST_CODE = 1; // Request code for CallModify activity

    private Map<String, String> contactMap; // Map to store contact names and phone numbers

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        view = inflater.inflate(R.layout.frag_call, container, false);

        // Initialize the contact map
        contactMap = new HashMap<>();
        contactMap.put("num1", "11111");
        contactMap.put("num2", "22222");
        contactMap.put("num3", "33333");
        contactMap.put("num4", "44444");
        contactMap.put("num5", "55555");
        contactMap.put("num6", "66666");

        Button c1 = view.findViewById(R.id.c1);
        c1.setText(contactMap.get("num1")); // 저장된 번호로 버튼 텍스트 설정
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber(contactMap.get("num1"));
            }
        });

        Button c2 = view.findViewById(R.id.c2);
        c2.setText(contactMap.get("num2")); // 저장된 번호로 버튼 텍스트 설정
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber(contactMap.get("num2"));
            }
        });

        Button c3 = view.findViewById(R.id.c3);
        c3.setText(contactMap.get("num3")); // 저장된 번호로 버튼 텍스트 설정
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber(contactMap.get("num3"));
            }
        });

        Button c4 = view.findViewById(R.id.c4);
        c4.setText(contactMap.get("num4")); // 저장된 번호로 버튼 텍스트 설정
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber(contactMap.get("num4"));
            }
        });

        Button c5 = view.findViewById(R.id.c5);
        c5.setText(contactMap.get("num5")); // 저장된 번호로 버튼 텍스트 설정
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber(contactMap.get("num5"));
            }
        });

        Button c6 = view.findViewById(R.id.c6);
        c6.setText(contactMap.get("num6")); // 저장된 번호로 버튼 텍스트 설정
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber(contactMap.get("num6"));
            }
        });

        Button modifyButton = view.findViewById(R.id.modify);
        modifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditContactsActivity();
            }
        });

        Button sendButton = view.findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = ((EditText) view.findViewById(R.id.title_et)).getText().toString();

                // 연락처 목록을 문자열로 변환하여 콤마로 구분합니다.
                StringBuilder phoneNumberListBuilder = new StringBuilder();
                for (Map.Entry<String, String> entry : contactMap.entrySet()) {
                    String phoneNumber = entry.getValue();
                    phoneNumberListBuilder.append(phoneNumber).append(",");
                }
                String phoneNumberList = phoneNumberListBuilder.toString();

                // 문자열에 마지막 콤마가 있을 경우 제거합니다.
                if (phoneNumberList.endsWith(",")) {
                    phoneNumberList = phoneNumberList.substring(0, phoneNumberList.length() - 1);
                }

                // 여러 연락처에 동시에 메시지를 보내기 위해 ACTION_SENDTO를 사용합니다.
                Uri uri = Uri.parse("smsto:" + phoneNumberList);
                Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
                sendIntent.putExtra("sms_body", message);
                startActivity(sendIntent);
            }
        });

        return view;
    }

    private void dialPhoneNumber(String phoneNumber) {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        dialIntent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(dialIntent);
    }

    private void openEditContactsActivity() {
        Intent intent = new Intent(getActivity(), CallModify.class);
        intent.putExtra("contactMap", (Serializable) contactMap);
        startActivityForResult(intent, MODIFY_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MODIFY_REQUEST_CODE && resultCode == getActivity().RESULT_OK) {
            Map<String, String> updatedContactMap = (Map<String, String>) data.getSerializableExtra("contactMap");
            if (updatedContactMap != null) {
                contactMap = updatedContactMap;
                // 수정된 연락처를 반영하는 작업 수행
                // 예: 버튼의 텍스트를 수정된 연락처로 업데이트
                Button c1 = view.findViewById(R.id.c1);
                c1.setText(contactMap.get("num1"));

                Button c2 = view.findViewById(R.id.c2);
                c2.setText(contactMap.get("num2"));

                Button c3  = view.findViewById(R.id.c3);
                c3.setText(contactMap.get("num3"));

                Button c4 = view.findViewById(R.id.c4);
                c4.setText(contactMap.get("num4"));

                Button c5 = view.findViewById(R.id.c5);
                c5.setText(contactMap.get("num5"));

                Button c6 = view.findViewById(R.id.c6);
                c6.setText(contactMap.get("num6"));
            }
        }
    }
}
