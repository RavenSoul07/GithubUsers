package com.ravensoul.githubusers.di;

import com.ravensoul.githubusers.view.MainActivity;
import com.ravensoul.githubusers.view.UserInfoActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    AllUsersComponent.Builder allUsersBuilder();

    SingleUserComponent.Builder singleUserBuilder();

}
