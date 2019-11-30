package com.life.unicore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.life.unicore.R;

public class AppointmentDetailsActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_details_activty);
        getWindow().setStatusBarColor(getResources().getColor(R.color.statusbarcolor));
    }
    public void onBack(View view) {
        onBackPressed();
    }
}
