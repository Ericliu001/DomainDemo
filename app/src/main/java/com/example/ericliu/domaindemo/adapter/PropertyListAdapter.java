package com.example.ericliu.domaindemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ericliu.domaindemo.R;
import com.example.ericliu.domaindemo.ui.EliteViewHolder;
import com.example.ericliu.domaindemo.ui.OrdinaryViewHolder;
import com.example.ericliu.domaindemo.ui.PropertyListPresenter;

/**
 * Created by eric.liu on 27/05/15.
 */

public class PropertyListAdapter extends RecyclerView.Adapter {

    public enum ViewType {
        ELITE, ORDINARY

    }

    private final PropertyListPresenter mPresenter;


    public PropertyListAdapter(PropertyListPresenter presenter) {

        this.mPresenter = presenter;
    }


    @Override
    public int getItemViewType(int position) {
        return mPresenter.getItemViewType(position).ordinal();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        RecyclerView.ViewHolder holder = null;

        if (viewType == ViewType.ELITE.ordinal()) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_elite_layout, parent, false);
            holder = new EliteViewHolder(itemView);
        } else if (viewType == ViewType.ORDINARY.ordinal()) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ordinary_layout, parent, false);
            holder = new OrdinaryViewHolder(itemView);
        }


        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (mPresenter.getItemViewType(position) == ViewType.ELITE) {
            mPresenter.onBindViewHolder((EliteViewHolder) holder, position);
        } else if (mPresenter.getItemViewType(position) == ViewType.ORDINARY) {
            mPresenter.onBindViewHolder((OrdinaryViewHolder) holder, position);
        }
    }

    @Override
    public int getItemCount() {
        return mPresenter.getItemCount();
    }
}