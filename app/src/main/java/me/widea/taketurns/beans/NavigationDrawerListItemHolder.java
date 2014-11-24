package me.widea.taketurns.beans;

import android.graphics.drawable.Drawable;

/**
 * Created by bearcatmobile on 11/21/14.
 */
public class NavigationDrawerListItemHolder {
    private String text;
    private Drawable imageId;

    public NavigationDrawerListItemHolder(String text, Drawable imageId) {
        this.text = text;
        this.imageId = imageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Drawable getImageId() {
        return imageId;
    }

    public void setImageId(Drawable imageId) {
        this.imageId = imageId;
    }
}
