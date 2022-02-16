package com.life.unicore.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import android.widget.SearchView;
import android.widget.TextView;

import com.life.unicore.R;
import com.life.unicore.others.ExpandableHeightGridView;
import com.squareup.picasso.Picasso;

public class FindDoctorsActivity extends AppCompatActivity {


    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctors);
        searchView=findViewById(R.id.searchView);

        getWindow().setStatusBarColor(getResources().getColor(R.color.statusbarcolor));
        ((ExpandableHeightGridView) findViewById(R.id.healthConcernGridView)).setAdapter(new HealthConcernGridViewAdapter());
        ((ExpandableHeightGridView) findViewById(R.id.healthConcernGridView)).setExpanded(true);
    }
    
    class HealthConcernGridViewAdapter extends BaseAdapter {

        private TextView textView_navTitle;
        private ImageView imageView_nav;

        public  int[] slider_images=
                {
                        R.drawable.ic_general_surgon,R.drawable.ic_general_surgon,R.drawable.ic_general_surgon,
                        R.drawable.ic_general_surgon,R.drawable.ic_general_surgon,R.drawable.ic_general_surgon,
                        R.drawable.ic_general_surgon,R.drawable.ic_general_surgon,R.drawable.ic_general_surgon,
                        R.drawable.ic_general_surgon,R.drawable.ic_general_surgon,R.drawable.ic_general_surgon,
                        R.drawable.ic_general_surgon,R.drawable.ic_general_surgon,R.drawable.ic_general_surgon,
                        R.drawable.ic_general_surgon,R.drawable.ic_general_surgon
                };

        public  String[] slider_headings={"Dentist","Women's Health","Skin & Hair","Child Specialist","Ear, Nose, Throat","Physiotherapist",
                "General surgeon","Orthopedist","Sex Specialist","Homeopathy","Mental Wellness","Diabetes \n" +
                "Managment",
                "Ayurveda","Heart","Cancer","Brain & Nerves","Bones & joints"};


        @Override
        public int getCount() {

            return slider_images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            if (convertView == null)
            {
                convertView = getLayoutInflater().inflate(R.layout.health_concern_slider_item, parent, false);


                textView_navTitle = convertView.findViewById(R.id.healthCareTitle);
                imageView_nav = convertView.findViewById(R.id.healthcareImg);

                textView_navTitle.setText(slider_headings[position]);

                try {
                    //Picasso.get().load(imageList.get(position)).into(imageView);
                    //Picasso.get().load(slider_images[position]).into(imageView_nav);
                    Picasso.get().load("https://images.unsplash.com/photo-1561766926-a7c863179e15?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80").into(imageView_nav);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                //imageView_nav.setImageResource();


                convertView.findViewById(R.id.healthConcernCardView).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Intent i=new Intent(FindDoctorsActivity.this,DoctorsListActivity.class);
                        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                        //startActivity(intent);
                    }
                });

            }

            return convertView;
        }

    }
    public void onBack(View view) {
        onBackPressed();
    }
}
