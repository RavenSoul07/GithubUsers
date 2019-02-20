package com.ravensoul.githubusers.view;

import com.ravensoul.githubusers.model.UserData;

import java.util.List;

public interface UserView {

    interface AllUserseView {
        void onGetDataSuccess(List<UserData> list);

        void onGetDataFailure(String message);
    }

    interface SingleUserView {
        void onGetDataSingleSuccess(UserData userData);

        void onGetDataFailure(String message);
    }

    interface AllUsersPresenter {
        void getAllUsers();
    }

    interface SingleUserPresenter {
        void getSingleUser(String login);
    }

    interface AllUsersInteractor {
        void GetAllUsersFormGitHub(onGetDataAllListener listener);
    }

    interface SingleUserInteractor {
        void GetSingleUserFormGitHub(String username, onGetDataSingleListener listener);
    }

    interface onGetDataAllListener {
        void onSuccessForAllUsers(List<UserData> list);

        void onFailure(String message);
    }

    interface onGetDataSingleListener {
        void onSuccesForSingleUser(UserData userData);

        void onFailure(String message);
    }
}
