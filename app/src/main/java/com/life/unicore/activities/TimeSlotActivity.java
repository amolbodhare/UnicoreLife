package com.life.unicore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.life.unicore.R;

public class TimeSlotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_slot);
        getWindow().setStatusBarColor(getResources().getColor(R.color.statusbarcolor));
        ((Button)findViewById(R.id.bookAppointmentBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(TimeSlotActivity.this,PatientDetailsActivity.class);
                startActivity(i);
            }
        });

    }
}
