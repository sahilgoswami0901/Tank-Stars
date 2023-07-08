package com.mygdx.game;
import java.util.ArrayList;

public class Tanks {
    ArrayList<Tanks> arrt = new ArrayList<>();
    private int power;
    private int Health;
    private int Price;

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }
}