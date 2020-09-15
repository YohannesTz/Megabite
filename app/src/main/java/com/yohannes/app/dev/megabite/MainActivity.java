package com.yohannes.app.dev.megabite;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Resources localobject = getResources();
        String[] english = localobject.getStringArray(R.array.services_eng);
        String[] amharic = localobject.getStringArray(R.array.services_amh);
        String[][] service_detail = {
                localobject.getStringArray(R.array.daily_services),
                localobject.getStringArray(R.array.weekly_service),
                localobject.getStringArray(R.array.monthly_service),
                localobject.getStringArray(R.array.night_service),
                localobject.getStringArray(R.array.daily_vservice),
                localobject.getStringArray(R.array.weekly_vservice),
                localobject.getStringArray(R.array.monthly_vservice),
                localobject.getStringArray(R.array.night_vservice),
        };


        ListView listView = (ListView) findViewById(R.id.service_List);
        //ItemAdapter listAdapter = new ItemAdapter(this, amharic, english);
        final Service[] services = {
                new Service(english[0], amharic[0], service_detail[0]),//Daily
                new Service(english[1], amharic[1], service_detail[1]),//Weekly
                new Service(english[2], amharic[2], service_detail[2]),//Month
                new Service(english[3], amharic[3], service_detail[3]),//N/
                new Service(english[4], amharic[4], service_detail[4]),//daily
                new Service(english[5], amharic[5], service_detail[5]),//weekly
                new Service(english[6], amharic[6], service_detail[6]),//monthly
                new Service(english[7], amharic[7], service_detail[7]),//night
        };

        ServiceAdapter listAdapter = new ServiceAdapter(this, services);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detailActivity = new Intent(getApplicationContext(), Detail.class);
                detailActivity.putExtra("service", services[position]);
                MainActivity.this.startActivity(detailActivity);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.nav_about){
            MainActivity.this.startActivity(new Intent(getApplicationContext(), About.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
