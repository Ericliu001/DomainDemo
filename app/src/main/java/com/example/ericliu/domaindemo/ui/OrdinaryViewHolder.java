package com.example.ericliu.domaindemo.ui;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.example.ericliu.domaindemo.R;
import com.example.ericliu.domaindemo.model.Property;
import com.squareup.picasso.Picasso;

/**
 * Created by ericliu on 11/08/2016.
 */
public class OrdinaryViewHolder extends PropertyListViewHolder {
    private ImageView ivPhoto;

    public OrdinaryViewHolder(View itemView) {
        super(itemView);
        ivPhoto = (ImageView) itemView.findViewById(R.id.ivPhoto);

    }

    @Override
    void displayImages(Property p, Activity activity) {
        if (p.getRetinaDisplayThumbUrl() != null) {
            Uri imageUrl = Uri.parse(p.getRetinaDisplayThumbUrl());
            Picasso.with(activity).load(imageUrl).into(ivPhoto);
        }

    }


}
