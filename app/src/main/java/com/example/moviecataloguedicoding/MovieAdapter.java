package com.example.moviecataloguedicoding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    Context context;
    ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_row, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);

        return view;

    }

    private class ViewHolder {
        TextView txtTitle, txtReleaseDate;
        ImageView imagePoster;

        ViewHolder(View v) {
            txtTitle = v.findViewById(R.id.tv_title);
            txtReleaseDate = v.findViewById(R.id.tv_date);
            imagePoster = v.findViewById(R.id.iv_movie);
        }

        void bind(Movie movie) {
            txtTitle.setText(movie.getOriginalTitle());
            txtReleaseDate.setText(movie.getReleaseDate());
            imagePoster.setImageResource(movie.getPosterPath());
        }
    }
}
