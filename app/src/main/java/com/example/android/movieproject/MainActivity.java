package com.example.android.movieproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.example.android.movieproject.AdapterMain.RecyclerViewAdapter;
import com.example.android.movieproject.AdapterMain.RecyclerViewAdapter2;
import com.example.android.movieproject.Model.ChildResult;
import com.example.android.movieproject.Model.ChildResult2;
import com.example.android.movieproject.Model.Result;
import com.example.android.movieproject.Model.Result2;
import com.example.android.movieproject.Model.api.MovieService;
import com.example.android.movieproject.Model.api.MovieService2;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayoutManager gridLayout;
        final List<ChildResult> allItems = new ArrayList<ChildResult>();
        final RecyclerView recyclerView;

        gridLayout = new GridLayoutManager(MainActivity.this, 2);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayout);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieService movieTemp = retrofit.create(MovieService.class);
        movieTemp.getMovie().enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                for (int i = 0; i < result.getResults().size(); i++) {
                    allItems.add(new ChildResult("http://image.tmdb.org/t/p/w500"
                            .concat(result.getResults().get(i).getPoster_path())
                            , result.getResults().get(i).getId()));
                }

                RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(MainActivity.this, allItems);
                recyclerView.setAdapter(rcAdapter);
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(MainActivity.this, allItems);
        recyclerView.setAdapter(rcAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Toast.makeText(MainActivity.this, "Created By : Mikkel Septiano", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
