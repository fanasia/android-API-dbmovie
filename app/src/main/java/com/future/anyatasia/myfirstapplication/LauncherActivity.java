package com.future.anyatasia.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LauncherActivity extends AppCompatActivity {

    private TextView loginTitle;
    private Button buttonLogin;

    private EditText usernameField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        loginTitle = findViewById(R.id.textView);
        buttonLogin = findViewById(R.id.button);
        usernameField = findViewById(R.id.editText);
        passwordField = findViewById(R.id.editText2);

        // set text di textview
       loginTitle.setText("Please Login First!");

       // pindah activity + kirim data
       buttonLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
//               get dr field
//               loginTitle.setText("Hi, " + usernameField.getText().toString() + "!");
//               kirim data
               Intent intent = new Intent(LauncherActivity.this, DetailActivity.class);
               intent.putExtra("username", usernameField.getText().toString());
               intent.putExtra("password", passwordField.getText().toString());
               startActivity(intent);
           }
       });
    }
}
