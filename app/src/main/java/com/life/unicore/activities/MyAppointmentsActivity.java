package com.life.unicore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.life.unicore.R;

public class MyAppointmentsActivity extends AppCompatActivity {

    private UpcomingAppoListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_appointments);
        getWindow().setStatusBarColor(getResources().getColor(R.color.statusbarcolor));
        listAdapter = new UpcomingAppoListAdapter();

        ListView upcominglistView = (ListView) findViewById(R.id.upcomingAppoListView);
        upcominglistView.setAdapter(listAdapter);

        ListView pastlistView = (ListView) findViewById(R.id.pastAppoListView);
        pastlistView.setAdapter(listAdapter);
    }

    private class UpcomingAppoListAdapter extends BaseAdapter implements View.OnClickListener
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
                convertView = getLayoutInflater().inflate(R.layout.upcoming_appointments_item_layout, parent, false);

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
