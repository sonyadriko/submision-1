package com.example.moviecataloguedicoding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    String title, overview, language, releaseDate;
    int path;

    TextView txtTitle, txtOverview, txtLanguage, txtReleaseDate;
    ImageView imagePoster;


    public static final String EXTRA_DATA = "move_movie_here";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtLanguage = findViewById(R.id.language_detail);
        txtTitle = findViewById(R.id.title_detail);
        txtOverview = findViewById(R.id.overview_detail);
        txtReleaseDate = findViewById(R.id.releasedate_detail);
        imagePoster = findViewById(R.id.image_detail);


        Movie movie = getIntent().getParcelableExtra(EXTRA_DATA);

        String text = movie.getOriginalTitle();
        txtTitle.setText(text);

        String text2 = movie.getOriginalLanguage();
        txtLanguage.setText(text2);

        String text3 = movie.getOverview();
        txtOverview.setText(text3);

        String text4 = movie.getReleaseDate();
        txtReleaseDate.setText(text4);

        int posterPath = movie.getPosterPath();
        imagePoster.setImageResource(posterPath);


    }
}
