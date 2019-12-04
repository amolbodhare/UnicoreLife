package com.life.unicore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.life.unicore.R;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getWindow().setStatusBarColor(getResources().getColor(R.color.walktitle));
    }

    public void onBackClick(View view) {
        finish();
    }
}
