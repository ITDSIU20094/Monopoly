package Domain.Model.Square;

import Domain.Model.GameEngine;
import Domain.Controller.MoneyController;
import Domain.Controller.PlayerController;

public class BusCell extends SpecialCell {
    private MoneyController moneyController = MoneyController.getInstance();
    private PlayerController playerController = PlayerController.getInstance();
    private int busFee = 100;
    public BusCell(String name, String type) {
        super(name, type);
    }

    @Override
    public void evaluateSquare(GameEngine gameEngine) {
        moneyController.decreaseMoney(playerController.getCurrentPlayer(),busFee);

    }

}