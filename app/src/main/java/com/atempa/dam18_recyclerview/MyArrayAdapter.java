package com.atempa.dam18_recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyArrayAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<Movie> mDataSource;

    public MyArrayAdapter(@NonNull Context context, List<Movie> movies) {
        mContext = context;
        mDataSource = movies;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get view for row item
        View rowView = mInflater.inflate(R.layout.list_item_movie, parent, false);

        TextView titleTextView = (TextView) rowView.findViewById(R.id.text_title);
        TextView descriptionTextView = (TextView) rowView.findViewById(R.id.text_description);
        ImageView posterImageView = (ImageView) rowView.findViewById(R.id.image_poster);

        Movie movie = (Movie) getItem(position);
        titleTextView.setText(movie.getTitle());
        descriptionTextView.setText(movie.getDescription());

        return rowView;
    }
}
