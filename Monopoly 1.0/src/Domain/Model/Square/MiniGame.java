package Domain.Model.Square;

import Domain.MiniGame.src.main.Game;
import Domain.Model.GameEngine;
import Domain.MiniGame.src.main.MainClass;

public class MiniGame extends Square {
    public MiniGame(String t , String n) {
        super(t,n);
    }
    public boolean play() {
        new Game();
        return true;
    }

    @Override
    public void evaluateSquare(GameEngine gameEngine) {

    }
}
