package com.example.mymovieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymovieapp.Adapters.RunningMovieAdapter;
import com.example.mymovieapp.DataModels.RunningMovies;
import com.example.mymovieapp.Interfaces.RunningJsonPlaceHolderApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements RunningMovieAdapter.CardListener {

    RecyclerView mRecyclerView;
    RunningMovieAdapter mAdapter;
    RunningJsonPlaceHolderApi runningJsonPlaceHolderApi;
    RunningMovies runningMovies;
    private final String baseURL = "https://api.themoviedb.org/3/movie/",
                         api_key ="55957fcf3ba81b137f8fc01ac5a31fb5";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        runningJsonPlaceHolderApi = retrofit.create(RunningJsonPlaceHolderApi.class);

        Call<RunningMovies> call = runningJsonPlaceHolderApi.getRunningMovies("now_playing",
                api_key, "en-US", "undefined");

        call.enqueue(new Callback<RunningMovies>() {
            @Override
            public void onResponse(Call<RunningMovies> call, Response<RunningMovies> response) {
                if (!response.isSuccessful()) {
                    Log.e("TAG", "onResponse: " );

                    Toast.makeText(MainActivity.this, "something happened", Toast.LENGTH_LONG);
                    return;
                }

                runningMovies = response.body();

                // Create recycler view.
                mRecyclerView = findViewById(R.id.runningRecyclerView);
                // Create an adapter and supply the data to be displayed.
                mAdapter = new RunningMovieAdapter(MainActivity.this,
                        runningMovies.getResults(),
                        MainActivity.this::onClick);
                // Connect the adapter with the recycler view.
                mRecyclerView.setAdapter(mAdapter);
                // Give the recycler view a default layout manager.
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL));


            }

            @Override
            public void onFailure(Call<RunningMovies> call, Throwable t) {
                Log.e("tage", "onFailure: ");
            }
        });
    }

    @Override
    public void onClick(int position) {

        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra("clickedMovie", runningMovies.getResults().get(position));
        startActivity(intent);

    }
}