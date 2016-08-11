package com.example.ericliu.domaindemo.ui;

import com.example.ericliu.domaindemo.adapter.PropertyListAdapter;
import com.example.ericliu.domaindemo.mvp.Presenter;

/**
 * Created by ericliu on 11/08/2016.
 */
public interface PropertyListPresenter extends Presenter {
    PropertyListAdapter.ViewType getItemViewType(int position);

    int getItemCount();

    void onBindViewHolder(EliteViewHolder holder, int position);

    void onBindViewHolder(OrdinaryViewHolder holder, int position);
}
