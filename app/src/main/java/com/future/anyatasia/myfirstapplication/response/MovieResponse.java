package com.future.anyatasia.myfirstapplication.response;

import com.google.gson.annotations.SerializedName;

public class MovieResponse {
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("title")
    private String MovieTitle;
    @SerializedName("vote_average")
    private Double voteAverage;


    public MovieResponse(String posterPath, String movieTitle, Double voteAverage) {
        this.posterPath = posterPath;
        MovieTitle = movieTitle;
        this.voteAverage = voteAverage;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getMovieTitle() {
        return MovieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        MovieTitle = movieTitle;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }
}
