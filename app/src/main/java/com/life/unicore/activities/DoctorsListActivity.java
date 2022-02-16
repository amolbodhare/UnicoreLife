package com.life.unicore.activities;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.cardview.widget.CardView;
        import androidx.core.view.GravityCompat;
        import androidx.recyclerview.widget.DefaultItemAnimator;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.app.ActionBar;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
        import android.util.Log;
        import android.view.Gravity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.LinearLayout;
        import android.widget.SearchView;
        import android.widget.TextView;

        import com.facebook.shimmer.ShimmerFrameLayout;
        import com.life.unicore.R;

        import java.util.ArrayList;

public class DoctorsListActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private Context context;
    DoctorsListAdapter doctorsListAdapter;
    SearchView searchview;
    ArrayList<String> arrayList=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_list);
        getWindow().setStatusBarColor(getResources().getColor(R.color.statusbarcolor));

        context=DoctorsListActivity.this;
        recyclerView = findViewById(R.id.doctorsListRecyclerView);
        searchview=findViewById(R.id.searchView);
        doctorsListAdapter=new DoctorsListAdapter(context,arrayList);
        layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.hasFixedSize();
        recyclerView.setAdapter(doctorsListAdapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doctorsListAdapter.showShiimer=false;
                loadDummyData();
                recyclerView.hasFixedSize();
                doctorsListAdapter.notifyDataSetChanged();
            }
        },5000);

    }

    public class DoctorsListAdapter extends RecyclerView.Adapter<DoctorsListAdapter.MyViewHolder> {
        private Context context;

        ArrayList<String> list=new ArrayList<String>();
        boolean showShiimer=true;
        int NUMBER_SHIMMERS=3;

        public class MyViewHolder extends RecyclerView.ViewHolder {

            CardView cardView;
            TextView textViewEventName;
            TextView textViewCompUsrNameTv;
            TextView textViewDoctNameTv;
            TextView textViewClinicAreaTv;
            TextView textViewDate;
            TextView textViewSerial;
            ShimmerFrameLayout shimmerFrameLayout;


            public MyViewHolder(View itemView) {
                super(itemView);

                this.shimmerFrameLayout = (ShimmerFrameLayout) itemView.findViewById(R.id.shimmmerLayout);
                this.textViewDoctNameTv = (TextView) itemView.findViewById(R.id.docNameTv);
                this.textViewClinicAreaTv = (TextView) itemView.findViewById(R.id.clinicAreaTv);
                /*this.cardView = (CardView) itemView.findViewById(R.id.card_view);
                this.textViewEventName = (TextView) itemView.findViewById(R.id.eventNameTv);
                this.textViewCompUsrNameTv = (TextView) itemView.findViewById(R.id.companyUserNameTv);
                this.textViewCompNameTv = (TextView) itemView.findViewById(R.id.companyNameTv);
                this.textViewLocation = (TextView) itemView.findViewById(R.id.eventLocationTv);
                this.textViewDate = (TextView) itemView.findViewById(R.id.eventDateTv);
                this.textViewSerial = (TextView) itemView.findViewById(R.id.eventSerialTv);*/
            }
        }

        public DoctorsListAdapter(Context context,ArrayList<String> list)
        {
            this.context = context;
            this.list=list;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.doctors_list_item, parent, false);
            view.findViewById(R.id.viewProfileBtn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(DoctorsListActivity.this,ProfileActivity.class);
                    startActivity(i);
                }
            });
            //view.setOnClickListener(EventListFragment.myOnClickListener);

            MyViewHolder myViewHolder = new MyViewHolder(view);

            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
            if(showShiimer)
            {
                holder.shimmerFrameLayout.startShimmer();
                //holder.textViewCompNameTv.setBackground(null);

            }
            else
            {
                holder.shimmerFrameLayout.stopShimmer();
                holder.shimmerFrameLayout.setShimmer(null);

                //holder.textViewDoctNameTv.setBackground(null);
                holder.textViewClinicAreaTv.setBackground(null);
                holder.textViewClinicAreaTv.setText(arrayList.get(listPosition));

            }

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
            return showShiimer?NUMBER_SHIMMERS:10;
        }
        // Filter Method

    }
    public void onBack(View view) {
        onBackPressed();
    }

    private  void loadDummyData()
    {
        arrayList.add("Dr.Amit Trivedi");
        arrayList.add("Dr.Zakir Husen");
        arrayList.add("Dr.Geetaanjali Shetty");
        arrayList.add("Dr.Amit Trivedi");
        arrayList.add("Dr.Zakir Husen");
        arrayList.add("Dr.Geetaanjali Shetty");
        arrayList.add("Dr.Amit Trivedi");
        arrayList.add("Dr.Zakir Husen");
        arrayList.add("Dr.Geetaanjali Shetty");
        arrayList.add("Dr.Amit Trivedi");
        arrayList.add("Dr.Zakir Husen");
        arrayList.add("Dr.Geetaanjali Shetty");
    }
}
