package com.example.hw411;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);
        BaseAdapter listContentAdapter = createAdapter();

        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private BaseAdapter createAdapter() {
        int[] to = {R.id.text, R.id.textLength};
        String[] from = {"text", "length"};
        return new SimpleAdapter(this, prepareContent(), R.layout.list_item, from, to);
    }

    @NonNull
    private List<HashMap<String, String>> prepareContent() {
        List<HashMap<String, String>> list = new ArrayList<>();
        HashMap<String, String> map;
        String[] stringArray = getString(R.string.large_text).split("\n\n");
        for (int i = 0; i < stringArray.length; i++) {
            map = new HashMap<>();
            map.put("text", stringArray[i]);
            map.put("length", stringArray[i].length() + "");
            list.add(map);
        }
        return list;
    }
}
