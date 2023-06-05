package Domain.Model.Square;

import Domain.Model.GameEngine;
import Domain.Model.Player;
import Domain.Controller.PlayerController;
import Domain.Controller.MoneyController;

import javax.swing.text.html.Option;

public class TaxSquare extends Square {
    public TaxSquare(String n, String t) {
        super(n, t);

    }


    @Override
    public void evaluateSquare(GameEngine gameEngine) {
        Player currentPlayer = gameEngine.getPlayerController().getCurrentPlayer();
        MoneyController.getInstance().decreaseMoney(currentPlayer,200);
        gameEngine.publishEvent("empty");
    }

    @Override
    public Option trigger(Player player) {
        return null;
    }
}
