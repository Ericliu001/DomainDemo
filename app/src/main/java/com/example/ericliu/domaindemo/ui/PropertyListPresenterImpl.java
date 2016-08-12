package com.example.ericliu.domaindemo.ui;

import com.example.ericliu.domaindemo.adapter.PropertyListAdapter;
import com.example.ericliu.domaindemo.model.Property;
import com.example.ericliu.domaindemo.repository.PropertyRemoteRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ericliu on 11/08/2016.
 */

public class PropertyListPresenterImpl implements PropertyListContract.PropertyListPresenter {
    private List<Property> mList;
    private PropertyListContract.PropertyListView mDisplayView;
    private Subscription mPropertyListResultSubscripton;


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
        holder.displayImages(mList.get(position), mDisplayView.activity());
    }


    @Override
    public void onViewCreated(PropertyListContract.PropertyListView displayView, boolean isConfigurationChange) {
        mDisplayView = displayView;
        if (!isConfigurationChange) {
            loadPropertyList();
        }
    }

    private void loadPropertyList() {

        Single<List<Property>> weatherResultSingle = Single.fromCallable(new Callable<List<Property>>() {
            @Override
            public List<Property> call() throws Exception {
                final PropertyRemoteRepo remoteRepo = new PropertyRemoteRepo();
                return remoteRepo.query(null);
            }
        });

        mPropertyListResultSubscripton = weatherResultSingle
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<List<Property>>() {
                    @Override
                    public void onSuccess(List<Property> value) {
                        mList = new ArrayList<Property>(value);
                        mDisplayView.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable error) {

                    }
                });
    }





    @Override
    public void onViewDestroyed() {
        mDisplayView = new PropertyListContract.StubView();
        if (mPropertyListResultSubscripton != null && !mPropertyListResultSubscripton.isUnsubscribed()) {
            mPropertyListResultSubscripton.unsubscribe();
        }
    }
}
