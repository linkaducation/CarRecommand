package com.kaolashopping.kaola.bean;

import java.util.Date;

/**
 * @author ming.zhong
 * @date 2018/3/24 下午4:31
 */
public class CarModel {

    private int id;
    private String brand;
    private String uniqueId;
    private String carVersion;
    private Date firstLicence;
    private int mailage;
    private int newPrice;
    private boolean comeFrom;
    private String area;
    private String color;
    private int transferTimes;
    private Date addDate;
    private String fixRecord;
    private String url;
    private int currentPrice;
    private Date updateDate;
    private String dateVersion;
    private String site;
    private boolean isImport;
    private String disRank;
    private Date publishTime;
    private int carAge;
    private float premiumRate;
    private boolean deleted;

    public int getCarAge() {
        return carAge;
    }

    public void setCarAge(int carAge) {
        this.carAge = carAge;
    }

    public float getPremiumRate() {
        return premiumRate;
    }

    public void setPremiumRate(float premiumRate) {
        this.premiumRate = premiumRate;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getCarVersion() {
        return carVersion;
    }

    public void setCarVersion(String carVersion) {
        this.carVersion = carVersion;
    }

    public Date getFirstLicence() {
        return firstLicence;
    }

    public void setFirstLicence(Date firstLicence) {
        this.firstLicence = firstLicence;
    }

    public int getMailage() {
        return mailage;
    }

    public void setMailage(int mailage) {
        this.mailage = mailage;
    }

    public int getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(int newPrice) {
        this.newPrice = newPrice;
    }

    public boolean isComeFrom() {
        return comeFrom;
    }

    public void setComeFrom(boolean comeFrom) {
        this.comeFrom = comeFrom;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTransferTimes() {
        return transferTimes;
    }

    public void setTransferTimes(int transferTimes) {
        this.transferTimes = transferTimes;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getFixRecord() {
        return fixRecord;
    }

    public void setFixRecord(String fixRecord) {
        this.fixRecord = fixRecord;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDateVersion() {
        return dateVersion;
    }

    public void setDateVersion(String dateVersion) {
        this.dateVersion = dateVersion;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public boolean isImport() {
        return isImport;
    }

    public void setImport(boolean anImport) {
        isImport = anImport;
    }

    public String getDisRank() {
        return disRank;
    }

    public void setDisRank(String disRank) {
        this.disRank = disRank;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}
