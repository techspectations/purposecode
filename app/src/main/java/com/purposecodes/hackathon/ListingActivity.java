package com.purposecodes.hackathon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.purposecodes.hackathon.adapter.RecyclerAdapter;
import com.purposecodes.hackathon.api.ApiFailureEvent;
import com.purposecodes.hackathon.api.ApiSuccessEvent;
import com.purposecodes.hackathon.api.BusProvider;
import com.purposecodes.hackathon.api.RecyclerItemDecoration;
import com.purposecodes.hackathon.api.SearchModel;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by PURPOSE CODE on 11/12/2016.
 */

public class ListingActivity extends AppCompatActivity {

    // Widgets
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;

    // Adapter
    private RecyclerAdapter mAdapter;

    private List<SearchModel.Article> mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        BusProvider.getInstance().register(this);

        String searchTerm = getIntent().getStringExtra("term");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle(searchTerm);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        setUpRecyclerView();

        HashMap<String, String> options = new HashMap<>();
        options.put("term", searchTerm);
        options.put("size", "10");

        App.get().getSearchArticles(options);
    }

    private void setUpRecyclerView() {

        mList = new ArrayList<>();
        int spacing = getResources().getDimensionPixelSize(R.dimen.eight_dp);

        mAdapter = new RecyclerAdapter(mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new RecyclerItemDecoration(1, spacing, true));
    }

    @Subscribe
    public void onHttpSuccess(ApiSuccessEvent<SearchModel> response) {

        if (response != null) {

            mProgressBar.setVisibility(View.GONE);
            SearchModel searchModel = response.response.body();

            if (searchModel.getArticlesCount() > 0) {

                List<SearchModel.Article> list = searchModel.getArticles();
                if (list != null && list.size() > 0) {

                    mList.addAll(list);
                    mAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    @Subscribe
    public void onHttpFailure(ApiFailureEvent response) {


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        BusProvider.getInstance().unregister(this);
        super.onDestroy();
    }
}
