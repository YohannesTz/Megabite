package com.yohannes.app.dev.megabite;

import android.content.Context;
import android.nfc.Tag;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Arrays;

/**
 * Created by Yohannes on 27-Feb-20.
 */

public class ItemAdapter extends ArrayAdapter {

    String[] amh_items;
    String[] eng_items;

    public ItemAdapter(Context c, String[] amh_items, String[] eng_items){
        super(c,R.layout.coustom_row, R.id.serviceName, eng_items);
        this.amh_items = amh_items;
        this.eng_items = eng_items;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.coustom_row, null, false);

        TextView engTextView = (TextView) customView.findViewById(R.id.serviceName);
        TextView amhTextView = (TextView) customView.findViewById(R.id.serviceName_Amh);

        Log.e("Error", eng_items[position]);
        Log.e("Error", amh_items[position]);


        engTextView.setText(eng_items[position]);
        amhTextView.setText(amh_items[position]);

        return customView;
    }
}
