package com.example.myweatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myweatherapp.Adapters.WeatherAdapter;
import com.example.myweatherapp.Interfaces.JsonPlaceHolderApi;
import com.example.myweatherapp.Model.Future;
//import com.example.myweatherapp.Models.Post;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements WeatherAdapter.CardListener {

    private RecyclerView mRecyclerView;
    private WeatherAdapter mAdapter;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    private EditText editText;
    private TextView cityTextView,dateTextView,tempTextView,mainTextView,
            snowTextView,speedTextView,cloudsTextView,humidityTextView;
    private ImageView iconImageView;
    private String imageURL,baseURL = "http://api.openweathermap.org/data/2.5/forecast/";
    final String imageURLPre = "http://openweathermap.org/img/w/",
            imageURLPost = ".png";
    Future future;
    WeatherAdapter.CardListener cardListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.cityEditText);
        cityTextView = findViewById(R.id.cityTextView);
        dateTextView = findViewById(R.id.dateTextView);
        tempTextView = findViewById(R.id.tempTextView);
        mainTextView = findViewById((R.id.mainTextView));
        iconImageView =findViewById(R.id.iconImageView);
        snowTextView = findViewById(R.id.snowTextView);
        speedTextView = findViewById(R.id.speedTextView);
        cloudsTextView = findViewById(R.id.cloudTextView);
        humidityTextView = findViewById(R.id.humidityTextView);

        // Create recycler view.
        mRecyclerView = findViewById(R.id.recyclerView);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


    }

    public void getWeatherDetails(View view) {

        Call<Future> call = jsonPlaceHolderApi.getFuture("daily","metric",editText.getText().toString(),11,
                "ebfcac32bda131ed5a160f2757938396");

        call.enqueue(new Callback<Future>() {
            @Override
            public void onResponse(Call<Future> call, Response<Future> response) {
                if (!response.isSuccessful()) {

                    Toast.makeText(MainActivity.this,"something happened",Toast.LENGTH_LONG);
                    return;
                }

            future = response.body();
            setCard(future);

            // Create an adapter and supply the data to be displayed.
            mAdapter = new WeatherAdapter(MainActivity.this, future.getMainData(),MainActivity.this::onClick);
            // Connect the adapter with the recycler view.
            mRecyclerView.setAdapter(mAdapter);
            // Give the recycler view a default layout manager.
            mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));

        }

            @Override
            public void onFailure(Call<Future> call, Throwable t) {

                Log.d("OnCreate", "onCreate: MainActivity"+t.toString());

            }
        });
    }

    private void setCard(Future future) {

        cityTextView.setText(future.getCity().getName());
        dateTextView.setText(convertToDate(future.getMainData().get(0).getDt()));
        tempTextView.setText(""+future.getMainData().get(0).getTemp().getDay()+"°C");
        mainTextView.setText(future.getMainData().get(0).getWeather().get(0).getMain());
        imageURL = imageURLPre+future.getMainData().get(0).getWeather().get(0).getIcon()+imageURLPost;
        Picasso.get().load(imageURL).into(iconImageView);
        snowTextView.setText(""+future.getMainData().get(0).getSnow());
        speedTextView.setText(""+future.getMainData().get(0).getSpeed());
        //Log.e("error", "setCard: "+future.getMainData().get(0).getHumidity() );
        humidityTextView.setText(""+future.getMainData().get(0).getHumidity());
        cloudsTextView.setText(""+future.getMainData().get(0).getClouds());
        CardView cardView = findViewById(R.id.mainCardView);
        cardView.setVisibility(View.VISIBLE);

    }

    public CharSequence convertToDate(long dt) {
        long unix_seconds = dt;
        //convert seconds to milliseconds
        Date date = new Date(unix_seconds*1000L);
        // format of the date
        SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd");
        jdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
        CharSequence java_date = jdf.format(date);

        return java_date;
    }

    @Override
    public void onClick(int position) {

        dateTextView.setText(convertToDate(future.getMainData().get(position).getDt()));
        tempTextView.setText(""+future.getMainData().get(position).getTemp().getDay()+"°C");
        mainTextView.setText(future.getMainData().get(position).getWeather().get(0).getMain());
        imageURL = imageURLPre+future.getMainData().get(position).getWeather().get(0).getIcon()+imageURLPost;
        Picasso.get().load(imageURL).into(iconImageView);
        snowTextView.setText(""+future.getMainData().get(position).getSnow());
        speedTextView.setText(""+future.getMainData().get(position).getSpeed());
        //Log.e("error", "setCard: "+future.getMainData().get(position).getHumidity() );
        humidityTextView.setText(""+future.getMainData().get(position).getHumidity());
        cloudsTextView.setText(""+future.getMainData().get(position).getClouds());
    }
}