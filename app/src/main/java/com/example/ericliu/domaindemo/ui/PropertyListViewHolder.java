package com.example.ericliu.domaindemo.ui;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ericliu.domaindemo.R;
import com.example.ericliu.domaindemo.model.Property;

/**
 * Created by ericliu on 12/08/2016.
 */

public abstract class PropertyListViewHolder extends RecyclerView.ViewHolder {
    protected TextView tvDisplayPrice, tvRoomNumber, tvAddress;

    public PropertyListViewHolder(View itemView) {
        super(itemView);
        tvDisplayPrice = (TextView) itemView.findViewById(R.id.tvDisplayPrice);
        tvRoomNumber = (TextView) itemView.findViewById(R.id.tvRoomNumber);
        tvAddress = (TextView) itemView.findViewById(R.id.tvAddress);
    }




    public void displayTexts(Property p) {

        tvDisplayPrice.setText(p.getDisplayPrice());
        StringBuilder stringBuilder = new StringBuilder();
        if (p.getBedrooms() > 0) {
            stringBuilder.append(p.getBedrooms());
            stringBuilder.append(" bed");
        }

        if (p.getBathrooms() > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(p.getBathrooms());
            stringBuilder.append(" bath");
        }

        if (p.getCarspaces() > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(p.getCarspaces());
            stringBuilder.append(" car");
        }

        tvRoomNumber.setText(stringBuilder.toString());
        tvAddress.setText(p.getDisplayableAddress());


    }

    abstract void displayImages(Property p, Activity activity);
}
