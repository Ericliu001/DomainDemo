package com.example.ericliu.domaindemo.ui;

import android.app.Activity;
import android.net.Uri;
import android.view.View;

import com.example.ericliu.domaindemo.R;
import com.example.ericliu.domaindemo.customview.PhotoViewPager;
import com.example.ericliu.domaindemo.model.Property;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericliu on 11/08/2016.
 */
public class EliteViewHolder extends PropertyListViewHolder {

    private PhotoViewPager mPhotoViewPager;


    public EliteViewHolder(View itemView) {
        super(itemView);

        mPhotoViewPager = (PhotoViewPager) itemView.findViewById(R.id.imageViewPager);
    }

    @Override
    void displayImages(Property p, Activity activity) {


        List<Uri> imageUris = new ArrayList<>(p.getImageUrls().size());
        if (p.getRetinaDisplayThumbUrl() != null) {
            imageUris.add(Uri.parse(p.getRetinaDisplayThumbUrl()));
        }

        if (p.getSecondRetinaDisplayThumbUrl() != null) {
            imageUris.add(Uri.parse(p.getSecondRetinaDisplayThumbUrl()));
        }

        mPhotoViewPager.populateImages(imageUris, activity.getFragmentManager());
    }


}
