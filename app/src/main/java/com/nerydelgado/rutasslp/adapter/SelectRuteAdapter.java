package com.nerydelgado.rutasslp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import com.nerydelgado.rutasslp.R;
import com.nerydelgado.rutasslp.SelectRute;
import com.nerydelgado.rutasslp.model.Rutes;
import com.nerydelgado.rutasslp.util.Txt2Json;
import com.nerydelgado.rutasslp.view.ViewSelectionHolder;

/**
 * Created by nery.delgado on 11/4/2014.
 */
public class SelectRuteAdapter extends BaseAdapter{

    private Rutes rutes;
    private LayoutInflater inflater;

    public SelectRuteAdapter(Context ctx){
        inflater = LayoutInflater.from(ctx);
        rutes = Txt2Json.getRutes(ctx);
    }

    @Override
    public int getCount() {
        if(rutes == null) return 0;
        return rutes.getRutes().size();
    }

    @Override
    public Object getItem(int position) {
        if(rutes == null) return null;
        return rutes.getRutes().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewSelectionHolder vsh ;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.menu_rute_row, null);
            vsh = new ViewSelectionHolder();
            vsh.setCheckBox((CheckBox) convertView.findViewById(R.id.chbox_rute));

            setText(vsh, position);
            convertView.setTag(vsh);
        }else{
            vsh = (ViewSelectionHolder)convertView.getTag();
        }
        return convertView;
    }

    private void setText(ViewSelectionHolder vsh, int position) {
        vsh.getCheckBox().setText(rutes.getRutes().get(position).getName());
    }
}
