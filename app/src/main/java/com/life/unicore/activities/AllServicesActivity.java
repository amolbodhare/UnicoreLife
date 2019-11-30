package com.life.unicore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.life.unicore.R;

public class AllServicesActivity extends AppCompatActivity {

    private AllServicesListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_services);
        getWindow().setStatusBarColor(getResources().getColor(R.color.statusbarcolor));
        listAdapter = new AllServicesListAdapter();
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(listAdapter);
        ((Button)findViewById(R.id.bookAppointmentBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(AllServicesActivity.this,TimeSlotActivity.class);
                startActivity(i);
            }
        });
    }
    private class AllServicesListAdapter extends BaseAdapter implements View.OnClickListener {

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
                convertView = getLayoutInflater().inflate(R.layout.all_services_list_item_layout, parent, false);

            return convertView;
        }

        @Override
        public void onClick(View v) {

        }
    }
    public void onBack(View view) {
        onBackPressed();
    }
}
