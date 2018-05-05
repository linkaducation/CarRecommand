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
    private boolean deleted;

    public CarBrowsingHistory() {
    }

    public CarBrowsingHistory(int userId, int carId, Date browsingDate, boolean deleted) {
        this.userId = userId;
        this.carId = carId;
        this.browsingDate = browsingDate;
        this.deleted = deleted;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
