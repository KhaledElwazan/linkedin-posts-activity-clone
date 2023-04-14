package com.example.linkedin_app_clone;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.util.Log;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import com.example.linkedin_app_clone.models.Post;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @SuppressLint("NonConstantResourceId")
    @BindView(value = R.id.post_recycler_view)
    RecyclerView postRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        ArrayList<Post> posts = Post.generatePosts(10);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(posts);
        postRecyclerView.setAdapter(recyclerAdapter);
        postRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        scheduleJob();
    }

}