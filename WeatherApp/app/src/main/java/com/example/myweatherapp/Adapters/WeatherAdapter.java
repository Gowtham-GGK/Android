package com.example.myweatherapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherapp.Model.MainData;
import com.example.myweatherapp.R;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private LayoutInflater minflater;
    private List<MainData> mainDataList;
    final String imageURLPre = "http://openweathermap.org/img/w/",
            imageURLPost = ".png";
    String imageURL;
    private CardListener cardListener;

    public WeatherAdapter(Context context,
                          List<MainData> mainDataList,CardListener cardListener) {
        this.minflater = LayoutInflater.from(context);
        this.mainDataList = mainDataList;
        this.cardListener = cardListener;

    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =minflater.inflate(R.layout.future_card,parent,false);
        return new WeatherViewHolder(v,this,cardListener);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {

        CharSequence mDate = mainDataList.get(position).convertToDate(mainDataList.get(position).getDt());
        float mTemp = mainDataList.get(position).getTemp().getDay();
        imageURL = imageURLPre+mainDataList.get(position).getWeather().get(0).getIcon()+imageURLPost;
        Picasso.get().load(imageURL).into(holder.cardImageView);
        holder.cardTempTextView.setText(""+mTemp+"°C");
        holder.cardDateTextView.setText(mDate);


    }

    @Override
    public int getItemCount() {
        return mainDataList.size();
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView cardImageView;
        private TextView cardDateTextView,cardTempTextView;
        private WeatherAdapter weatherAdapter;
        CardListener cardListener;


        public WeatherViewHolder(@NonNull View itemView,WeatherAdapter weatherAdapter,CardListener cardListener) {

            super(itemView);
            this.weatherAdapter = weatherAdapter;
            cardDateTextView = itemView.findViewById(R.id.cardDatetextView);
            cardTempTextView = itemView.findViewById(R.id.cardTempTextView);
            cardImageView = itemView.findViewById(R.id.cardIconImageView);
            this.cardListener = cardListener;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            cardListener.onClick(getAdapterPosition());
        }
    }

    public interface CardListener{
        void onClick(int position);
    }


}
