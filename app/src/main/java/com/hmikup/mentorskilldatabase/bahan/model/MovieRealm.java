package com.hmikup.mentorskilldatabase.bahan.model;

import io.realm.RealmObject;

public class MovieRealm extends RealmObject {
    String poster_path;
    boolean adult;
    String overview;
    String release_date;
    int id;
    String original_title;
    String original_language;
    String title;
    String backdrop_path;
    int popularity;
    int vote_count;
    int vote_average;



    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public int getId() {
        return id;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public int getVote_average() {
        return vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getTitle() {
        return title;
    }
    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVote_average(int vote_average) {
        this.vote_average = vote_average;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }
}
