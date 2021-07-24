package com.example.myweatherapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

//        "cod":"200",
//        "message":0,
//        "city":  {
//        },
//        "cnt":7,
//        "list":[
//            {
//
//            }

public class Future {

    private int cod;

    private float message;

    private City city;

    private int cnt;

    @SerializedName("list")
    private List<MainData> mainData;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public float getMessage() {
        return message;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<MainData> getMainData() {
        return mainData;
    }

    public void setMainData(List<MainData> mainData) {
        this.mainData = mainData;
    }
}
