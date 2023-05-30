package Domain.Model.Square;

import Domain.Model.GameEngine;

import java.io.Serializable;

public abstract class Square implements Serializable {
    private String name;
    private String type;
    private boolean flyover;

    public Square(String name, String type) {
        this.name = name;
        this.type = type;
        setFlyover(false);
    }
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean getFlyover()
    {
        return flyover;
    }


    public void setFlyover(boolean b) {
        this.flyover = b;
    }

    public void evaluateSquare(GameEngine gg, String args) {
        evaluateSquare(gg);
    }


    public abstract void evaluateSquare(GameEngine gameEngine);
}
