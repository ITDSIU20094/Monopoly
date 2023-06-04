package Domain.Model.Square;

import Domain.Model.GameEngine;
import Domain.Controller.MoneyController;
import Domain.Controller.PlayerController;

import java.util.ArrayList;
import java.util.List;

public class BusCell extends Square {
    private MoneyController moneyController = MoneyController.getInstance();
    private PlayerController playerController = PlayerController.getInstance();
    private int busFee = 100;
    public BusCell(String name, String type) {
        super(name, type);
    }

    @Override
    public void evaluateSquare(GameEngine gameEngine) {
        if(moneyController.hasEnoughMoney(playerController.getCurrentPlayer(),busFee)) {
            List<Square> availableSquares = new ArrayList<>();

        }

    }

}