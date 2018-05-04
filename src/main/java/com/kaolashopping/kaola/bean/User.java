package com.kaolashopping.kaola.bean;

/**
 * @author ming.zhong
 * @date 2018/3/10 下午2:43
 */
public class User {

    private int id;
    private String userName;
    private String nickName;
    private String password;
    private String addDate;
    private String updateDate;
    private boolean isDeleted;
    private int status;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddDate() {
        return addDate;
    }

    public User setAddDate(String addDate) {
        this.addDate = addDate;
        return this;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public User setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public User setIsDeleted(int deleted) {
        isDeleted = deleted == 1 ? true : false;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public User setStatus(int status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        return this.id == user.getId() && this.userName.equals(user.getUserName())
                && this.password.equals(user.getPassword());
    }
}
