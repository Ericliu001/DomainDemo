package com.example.ericliu.domaindemo.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ericliu.domaindemo.model.Property;

/**
 * Created by ericliu on 11/08/2016.
 */
public class OrdinaryViewHolder extends RecyclerView.ViewHolder {
    protected Property mProperty;


    public OrdinaryViewHolder(View itemView) {
        super(itemView);

    }


    public void setItemData(Property p) {
        this.mProperty = p;

    }


}
