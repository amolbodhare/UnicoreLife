package com.life.unicore.activities;

        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.widget.Toolbar;
        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentManager;
        import androidx.fragment.app.FragmentPagerAdapter;
        import androidx.viewpager.widget.ViewPager;

        import android.net.Uri;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageView;


        import com.google.android.material.appbar.AppBarLayout;
        import com.google.android.material.appbar.CollapsingToolbarLayout;
        import com.google.android.material.tabs.TabLayout;
        import com.life.unicore.R;
        import com.life.unicore.fragments.LifeStyleInfoFragment;
        import com.life.unicore.fragments.MedicalInfoFragment;
        import com.life.unicore.fragments.PersonalInfoFragment;
        import com.squareup.picasso.Picasso;

        import java.util.ArrayList;

public class MyProfileActivity extends AppCompatActivity implements MedicalInfoFragment.OnFragmentInteractionListener,PersonalInfoFragment.OnFragmentInteractionListener,LifeStyleInfoFragment.OnFragmentInteractionListener
{

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_profile);

        //getWindow().setStatusBarColor(getResources().getColor(R.color.walktitle));

        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //it will remove status bar
        //getWindow().getDecorView().setSystemUiVisibility(0);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        //it will move laayout under statusbar

        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        getWindow().setStatusBarColor(getResources().getColor(R.color.transparent));


        tabLayout=findViewById(R.id.tabs);
        viewPager=findViewById(R.id.viewPager);
        tabLayout.setupWithViewPager(viewPager);
        viewPagerDemo(viewPager);
        /*try {
            //Glide.with(this).load(R.drawable.cover).into((ImageView) findViewById(R.id.backdrop));
            Picasso.get().load(R.drawable.cover).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
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

    public void onBack(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
