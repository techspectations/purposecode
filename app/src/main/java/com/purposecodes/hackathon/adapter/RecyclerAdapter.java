package com.purposecodes.hackathon.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.purposecodes.hackathon.R;
import com.purposecodes.hackathon.api.SearchModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by PURPOSE CODE on 11/12/2016.
 */

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    private List<SearchModel.Article> mList;

    public RecyclerAdapter(List<SearchModel.Article> searchModels) {
        mList = searchModels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_recycler, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        SearchModel.Article article = mList.get(position);

        if (!TextUtils.isEmpty(article.getImgWeb())) {

            Picasso.with(holder.itemView.getContext())
                    .load(article.getImgWeb())
                    .fit()
                    .centerCrop()
                    .into(holder.image);
        }

        holder.title.setText(article.getTitle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.imageView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
