package Domain.Model.Square;

import Domain.Model.GameEngine;
import Domain.Controller.MoneyController;
import Domain.Controller.PlayerController;
import Domain.Model.Player;

import java.util.ArrayList;
import java.util.List;

public class BusCell extends Square {
    private MoneyController moneyController = MoneyController.getInstance();
    private PlayerController playerController = PlayerController.getInstance();
    private int busFee = 100;
    private int[] specialcells = {2,4,7,10,15,17,20,22,25,30,35,36,38};
    public BusCell(String name, String type) {
        super(name, type);
    }

    @Override
    public void evaluateSquare(GameEngine gameEngine) {
        Player currentPlayer = PlayerController.getInstance().getCurrentPlayer();
        if (gameEngine.isMyTurn() && !currentPlayer.isBot()) {
            int destination = gameEngine.getChosenSquareIndex();
            for (int cell : specialcells) {
                if (destination != cell) {
                    currentPlayer.getTargetPosition();
                }
            }
        }

    }

}