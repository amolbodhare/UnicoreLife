package com.life.unicore.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.life.unicore.R;

public class WalkThroughActivity extends AppCompatActivity
{

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private  SliderAdapter sliderAdapter;
    private  TextView[] mDots;
    private  int mDotsLength;
    int mCurrentPage;
    ImageView walkPreBtn;
    ImageView walkNextBtn;
    Button getStartdBtn;
    ImageView backBtnImv;
    TextView skipBtnTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(0);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorAccent));

        setContentView(R.layout.activity_walk_through);


        backBtnImv=(ImageView)findViewById(R.id.backBtn);
        skipBtnTv=(TextView)findViewById(R.id.skipTextView);

        walkPreBtn=(ImageView)findViewById(R.id.walkPrevBtn);
        walkNextBtn=(ImageView)findViewById(R.id.walkNextBtn);
        getStartdBtn=(Button)findViewById(R.id.getStartedBtn);
        mSlideViewPager=findViewById(R.id.slideViewPager);
        mDotLayout=findViewById(R.id.dotsLayout);

        sliderAdapter=new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);
        getStartdBtn.setVisibility(View.GONE);
        walkPreBtn.setVisibility(View.INVISIBLE);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        walkNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentPage+1);
            }
        });
        walkPreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentPage-1);
            }
        });

    }

    public void addDotsIndicator(int position)
    {
    /*    mDots=new TextView[7];
        mDotLayout.removeAllViews();
        for(int i=0;i<mDots.length;i++)
        {
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorAccent));
            mDotLayout.addView(mDots[i]);
        }
        if(mDots.length>0)
        {
            mDots[position].setTextColor(getResources().getColor(R.color.walktitle));
        }*/

        mDotsLength=mDotLayout.getChildCount();


        for(int i=0;i<mDotLayout.getChildCount();i++)
        {
            ((View)mDotLayout.getChildAt(i)).setBackground(getResources().getDrawable(R.drawable.deactivated_walk_dot_back));

        }

            if(position==mDotsLength)
            {

            }
            else
            ((View)mDotLayout.getChildAt(position)).setBackground(getResources().getDrawable(R.drawable.activated_walk_dot));

    }

    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);
            mCurrentPage=position;

            if(position==0)
            {
                walkNextBtn.setEnabled(true);
                walkPreBtn.setEnabled(false);
                mDotLayout.setVisibility(View.VISIBLE);
                walkPreBtn.setVisibility(View.INVISIBLE);
                getStartdBtn.setVisibility(View.GONE);

                //walkNextBtn.setText("Next");
                //walkPreBtn.setText("");

            }
            else if(position==mDotsLength)
            {

                walkPreBtn.setVisibility(View.GONE);
                walkNextBtn.setVisibility(View.GONE);
                mDotLayout.setVisibility(View.GONE);
                getStartdBtn.setVisibility(View.VISIBLE);

                //walkNextBtn.setEnabled(true);
                //walkPreBtn.setEnabled(true);


                //walkNextBtn.setText("Finish");
                //walkPreBtn.setText("Back");

            }
            else
            {
                walkNextBtn.setEnabled(true);
                walkPreBtn.setEnabled(true);
                walkPreBtn.setVisibility(View.VISIBLE);
                mDotLayout.setVisibility(View.VISIBLE);
                walkNextBtn.setVisibility(View.VISIBLE);
                getStartdBtn.setVisibility(View.GONE);

                //walkNextBtn.setText("Next");
                //walkPreBtn.setText("Back");

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };



    public  class SliderAdapter extends PagerAdapter
    {
        Context context;
        LayoutInflater layoutInflater;


        public  SliderAdapter(Context context)
        {
            this.context=context;

        }

        public  int[] slider_images=
        {
            R.drawable.doctorswalk,R.drawable.hospitalswalk,R.drawable.diagwalk,
                    R.drawable.ambulancewalk,R.drawable.bloodbankwalk,R.drawable.fitnesswalk,
                    R.drawable.pharmacywalk
        };

        public  String[] slider_headings={"FIND DOCTORS","FIND HOSPITALS","DIGESTIVE CENTRE","AMBULANCE","BLOOD BANK","FITNESS CENTRE","PHARMACY"};

        public  String[] slider_desc=
                {
                        "One way to announce or promote a certain new products or special.One way to announce or promote a certain new products or special.",
                        "One way to announce or promote a certain new products or special.One way to announce or promote a certain new products or special.",
                        "One way to announce or promote a certain new products or special.One way to announce or promote a certain new products or special.",
                        "One way to announce or promote a certain new products or special.One way to announce or promote a certain new products or special.",
                        "One way to announce or promote a certain new products or special.One way to announce or promote a certain new products or special.",
                        "One way to announce or promote a certain new products or special.One way to announce or promote a certain new products or special.",
                        "One way to announce or promote a certain new products or special.One way to announce or promote a certain new products or special."
                };

        @Override
        public int getCount() {
            return slider_headings.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==(RelativeLayout)object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position)
        {
            layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View view=layoutInflater.inflate(R.layout.walk_slider_layout,container,false);

            ImageView sliderImv=(ImageView) view.findViewById(R.id.walk_imv);
            TextView  sliderHeadings=(TextView)view.findViewById(R.id.walk_title);
            TextView  sliderdesc=(TextView)view.findViewById(R.id.walk_desc);

            sliderImv.setImageResource(slider_images[position]);
            sliderHeadings.setText(slider_headings[position]);
            sliderdesc.setText(slider_desc[position]);

            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((RelativeLayout)object);
        }
    }

}
