package com.jorgeandresdiaz.aplicacionposts.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jorgeandresdiaz.aplicacionposts.R;
import com.jorgeandresdiaz.aplicacionposts.contract.MainContract;
import com.jorgeandresdiaz.aplicacionposts.model.Post;
import com.jorgeandresdiaz.aplicacionposts.presenter.MainPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.rv_posts)
    RecyclerView rvPosts;

    private MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setUpPresenter();
    }

    private void setUpPresenter() {
        presenter = new MainPresenter();
        presenter.setView(this);
    }

    @OnClick(R.id.btn_obtain_posts)
    void getPosts() {
        presenter.getPosts();
    }


    private void setUpRecyclerView(List<Post> postList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvPosts.setLayoutManager(layoutManager);

        PostAdapter postAdapter = new PostAdapter(postList);
        rvPosts.setAdapter(postAdapter);
    }

    @Override
    public void OnPostsResponse(List<Post> postList) {
        setUpRecyclerView(postList);
        Log.i("POSTresponse -> ", String.valueOf(postList.size()));
    }
}
