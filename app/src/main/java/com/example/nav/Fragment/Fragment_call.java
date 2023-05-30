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

    private Map<String, String> contactMap; // Map to store contact names and phone numbers

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        view = inflater.inflate(R.layout.frag_call, container, false);

        // Initialize the contact map
        contactMap = new HashMap<>();
        contactMap.put("home", "12345");
        contactMap.put("mom", "11111");
        contactMap.put("dad", "22222");
        contactMap.put("minwoo", "33333");
        contactMap.put("donghyun", "44444");
        contactMap.put("jinyoung", "55555");

        Button homeButton = view.findViewById(R.id.home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber(contactMap.get("home"));
            }
        });

        Button momButton = view.findViewById(R.id.mom_button);
        momButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber(contactMap.get("mom"));
            }
        });

        Button dadButton = view.findViewById(R.id.dad_button);
        dadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber(contactMap.get("dad"));
            }
        });

        Button minwooButton = view.findViewById(R.id.minwoo_button);
        minwooButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber(contactMap.get("minwoo"));
            }
        });

        Button donghyunButton = view.findViewById(R.id.donghyun_button);
        donghyunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber(contactMap.get("donghyun"));
            }
        });

        Button jinyoungButton = view.findViewById(R.id.jinyoung_button);
        jinyoungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber(contactMap.get("jinyoung"));
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
                for (Map.Entry<String, String> entry : contactMap.entrySet()) {
                    sendMessage(entry.getValue(), message);
                }
            }
        });

        return view;
    }

    private void dialPhoneNumber(String phoneNumber) {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        dialIntent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(dialIntent);
    }

    private void sendMessage(String phoneNumber, String message) {
        // Implement your logic to send the message to the given phone number
    }

    private void openEditContactsActivity() {
        Intent intent = new Intent(getActivity(), CallModify.class);
        intent.putExtra("contactMap", (Serializable) contactMap);
        startActivity(intent);
    }
}
