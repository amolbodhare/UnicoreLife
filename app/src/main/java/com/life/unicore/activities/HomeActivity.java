package com.life.unicore.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.life.unicore.R;
import com.life.unicore.others.ExpandableHeightGridView;

public class HomeActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerLayout = findViewById(R.id.drawerlayout);
        ((ExpandableHeightGridView) findViewById(R.id.hallsListGridView)).setAdapter(new HallsGridViewAdapter());
        ((ExpandableHeightGridView) findViewById(R.id.hallsListGridView)).setExpanded(true);
    }

    public void onDrawerCloseClick(View view) {
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    public void NavigationDrawerClick(View view) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    class HallsGridViewAdapter extends BaseAdapter {

        private TextView textView_navTitle;
        private TextView textView_navDesc;
        private ImageView imageView_nav;

        public  int[] slider_images=
                {
                        R.drawable.doctorswalk,R.drawable.hospitalswalk,R.drawable.diagwalk,
                        R.drawable.ambulancewalk,R.drawable.bloodbankwalk,R.drawable.ic_home_nav_dots
                };

        public  String[] slider_headings={"FIND DOCTORS","FIND HOSPITALS","DIGESTIVE CENTRE","AMBULANCE","BLOOD BANK","FIND MORE"};

        public  String[] slider_desc=
                {"FIND DOCTORS","FIND HOSPITALS","DIGESTIVE CENTRE","AMBULANCE","BLOOD BANK","FIND MORE"};

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

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.home_navigation_list_item, parent, false);

                convertView.findViewById(R.id.hallListCardView).setTag(position);


                textView_navTitle = convertView.findViewById(R.id.navTitle);
                textView_navDesc = convertView.findViewById(R.id.navDesc);
                imageView_nav = convertView.findViewById(R.id.navImv);

                textView_navTitle.setText(slider_headings[position]);
                textView_navDesc.setText(slider_desc[position]);
                imageView_nav.setImageResource(slider_images[position]);


                convertView.findViewById(R.id.hallListCardView).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        //Intent intent = new Intent(HallSelectionActivity.this,ClockActivity.class);
                        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        //startActivity(intent);
                    }
                });

            }

            return convertView;
        }

    }
}
