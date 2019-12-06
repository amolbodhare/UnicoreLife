package com.life.unicore.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.life.unicore.R;
import com.life.unicore.fragments.LifeStyleInfoFragment;
import com.life.unicore.fragments.MedicalInfoFragment;
import com.life.unicore.fragments.PersonalInfoFragment;

import java.util.ArrayList;

public class MyProfileActivity extends AppCompatActivity implements MedicalInfoFragment.OnFragmentInteractionListener,PersonalInfoFragment.OnFragmentInteractionListener,LifeStyleInfoFragment.OnFragmentInteractionListener
{

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        tabLayout=findViewById(R.id.tabs);
        viewPager=findViewById(R.id.viewPager);
        tabLayout.setupWithViewPager(viewPager);
        viewPagerDemo(viewPager);
    }

    public void viewPagerDemo(ViewPager viewPager)
    {
        TabsFragmentAdapter tabsFragmentAdapter=new TabsFragmentAdapter(getSupportFragmentManager());

        tabsFragmentAdapter.addFragment(new PersonalInfoFragment(),"Personal");
        tabsFragmentAdapter.addFragment(new MedicalInfoFragment(),"Medical");
        tabsFragmentAdapter.addFragment(new LifeStyleInfoFragment(),"LifeStyle");

        viewPager.setAdapter(tabsFragmentAdapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    class TabsFragmentAdapter extends FragmentPagerAdapter
    {

        ArrayList<Fragment> fragments=new ArrayList<Fragment>();
        ArrayList<String> title=new ArrayList<String>();

        public TabsFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return title.get(position);
        }

        public void addFragment(Fragment fragment,String name)
        {
            fragments.add(fragment);
            title.add(name.toLowerCase());
        }
    }

}
