package Model.Cards;

import Model.Cards.Card;
import Model.GameEngine;

public abstract class ChanceCard extends Card {
    public ChanceCard(String title, boolean isImmediate) {
        super(title, isImmediate);
    }
    public abstract void playCard(GameEngine gameEngine);

}
