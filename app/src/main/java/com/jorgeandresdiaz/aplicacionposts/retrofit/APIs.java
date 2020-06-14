package com.jorgeandresdiaz.aplicacionposts.retrofit;

import com.jorgeandresdiaz.aplicacionposts.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIs {

    @GET("/posts")
    Call<List<Post>> getAllPosts();

}
