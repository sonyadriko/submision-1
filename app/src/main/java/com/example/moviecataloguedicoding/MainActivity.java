package com.example.moviecataloguedicoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataTitle, dataOverview, dataLanguage, dataReleaseDate;
    private TypedArray dataPoster;
    private MovieAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        collectData();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent moveObject = new Intent(MainActivity.this, DetailActivity.class);

                ArrayList<Movie> movies = new ArrayList<Movie>();
                Movie movie = new Movie();
                movie.setOriginalTitle(dataTitle[i]);
                movie.setOriginalLanguage(dataLanguage[i]);
                movie.setOverview(dataOverview[i]);
                movie.setReleaseDate(dataReleaseDate[i]);
                movie.setPosterPath(dataPoster.getResourceId(i, -1));

                movies.add(movie);

                //moveObject.putParcelableArrayListExtra(DetailActivity.EXTRA_DATA,movies);
                moveObject.putExtra(DetailActivity.EXTRA_DATA, movie);
                startActivity(moveObject);
            }
        });
    }

    private void addItem() {
        ArrayList<Movie> movies = new ArrayList<>();

        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setOriginalTitle(dataTitle[i]);
            movie.setOriginalLanguage(dataLanguage[i]);
            movie.setOverview(dataOverview[i]);
            movie.setReleaseDate(dataReleaseDate[i]);
            movie.setPosterPath(dataPoster.getResourceId(i, -1));

            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void collectData() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataLanguage = getResources().getStringArray(R.array.data_language);
        dataReleaseDate = getResources().getStringArray(R.array.data_releaseDate);
        dataOverview = getResources().getStringArray(R.array.data_overviewfilm);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
    }
}
