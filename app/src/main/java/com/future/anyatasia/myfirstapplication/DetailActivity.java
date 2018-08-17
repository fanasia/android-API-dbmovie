package com.future.anyatasia.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView tvUsername;
    private TextView tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvUsername = findViewById(R.id.textView3);
        tvPassword = findViewById(R.id.textView4);

        Intent intent = getIntent();
        tvUsername.setText("Nama : " + intent.getStringExtra("username"));
        tvPassword.setText("Password : " + intent.getStringExtra("password"));
    }
}
