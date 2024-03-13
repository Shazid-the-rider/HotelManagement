package com.example.hotelmanagement;

import android.content.Context;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    String[] price;
    String[] foodName;
    Context context;
    private LayoutInflater inflater;

    CustomAdapter(Context context, String[] price, String[] foodName) {
        this.context = context;
        this.price = price;
        this.foodName = foodName;

    }

    @Override
    public int getCount() {
        return foodName.length;
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
        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sample, parent, false);
        }
        TextView text = (TextView) convertView.findViewById(R.id.textview);
        TextView text1 = (TextView) convertView.findViewById(R.id.textview1);
        text.setText(price[position]);
        text1.setText(foodName[position]);
        return convertView;
    }


}

