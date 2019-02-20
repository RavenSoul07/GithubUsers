package com.ravensoul.githubusers.core;

import android.util.Log;

import com.google.gson.Gson;
import com.ravensoul.githubusers.Api;
import com.ravensoul.githubusers.model.UserData;
import com.ravensoul.githubusers.view.UserView;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class SingleUserInteractor implements UserView.SingleUserInteractor {
    private Api mApi;

    public SingleUserInteractor(Api api) {
        mApi = api;
    }

    @Override
    public void GetSingleUserFormGitHub(final String username, final UserView.onGetDataSingleListener listener) {

        mApi.getUser(username, "7f90517464e60ad0b8ad", "81107f50141f721d575404ccbe39920d7c65971f")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends UserData>>() {
                    @Override
                    public ObservableSource<? extends UserData> apply(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Consumer<UserData>() {
                    @Override
                    public void accept(UserData userData) {
                        Log.d("SINGLE USER:", new Gson().toJson(userData));
                        listener.onSuccesForSingleUser(userData);
                    }
                }).isDisposed();
    }
}
