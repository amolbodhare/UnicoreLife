package com.life.unicore.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.life.unicore.R;

public class DoctorsListActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private Context context;
    DoctorsListAdapter doctorsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_list);

        context=DoctorsListActivity.this;
        recyclerView = findViewById(R.id.doctorsListRecyclerView);

        layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        doctorsListAdapter=new DoctorsListAdapter(context);
        recyclerView.setAdapter(doctorsListAdapter);

    }

    public class DoctorsListAdapter extends RecyclerView.Adapter<DoctorsListAdapter.MyViewHolder> {
        private Context context;

        public class MyViewHolder extends RecyclerView.ViewHolder {

            CardView cardView;
            TextView textViewEventName;
            TextView textViewCompUsrNameTv;
            TextView textViewCompNameTv;
            TextView textViewLocation;
            TextView textViewDate;
            TextView textViewSerial;


            public MyViewHolder(View itemView) {
                super(itemView);

                /*this.cardView = (CardView) itemView.findViewById(R.id.card_view);
                this.textViewEventName = (TextView) itemView.findViewById(R.id.eventNameTv);
                this.textViewCompUsrNameTv = (TextView) itemView.findViewById(R.id.companyUserNameTv);
                this.textViewCompNameTv = (TextView) itemView.findViewById(R.id.companyNameTv);
                this.textViewLocation = (TextView) itemView.findViewById(R.id.eventLocationTv);
                this.textViewDate = (TextView) itemView.findViewById(R.id.eventDateTv);
                this.textViewSerial = (TextView) itemView.findViewById(R.id.eventSerialTv);*/
            }
        }

        public DoctorsListAdapter(Context context) {
            this.context = context;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.doctors_list_item, parent, false);
            //view.setOnClickListener(EventListFragment.myOnClickListener);

            MyViewHolder myViewHolder = new MyViewHolder(view);

            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

     /*       CardView cardViewForClick = holder.cardView;
            TextView textViewEventName = holder.textViewEventName;
            TextView textViewCompUsrNameTv = holder.textViewCompUsrNameTv;
            TextView textViewCompName = holder.textViewCompNameTv;
            TextView textViewLocationn = holder.textViewLocation;
            TextView textViewDate = holder.textViewDate;
            TextView textViewSerial = holder.textViewSerial;

            Log.v("ListPosition", String.valueOf(listPosition));


            textViewEventName.setText(ClientListActivity.mEventJsonList.get(listPosition).getString(P.name));
            textViewCompUsrNameTv.setText(ClientListActivity.mEventJsonList.get(listPosition).getString(P.company_username));
            textViewCompName.setText(ClientListActivity.mEventJsonList.get(listPosition).getString(P.companyname));
            textViewLocationn.setText(ClientListActivity.mEventJsonList.get(listPosition).getString(P.location) + " " + ClientListActivity.mEventJsonList.get(listPosition).getString(P.city_name));
            textViewDate.setText(ClientListActivity.mEventJsonList.get(listPosition).getString(P.event_from_date) + "-" + ClientListActivity.mEventJsonList.get(listPosition).getString(P.event_to_date));
            if (listPosition < 9)
                textViewSerial.setText("0" + (listPosition + 1));
            else
                textViewSerial.setText(listPosition + 1 + "");



            cardViewForClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                *//*if (((ClientListActivity) context).eventDescFragment == null) {
                    ((ClientListActivity) context).eventDescFragment = EventDescFragment.newInstance();
                }*//*


                    //context.startActivity(new Intent(context, EventDescriptionActivity.class));
                    //((ClientListActivity) context).fragmentLoader(((ClientListActivity) context).eventDescFragment, "event description");

                }
            });
*/
        }

        @Override
        public int getItemCount() {
            return 10;
        }
        // Filter Method

    }
}
