package com.example.android.movieproject.AdapterVideo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.movieproject.Model.ChildVideo2;
import com.example.android.movieproject.R;

import java.util.List;

/**
 * Created by Yosefricaro on 02/12/2016.
 */

public class RecyclerVideoAdapter2 extends RecyclerView.Adapter<RecyclerVideoHolders2> {
    private List<ChildVideo2> itemList;
    private Context context;

    public RecyclerVideoAdapter2(Context context, List<ChildVideo2> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerVideoHolders2 onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext())
                                        .inflate(R.layout.card_video, parent, false);
        RecyclerVideoHolders2 rcv = new RecyclerVideoHolders2(layoutView, itemList);
        return rcv;
    }

    @Override
    public void onBindViewHolder(final RecyclerVideoHolders2 holder, final int position) {
        holder.trailer.setText("Trailer Movie " + (position+1));
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
