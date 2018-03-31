package com.atempa.dam18_recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        TextView text_title = (TextView) findViewById(R.id.text_title);
        TextView text_director = (TextView) findViewById(R.id.text_director);
        TextView text_release = (TextView) findViewById(R.id.text_release);
        TextView text_description = (TextView) findViewById(R.id.text_description);
        ImageView image_poster = (ImageView) findViewById(R.id.image_poster);

        Intent intent = this.getIntent();

        text_title.setText(intent.getExtras().getString("title"));
        text_director.setText(intent.getExtras().getString("director"));
        text_release.setText(intent.getExtras().getString("release"));
        text_description.setText(intent.getExtras().getString("description"));

        Picasso.get()
               .load(intent.getExtras().getString("poster"))
               .placeholder(R.mipmap.ic_launcher)
               .into(image_poster);
    }
}
