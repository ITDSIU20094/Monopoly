package Domain.Model.Square;

import Domain.Model.GameEngine;
import Domain.Model.Player;
import Domain.Controller.MoneyController;

import javax.swing.text.html.Option;

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
    public Option trigger(Player player) {
        return null;
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