package Domain.Model.Cards;

import Domain.Controller.PlayerController;
import Domain.Model.Cards.ChanceCard;
import Domain.Model.GameEngine;
import Domain.Model.Player;

public class ChanceGoToSpecialCell extends ChanceCard {

    private PlayerController playerController = PlayerController.getInstance();
    private int[] specialcells = {2,4,7,10,15,17,20,22,25,30,35,36,38};

    public ChanceGoToSpecialCell(String title, boolean isImmediate) {
        super(title, isImmediate);

    }

    @Override
    public void playCard(GameEngine gameEngine) {
        Player currentPlayer = PlayerController.getInstance().getCurrentPlayer();
        if (gameEngine.isMyTurn() && !currentPlayer.isBot()) {
            int choosenSquareIndex = gameEngine.getChosenSquareIndex();
            for (int cell : specialcells) {
                if (choosenSquareIndex == cell) {
                    gameEngine.publishEvent("teleport" + choosenSquareIndex);
                    break;
                }
            }
        }
    }
}
