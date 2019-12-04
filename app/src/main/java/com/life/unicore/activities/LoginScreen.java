package com.life.unicore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.life.unicore.R;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        getWindow().setStatusBarColor(getResources().getColor(R.color.walktitle));
        getIntent().getStringExtra("latitude");
        getIntent().getStringExtra("longitude");
        findViewById(R.id.loginBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginScreen.this,OtpActivity.class);
                startActivity(i);
            }
        });
        findViewById(R.id.signUpBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginScreen.this,RegistrationActivity.class);
                startActivity(i);
            }
        });
    }

    public void onBackClick(View view) {
        finish();
    }
}
