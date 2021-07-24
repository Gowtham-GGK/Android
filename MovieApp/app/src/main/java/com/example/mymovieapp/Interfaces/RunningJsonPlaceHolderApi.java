package com.example.mymovieapp.Interfaces;

import com.example.mymovieapp.DataModels.RunningMovies;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RunningJsonPlaceHolderApi {

    @POST("{search}")
    Call<RunningMovies> getRunningMovies(
            @Path("search") String search,
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("page") String page
    );
}
