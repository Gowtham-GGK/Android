package com.example.myweatherapp.Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

//               "dt":1485766800,
//                "temp":{  },
//                "pressure":1024.53,
//                "humidity":76,
//                "weather":[{  }],
//                "speed":4.57,
//                "deg":225,
//                "clouds":0,
//                "snow":0.01
public class MainData {

    private long dt;

    private Temp temp;

    private double pressure;

    private int humidity;

    private List<Weather> weather;

    private float speed;

    private int deg;

    private int clouds;

    private float snow;

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public float getSnow() {
        return snow;
    }

    public void setSnow(float snow) {
        this.snow = snow;
    }

    public CharSequence convertToDate(long dt) {
        long unix_seconds = dt;
        //convert seconds to milliseconds
        Date date = new Date(unix_seconds*1000L);
        // format of the date
        SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd");
        jdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
        CharSequence java_date = jdf.format(date);

        return java_date;
    }
}
