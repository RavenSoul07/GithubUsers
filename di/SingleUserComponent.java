package com.ravensoul.githubusers.di;

import com.ravensoul.githubusers.SingleUserScope;
import com.ravensoul.githubusers.view.UserInfoActivity;

import dagger.Subcomponent;

@SingleUserScope
@Subcomponent(modules = SingleUserModule.class)
public interface SingleUserComponent {

    @Subcomponent.Builder
    interface Builder {
        Builder singleUserComponent(SingleUserModule module);
        SingleUserComponent build();
    }

    void inject(UserInfoActivity activity);
}
