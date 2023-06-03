package Domain.Model.Square;

import Domain.MiniGame.src.main.Game;
import Domain.Model.GameEngine;


public class MiniGame extends Square {
    private Game miniGame;

    public MiniGame(String t, String n, Game miniGame) {
        super(t, n);
        this.miniGame = miniGame;
    }

    @Override
    public void evaluateSquare(GameEngine gameEngine) {


    }
}
