package com.jorgeandresdiaz.aplicacionposts.contract;

import com.jorgeandresdiaz.aplicacionposts.model.Post;

import java.util.List;

public interface MainContract {

    interface View {

        void OnPostsResponse(List<Post> body);
    }

    interface Presenter {
        void setView(MainContract.View view);

        void getPosts();
    }

}
