package com.life.unicore.activities;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;

import android.content.Intent;
import android.graphics.fonts.FontFamily;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.life.unicore.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManualSelectLocationActivity extends AppCompatActivity {

    Toolbar toolbar;
    List<String> names=new ArrayList<>();
    Context context;
    RecyclerView loactionRecyclerView;
    LinearLayoutManager linearLayoutManager;
    private RecyclerAdapter recyclerAdapter;
    RelativeLayout currenntLoclay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_select_location);
        context=ManualSelectLocationActivity.this;
        getWindow().setStatusBarColor(getResources().getColor(R.color.walktitle));
        toolbar= findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back_white);
        toolbar.setTitle("Select your city");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        currenntLoclay=(RelativeLayout)findViewById(R.id.currentLocLayout);
        currenntLoclay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ManualSelectLocationActivity.this,LoginScreen.class);
                startActivity(i);
            }
        });
        loactionRecyclerView=(RecyclerView)findViewById(R.id.locRecyclerView);
        linearLayoutManager=new LinearLayoutManager(this);
        loactionRecyclerView.setLayoutManager(linearLayoutManager);
        loactionRecyclerView.setHasFixedSize(true);


        names= Arrays.asList(getResources().getStringArray(R.array.locationlist));
        recyclerAdapter=new RecyclerAdapter(names);
        loactionRecyclerView.setAdapter(recyclerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        MenuItem searchItem=menu.findItem(R.id.searchh);
        SearchView searchView=(SearchView)searchItem.getActionView();
        searchView.setQueryHint("Search any city or locality");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String userInput=newText.toLowerCase();
                List<String> newList=new ArrayList<>();
                for(String name:names)
                {
                    if(name.toLowerCase().contains(userInput))
                    {
                        newList.add(name);
                    }
                }
                recyclerAdapter.updateList(newList);

                return true;
            }
        });
        return true;
    }

    public void onBack(View view) {
        onBackPressed();
    }

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>
    {
        private List<String> names;

        public RecyclerAdapter(List<String> names)
        {
            this.names=names;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            TextView  textView = (TextView)LayoutInflater.from(parent.getContext()).inflate(R.layout.textview_layout, parent, false);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(ManualSelectLocationActivity.this,LoginScreen.class);
                    startActivity(i);
                }
            });
            return new MyViewHolder(textView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            holder.Name.setText(names.get(position));
        }

        @Override
        public int getItemCount() {
            return names.size();
        }

        public  class MyViewHolder extends RecyclerView.ViewHolder
        {
            TextView Name;
            public MyViewHolder(TextView itemView) {
                super(itemView);
                Name=itemView;
            }
        }
        public  void updateList(List<String> newList)
        {
            names=new ArrayList<>();
            names.addAll(newList);
            notifyDataSetChanged();
        }

    }

}
