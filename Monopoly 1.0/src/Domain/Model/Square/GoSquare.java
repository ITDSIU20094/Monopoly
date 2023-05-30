package Model.Square;

import Model.GameEngine;
import Model.Player;
import SettingWindow.MoneyController;

public class GoSquare extends Square {

    public GoSquare(String n, String t) {
        super(n, t);

        this.setFlyover(true);
    }



    @Override
    public void evaluateSquare(GameEngine gameEngine) {
        Player currentPlayer = gameEngine.getPlayerController().getCurrentPlayer();
        MoneyController.getInstance().increaseMoney(currentPlayer, 300);
        gameEngine.publishEvent("empty");
    }

    @Override
    public void evaluateSquare(GameEngine gg, String args)
    {
        if (args.equals("flyover"))
        {
            this.evaluateSquare(gg);
        }
        else
        {
            throw new IllegalArgumentException("Illegal argument: " + args);
        }
    }

}