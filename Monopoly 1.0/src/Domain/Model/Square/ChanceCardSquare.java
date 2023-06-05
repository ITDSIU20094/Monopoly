package Domain.Model.Square;

import Domain.Model.GameEngine;
import Domain.Model.Player;

import javax.swing.text.html.Option;

public class ChanceCardSquare extends Square {

    public ChanceCardSquare(String name, String type) {
        super(name, type);
    }

    @Override
    public void evaluateSquare(GameEngine gameEngine) {
        gameEngine.publishEvent("drawCard");

    }

    @Override
    public Option trigger(Player player) {
        return null;
    }

}