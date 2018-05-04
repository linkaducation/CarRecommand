package com.kaolashopping.kaola.bean;


/**
 * @author ming.zhong
 * @date 2018/2/13 下午10:21
 */
public class Car {

    private int id;
    private int parentId;
    private int minPrice;
    private int maxPrice;
    private int price;
    private int officialPrice;
    private String orientation;
    private String emissions;
    private String brand;
    private String picturePath;
    private int power;
    private boolean isChild;
    private String equipment;
    private String evaluate;
    private String simIds;
    private int count;
    private String type;
    private boolean onSale;
    private String advantages;
    private String disAdvantages;
    private float score;
    private String otherSimIds;
    private int popularity;

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getOtherSimIds() {
        return otherSimIds;
    }

    public void setOtherSimIds(String otherSimIds) {
        this.otherSimIds = otherSimIds;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public String getAdvantages() {
        return advantages;
    }

    public void setAdvantages(String advantages) {
        this.advantages = advantages;
    }

    public String getDisAdvantages() {
        return disAdvantages;
    }

    public void setDisAdvantages(String disAdvantages) {
        this.disAdvantages = disAdvantages;
    }

    public String getSimIds() {
        return simIds;
    }

    public void setSimIds(String simIds) {
        this.simIds = simIds;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public boolean isChild() {
        return isChild;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOfficialPrice() {
        return officialPrice;
    }

    public void setOfficialPrice(int officialPrice) {
        this.officialPrice = officialPrice;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getEmissions() {
        return emissions;
    }

    public void setEmissions(String emissions) {
        this.emissions = emissions;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean getisChild() {
        return isChild;
    }

    public void setChild(boolean child) {
        isChild = child;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == ((Car)obj).getId();
    }
}
