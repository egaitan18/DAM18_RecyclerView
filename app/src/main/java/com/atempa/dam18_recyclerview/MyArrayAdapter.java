package com.atempa.dam18_recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyArrayAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Movie> mDataSource;

    public MyArrayAdapter() {
        mDataSource = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;

        // Inflate the custom layout
        view = inflater.inflate(R.layout.list_item_movie, parent, false);

        // Return a new holder instance
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Movie movie = mDataSource.get(position);
        MovieHolder movieHolder = (MovieHolder) holder;
        movieHolder.titleTextView.setText(movie.getTitle());
        movieHolder.descriptionTextView.setText(movie.getDescription());

        Picasso.get().load(movie.getPoster()).placeholder(R.mipmap.ic_launcher).into(movieHolder.posterImageView);
    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
    }

    public Movie getItem(int position) {
        return mDataSource.get(position);
    }

    public void addData(List<Movie> movies) {
        mDataSource.addAll(movies);
        notifyDataSetChanged();
    }

    public class MovieHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView descriptionTextView;
        private ImageView posterImageView;

        public MovieHolder(View itemView) {
            super(itemView);

            titleTextView = (TextView) itemView.findViewById(R.id.text_title);
            descriptionTextView = (TextView) itemView.findViewById(R.id.text_description);
            posterImageView = (ImageView) itemView.findViewById(R.id.image_poster);
        }
    }
}
