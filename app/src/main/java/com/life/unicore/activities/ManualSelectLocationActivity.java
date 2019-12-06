package com.life.unicore.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.life.unicore.R;

import java.util.ArrayList;

public class ManualSelectLocationActivity extends AppCompatActivity {

    ArrayList<String> list=new ArrayList<String>();
    private LocationListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_select_location);
        list.add("Banglore");
        list.add("Chennai");
        list.add("Delhi");
        list.add("Hydrabad");
        list.add("Mumbai");
        list.add("Pune");
        getWindow().setStatusBarColor(getResources().getColor(R.color.statusbarcolor));
        listAdapter = new LocationListAdapter();
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(listAdapter);

        //Toolbar toolbarTop = (Toolbar) findViewById(R.id.toolbar);

        //TextView mTitle = (TextView) toolbarTop.findViewById(R.id.toolbar_title);
        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getSupportActionBar().setCustomView(R.layout.action_bar_layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*getMenuInflater().inflate(R.menu.main_menu,menu);
        MenuItem item=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });*/
        return super.onCreateOptionsMenu(menu);
    }
    public void onBack(View view) {
        onBackPressed();
    }
    private class LocationListAdapter extends BaseAdapter implements View.OnClickListener {

        ImageView imageView;

        TextView textView;
        int i;

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //json=jsonList.get(position);
            if (convertView == null)
                convertView = getLayoutInflater().inflate(R.layout.select_location_list_item_layout, parent, false);
            ((TextView)convertView.findViewById(R.id.cityName)).setText(list.get(position));
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(ManualSelectLocationActivity.this,LoginScreen.class);
                    startActivity(i);
                }
            });

            return convertView;
        }

        @Override
        public void onClick(View v) {

        }
    }
}
