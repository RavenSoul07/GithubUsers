package com.ravensoul.githubusers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ravensoul.githubusers.di.AppComponent;
import com.ravensoul.githubusers.di.AppModule;
import com.ravensoul.githubusers.di.DaggerAppComponent;

public class BaseApp extends AppCompatActivity {

    AppComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
    }

    public AppComponent getComponent() {
        return mComponent;
    }
}
