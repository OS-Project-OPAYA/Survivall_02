package com.example.nav;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Toast;

import com.example.nav.Fragment.DataBaseHelper;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private DataBaseHelper dbHelper;

    public static void startActivity(Context context, String query) {
        Intent intent = new Intent(context, SearchActivity.class);
        intent.putExtra("query", query);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHelper = new DataBaseHelper(this);

        String query = getIntent().getStringExtra("query");
        if (query != null) {
            performSearch(query);
        } else {
            Toast.makeText(this, "No query specified", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void performSearch(String query) {
        List<String> searchResults = dbHelper.searchData(query);

        if (searchResults.isEmpty()) {
            Toast.makeText(this, "No results found", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            StringBuilder message = new StringBuilder();
            for (String result : searchResults) {
                message.append(result).append("\n");
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Search Results")
                    .setMessage(message.toString())
                    .setPositiveButton("Close", (dialog, which) -> finish());

            AlertDialog dialog = builder.create();

            // 팝업창의 배경색을 설정
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.popup_background)));

            dialog.show();
        }
    }
}
