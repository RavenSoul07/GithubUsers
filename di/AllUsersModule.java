package com.ravensoul.githubusers.di;


import com.ravensoul.githubusers.AllUsersScope;
import com.ravensoul.githubusers.Api;
import com.ravensoul.githubusers.core.AllUsersInteractor;
import com.ravensoul.githubusers.core.AllUsersPresenter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AllUsersModule {

    @Provides
    Api provideApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

    @Provides
    AllUsersInteractor provideAllUsersInteractor(Api api) {
        return new AllUsersInteractor(api);
    }

    @Provides
    AllUsersPresenter provideAllUsersPresenter(AllUsersInteractor allUsersInteractor) {
        return new AllUsersPresenter(allUsersInteractor);
    }
}
