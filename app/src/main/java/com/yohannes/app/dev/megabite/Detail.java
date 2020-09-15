package com.yohannes.app.dev.megabite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Detail extends AppCompatActivity {

    private Service service;
    private ListView serviceDetailList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        service = (Service) getIntent().getSerializableExtra("service");

        serviceDetailList = (ListView) findViewById(R.id.service_detail_list);
        if(service.getService_detail() != null) {
            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.basic_row, service.getService_detail());
            serviceDetailList.setAdapter(listAdapter);
        }

        //setting up back arrow to go back
        Toolbar toolbar = (Toolbar) findViewById(R.id.activityToolbar);
        toolbar.setTitle(service.getAmh_name());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

 /*   @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = (Service) getIntent().getSerializableExtra("service");

        RelativeLayout detailLayout = new RelativeLayout(this);

        //setting toolbar
        Toolbar toolbar = new Toolbar(this);
        toolbar.setTitle(service.getAmh_name());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Setup ListView if service_detail is not null
        if(service.getService_detail() != null){
            ListView serviceDetailList = new ListView(this);
            ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, service.getService_detail());
            serviceDetailList.setAdapter(listAdapter);
            detailLayout.addView(toolbar);
            detailLayout.addView(serviceDetailList);
        }else{
            TextView textView = new TextView(this);
            textView.setText("Hello world simple activity");
            detailLayout.addView(toolbar);
            detailLayout.addView(textView);
        }

        setContentView(detailLayout);
    }*/

    //return from the current activity
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
