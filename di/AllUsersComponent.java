package com.ravensoul.githubusers.di;

import com.ravensoul.githubusers.AllUsersScope;
import com.ravensoul.githubusers.view.MainActivity;

import dagger.Subcomponent;

@AllUsersScope
@Subcomponent(modules = AllUsersModule.class)
public interface AllUsersComponent {


    @Subcomponent.Builder
    interface Builder {
        Builder allUsersComponent(AllUsersModule module);
        AllUsersComponent build();
    }

    public void inject(MainActivity activity);

}
