package com.kaolashopping.kaola.bean;

import java.util.Date;

/**
 * 用户浏览汽车记录
 */
public class CarBrowsingHistory {

    private int id;
    private int userId;
    private int carId;
    private Date browsingDate;

    public CarBrowsingHistory() {
    }

    public CarBrowsingHistory(int userId, int carId, Date browsingDate) {
        this.userId = userId;
        this.carId = carId;
        this.browsingDate = browsingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public Date getBrowsingDate() {
        return browsingDate;
    }

    public void setBrowsingDate(Date browsingDate) {
        this.browsingDate = browsingDate;
    }
}
