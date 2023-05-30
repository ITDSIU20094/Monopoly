package Domain.Model.Square;

import Model.Square.Square;

public abstract class SpecialCell extends Square {
    private int position;
    public SpecialCell(String name, String type) {
        super(name, type);
    }


    public int getPosition() {
        return position;
    }
}

