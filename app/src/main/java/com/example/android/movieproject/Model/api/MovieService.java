package com.example.android.movieproject.Model.api;

import com.example.android.movieproject.Model.Detail;
import com.example.android.movieproject.Model.Result;
import com.example.android.movieproject.Model.Video;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Yosefricaro on 02/12/2016.
 */

public interface MovieService {
    @GET("3/discover/movie?primary_release_year=2016&sort_by=popularity.desc&api_key=edfccf752de0d09758c56e652809912b")
    Call<Result> getMovie();

    @GET("3/movie/{movieId}?api_key=edfccf752de0d09758c56e652809912b")
    Call<Detail> getDetail(@Path("movieId") Long movieId);

    @GET("3/movie/{movieId}/videos?api_key=edfccf752de0d09758c56e652809912b")
    Call<Video> getVideo(@Path("movieId") Long movieId);
}
