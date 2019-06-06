package com.example.arrayadaptertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView textList;
    Button btnAdd;
    Button btnSwitch;
    TextView tvAdd;
    ArrayList<String> displayList = new ArrayList<>(); // Using ArrayList to Dynamically add Elements

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayList.add("Lion");
        displayList.add("Tea");

        textList = findViewById(R.id.lvText);
        tvAdd = findViewById(R.id.textInput);

        // ArrayAdapter takes an Array (Maybe also other Array like structures - TO TEST) and
        // inserts the Values into a premade layout file
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.populate_string_list, R.id.tvString, displayList);
        textList.setAdapter(arrayAdapter);

        btnAdd = findViewById(R.id.btnSave);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String insert = tvAdd.getText().toString();
                displayList.add(insert);
                tvAdd.setText("");

                // notifyDataSetChanged tells the ListView that the Data within it has changed
                arrayAdapter.notifyDataSetChanged();

            }
        });

        btnSwitch = findViewById(R.id.btnAdvance);
        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity(); // needs to be "outsourced" to a new function as SecondActivity.class cannot be used here(?)
            }
        });
    }

    private void launchActivity() { // we create an intent to move to a new Phone screen
        // needs an extra activity and java file
        // java file needs to be included in the android manifest file
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
