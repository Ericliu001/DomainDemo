package com.example.ericliu.domaindemo.ui;

import com.example.ericliu.domaindemo.adapter.PropertyListAdapter;
import com.example.ericliu.domaindemo.model.Property;
import com.example.ericliu.domaindemo.repository.PropertyRemoteRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericliu on 11/08/2016.
 */

public class PropertyListPresenterImpl implements PropertyListPresenter {
    private List<Property> mList;


    public PropertyListPresenterImpl() {
        mList = new ArrayList<>();
    }

    @Override
    public PropertyListAdapter.ViewType getItemViewType(int position) {
        Property property = mList.get(position);

        if (property.getIsElite() > 0) {
            return PropertyListAdapter.ViewType.ELITE;
        } else {
            return PropertyListAdapter.ViewType.ORDINARY;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onBindViewHolder(EliteViewHolder holder, int position) {
        holder.setItemData(mList.get(position));
    }

    @Override
    public void onBindViewHolder(OrdinaryViewHolder holder, int position) {

    }


    @Override
    public void onViewCreated(boolean isConfigurationChange) {
        if (!isConfigurationChange) {
            loadPropertyList();
        }
    }

    private void loadPropertyList() {
        PropertyRemoteRepo remoteRepo = new PropertyRemoteRepo();
        try {
            List<Property> propertyList = remoteRepo.query(null);
            mList = new ArrayList<>(propertyList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void setView(Object view) {
        // not used in this case as there is no user action.
    }

    @Override
    public void onViewDestroyed() {
        // don't need to do anything here as the presenter is not holding references of the Activity in this case.
    }
}
