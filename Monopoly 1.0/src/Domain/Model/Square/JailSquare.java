package Domain.Model.Square;

import Domain.Model.GameEngine;
import Domain.Model.Player;

import javax.swing.text.html.Option;

public class JailSquare extends Square {

    public JailSquare(String n, String t) {
        super(n, t);

    }

    @Override
    public void evaluateSquare(GameEngine gameEngine) {
        Player currentPlayer = gameEngine.getPlayerController().getCurrentPlayer();
        System.out.println("jailSquare" + currentPlayer.getName() + " " + currentPlayer.getPosition());
        gameEngine.publishEvent("empty");
    }

    @Override
    public Option trigger(Player player) {
        return null;
    }

}