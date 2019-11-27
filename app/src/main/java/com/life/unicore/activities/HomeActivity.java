package com.life.unicore.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.life.unicore.R;
import com.life.unicore.others.ExpandableHeightGridView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Context context;
    ArrayList<String> specialistnames=new ArrayList<String>();
    ArrayList<String> hospitalnames=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context=HomeActivity.this;
        drawerLayout = findViewById(R.id.drawerlayout);
        ((ExpandableHeightGridView) findViewById(R.id.homeNavGridView)).setAdapter(new HomeNavGridViewAdapter());
        ((ExpandableHeightGridView) findViewById(R.id.homeNavGridView)).setExpanded(true);
        specialistSliderList();
        hospitalsSliderList();
    }

    public void onDrawerCloseClick(View view) {
        drawerLayout.closeDrawer(GravityCompat.START);
    }


    public void NavigationDrawerClick(View view) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    class HomeNavGridViewAdapter extends BaseAdapter {

        private TextView textView_navTitle;
        private TextView textView_navDesc;
        private ImageView imageView_nav;

        public  int[] slider_images=
                {
                        R.drawable.ic_home_nav_doctors,R.drawable.hospitalswalk,R.drawable.diagwalk,
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


                        Intent i=new Intent(HomeActivity.this,FindDoctorsActivity.class);
                        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                        //startActivity(intent);
                    }
                });

            }

            return convertView;
        }

    }

    public void onDrawerMenuClick(View view)
    {

    }

    public  void specialistSliderList()
    {

        specialistnames.add("Dentist");
        specialistnames.add("Gynecologist");
        specialistnames.add("Dietitian/Nutrition");

        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.specialistRecyclerView);
        recyclerView.setLayoutManager(layoutManager);
        SpecialistAdapter adapter = new SpecialistAdapter(context,specialistnames);
        recyclerView.setAdapter(adapter);
    }

    public  void hospitalsSliderList()
    {

        hospitalnames.add("Apollo Hospital");
        hospitalnames.add("Fortis Hospital");
        hospitalnames.add("Apollo Hospital");

        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.hospitalsRecyclerView);
        recyclerView.setLayoutManager(layoutManager);
        HospitalsAdapter adapter = new HospitalsAdapter(context,hospitalnames);
        recyclerView.setAdapter(adapter);
    }

    public class SpecialistAdapter extends RecyclerView.Adapter<SpecialistAdapter.ViewHolder> {

        private static final String TAG = "SpecialistAdapter";

        //vars


        private Context mContext;

        public SpecialistAdapter(Context context, ArrayList<String> names) {
            specialistnames = names;
            mContext = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.specialist_slider_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            Log.d(TAG, "onBindViewHolder: called.");

            /*Glide.with(mContext)
                    .asBitmap()
                    //.load(mImageUrls.get(position))
                    .load(R.drawable.chinese_food)
                    .into(holder.thumbnail);*/

            holder.title.setText(specialistnames.get(position));

            holder.thumbnail.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    //Log.d(TAG, "onClick: clicked on an image: " + specialistnames.get(position));
                    //Toast.makeText(mContext, specialistnames.get(position), Toast.LENGTH_SHORT).show();

                }
            });
        }

        @Override
        public int getItemCount() {
            return specialistnames.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder{

            public TextView title;
            public ImageView thumbnail, overflow;

            public ViewHolder(View view)
            {
                super(view);
                title = (TextView) view.findViewById(R.id.specialistTitle);
                thumbnail = (ImageView) view.findViewById(R.id.specialistImg);
            }
        }
    }
    public class HospitalsAdapter extends RecyclerView.Adapter<HospitalsAdapter.ViewHolder> {

        private static final String TAG = "HospitalListAdapter";

        //vars


        private Context mContext;

        public HospitalsAdapter(Context context, ArrayList<String> names) {
            hospitalnames = names;
            mContext = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hospital_slider_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            Log.d(TAG, "onBindViewHolder: called.");

            /*Glide.with(mContext)
                    .asBitmap()
                    //.load(mImageUrls.get(position))
                    .load(R.drawable.chinese_food)
                    .into(holder.thumbnail);*/

            holder.title.setText(hospitalnames.get(position));

            holder.thumbnail.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    //Log.d(TAG, "onClick: clicked on an image: " + specialistnames.get(position));
                    //Toast.makeText(mContext, specialistnames.get(position), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return hospitalnames.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder{

            public TextView title;
            public ImageView thumbnail;

            public ViewHolder(View view)
            {
                super(view);
                title = (TextView) view.findViewById(R.id.hospitalTitle);
                thumbnail = (ImageView) view.findViewById(R.id.hospitalImg);
            }
        }
    }

}
