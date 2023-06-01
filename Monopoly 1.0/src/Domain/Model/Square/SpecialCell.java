package Domain.Model.Square;

import Domain.Model.Player;
import Domain.Model.Square.Square;

public abstract class SpecialCell extends Square {
    private int position;
    private MiniGame miniGame;
    public SpecialCell(MiniGame miniGame){
        this.miniGame = miniGame;
    }
    public void landOn(Player player){
        boolean isWinner = miniGame.play();
        if (isWinner) {
            player.receiveMoney(100);
        }
    }
    public SpecialCell(String name, String type) {
        super(name, type);
    }


    public int getPosition() {
        return position;
    }
}

