package com.example.myweatherapp.Model;

import com.google.gson.internal.$Gson$Preconditions;

public class Temp {

//    "day":262.65,
//            "min":261.41,
//            "max":262.65,
//            "night":261.41,
//            "eve":262.65,
//            "morn":262.65

    private float day;

    private float min;

    private float max;

    private float night;

    private float eve;

    private float morn;

    public float getDay() {
        return day;
    }

    public void setDay(float day) {
        this.day = day;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public float getNight() {
        return night;
    }

    public void setNight(float night) {
        this.night = night;
    }

    public float getEve() {
        return eve;
    }

    public void setEve(float eve) {
        this.eve = eve;
    }

    public float getMorn() {
        return morn;
    }

    public void setMorn(float morn) {
        this.morn = morn;
    }
}
