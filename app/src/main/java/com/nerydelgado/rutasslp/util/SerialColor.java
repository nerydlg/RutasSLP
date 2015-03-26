package com.nerydelgado.rutasslp.util;

/**
 * Created by nery.delgado on 11/6/2014.
 */
public class SerialColor {

    private enum Colors{
        RED(0xff8b2323),
        GRAY(0xff666666),
        BLUE(0xff104E8B),
        ORANGE(0xffFF7F24),
        BROWN(0xff5C3317),
        YELLOW(0xffEEEE00),
        YELLOW_2(0xff8B8B00),
        TOMATO(0xffFF6347),
        GREEN_Y(0xff99CC32),
        VIOLET(0xffD02090),
        PINK(0xffEEA9B8),
        GREEN(0xff00FF00),
        AQUA(0xff00FFFF),
        BLUE_2(0xff0000FF);


        private int val;

        private Colors(int color){
            this.val = color;
        }

        public int getValue(){
            return val;
        }
    }

    private static int current = -1;
    private static int last;

    public static void init(){
        last = Colors.values().length;
    }

    public static int getColor(){
        if(current == last){
            // restart count
            current = 0;
        }else{
            // move to next
            current++;
        }

        return Colors.values()[current].getValue();
    }

}
