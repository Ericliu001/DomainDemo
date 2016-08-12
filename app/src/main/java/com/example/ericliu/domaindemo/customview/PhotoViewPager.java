package com.example.ericliu.domaindemo.customview;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * TODO: document your custom view class.
 */
public class PhotoViewPager extends ViewPager {


    private Context mContext;


    private List<Uri> mUriList;
    private Adapter mAdapter;

    public PhotoViewPager(Context context) {
        super(context);
        init(context);
    }

    public PhotoViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    private void init(Context context) {

        mContext = context;
    }


    public void populateImages(List<Uri> uriList, FragmentManager fm) {
        mUriList = uriList;
        mAdapter = new Adapter(fm);
        this.setAdapter(mAdapter);
    }

    public class Adapter extends FragmentStatePagerAdapter {

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ImageFragment.newInstance(mUriList.get(position));
        }

        @Override
        public int getCount() {
            return mUriList.size();
        }

        @Override
        public float getPageWidth(int position) {
            return 0.75f;
        }
    }

    public static class ImageFragment extends Fragment{


        private static final String ARG_IMAGE_URL = "args.image.url";

        public ImageFragment() {
        }

        public static Fragment newInstance(Uri url) {
            Fragment fragment = new ImageFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(ARG_IMAGE_URL, url);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            ImageView ivPhoto = new ImageView(getActivity());
            Bundle bundle = getArguments();
            Uri imageUrl = bundle.getParcelable(ARG_IMAGE_URL);

            Picasso.with(getActivity()).load(imageUrl).into(ivPhoto);

            return ivPhoto;
        }
    }
}
