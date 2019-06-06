package com.example.arrayadaptertest;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MovieAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList<Movie> displayList;

    public MovieAdapter(@NonNull Context context, ArrayList<Movie> displayList){
        super(context, 0, displayList); // TODO find out what this super does
        this.context = context;
        this.displayList = displayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Retrieving the position-th Movie to extract it's information
        Movie movie = (Movie) getItem(position); // Casting might not be the proper way to do this
        // Check if an existing view is being reused, otherwise inflate the view
        // TODO what is inflating
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.populate_movie_list, parent, false);
        }

        // Looking for the appropriate TextViews to then insert the Data into
        TextView MovieName = convertView.findViewById(R.id.tvMovieName);
        TextView MovieDate = convertView.findViewById(R.id.tvMovieDate);
        TextView MovieView = convertView.findViewById(R.id.tvMovieView);

        // Date Formatting to not get a load of gibberish
        DateFormat format = new SimpleDateFormat("dd MM yyyy");

        // now we insert the Movies Data into the TextViews
        MovieName.setText(movie.getmName());
        MovieDate.setText(format.format(movie.getmDate()));
        MovieView.setText(Integer.toString(movie.getmViews()));


        // TODO why do we return the inserted View
        return convertView;
    }

}
