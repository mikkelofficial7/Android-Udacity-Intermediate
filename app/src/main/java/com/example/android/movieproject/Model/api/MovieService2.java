package com.example.android.movieproject.Model.api;

import com.example.android.movieproject.Model.Detail;
import com.example.android.movieproject.Model.Detail2;
import com.example.android.movieproject.Model.Result;
import com.example.android.movieproject.Model.Result2;
import com.example.android.movieproject.Model.Video;
import com.example.android.movieproject.Model.Video2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by mikkel on 12/6/2016.
 */

public interface MovieService2 {
    @GET("3/movie/upcoming?api_key=edfccf752de0d09758c56e652809912b")
    Call<Result2> getMovie();

    @GET("3/movie/{movieId}?api_key=edfccf752de0d09758c56e652809912b")
    Call<Detail2> getDetail(@Path("movieId2") Long movieId);

    @GET("3/movie/{movieId}/videos?api_key=edfccf752de0d09758c56e652809912b")
    Call<Video2> getVideo(@Path("movieId2") Long movieId);
}
