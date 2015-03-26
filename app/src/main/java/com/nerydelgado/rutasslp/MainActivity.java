package com.nerydelgado.rutasslp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.nerydelgado.rutasslp.adapter.MenuAdapter;


public class MainActivity extends Activity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        setAdapter();
        setClicks();
    }

    private void setClicks() {
        list.setOnItemClickListener( new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch(position){
                    case 0: intent = new Intent(MainActivity.this, SelectRute.class);
                            startActivity(intent);
                        break;
                    case 1: intent = new Intent(MainActivity.this, MapActivity.class);
                            startActivity(intent);
                        break;
                }

            }
        });
    }

    private void setAdapter() {
        MenuAdapter adapter = new MenuAdapter(this);
        list.setAdapter(adapter);
    }

    private void initUI() {
        list = (ListView) findViewById(R.id.main_menu);
    }

}
