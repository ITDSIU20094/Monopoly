package Domain.Model.Cards;

import Domain.Controller.PlayerController;
import Domain.Model.Cards.ChanceCard;
import Domain.Model.GameEngine;
import Domain.Model.Player;

public class ChanceGoToSpecialCell extends ChanceCard {

    private PlayerController playerController = PlayerController.getInstance();


    public ChanceGoToSpecialCell(String title, boolean isImmediate) {
        super(title, isImmediate);

    }

    @Override
    public void playCard(GameEngine gameEngine) {
        Player currentPlayer = PlayerController.getInstance().getCurrentPlayer();
        if (gameEngine.isMyTurn() && !currentPlayer.isBot()) {
            if (gameEngine.getChosenSquareIndex() == 7 ) {
                gameEngine.publishEvent("teleport" + gameEngine.getChosenSquareIndex());
                //gameEngine.publishEvent("drawCard");
            } else if (gameEngine.getChosenSquareIndex() == 17) {
                gameEngine.publishEvent("teleport" + gameEngine.getChosenSquareIndex());
                //gameEngine.publishEvent("drawCard");
            } else if (gameEngine.getChosenSquareIndex() == 22) {
                gameEngine.publishEvent("teleport" + gameEngine.getChosenSquareIndex());
                //gameEngine.publishEvent("drawCard");
            } else if (gameEngine.getChosenSquareIndex() == 36) {
                gameEngine.publishEvent("teleport" + gameEngine.getChosenSquareIndex());
                //gameEngine.publishEvent("drawCard");
            } else if (gameEngine.getChosenSquareIndex()== 4) {
                gameEngine.publishEvent("teleport" + gameEngine.getChosenSquareIndex());
            } else if (gameEngine.getChosenSquareIndex() == 38) {
                gameEngine.publishEvent("teleport" + gameEngine.getChosenSquareIndex());
            }
        }


    }
}
