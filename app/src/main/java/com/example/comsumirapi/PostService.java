package com.example.comsumirapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PostService {

    @GET("/users")
    Call<List<Post>> find(@Query("q")String q);

}
