package com.atempa.dam18_recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyArrayAdapter.MovieItemListener movieItemListener = new MyArrayAdapter.MovieItemListener() {
        @Override
        public void onMovieClick(Movie movie) {
            Intent intent = new Intent(getBaseContext(), MovieDetailActivity.class);
            intent.putExtra("title", movie.getTitle());
            intent.putExtra("description", movie.getDescription());
            intent.putExtra("poster", movie.getPoster());
            intent.putExtra("director", movie.getDirector());
            intent.putExtra("release", movie.getRelease());
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView listView = (RecyclerView) findViewById(R.id.listView);
        // Create an adapter
        MyArrayAdapter adapter = new MyArrayAdapter(movieItemListener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        listView.setAdapter(adapter);
        listView.setLayoutManager(layoutManager);

        adapter.addData(getMovies());
    }

    private List<Movie> getMovies() {
        List<Movie> movieList = new ArrayList<Movie>();

        try {
            // Load data
            String jsonString = loadJsonFromAsset("movies.json", this);
            JSONObject json = new JSONObject(jsonString);
            JSONArray movies = json.getJSONArray("movies");
            // Get Movie objects from data
            for (int i = 0; i < movies.length(); i++) {
                Movie movie = new Movie();
                movie.setTitle(movies.getJSONObject(i).getString("title"));
                movie.setDescription(movies.getJSONObject(i).getString("description"));
                movie.setPoster(movies.getJSONObject(i).getString("poster"));
                movie.setDirector(movies.getJSONObject(i).getString("director"));
                movie.setRelease(movies.getJSONObject(i).getString("release"));
                movieList.add(movie);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return movieList;
    }

    private static String loadJsonFromAsset(String filename, Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }
}
