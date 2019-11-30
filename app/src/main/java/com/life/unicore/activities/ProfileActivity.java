package com.life.unicore.activities;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.viewpager.widget.PagerAdapter;
        import androidx.viewpager.widget.ViewPager;

        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
        import android.text.Html;
        import android.view.LayoutInflater;
        import android.view.TextureView;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.RelativeLayout;
        import android.widget.TextView;

        import com.life.unicore.R;
        import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener
{

    public ViewPager viewPager;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        //it will move laayout under statusbar
        getWindow().setStatusBarColor(getResources().getColor(R.color.walktitle));
        context=ProfileActivity.this;

        ((Button)findViewById(R.id.shareExpBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        ((Button)findViewById(R.id.bookAppointBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        ((TextView)findViewById(R.id.viewAllTimings)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ProfileActivity.this,AllTimingsActivity.class);
                startActivity(i);
            }
        });
        ((TextView)findViewById(R.id.viewAllServices)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ProfileActivity.this,AllServicesActivity.class);
                startActivity(i);
            }
        });


        viewPager = findViewById(R.id.viewPager);
        hitSlidersApi();
        viewPager.addOnPageChangeListener(this);
        timingsListview();
        servicesListview();
        specializationListview();
        patientExpListview();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        changeDotColor(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, final int position) {
            View view = LayoutInflater.from(context).inflate(R.layout.doctor_image_slider, container, false);
            ImageView imageView = view.findViewById(R.id.sliderImageView);
            try {
                //Picasso.get().load(imageList.get(position)).into(imageView);
                Picasso.get().load(R.drawable.sample_img).into(imageView);
            } catch (Exception e) {
                e.printStackTrace();
            }
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //((ClientListActivity) context).showImagePopUp(context, imageList.get(position));
                }
            });

            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }

    private void setUpSliderDot() {
        try {
            TextView textView;
            LinearLayout linearLayout = findViewById(R.id.dotContainer);
            for (int i = 0; i < 3; i++) {
                textView = new TextView(context);
                textView.setText(Html.fromHtml("&#8226;"));
                textView.setTextSize(25);
                textView.setTextColor(getResources().getColor(R.color.white));
                //textView.setTextColor(Color.parseColor("#FFFFFF"));
                linearLayout.addView(textView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int i;
    public Handler handler = new Handler();
    public Runnable runnable;

    public void handlerViewPagerSlider(final ViewPager viewPager) {
        runnable = new Runnable() {
            @Override
            public void run() {
                changeDotColor(i);
                viewPager.setCurrentItem(i, true);
                if (i < 2)
                    i++;
                else
                    i = 0;
                //H.log("iIS", i + "");

                try {

                    handler.postDelayed(this, 3210);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };
        runnable.run();
    }

    private void changeDotColor(int i) {
        LinearLayout linearLayout = findViewById(R.id.dotContainer);
        TextView textView;
        try {
            for (int j = 0; j < linearLayout.getChildCount(); j++) {
                textView = ((TextView) linearLayout.getChildAt(j));
                if (i == j) {
                    textView.setTextColor(getResources().getColor(R.color.white));
                    continue;
                }
                textView.setTextColor(getResources().getColor(R.color.icongrey));
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    private void hitSlidersApi() {
        viewPager.setAdapter(new ViewPagerAdapter());
        handlerViewPagerSlider(viewPager);
        setUpSliderDot();
        changeDotColor(0);//for the first time nothing is showing selected.
    }
    private void timingsListview() {
        int n = 3;

        LinearLayout linearLayout = findViewById(R.id.timingContainerLayout);

        for (int j = 0; j < n; j++) {
            LinearLayout ll = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.inflatable_textview, null);
            TextView timetv = (TextView) ll.getChildAt(0);
            timetv.setText("11:00 am - 01:00 pm");

            //timetv.setOnCheckedChangeListener(this);
            linearLayout.addView(ll);
        }
    }
    private void servicesListview() {
        int n = 4;

        LinearLayout linearLayout = findViewById(R.id.servicesContainerLayout);

        for (int j = 0; j < n; j++) {
            LinearLayout ll = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.inflatable_textview, null);
            TextView timetv = (TextView) ll.getChildAt(0);
            timetv.setText("Normal Vaginal Delivery (NVD)");

            //timetv.setOnCheckedChangeListener(this);
            linearLayout.addView(ll);
        }
    }
    private void specializationListview() {
        int n = 4;

        LinearLayout linearLayout = findViewById(R.id.specializationContainerLayout);

        for (int j = 0; j < n; j++) {
            LinearLayout ll = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.inflatable_textview, null);
            TextView timetv = (TextView) ll.getChildAt(0);
            timetv.setText("Gynecologist");

            //timetv.setOnCheckedChangeListener(this);
            linearLayout.addView(ll);
        }
    }
    private void patientExpListview() {
        int n = 2;

        LinearLayout linearLayout = findViewById(R.id.patientExpContainerLayout);

        for (int j = 0; j < n; j++) {
            LinearLayout ll = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.inflatable_patient_exp_layout, null);
            TextView nametv = (TextView) ll.getChildAt(0);
            nametv.setText("Mansi");
            TextView exptv = (TextView) ll.getChildAt(1);
            exptv.setText("Doctor Varsha is an experienced gynaecologist with decades of experience. I went to her clinic for my pregnancy with some apprehension and she calmly cleared all of my doubts. I developed few complications during the course of my pregnancy but Dr Varsha handled them very ably and showed her true experience in the field. I would recommend Dr Varsha to anybody who wants a safe and enjoyable pregnancy.");

            RelativeLayout horiLinLay=(RelativeLayout) ll.findViewById(R.id.inflatableBottomLay);
            TextView verifiedtv=(TextView)horiLinLay.getChildAt(0);
            verifiedtv.setText("Verified patient");
            TextView durationtv=(TextView)horiLinLay.getChildAt(1);
            durationtv.setText("3 years ago");

            //timetv.setOnCheckedChangeListener(this);
            linearLayout.addView(ll);
        }
    }
    public void onBack(View view) {
        onBackPressed();
    }
}
