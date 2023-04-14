package com.example.linkedin_app_clone.models;

import android.annotation.SuppressLint;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

public class Post {

    private final String id;
    private final String postContent;

    private final int impressionCount;

    public Post(String id, String postContent, int impressionCount) {
        this.id = id;
        this.postContent = postContent;
        this.impressionCount = impressionCount;
    }

    public String getId() {
        return id;
    }

    public String getPostContent() {
        return postContent;
    }

    public String getImpressionCount() {
        return getFormattedImpressionCount();
    }

//    format impressionCount to add comma after every 3 digits
    @SuppressLint("DefaultLocale")
    private String getFormattedImpressionCount() {
        return String.format("%,d", impressionCount);
    }

    @NotNull
    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", postContent='" + postContent + '\'' +
                ", impressionCount=" + impressionCount +
                '}';
    }


    public static ArrayList<Post> generatePosts(int count) {
        ArrayList<Post> posts = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            Post post = new Post("id" + random.nextInt(), "This is a dummy context for the post", random.nextInt(50000));
            posts.add(post);
        }
        return posts;

    }
}
