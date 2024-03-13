package com.example.hotelmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {

    Context context;
    ArrayList<String> product_name;
    ArrayList<Float> price;
    ArrayList<String> Order_Type;

    public myadapter(Context context, ArrayList<String> product_name, ArrayList<Float> price, ArrayList<String> Order_Type) {
        this.context = context;
        this.product_name = product_name;
        this.price = price;
        this.Order_Type = Order_Type;

    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cartsample2, viewGroup, false);

        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.Product.setText(product_name.get(position));
        holder.Order.setText(Order_Type.get(position));
        String x = price.get(position).toString();
        holder.Price.setText(x + " $");
    }

    @Override
    public int getItemCount() {
        return Order_Type.toArray().length;
    }

    class myviewholder extends RecyclerView.ViewHolder {
        TextView Product, Price, Order;

        public myviewholder(@NonNull View itemView) {

            super(itemView);
            Product = itemView.findViewById(R.id.textview1);
            Price = itemView.findViewById(R.id.textview2);
            Order = itemView.findViewById(R.id.textview3);
        }
    }
}
