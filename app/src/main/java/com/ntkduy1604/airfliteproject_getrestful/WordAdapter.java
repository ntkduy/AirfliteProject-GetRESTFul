package com.ntkduy1604.airfliteproject_getrestful;

/**
 * Created by NTKDUY on 2/26/2017
 * for PIGGY HOUSE
 * you can contact me at: ntkduy1604@gmail.com
 */

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * This class inherits all the properties of ArrayAdapter
 * but it will extend ArrayAdapter class to support double TextView
 * for a particular data type Word (custom class)
 */
public class WordAdapter extends ArrayAdapter<Word> {

    private int mImageResourceId;

    public WordAdapter (Activity context, ArrayList<Word> word, int vImageResourceId){
        super(context, 0, word);
        mImageResourceId = vImageResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        TextView idTextView = (TextView) listItemView.findViewById(R.id.id_text_view);
        idTextView.setText(currentWord.getId());

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        nameTextView.setText(currentWord.getName());

        TextView serialnoTextView = (TextView) listItemView.findViewById(R.id.serial_no_text_view);
        serialnoTextView.setText(currentWord.getSerialno());

        TextView activatedateTextView = (TextView) listItemView.findViewById(R.id.active_date_text_view);
        activatedateTextView.setText(currentWord.getActivedate());

//        TextView useridTextView = (TextView) listItemView.findViewById(R.id.user_id_text_view);
//        useridTextView.setText(currentWord.getUserid());
//
//        TextView comidTextView = (TextView) listItemView.findViewById(R.id.com_id_text_view);
//        comidTextView.setText(currentWord.getComid());
//
//        TextView modelTextView = (TextView) listItemView.findViewById(R.id.model_text_view);
//        modelTextView.setText(currentWord.getModel());
//
//        TextView tagidTextView = (TextView) listItemView.findViewById(R.id.tagid_text_view);
//        tagidTextView.setText(currentWord.getTagid());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        // Check if an image is provided for this word or not
        if (currentWord.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentWord.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        View textContainer = (View) listItemView.findViewById(R.id.text_container);
        View textDisplay = (View) listItemView.findViewById(R.id.text_view);
        int color = ContextCompat.getColor(getContext(), mImageResourceId);
        textContainer.setBackgroundColor(color);
        textDisplay.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
