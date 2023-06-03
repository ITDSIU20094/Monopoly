package Domain.Model.Square;

import Domain.Model.Player;
import Domain.Model.Square.Square;

public abstract class SpecialCell extends Square {
    private int position;


    public SpecialCell(String name, String type) {
        super(name, type);
    }


    public int getPosition() {
        return position;
    }
}

