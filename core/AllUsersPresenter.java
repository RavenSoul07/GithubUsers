package com.ravensoul.githubusers.core;

import com.ravensoul.githubusers.model.UserData;
import com.ravensoul.githubusers.view.UserView;

import java.util.List;

public class AllUsersPresenter implements UserView.AllUsersPresenter, UserView.onGetDataAllListener {

    private UserView.AllUserseView mAllUserseView;
    private AllUsersInteractor mAllUsersInteractor;

    public AllUsersPresenter(AllUsersInteractor allUsersInteractor) {
        mAllUsersInteractor = allUsersInteractor;
    }

    public void setAllUserseView(UserView.AllUserseView allUserseView) {
        this.mAllUserseView = allUserseView;
    }

    @Override
    public void getAllUsers() {
        mAllUsersInteractor.GetAllUsersFormGitHub(this);
    }

    @Override
    public void onSuccessForAllUsers(List<UserData> list) {
        mAllUserseView.onGetDataSuccess(list);
    }

    @Override
    public void onFailure(String message) {
        mAllUserseView.onGetDataFailure(message);
    }
}
