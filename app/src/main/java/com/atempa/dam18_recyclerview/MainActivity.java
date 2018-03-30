package com.atempa.dam18_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private MyArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        // Build a dataset
        String[] films = { "A New Hope", "The Empire Strikes Back", "Return of the Jedi",
                "The Phantom Menace", "Attack of the Clones", "Revenge of the Sith",
                "The Force Awakens", "The Last Jedi" };
        // Create an adapter
        adapter = new MyArrayAdapter(this, android.R.layout.simple_list_item_1, films);
        // Bind listview with adapter
        listView.setAdapter(adapter);
    }
}
