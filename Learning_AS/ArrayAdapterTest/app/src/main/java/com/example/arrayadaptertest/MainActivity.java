package com.example.arrayadaptertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    ListView textList;
    String displayList[] = {"Lion", "Tea"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textList = findViewById(R.id.lvText);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.populate_list_view, R.id.textView, displayList);
        textList.setAdapter(arrayAdapter);
    }
}
