package com.example.topnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.topnews.data.model.Article;
import com.example.topnews.data.model.Articles;
import com.example.topnews.data.remote.ApiUtils;
import com.example.topnews.data.remote.ArticleService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    RecyclerView mArticlesList;
    RecyclerView.Adapter mArticlesAdapter;
    ArticleService mService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mArticlesList = findViewById(R.id.rv);
        mArticlesList.hasFixedSize();
        mArticlesList.setLayoutManager(new LinearLayoutManager(this));

        mService = ApiUtils.getArticleService();


        loadArticles();




    }

    private void loadArticles() {

        mService.getArticles().enqueue(new Callback<Articles>() {
            @Override
            public void onResponse(Call<Articles> call, Response<Articles> response) {
                if(response.isSuccessful())
                {
                    List<Article> artResponse = response.body().getArticles();
                    mArticlesAdapter = new ArticlesAdapter(artResponse);
                    mArticlesList.setAdapter(mArticlesAdapter);

                }
                else
                {
                    int statusCode= response.code();
                }
            }

            @Override
            public void onFailure(Call<Articles> call, Throwable t) {

                Log.d("MainActivity", "error loading from API");

            }
        });
    }

}
