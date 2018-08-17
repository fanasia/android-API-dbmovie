package com.future.anyatasia.myfirstapplication.retrovit;

import com.future.anyatasia.myfirstapplication.response.ListResponse;
import com.future.anyatasia.myfirstapplication.response.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    @GET("movie/popular")
    Call<ListResponse<MovieResponse>> findPopularMovies(@Query("api_key") String apiKey);
    // ini untuk nge wrap response yang async
}
