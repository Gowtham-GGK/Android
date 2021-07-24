package com.example.myweatherapp.Model;


//{
//        "geoname_id":524901,
//        "name":"Moscow",
//        "lat":55.7522,
//        "lon":37.6156,
//        "country":"RU",
//        "iso2":"RU",
//        "type":"city",
//        "population":0
//        },
public class City {

    private long geoname_id;

    private String name;

    private double lat;

    private double lon;

    private String country;

    private String iso2;

    private String type;

    private int population;

    public long getGeoname_id() {
        return geoname_id;
    }

    public void setGeoname_id(long geoname_id) {
        this.geoname_id = geoname_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
