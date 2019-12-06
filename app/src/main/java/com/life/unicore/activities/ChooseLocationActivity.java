package com.life.unicore.activities;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;


import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.life.unicore.R;


public class ChooseLocationActivity extends AppCompatActivity
{

    private FusedLocationProviderClient client;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_location);
        context=ChooseLocationActivity.this;
        getWindow().setStatusBarColor(getResources().getColor(R.color.semi_transparent));
        client= LocationServices.getFusedLocationProviderClient(this);

        findViewById(R.id.currentLocBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ActivityCompat.requestPermissions(ChooseLocationActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 31);
            }
        });

        findViewById(R.id.manualLocBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(ChooseLocationActivity.this,ManualSelectLocationActivity.class);
                startActivity(i);
            }
        });


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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        Intent i=new Intent(ChooseLocationActivity.this,LoginScreen.class);
        startActivity(i);
       /* client.getLastLocation().addOnSuccessListener(ChooseLocationActivity.this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location)
            {
                //Toast.makeText(ChooseLocationActivity.this, ""+location, Toast.LENGTH_SHORT).show();
                if(location==null)
                {
                    showGpsDialog();
                    //Toast.makeText(ChooseLocationActivity.this, "null"+location, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(ChooseLocationActivity.this, ""+location, Toast.LENGTH_SHORT).show();

                    Intent i=new Intent(ChooseLocationActivity.this,LoginScreen.class);
                    i.putExtra("latitude",location.getLatitude());
                    i.putExtra("longitude",location.getLongitude());
                    startActivity(i);
                }

            }

        });*/


    }

    public  void showGpsDialog()
    {
        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        boolean gps_enabled = false;
        boolean network_enabled = false;
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {
        }

        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) {
        }

        if (!gps_enabled && !network_enabled)
        {
            // notify user
            new AlertDialog.Builder(context)
                    .setMessage("GPS not enabled")
                    .setPositiveButton("open location settings", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                            context.startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                            Toast.makeText(ChooseLocationActivity.this, "after", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("cancel", null)
                    .show();
        }
    }
}
