package com.example.nav;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nav.Fragment.DataBaseHelper;

import java.util.List;



public class SearchActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private DataBaseHelper dbHelper;

    public static void startActivity(Context context, String query) {
        Intent intent = new Intent(context, SearchActivity.class);
        intent.putExtra("query", query);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listView = new ListView(this);
        setContentView(listView);

        dbHelper = new DataBaseHelper(this);

        String query = getIntent().getStringExtra("query");
        if (query != null) {
            performSearch(query);
        } else {
            Toast.makeText(this, "No query specified", Toast.LENGTH_SHORT).show();
        }
    }

    private void performSearch(String query) {
        List<String> searchResults = dbHelper.searchData(query);

        if (searchResults.isEmpty()) {
            Toast.makeText(this, "No results found", Toast.LENGTH_SHORT).show();
        } else {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, searchResults);
            listView.setAdapter(adapter);
        }
    }
}
