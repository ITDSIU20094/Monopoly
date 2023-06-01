package Domain.Model.Square;

import Domain.Model.GameEngine;

public class MiniGame extends Square {
    public MiniGame(String t , String n) {
        super(t,n);
    }
    public boolean play() {
        return true;
    }

    @Override
    public void evaluateSquare(GameEngine gameEngine) {

    }
}
