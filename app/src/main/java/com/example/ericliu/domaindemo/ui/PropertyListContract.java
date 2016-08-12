package com.example.ericliu.domaindemo.ui;

import android.app.Activity;

import com.example.ericliu.domaindemo.adapter.PropertyListAdapter;
import com.example.ericliu.domaindemo.mvp.DisplayView;
import com.example.ericliu.domaindemo.mvp.Presenter;

/**
 * Created by ericliu on 12/08/2016.
 */

public interface PropertyListContract {

    interface PropertyListView extends DisplayView<PropertyListPresenter> {
        void notifyDataSetChanged();
    }


    /**
     * Created by ericliu on 11/08/2016.
     */
    interface PropertyListPresenter extends Presenter<PropertyListView> {
        PropertyListAdapter.ViewType getItemViewType(int position);

        int getItemCount();

        void onBindViewHolder(EliteViewHolder holder, int position);

        void onBindViewHolder(OrdinaryViewHolder holder, int position);
    }


    public class StubView implements PropertyListView{

        @Override
        public Activity activity() {
            return null;
        }

        @Override
        public void notifyDataSetChanged() {

        }
    }
}
