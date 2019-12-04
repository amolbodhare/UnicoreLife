package com.life.unicore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.life.unicore.R;

public class OtpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        getWindow().setStatusBarColor(getResources().getColor(R.color.walktitle));
        findViewById(R.id.loginBtn).setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                               Intent i=new Intent(OtpActivity.this,HomeActivity.class);
                                                               startActivity(i);
                                                           }
                                                       }
        );
    }

    public void onBackClick(View view) {
        finish();
    }
}
