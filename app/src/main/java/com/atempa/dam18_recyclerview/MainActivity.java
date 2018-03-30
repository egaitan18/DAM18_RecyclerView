package com.atempa.dam18_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private MyArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        // Build a dataset
        String[] films = { "A New Hope", "The Empire Strikes Back", "Return of the Jedi",
                "The Phantom Menace", "Attack of the Clones", "Revenge of the Sith",
                "The Force Awakens", "The Last Jedi" };

        String[] filmDescriptions = { "Part IV in George Lucas' epic, Star Wars: A New Hope opens with a Rebel ship being boarded by the tyrannical Darth Vader. ",
                "Fleeing the evil Galactic Empire, the Rebels abandon their new base in an assault with the Imperial AT-AT walkers on the ice world of Hoth.",
                "Darth Vader and the Empire are building a new, indestructible Death Star. Meanwhile, Han Solo has been imprisoned, and Luke Skywalker has sent R2-D2 and C-3PO to try and free him.",
                "The evil Trade Federation, led by Nute Gunray is planning to take over the peaceful world of Naboo.", "Ten years after the 'Phantom Menace' threatened the planet Naboo, Padmé Amidala is now a Senator representing her homeworld.",
                "Three years after the onset of the Clone Wars; the noble Jedi Knights are spread out across the galaxy leading a massive clone army in the war against the Separatists.",
                "Luke Skywalker has vanished. In his absence, the sinister FIRST ORDER has risen from the ashes of the Empire and will not rest until Skywalker, the last Jedi, has been destroyed.", "The FIRST ORDER reigns. Having decimated the peaceful Republic, Supreme Leader Snoke now deploys his merciless legions to seize military control of the galaxy." };

        List<Movie> movieList = new ArrayList<Movie>();
        for (int i = 0; i < films.length; i++) {
            Movie movie = new Movie();
            movie.setTitle(films[i]);
            movie.setDescription(filmDescriptions[i]);
            movieList.add(movie);
        }
        // Create an adapter
        adapter = new MyArrayAdapter(this, movieList);
        listView.setAdapter(adapter);
    }
}
