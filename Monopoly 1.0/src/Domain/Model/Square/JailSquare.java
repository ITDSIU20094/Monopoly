package Model.Square;

import Model.GameEngine;
import Model.Player;

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

}