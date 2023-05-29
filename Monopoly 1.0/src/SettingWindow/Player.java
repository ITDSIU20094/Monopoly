package SettingWindow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Player implements Serializable {
    private String name;
    private int money = 2000;
    private boolean inJail;
    private boolean bot = false;
    private int rentMultiplier = 1;
    private int placeHolder;
    private boolean direction = true;
    private int targetPosition = 56;
    private int position = 56;
    private HashMap<String, ArrayList<PropertySquare>> propertyCardsMap;


    public boolean isInJail() {
        return inJail;
    }
    public void setinJail(boolean b) {
        inJail = b;
    }

    public void setTargetPosition(int targetIndex) {
        this.targetPosition = position;
    }

    public void setPosition(int newPos) {

        position = newPos;
    }

    public int getPosition() {
        return position;
    }

    public HashMap<String, ArrayList<PropertySquare>> getPropertyCardsMap() {
        return propertyCardsMap;
    }
    public String getName() {
        if(bot){
            return "Bot | " + name;
        }
        return name;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int newmoney) {
        money = newmoney;
    }

    public int getPlaceHolder() {
        return placeHolder;
    }
    public int getTargetPosition() {
        return targetPosition;
    }
}
