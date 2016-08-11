package com.example.ericliu.domaindemo.ui;

import com.example.ericliu.domaindemo.adapter.PropertyListAdapter;

/**
 * Created by ericliu on 11/08/2016.
 */

public class PropertyListPresenterImpl implements PropertyListPresenter {
    @Override
    public PropertyListAdapter.ViewType getItemViewType(int position) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onBindViewHolder(EliteViewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(OrdinaryViewHolder holder, int position) {

    }

    @Override
    public void setView(Object view) {
        // not used in this case as there is no user action.
    }

    @Override
    public void onViewCreated(boolean isConfigurationChange) {

    }

    @Override
    public void onViewDestroyed() {

    }
}
