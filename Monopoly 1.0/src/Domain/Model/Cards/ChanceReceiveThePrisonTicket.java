package Domain.Model.Cards;

import Domain.Controller.MoneyController;
import Domain.Controller.PlayerController;
import Domain.Model.Cards.ChanceCard;
import Domain.Model.DomainBoard;
import Domain.Model.GameEngine;
import Domain.Model.Player;
import Domain.Model.Square.Square;

import java.util.HashMap;

public class ChanceReceiveThePrisonTicket extends ChanceCard {
    private MoneyController moneyController = MoneyController.getInstance();
    private PlayerController playerController = PlayerController.getInstance();
    boolean firstTime = true;
    public ChanceReceiveThePrisonTicket(String title, boolean isImmediate) {
        super(title, isImmediate);
    }

    @Override
    public void playCard(GameEngine gameEngine) {
        DomainBoard db = gameEngine.getDomainBoard();
        HashMap<Integer, Square> squares = db.getSquareMap();
        Player currentPlayer = playerController.getCurrentPlayer();
        int pos = currentPlayer.getPosition();
        if (!firstTime)
        {
            if (currentPlayer.isInJail())
            {
                playerController.getOutFromJail();
                currentPlayer.getCardList().remove(this);
                this.firstTime = true;
                db.getChanceCards().add(this);
            }
        }
        else
        {
            currentPlayer.getCardList().add(this);
            firstTime = false;
            db.getChanceCards().remove(this);
        }
    }
}
