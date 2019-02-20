package com.ravensoul.githubusers.di;

import com.ravensoul.githubusers.Api;
import com.ravensoul.githubusers.core.SingleUserInteractor;
import com.ravensoul.githubusers.core.SingleUserPresenter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class SingleUserModule {

    @Provides
    Api provideApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

    @Provides
    SingleUserInteractor provideSingleUserInteractor(Api api) {
        return new SingleUserInteractor(api);
    }

    @Provides
    SingleUserPresenter provideSingleUserPresenter(SingleUserInteractor singleUserInteractor) {
        return new SingleUserPresenter(singleUserInteractor);
    }
}
