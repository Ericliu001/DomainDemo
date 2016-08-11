package com.example.ericliu.domaindemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.ericliu.domaindemo.R;
import com.example.ericliu.domaindemo.adapter.PropertyListAdapter;
import com.example.ericliu.domaindemo.util.CacheFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private PropertyListAdapter mAdapter;
    private PropertyListPresenter mPropertyListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            mPropertyListPresenter = new PropertyListPresenterImpl();
            mPropertyListPresenter.onViewCreated(false);
            CacheFragment<PropertyListPresenter> cacheFragment = new CacheFragment<>();
            getFragmentManager().beginTransaction().add(cacheFragment, TAG).commit();
        } else {
            CacheFragment<PropertyListPresenter> cacheFragment;
            cacheFragment = (CacheFragment<PropertyListPresenter>) getFragmentManager().findFragmentByTag(TAG);
            mPropertyListPresenter = cacheFragment.getData();
            mPropertyListPresenter.onViewCreated(true);
        }

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


        mAdapter = new PropertyListAdapter(mPropertyListPresenter);
        mRecyclerView.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

    }

    @Override
    protected void onDestroy() {
        mPropertyListPresenter.onViewDestroyed();
        super.onDestroy();
    }
}
