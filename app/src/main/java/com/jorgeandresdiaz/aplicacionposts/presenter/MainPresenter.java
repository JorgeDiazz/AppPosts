package com.jorgeandresdiaz.aplicacionposts.presenter;

import android.util.Log;

import com.jorgeandresdiaz.aplicacionposts.contract.MainContract;
import com.jorgeandresdiaz.aplicacionposts.model.Post;
import com.jorgeandresdiaz.aplicacionposts.retrofit.APIs;
import com.jorgeandresdiaz.aplicacionposts.retrofit.ClientRetrofit;
import com.jorgeandresdiaz.aplicacionposts.view.MainActivity;

import java.lang.ref.WeakReference;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {

    private WeakReference<MainContract.View> view;

    @Override
    public void setView(MainContract.View view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void getPosts() {
        APIs apis = ClientRetrofit.getRetrofit().create(APIs.class);

        Call<List<Post>> callToPosts = apis.getAllPosts();
        callToPosts.enqueue(new PostsResponse());
    }


    private class PostsResponse implements Callback<List<Post>> {

        @Override
        public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
            view.get().OnPostsResponse(response.body());
        }

        @Override
        public void onFailure(Call<List<Post>> call, Throwable t) {
            Log.e("POSTerror -> ", "An error has occurred.");
        }
    }
}
