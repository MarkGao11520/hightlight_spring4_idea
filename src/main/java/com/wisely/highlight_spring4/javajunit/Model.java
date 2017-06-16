package com.wisely.highlight_spring4.javajunit;

/**
 * Created by gaowenfeng on 2017/4/24.
 */
public class Model {
    private int a;
    private int b;
    private int x;

    public Model() {
    }

    public Model(int a, int b, int x) {
        this.a = a;
        this.b = b;
        this.x = x;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
