package com.example.topnews.data.remote;

import com.example.topnews.data.model.Articles;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ArticleService {
    @GET("/v2/top-headlines?country=us&apiKey=26ffa6dfac17431b86bf9db694852668")
    Call<Articles> getArticles();
}
