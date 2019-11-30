package com.life.unicore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.life.unicore.R;

public class BookedSuccessfullyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked_successfully);
        getWindow().setStatusBarColor(getResources().getColor(R.color.bookedsuccessback));
        findViewById(R.id.doneBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(BookedSuccessfullyActivity.this,AppointmentDetailsActivty.class);
                startActivity(i);
            }
        });
    }
}
