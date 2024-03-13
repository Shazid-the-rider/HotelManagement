package com.example.hotelmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class flightadapter extends BaseAdapter {
    String[] Times;
    String[] Flights;
    Context context;
    private LayoutInflater inflater;

    flightadapter(Context context, String[] Flights, String[] Times) {
        this.context = context;
        this.Flights = Flights;
        this.Times = Times;

    }

    @Override
    public int getCount() {
        return Flights.length;
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
        text.setText(Flights[position]);
        text1.setText(Times[position]);
        return convertView;
    }
}
