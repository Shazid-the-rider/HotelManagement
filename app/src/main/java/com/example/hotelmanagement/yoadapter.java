package com.example.hotelmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class yoadapter extends RecyclerView.Adapter<yoadapter.myviewholder> {

    private Context context;
    private ArrayList<String> usersWithProducts;

    public yoadapter(Context context, ArrayList<String> usersWithProducts) {
        this.context = context;
        this.usersWithProducts = usersWithProducts;
    }

    @NonNull
    @Override
    public yoadapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.emni, parent, false);
        return new yoadapter.myviewholder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull yoadapter.myviewholder holder, int position) {
        String userWithProduct = usersWithProducts.get(position);
        // Split the string to extract username and product separately
        String[] parts = userWithProduct.split(": ");
        if (parts.length == 4) {
            holder.usernameTextView.setText(parts[0]);
            holder.productTextView.setText(parts[1]);
            holder.pricedetails.setText(parts[2] + " $");
            holder.producttype.setText(parts[3]);
        }
    }

    @Override
    public int getItemCount() {
        return usersWithProducts.size();
    }

    static class myviewholder extends RecyclerView.ViewHolder {
        TextView usernameTextView, productTextView, pricedetails, producttype;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            usernameTextView = itemView.findViewById(R.id.textview1);
            productTextView = itemView.findViewById(R.id.textview2);
            pricedetails = itemView.findViewById(R.id.textview3);
            producttype = itemView.findViewById(R.id.textview4);
        }
    }
}

