package com.ravensoul.githubusers.core;

import com.ravensoul.githubusers.model.UserData;
import com.ravensoul.githubusers.view.UserView;

public class SingleUserPresenter implements UserView.SingleUserPresenter, UserView.onGetDataSingleListener {

    private UserView.SingleUserView mSingleUserView;
    private SingleUserInteractor mSingleUserInteractor;

    public SingleUserPresenter(SingleUserInteractor singleUserInteractor) {
        mSingleUserInteractor = singleUserInteractor;
    }

    public void setSingleUserView(UserView.SingleUserView singleUserView){
        this.mSingleUserView = singleUserView;
    }

    @Override
    public void getSingleUser(String login) {
        mSingleUserInteractor.GetSingleUserFormGitHub(login, this);
    }

    @Override
    public void onSuccesForSingleUser(UserData userData) {
        mSingleUserView.onGetDataSingleSuccess(userData);
    }

    @Override
    public void onFailure(String message) {
        mSingleUserView.onGetDataFailure(message);
    }
}
