package Model.Cards;

import Model.Cards.ChanceCard;
import Model.GameEngine;
import SettingWindow.MoneyController;
import SettingWindow.PlayerController;

public class ReceiveMoneyFromTheBank extends ChanceCard {
    private MoneyController moneyController = MoneyController.getInstance();
    private PlayerController playerController = PlayerController.getInstance();
    private int receiveMoney = 200;
    public ReceiveMoneyFromTheBank(String title, boolean isImmediate) {
        super(title,isImmediate);
    }


    @Override
    public void playCard(GameEngine gameEngine) {
        moneyController.increaseMoney(playerController.getCurrentPlayer(), receiveMoney);
        gameEngine.publishEvent("message/" + "[System]: " + playerController.getCurrentPlayer().getName() + " gained " + receiveMoney + "$.");
        
    }
}
