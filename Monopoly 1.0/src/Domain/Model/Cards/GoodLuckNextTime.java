package Domain.Model.Cards;

import Domain.Model.Cards.ChanceCard;
import Domain.Model.GameEngine;

public class GoodLuckNextTime extends ChanceCard {
    public GoodLuckNextTime(String title, boolean isImmediate) {
        super(title, isImmediate);
    }

    @Override
    public void playCard(GameEngine gameEngine) {

    }
}
