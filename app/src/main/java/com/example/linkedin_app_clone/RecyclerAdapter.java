package com.example.linkedin_app_clone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.linkedin_app_clone.models.Post;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {


    final private ArrayList<Post> posts;

    public RecyclerAdapter(ArrayList<Post> posts) {
        this.posts = posts;
    }


    @NonNull
    @NotNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.post_card;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ItemViewHolder holder, int position) {
        Post post = posts.get(position);
//        holder.postContentTextView.setText(post.getPostContent());
        holder.postImpressionCountTextView.setText(String.valueOf(post.getImpressionCount()));
        Glide.with(holder.profileImage.getContext()).load("https://picsum.photos/200").apply(RequestOptions.circleCropTransform()).into(holder.profileImage);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.post_content)
        TextView postContentTextView;

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.post_impression_count)
        TextView postImpressionCountTextView;

        @SuppressLint("NonConstantResourceId")
        @BindView(value = R.id.profile_image)
        ImageView profileImage;


        public ItemViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
