package com.example.luichang.my_not_first_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // woriking through the tutorial offered by the android dev page https://developer.android.com/training/index.html
    public static final String EXTRA_MESSAGE = "com.example.luichang.my_not_first_app.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        // using intents to change not only to a new app screen, but also change which java file is currently active,
        // so new java files are not only used for classes, but can also be used for different screens
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        // I usually like defining these globally, but it is probably more resource effective to not define them globally
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        // intent.putExtra passes arguments to the to be called intent/Activity
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
