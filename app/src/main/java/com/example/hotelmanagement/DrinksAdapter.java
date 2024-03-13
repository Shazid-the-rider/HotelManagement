package com.example.hotelmanagement;

import android.content.Context;
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

public class DrinksAdapter extends BaseAdapter {

    String[] drink_price;
    String[] drink_name;
    Context context;
    private LayoutInflater inflater;

    DrinksAdapter(Context context, String[] drink_price, String[] drink_name) {
        this.context = context;
        this.drink_price = drink_price;
        this.drink_name = drink_name;

    }

    @Override
    public int getCount() {
        return drink_name.length;
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
        text.setText(drink_price[position]);
        text1.setText(drink_name[position]);
        return convertView;
    }


}

