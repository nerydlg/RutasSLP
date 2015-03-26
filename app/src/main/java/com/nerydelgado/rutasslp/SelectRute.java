package com.nerydelgado.rutasslp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import com.nerydelgado.rutasslp.adapter.SelectRuteAdapter;
import com.nerydelgado.rutasslp.util.Txt2Json;

import java.util.ArrayList;
import java.util.List;


public class SelectRute extends Activity {

    private ListView list;
    private Button btnAccept;
    private Button btnCancel;
    private ArrayList<Integer> selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_rute);
        selected = new ArrayList<Integer>();
        initUI();
        setAdapter();
        setClicks();
    }

    private void setClicks() {
        //next button
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean hideAll = (selected != null)? selected.size() == 0 : false;
                Intent intent = new Intent(SelectRute.this, MapActivity.class);
                intent.putExtra(MapActivity.HIDE_ALL, hideAll);
                intent.putIntegerArrayListExtra(MapActivity.SELECTION, selected);
                startActivity(intent);
            }
        });

        // cancel button
        btnCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckBox chBox = (CheckBox) view.findViewById(R.id.chbox_rute);
                // first perform click
                chBox.performClick();
                // if is it checked
                if(chBox.isChecked()){
                    selected.add(position);
                }else{
                    int aux = selected.indexOf(position);
                    selected.remove(aux);
                }
            }
        });

    }

    private void setAdapter() {
        SelectRuteAdapter adapter = new SelectRuteAdapter(this);
        list.setAdapter(adapter);

    }

    private void initUI() {
        list = (ListView) findViewById(R.id.rute_list);
        list.setItemsCanFocus(false);
        btnAccept = (Button) findViewById(R.id.btn_next);
        btnCancel = (Button) findViewById(R.id.btn_return);
    }


}
