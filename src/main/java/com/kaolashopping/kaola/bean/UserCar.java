package com.kaolashopping.kaola.bean;

public class UserCar {

    private int id;
    private int userId;
    private String type;
    private String content;
    private int brandId;

    public UserCar() {
    }

    public UserCar(int userId, String type, String content, int brandId) {
        this.userId = userId;
        this.type = type;
        this.content = content;
        this.brandId = brandId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
