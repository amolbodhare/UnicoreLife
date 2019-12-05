package com.life.unicore.activities;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.life.unicore.R;

public class MyDoctorsActivity extends AppCompatActivity {

    private MyDoctorsListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_doctors);
        getWindow().setStatusBarColor(getResources().getColor(R.color.statusbarcolor));
        listAdapter = new MyDoctorsListAdapter();

        ListView upcominglistView = (ListView) findViewById(R.id.upcomingAppoListView);
        upcominglistView.setAdapter(listAdapter);

    }

    private class MyDoctorsListAdapter extends BaseAdapter implements View.OnClickListener
    {
        ImageView imageView;
        String string = "";
        TextView textView;
        int i;

        @Override
        public int getCount() {
            return 15;
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
                convertView = getLayoutInflater().inflate(R.layout.my_doctors_item_layout, parent, false);

            return convertView;
        }

        @Override
        public void onClick(View v) {

        }
    }

    public void onBack(View view)
    {
        onBackPressed();
    }
}
