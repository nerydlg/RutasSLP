package com.nerydelgado.rutasslp.model;

/**
 * Created by nery.delgado on 11/3/2014.
 */
public class MenuItem {
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public MenuItem(Integer image, String label){
        this.image = image;
        this.label = label;
    }

    private String label;
    private Integer image;

}
