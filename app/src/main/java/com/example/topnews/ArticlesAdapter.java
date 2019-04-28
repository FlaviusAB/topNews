package com.example.topnews;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.topnews.data.model.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ViewHolder> {


    private List<Article> mArticles;

    ArticlesAdapter(List<Article> articles)
    {
        mArticles = articles;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.news_list_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        String imgUri=mArticles.get(position).getUrlToImage();
        Context context = viewHolder.image.getContext();
        Picasso.with(context).load(imgUri).into(viewHolder.image);

        viewHolder.title.setText((mArticles.get(position).getTitle()));
        viewHolder.content.setText(mArticles.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView content;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.newsTitle);
            content = itemView.findViewById(R.id.newsContent);
            image = itemView.findViewById(R.id.newsPhoto);
        }
    }

}
