package com.codingapps.myrecipes.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.codingapps.myrecipes.R;

public class ReciperViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView title, publisher,socialScore;
    AppCompatImageView image;

    public ReciperViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.recipe_title);
        publisher = itemView.findViewById(R.id.recipe_publisher);
        socialScore = itemView.findViewById(R.id.recipe_social_score);
        image = itemView.findViewById(R.id.recipe_image);
    }

    @Override
    public void onClick(View v) {

    }
}
