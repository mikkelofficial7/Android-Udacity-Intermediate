package com.example.android.movieproject.AdapterVideo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.android.movieproject.Model.ChildVideo;
import com.example.android.movieproject.Model.ChildVideo2;
import com.example.android.movieproject.R;

import java.util.List;

/**
 * Created by Yosefricaro on 02/12/2016.
 */

public class RecyclerVideoHolders2 extends RecyclerView.ViewHolder implements View.OnClickListener {
    public Button trailer;
    public List<ChildVideo2> list;

    public RecyclerVideoHolders2(View itemView, List<ChildVideo2> rowListItem) {
        super(itemView);
        itemView.setOnClickListener(this);
        trailer = (Button)itemView.findViewById(R.id.button);
        trailer.setOnClickListener(this);
        list = rowListItem;
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.youtube.com/watch?v=" + list.get(getPosition()).getKey()));
        view.getContext().startActivity(i);
    }
}
