package com.life.unicore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.life.unicore.R;

public class ChooseLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_location);
    }
    public void onBackClick(View view) {
        onBackPressed();
    }

    public void onSkipClick(View view) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
