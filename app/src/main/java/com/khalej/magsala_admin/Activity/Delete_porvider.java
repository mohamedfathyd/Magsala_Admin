package com.khalej.magsala_admin.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.khalej.magsala_admin.Adapter.RecyclerAdapter_providersdelete;
import com.khalej.magsala_admin.Model.Apiclient_home;
import com.khalej.magsala_admin.Model.apiinterface_home;
import com.khalej.magsala_admin.Model.user_content;
import com.khalej.magsala_admin.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Delete_porvider extends AppCompatActivity {
    Toolbar toolbar;
    ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter_providersdelete recyclerAdapter_secondry;
    private List<user_content> contactList;
    private apiinterface_home apiinterface;
    int id = 0;
    String name;
    int sec_id;
    Typeface myTypeface;
    Intent intent;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_porvider);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_subject);
        textView = (TextView) findViewById(R.id.toolbar_title);
//        progressBar.setVisibility(View.VISIBLE);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        intent = getIntent();

        this.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_black_24dp);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );

        recyclerView = (RecyclerView) findViewById(R.id.review);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_subject);
        progressBar.setVisibility(View.VISIBLE);
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        fetchInfo();
    }

    public void fetchInfo() {
        apiinterface = Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<List<user_content>> call = apiinterface.getcontacts_provider_acc();
        call.enqueue(new Callback<List<user_content>>() {
            @Override
            public void onResponse(Call<List<user_content>> call, Response<List<user_content>> response) {
                contactList = response.body();
                progressBar.setVisibility(View.GONE);
                recyclerAdapter_secondry = new RecyclerAdapter_providersdelete(Delete_porvider.this, contactList);
                recyclerView.setAdapter(recyclerAdapter_secondry);


            }

            @Override
            public void onFailure(Call<List<user_content>> call, Throwable t) {

            }
        });
    }
}