package com.life.unicore.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.life.unicore.R;

public class PatientDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);
        findViewById(R.id.bookAppointmentBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(PatientDetailsActivity.this,BookedSuccessfullyActivity.class);
                startActivity(i);
            }
        });

        getWindow().setStatusBarColor(getResources().getColor(R.color.statusbarcolor));
        handleTermsOfUse();
    }
    private void handleTermsOfUse() {
        TextView textView = findViewById(R.id.tAndC);
        String string = textView.getText().toString();

        SpannableString spannableString = new SpannableString(string);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view)
            {
                Intent intent = new Intent(PatientDetailsActivity.this, WebViewActivity.class);
                intent.putExtra("url","https://www.google.com");
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds)
            {
                super.updateDrawState(ds);
                ds.setColor(getResources().getColor(R.color.termscondition));
            }
        };

        spannableString.setSpan(clickableSpan,string.indexOf("T"),string.indexOf("C")+10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
    public void onBack(View view) {
        onBackPressed();
    }
}
