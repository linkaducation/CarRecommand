package com.kaolashopping.kaola.bean;

public class EvaluateIdNode {

    private int id;
    private float simRatio;

    public EvaluateIdNode(int id, float simRatio) {
        this.id = id;
        this.simRatio = simRatio;
    }

    public int getId() {
        return id >= 0 ? id : -1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSimRatio() {
        return simRatio;
    }

    public void setSimRatio(float simRatio) {
        this.simRatio = simRatio;
    }

}
