package com.example.arrayadaptertest;

import java.util.Date;

public class Movie {

    private String mName;

    private Date mDate;

    private int mViews;

    public Movie(String mName, Date mDate, int mViews) {
        this.mName = mName;
        this.mDate = mDate;
        this.mViews = mViews;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public int getmViews() {
        return mViews;
    }

    public void setmViews(int mViews) {
        this.mViews = mViews;
    }

}
