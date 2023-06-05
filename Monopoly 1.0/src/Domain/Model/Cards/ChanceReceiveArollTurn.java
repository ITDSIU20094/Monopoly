package Domain.Model.Cards;

import Domain.Model.Cards.ChanceCard;
import Domain.Model.GameEngine;

public class ChanceReceiveArollTurn extends ChanceCard {
    public ChanceReceiveArollTurn(String title, boolean isImmediate) {
        super(title, isImmediate);
    }

    @Override
    public void playCard(GameEngine gameEngine) {
        gameEngine.isMyTurn();
    }
}
