package com.future.anyatasia.myfirstapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.future.anyatasia.myfirstapplication.response.MovieResponse;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<MovieResponse> data;

    class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView imagePoster;
        TextView textRating;
        TextView textTitle;

        public MovieViewHolder(View itemView) {
            super(itemView);
            imagePoster = itemView.findViewById(R.id.image_poster);
            textRating = itemView.findViewById(R.id.text_rating);
            textTitle = itemView.findViewById(R.id.text_movie_title);
        }
    }

    public MovieAdapter(List<MovieResponse> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // passing si item list
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_movies, parent, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        // nge bind data ke item list
        MovieResponse item = data.get(position);
        holder.textRating.setText(String.valueOf(item.getVoteAverage()));
        holder.textTitle.setText(String.valueOf(item.getMovieTitle()));
        Glide.with(holder.imagePoster.getContext())
                .load("http://image.tmdb.org/t/p/w185/" + item.getPosterPath())
                .into(holder.imagePoster);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
