package com.nerydelgado.rutasslp.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by nery.delgado on 10/30/2014.
 */
public class Rute {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void addPoint(Point p) {
        points.add(p);
    }
    private String name;
    private List<Point> points;


}
