package com.kaolashopping.kaola.bean;

public class TouristUser {

    private int id;
    private String touristKey;

    public TouristUser() {
    }

    public TouristUser(String touristKey) {
        this.touristKey = touristKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTouristKey() {
        return touristKey;
    }

    public void setTouristKey(String touristKey) {
        this.touristKey = touristKey;
    }
}
