package com.kaolashopping.kaola.bean;

/**
 * @author ming.zhong
 * @date 2018/3/24 下午10:16
 */
public class OveragePremiumRateOfCarUsingKM {

    private int id;
    private float premiumRate;
    private int kilometre;
    private String brand;
    private int sampleCount;

    public int getKilometre() {
        return kilometre;
    }

    public void setKilometre(int kilometre) {
        this.kilometre = kilometre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPremiumRate() {
        return premiumRate;
    }

    public void setPremiumRate(float premiumRate) {
        this.premiumRate = premiumRate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSampleCount() {
        return sampleCount;
    }

    public void setSampleCount(int sampleCount) {
        this.sampleCount = sampleCount;
    }

}
