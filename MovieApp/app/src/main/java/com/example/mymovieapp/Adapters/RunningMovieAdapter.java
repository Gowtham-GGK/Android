package com.example.mymovieapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymovieapp.DataModels.Results;
import com.example.mymovieapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RunningMovieAdapter extends RecyclerView.Adapter<RunningMovieAdapter.RunningMovieViewHolder> {

    private LayoutInflater minflater;
    private List<Results> resultsList;
    CardListener cardListener;

    public RunningMovieAdapter(Context context, List<Results> resultsList, CardListener cardListener) {
        this.minflater = LayoutInflater.from(context);
        this.resultsList = resultsList;
        this.cardListener = cardListener;

    }

    @NonNull
    @Override
    public RunningMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = minflater.inflate(R.layout.movie_card,parent,false);

        return new RunningMovieViewHolder(view,this,cardListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RunningMovieViewHolder holder, int position) {

        //holder.textView.setText(resultsList.get(position).getOriginal_title());
        Picasso.get().load("https://image.tmdb.org/t/p/w780"+resultsList.get(position).getPoster_path())
               .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }

    public class RunningMovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;
        ImageView imageView;
        RunningMovieAdapter runningMovieAdapter;
        CardListener cardListener;

        public RunningMovieViewHolder(@NonNull View itemView, RunningMovieAdapter runningMovieAdapter, CardListener cardListener) {
            super(itemView);
            //textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
            this.runningMovieAdapter = runningMovieAdapter;
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
