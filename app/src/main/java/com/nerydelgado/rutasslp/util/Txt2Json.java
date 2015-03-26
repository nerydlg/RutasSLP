package com.nerydelgado.rutasslp.util;

import android.content.Context;
import android.os.Environment;

import com.google.gson.Gson;
import com.nerydelgado.rutasslp.model.Rutes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by nery.delgado on 11/5/2014.
 */
public class Txt2Json {

    public static synchronized Rutes getRutes(Context ctx){
        Rutes rutes = new Rutes();
        Gson gson = new Gson();
        File folder = new File(Environment.getExternalStorageDirectory()+File.separator+"Rutes");
        if(!folder.exists()){
            rutes = null; // rutes null = folder or file not found
        }else{
            File f = new File(Environment.getExternalStorageDirectory()+File.separator+"Rutes"+File.separator+"rutes.json");
            if(!f.exists()){
                rutes = null;
            }else{
                try {
                    BufferedReader bf = new BufferedReader(new FileReader(f.toString()));
                    rutes = gson.fromJson(bf, Rutes.class);

                }catch(FileNotFoundException fnf){

                }
            }
        }
        return rutes;
    }
}
