package com.ravensoul.githubusers.core;

import android.util.Log;

import com.google.gson.Gson;
import com.ravensoul.githubusers.Api;
import com.ravensoul.githubusers.model.UserData;
import com.ravensoul.githubusers.view.UserView;


import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class AllUsersInteractor implements UserView.AllUsersInteractor {

    private Api mApi;

    public AllUsersInteractor(Api api) {
        this.mApi = api;
    }

    @Override
    public void GetAllUsersFormGitHub(final UserView.onGetDataAllListener listener) {
        mApi.getAllUsers("7f90517464e60ad0b8ad", "81107f50141f721d575404ccbe39920d7c65971f")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends List<UserData>>>() {
                    @Override
                    public ObservableSource<? extends List<UserData>> apply(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Consumer<List<UserData>>() {
                    @Override
                    public void accept(List<UserData> list) {
                        Log.d("ALL USERS:", new Gson().toJson(list));
                        listener.onSuccessForAllUsers(list);
                    }
                }).isDisposed();
    }
}
