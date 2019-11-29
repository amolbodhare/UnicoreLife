package com.life.unicore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.life.unicore.R;

public class PatientDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);
        getWindow().setStatusBarColor(getResources().getColor(R.color.statusbarcolor));
    }
}
