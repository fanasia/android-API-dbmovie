package com.future.anyatasia.myfirstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.future.anyatasia.myfirstapplication.response.ListResponse;
import com.future.anyatasia.myfirstapplication.response.MovieResponse;
import com.future.anyatasia.myfirstapplication.retrovit.MovieService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    private MovieService movieService;
    private MovieAdapter movieAdapter;
    private RecyclerView movieRecycleView;
    private LinearLayoutManager movieLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        movieRecycleView = findViewById(R.id.recycler_view_movie);
        movieLayoutManager = new LinearLayoutManager(this);
        movieLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        movieRecycleView.setLayoutManager(movieLayoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        movieService = retrofit.create(MovieService.class);

        // karena tadi asyncronus jadi kita callback dulu
        movieService.findPopularMovies("4bbbfeaa56287e045385e892563e7168")
                .enqueue(new Callback<ListResponse<MovieResponse>>() {

                @Override
                public void onResponse(Call<ListResponse<MovieResponse>> call,
                                        Response<ListResponse<MovieResponse>> response) {
                    // ini balikan http nya 200 alias OK
                     if(response.isSuccessful()){
                         ListResponse<MovieResponse> responseContent =  response.body();
                         movieAdapter = new MovieAdapter(responseContent.getResults());
                         movieRecycleView.setAdapter(movieAdapter);
                     } else { // kalo ini balikannya 400, 404, 500
                         // kasih toast error
                         Toast.makeText(HomeActivity.this,"HTTP EROR BOSQUE", Toast.LENGTH_SHORT).show();
                     }                    }

                @Override
                public void onFailure(Call<ListResponse<MovieResponse>> call, Throwable t) {
                     Toast.makeText(HomeActivity.this,"HTTP EROR BOSQUE", Toast.LENGTH_SHORT).show();
                 }
             }
        );
    }
}
