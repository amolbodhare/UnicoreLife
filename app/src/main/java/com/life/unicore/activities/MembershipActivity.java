package com.life.unicore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.life.unicore.R;

public class MembershipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);
        getWindow().setStatusBarColor(getResources().getColor(R.color.statusbarcolor));
    }
    public void onBack(View view) {
        onBackPressed();
    }
}
