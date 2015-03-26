package com.nerydelgado.rutasslp.view;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nery.delgado on 11/4/2014.
 */
public class ViewMenuHolder {
    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public TextView getText() {
        return text;
    }

    public void setText(TextView text) {
        this.text = text;
    }

    private ImageView image;
    private TextView text;

}
