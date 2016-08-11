package com.example.ericliu.domaindemo.ui;

import android.support.v7.widget.RecyclerView;

import com.example.ericliu.domaindemo.adapter.PropertyListAdapter;

/**
 * Created by ericliu on 11/08/2016.
 */
public interface PropertyListPresenter {
    PropertyListAdapter.ViewType getItemViewType(int position);

    int getItemCount();

    void onBindViewHolder(RecyclerView.ViewHolder holder, int position);
}
