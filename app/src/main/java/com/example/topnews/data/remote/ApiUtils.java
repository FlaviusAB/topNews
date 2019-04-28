package com.example.topnews.data.remote;

public class ApiUtils {
    public static final String BASE_URL = "https://newsapi.org/";
    public static ArticleService getArticleService()
    {
        return RetrofitClient.getClient(BASE_URL).create(ArticleService.class);
    }
}
