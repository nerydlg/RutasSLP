package com.nerydelgado.rutasslp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nerydelgado.rutasslp.R;
import com.nerydelgado.rutasslp.model.MenuItem;
import com.nerydelgado.rutasslp.view.ViewMenuHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nery.delgado on 11/3/2014.
 */
public class MenuAdapter extends BaseAdapter{

    private List<MenuItem> items;
    private LayoutInflater inflater;

    public MenuAdapter(Context ctx){
        inflater = LayoutInflater.from(ctx);
        initLists(ctx);
    }

    private void initLists(Context ctx) {
        items = new ArrayList<MenuItem>();

        items.add( new MenuItem( R.drawable.gps, ctx.getString(R.string.gps_image_text) ) );
        items.add( new MenuItem( R.drawable.pin, ctx.getString(R.string.pin_image_text) ) );
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewMenuHolder vmh ;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.main_menu_row, null);
            vmh = new ViewMenuHolder();
            vmh.setImage((ImageView)convertView.findViewById(R.id.image_menu));
            vmh.setText((TextView) convertView.findViewById(R.id.text_menu));
            initElem(vmh, position);
            convertView.setTag(vmh);
        }else{
            vmh = (ViewMenuHolder) convertView.getTag();
        }
        return convertView;
    }

    private void initElem(ViewMenuHolder vmh, int position) {
        MenuItem item = (MenuItem)getItem(position);
        vmh.getImage().setImageResource( item.getImage() );
        vmh.getText().setText(item.getLabel());
    }

}
