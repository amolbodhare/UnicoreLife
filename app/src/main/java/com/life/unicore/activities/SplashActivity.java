package com.life.unicore.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.life.unicore.R;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 1000;

    //private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(getResources().getColor(R.color.transparent));
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 31);

    }

    private void startNewActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent intent;
                intent=new Intent(SplashActivity.this,WalkThroughActivity.class);

              /*String string = session.getString(P.tokenData);
                H.log("tokenIs", string);
                if (!sharableLink.isEmpty()) {
                    intent = new Intent(SplashActivity.this, WebViewActivity.class);
                    intent.putExtra("url", sharableLink);
                } else if (string == null || string.isEmpty())
                    intent = new Intent(SplashActivity.this, WalkThroughActivity.class);
                else if (session.getInt(P.full_register) == 0)
                    intent = new Intent(SplashActivity.this, RegSecondPageActivity.class);
                else
                    intent = new Intent(SplashActivity.this, HomeActivity.class);
*/

                //for deep linking
                /*if (!profileId.isEmpty())
                    intent.putExtra(P.profile_id,profileId);*/

                startActivity(intent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        startNewActivity();
    }
}
