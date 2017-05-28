package com.example.android.movieproject.Model;

/**
 * Created by Yosefricaro on 02/12/2016.
 */

public class ChildResult2 {
    String poster_path;
    Long id;

    public ChildResult2(String tempPoster , Long Id) {
        this.poster_path = tempPoster;
        this.id = Id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
