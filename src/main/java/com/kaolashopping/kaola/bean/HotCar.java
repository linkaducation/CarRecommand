package com.kaolashopping.kaola.bean;

/**
 * 存储每个用户的最感兴趣的汽车
 */
public class HotCar {

    private int id;
    private int userId;
    private String carContent;
    private String brandContent;

    public HotCar() {
    }

    public HotCar(int userId, String carContent, String brandContent) {
        this.userId = userId;
        this.carContent = carContent;
        this.brandContent = brandContent;
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

    public String getCarContent() {
        return carContent;
    }

    public void setCarContent(String carContent) {
        this.carContent = carContent;
    }

    public String getBrandContent() {
        return brandContent;
    }

    public void setBrandContent(String brandContent) {
        this.brandContent = brandContent;
    }
}
