package Domain.Model.Square;

import Domain.Model.GameEngine;
import Domain.Model.Player;

import javax.swing.text.html.Option;

public class Festival extends Square {
    public Festival(String name, String type) {
        super(name, type);
    }

    @Override
    public void evaluateSquare(GameEngine gameEngine) {

    }

    @Override
    public Option trigger(Player player) {
        return null;
    }
}
