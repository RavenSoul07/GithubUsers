package com.ravensoul.githubusers;

import com.ravensoul.githubusers.model.UserData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    @GET("users?/")
    Observable<List<UserData>> getAllUsers(@Query("client_id") String client_id, @Query("client_secret") String client_secret);

    @GET("users/{username}")
    Observable<UserData> getUser(@Path("username") String login, @Query("client_id") String client_id, @Query("client_secret") String client_secret);
}
