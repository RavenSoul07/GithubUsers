package com.ravensoul.githubusers.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ravensoul.githubusers.BaseApp;
import com.ravensoul.githubusers.R;
import com.ravensoul.githubusers.adapter.ListAdapter;
import com.ravensoul.githubusers.core.AllUsersPresenter;
import com.ravensoul.githubusers.model.UserData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseApp implements UserView.AllUserseView {

    @Inject
    AllUsersPresenter mPresenter;
    private static final String TAG = "MainActivity";
    private RecyclerView mRecyclerView;
    private ListAdapter mListAdapter;
    private List<UserData> mDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getComponent().allUsersBuilder().build().inject(this);
        mPresenter.setAllUserseView(this);
        initViews();
    }

    public void initViews(){
        mRecyclerView = findViewById(R.id.recycler);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadData();

    }

    public void loadData(){
        mListAdapter = new ListAdapter(mDataList, MainActivity.this);
        mRecyclerView.setAdapter(mListAdapter);
        mDataList.clear();
        mListAdapter.loadNewData(mDataList);
        mPresenter.getAllUsers();
    }

    @Override
    public void onGetDataSuccess(List<UserData> list) {
        Log.d(TAG, "onGetDataSuccess: " + list);
        mListAdapter.loadNewData(list);
    }

    @Override
    public void onGetDataFailure(String message) {
        Log.d(TAG, "onGetDataFailure: " + message);
    }

}
