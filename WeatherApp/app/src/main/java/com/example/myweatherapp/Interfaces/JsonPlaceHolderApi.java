package com.example.myweatherapp.Interfaces;

import com.example.myweatherapp.Model.Future;
//import com.example.myweatherapp.Models.Post;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

//    @GET("{search}")
//    Call<Post> getPosts(
//            @Path("search") String search,
//            @Query("q") String city,
//            @Query("AppID") String appID
//    );

    @GET("{search}")
    Call<Future> getFuture(
            @Path("search") String search,
            @Query("units") String units,
            @Query("q") String city,
            @Query("cnt") int cnt,
            @Query("AppID") String appID
    );

}
