package com.yohannes.app.dev.megabite;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by Yohannes on 02-Mar-20.
 */

public class ServiceAdapter extends ArrayAdapter {

    private Service[] services;

    public ServiceAdapter(Context c, Service[] service){
        super(c, R.layout.coustom_row, R.id.serviceName, service);
        this.services = service;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.coustom_row, null, false);

        Service service = services[position];
        TextView engTextView = (TextView) customView.findViewById(R.id.serviceName);
        TextView amhTextView = (TextView) customView.findViewById(R.id.serviceName_Amh);

        Log.e("Error", "ddddddddddddd " + service.getEng_name());
        Log.e("Error", "ddddddddddddd " + service.getAmh_name());


        engTextView.setText(service.getEng_name());
        amhTextView.setText(service.getAmh_name());

        return customView;
    }
}
