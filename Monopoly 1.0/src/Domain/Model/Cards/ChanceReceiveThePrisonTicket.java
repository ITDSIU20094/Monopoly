package Domain.Model.Cards;

import Domain.Model.Cards.ChanceCard;
import Domain.Model.GameEngine;

public class ChanceReceiveThePrisonTicket extends ChanceCard {
    public ChanceReceiveThePrisonTicket(String title, boolean isImmediate) {
        super(title, isImmediate);
    }

    @Override
    public void playCard(GameEngine gameEngine) {

    }
}
