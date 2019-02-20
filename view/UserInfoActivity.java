package com.ravensoul.githubusers.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.ravensoul.githubusers.BaseApp;
import com.ravensoul.githubusers.R;
import com.ravensoul.githubusers.core.SingleUserPresenter;
import com.ravensoul.githubusers.model.UserData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class UserInfoActivity extends BaseApp implements UserView.SingleUserView {

    @Inject
    SingleUserPresenter mSingleUserPresenter;

    private static final String TAG = "UserInfoActivity";
    private TextView loginT, nameT, companyT, blogT, locationT, hireableT;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);
        loginT = findViewById(R.id.login);
        nameT = findViewById(R.id.name);
        companyT = findViewById(R.id.company);
        blogT = findViewById(R.id.blog);
        locationT = findViewById(R.id.location);
        hireableT = findViewById(R.id.hireable);
        image = findViewById(R.id.avatar2);

        getComponent().singleUserBuilder().build().inject(this);
        mSingleUserPresenter.setSingleUserView(this);

        Intent in = getIntent();

        Bundle b = in.getExtras();

        String t = (String) b.get("login");

        mSingleUserPresenter.getSingleUser(t);
    }

    @Override
    public void onGetDataSingleSuccess(UserData userData) {
        if (userData != null) {
            loginT.setText("Login: " + userData.getLogin());
            nameT.setText("Name: " + userData.getName());
            companyT.setText("Company: " + userData.getCompany());
            blogT.setText("Blog: " + userData.getBlog());
            locationT.setText("Location: " + userData.getLocation());
            hireableT.setText("Followers: " + userData.getFollowers() + " Following: " + userData.getFollowing());
            Picasso.get().load(userData.getAvatarUrl())
                    .error(R.drawable.placeholder)
                    .placeholder(R.drawable.placeholder)
                    .into(image);
        }
    }

    @Override
    public void onGetDataFailure(String message) {
        Log.d(TAG, "onGetDataFailure: " + message);
    }
}
