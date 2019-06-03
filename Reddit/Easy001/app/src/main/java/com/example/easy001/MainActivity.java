package com.example.easy001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        final Button submit = findViewById(R.id.btnSubmit);
        final EditText userName = findViewById(R.id.editName);
        final EditText userAge = findViewById(R.id.editAge);
        final EditText userUsername = findViewById(R.id.editUsername);
        final TextView result = findViewById(R.id.viewResult);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String usrName = userName.getText().toString();
                int usrAge = Integer.parseInt(userAge.getText().toString());
                String usrUsername = userUsername.getText().toString();

                userName.setText("");
                userAge.setText("");
                userUsername.setText("");

                String outputString = "Hello " + usrName + "! you said you are " + usrAge + " years old and your username is " + usrUsername;
                //String outputString = "Test";
                result.setText(outputString);
            }
        });
    }
}
