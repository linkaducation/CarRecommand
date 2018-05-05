package com.kaolashopping.kaola.bean;

import java.util.Date;

/**
 * 用户浏览品牌记录
 */
public class BrandBrowsingHistory {

    private int id;
    private int userId;
    private int brandId;
    private String brand;
    private Date browsingDate;
    private boolean deleted;

    public BrandBrowsingHistory() {
    }

    public BrandBrowsingHistory(int userId, int brandId, String brand, Date browsingDate, boolean deleted) {
        this.userId = userId;
        this.brandId = brandId;
        this.brand = brand;
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

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getBrowsingDate() {
        return browsingDate;
    }

    public void setBrowsingDate(Date browsingDate) {
        this.browsingDate = browsingDate;
    }
}
