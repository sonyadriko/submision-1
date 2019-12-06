package com.example.moviecataloguedicoding;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String originalTitle;
    private String overview;
    private String releaseDate;
    private String originalLanguage;
    private int posterPath;

    public Movie(String originalTitle, String overview, String releaseDate, String originalLanguage, int posterPath) {
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.originalLanguage = originalLanguage;
        this.posterPath = posterPath;
    }

    public Movie() {
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public int getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(int posterPath) {
        this.posterPath = posterPath;
    }

    protected Movie(Parcel in) {
        originalTitle = in.readString();
        overview = in.readString();
        releaseDate = in.readString();
        originalLanguage = in.readString();
        posterPath = in.readInt();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(originalTitle);
        parcel.writeString(overview);
        parcel.writeString(releaseDate);
        parcel.writeString(originalLanguage);
        parcel.writeInt(posterPath);
    }
}
