package com.example.ericliu.domaindemo.ui;

import com.example.ericliu.domaindemo.adapter.PropertyListAdapter;
import com.example.ericliu.domaindemo.model.Property;
import com.example.ericliu.domaindemo.repository.PropertyRemoteRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericliu on 11/08/2016.
 */

public class PropertyListPresenterImpl implements PropertyListContract.PropertyListPresenter {
    private List<Property> mList;
    private PropertyListContract.PropertyListView mDisplayView;


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
        holder.displayTexts(mList.get(position));
        holder.displayImages(mList.get(position), mDisplayView.activity());
    }

    @Override
    public void onBindViewHolder(OrdinaryViewHolder holder, int position) {
        holder.displayTexts(mList.get(position));
    }


    @Override
    public void onViewCreated(PropertyListContract.PropertyListView displayView, boolean isConfigurationChange) {
        mDisplayView = displayView;
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
    public void onViewDestroyed() {
        mDisplayView = new PropertyListContract.StubView();
    }
}
