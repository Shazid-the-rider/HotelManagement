package com.example.hotelmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class touradapteR extends RecyclerView.Adapter<touradapteR.myviewholder> {

    Context context;
    ArrayList<Float> price;
    ArrayList<String> Order_Type;

    public touradapteR(Context context, ArrayList<Float> price, ArrayList<String> Order_Type) {
        this.context = context;
        this.price = price;
        this.Order_Type = Order_Type;

    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cannn, viewGroup, false);

        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        String x = price.get(position).toString();
        holder.Order.setText(x + " $");
        holder.Price.setText(Order_Type.get(position));
    }

    @Override
    public int getItemCount() {
        return Order_Type.toArray().length;
    }

    class myviewholder extends RecyclerView.ViewHolder {
        TextView Product, Price, Order;

        public myviewholder(@NonNull View itemView) {

            super(itemView);
            Price = itemView.findViewById(R.id.textview2);
            Order = itemView.findViewById(R.id.textview3);
        }
    }
}
