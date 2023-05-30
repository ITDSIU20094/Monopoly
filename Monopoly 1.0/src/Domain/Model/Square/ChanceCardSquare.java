package Model.Square;

import Model.GameEngine;

public class ChanceCardSquare extends Square {

    public ChanceCardSquare(String name, String type) {
        super(name, type);
    }

    @Override
    public void evaluateSquare(GameEngine gameEngine) {
        gameEngine.publishEvent("drawCard");

    }

}