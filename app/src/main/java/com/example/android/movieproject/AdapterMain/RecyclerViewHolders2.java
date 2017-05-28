package com.example.android.movieproject.AdapterMain;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.android.movieproject.DetailActivity;
import com.example.android.movieproject.Model.ChildResult;
import com.example.android.movieproject.Model.ChildResult2;
import com.example.android.movieproject.R;

import java.util.List;

/**
 * Created by Yosefricaro on 02/12/2016.
 */

public class RecyclerViewHolders2 extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView moviePoster;
    public List<ChildResult2> list;

    public RecyclerViewHolders2(View itemView, List<ChildResult2> rowListItem) {
        super(itemView);
        itemView.setOnClickListener(this);
        moviePoster = (ImageView)itemView.findViewById(R.id.movie_poster);
        list = rowListItem;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(),DetailActivity.class)
                .putExtra("movieId2", list.get(getPosition()).getId());
        view.getContext().startActivity(intent);
    }
}
