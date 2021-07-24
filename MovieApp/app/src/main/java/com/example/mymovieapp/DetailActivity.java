package com.example.mymovieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mymovieapp.DataModels.Results;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView movieNameTextView,releaseTextView,voteCountTextView,overviewTextView,progressValue;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        progressBar =findViewById(R.id.progressBar);
        movieNameTextView = findViewById(R.id.movieTextView);
        releaseTextView = findViewById(R.id.releaseTextView);
        voteCountTextView = findViewById(R.id.voteCountTextView);
        //overviewTextView = findViewById(R.id.overviewTextView);
        imageView = findViewById(R.id.imageView2);
        progressValue = findViewById(R.id.progressValue);

        Results results = getIntent().getParcelableExtra("clickedMovie");
        Log.e("TAG", "onCreate: "+ results.getPoster_path());
        Picasso.get().load("https://image.tmdb.org/t/p/w780"+results.getBackdrop_path()).into(imageView);
        progressBar.setProgress((int) results.getVote_average());
        movieNameTextView.setText(""+results.getOriginal_title());
        releaseTextView.setText(""+results.getRelease_date());
        voteCountTextView.setText(""+results.getVote_count());
        //overviewTextView.setText(""+results.getOverview());
        progressValue.setText(""+results.getVote_average());

    }
}