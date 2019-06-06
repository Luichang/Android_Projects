package com.example.arrayadaptertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SecondActivity extends AppCompatActivity {

    Button btnReturn;
    Button btnAdd;
    ListView textList;
    TextView tvMovieName;
    TextView tvMovieDate;
    TextView tvMovieViews;

    private ArrayList<Movie> displayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        textList = findViewById(R.id.lvAdvText);
        tvMovieName = findViewById(R.id.txtInputName);
        tvMovieDate = findViewById(R.id.txtInputRelease);
        tvMovieViews = findViewById(R.id.txtInputViews);

        final MovieAdapter movieAdapter = new MovieAdapter(this, displayList);
        textList.setAdapter(movieAdapter);

        btnAdd = findViewById(R.id.btnAdSave);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String insertName = tvMovieName.getText().toString();
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Calendar calendar = Calendar.getInstance();
                Date insertDate;
                int insertViews = Integer.parseInt(tvMovieViews.getText().toString());
                try {
                    insertDate = df.parse(tvMovieDate.getText().toString());
                    Movie insert = new Movie(insertName, insertDate, insertViews);

                    displayList.add(insert);
                    tvMovieName.setText("");
                    tvMovieDate.setText("");
                    tvMovieViews.setText("");

                    movieAdapter.notifyDataSetChanged();

                } catch (ParseException e) {
                    e.printStackTrace();
                }


            }
        });

        btnReturn = findViewById(R.id.btnReturn);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
