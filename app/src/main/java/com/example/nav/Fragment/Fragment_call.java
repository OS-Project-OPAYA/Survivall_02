package com.example.nav.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nav.R;

public class Fragment_call extends Fragment {

    private View view;
    private String TAG = "프래그먼트";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        view = inflater.inflate(R.layout.frag_call, container, false);

        Button homeButton = view.findViewById(R.id.home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "12345";
                dialPhoneNumber(phoneNumber);
            }
        });

        Button momButton = view.findViewById(R.id.mom_button);
        momButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "11111"; // 엄마 전화번호 입력
                dialPhoneNumber(phoneNumber);
            }
        });

        Button dadButton = view.findViewById(R.id.dad_button);
        dadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "22222"; // 아빠 전화번호 입력
                dialPhoneNumber(phoneNumber);
            }
        });

        Button minwooButton = view.findViewById(R.id.minwoo_button);
        minwooButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "33333"; // 민우 전화번호 입력
                dialPhoneNumber(phoneNumber);
            }
        });

        Button donghyunButton = view.findViewById(R.id.donghyun_button);
        donghyunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "44444"; // 동현 전화번호 입력
                dialPhoneNumber(phoneNumber);
            }
        });

        Button jinyoungButton = view.findViewById(R.id.jinyoung_button);
        jinyoungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "55555"; // 진영 전화번호 입력
                dialPhoneNumber(phoneNumber);
            }
        });

        return view;
    }

    private void dialPhoneNumber(String phoneNumber) {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        dialIntent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(dialIntent);
    }

    
}
