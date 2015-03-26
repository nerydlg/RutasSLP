package com.nerydelgado.rutasslp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.nerydelgado.rutasslp.model.Point;
import com.nerydelgado.rutasslp.model.Rutes;
import com.nerydelgado.rutasslp.util.SerialColor;
import com.nerydelgado.rutasslp.util.Txt2Json;

import java.util.ArrayList;
import java.util.List;


public class MapActivity extends Activity {

    private static final LatLng SLP = new LatLng(22.156,-100.975);
    public static final String HIDE_ALL = "HideAll";
    public static final String SELECTION = "Selection";

    private GoogleMap map;
    private Polyline[] lines;
    private PolylineOptions[] options;
    private Rutes rutes;
    private ArrayList<Integer> selection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Intent intent = getIntent();
        initVars();
        initOptions(intent.getBooleanExtra(HIDE_ALL, false));
        initMap(intent.getBooleanExtra(HIDE_ALL, false));
    }

    private void initMap(boolean hideAll) {
        map = ( (MapFragment) getFragmentManager().findFragmentById(R.id.my_map) ).getMap();
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        // disabling indoor capabilities
        map.setIndoorEnabled(false);
        // enable location icon
        map.setMyLocationEnabled(true);
        // set the position of the map on SLP
        float zoom = 12.0f;
        map.moveCamera(CameraUpdateFactory.newLatLng(SLP));
        map.moveCamera(CameraUpdateFactory.zoomTo(zoom));

        if(!hideAll){
            for(int i=0; i < lines.length; i++){
                lines[i] = map.addPolyline(options[i]);
            }
        }

    }

    private void initVars() {
        Bundle bundle = getIntent().getExtras();
        // init rutes
        rutes = Txt2Json.getRutes(null);
        selection =  bundle.getIntegerArrayList(SELECTION);
        // check if we would hide all the routes
        if(!bundle.getBoolean(HIDE_ALL)) {

            lines  = new  Polyline[selection.size()];
            options = new PolylineOptions[selection.size()];
        }else{
            lines = new Polyline[rutes.getRutes().size()];
            options = new PolylineOptions[selection.size()];
        }


        SerialColor.init();
    }

    private void initOptions(boolean hideAll){
        // initializing options
        for (int i = 0; i < options.length; i++) {
            options[i] = new PolylineOptions();
        }

        if(hideAll) {
              for(Integer i : selection){
                  addPoints(i);
              }
        }else{
            for(int i=0; i < rutes.getRutes().size(); i++){
                addPoints(i);
            }
        }
    }

    private void addPoints(Integer i) {
        if(rutes == null) return;
        List<Point> points = rutes.getRutes().get(i).getPoints();
        for(Point p : points){
            options[i].add(new LatLng(p.getLat(), p.getLon()));
        }
        options[i].color(SerialColor.getColor());
    }


}
