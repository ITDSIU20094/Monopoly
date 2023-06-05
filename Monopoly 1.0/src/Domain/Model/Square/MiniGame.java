package Domain.Model.Square;

import Domain.MiniGame.src.main.Game;
import Domain.Model.GameEngine;
import Domain.Model.Player;

import javax.swing.text.html.Option;


public class MiniGame extends Square {
    private Game miniGame;

    public MiniGame(String t, String n, Game miniGame) {
        super(t, n);
        this.miniGame = miniGame;
    }

    @Override
    public void evaluateSquare(GameEngine gameEngine) {


    }

    @Override
    public Option trigger(Player player) {
        return null;
    }
}
