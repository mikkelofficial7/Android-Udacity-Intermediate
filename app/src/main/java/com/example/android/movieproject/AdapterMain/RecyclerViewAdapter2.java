package com.example.android.movieproject.AdapterMain;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.movieproject.Model.ChildResult;
import com.example.android.movieproject.Model.ChildResult2;
import com.example.android.movieproject.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Yosefricaro on 02/12/2016.
 */

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewHolders2> {
    private List<ChildResult2> itemList;
    private Context context;

    public RecyclerViewAdapter2(Context context, List<ChildResult2> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders2 onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, null);
        RecyclerViewHolders2 rcv = new RecyclerViewHolders2(layoutView, itemList);
        return rcv;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolders2 holder, final int position) {
        Picasso.with(context)
                .load(itemList.get(position).getPoster_path())
                .into(holder.moviePoster);
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
