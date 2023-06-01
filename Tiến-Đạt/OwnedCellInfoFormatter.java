package gui;
import gui.Cell;
import gui.OwnedCell;
import gui.Player;


public abstract class OwnedCellInfoFormatter implements CellInfoFormatter{

    public OwnedCellInfoFormatter() {
        super();

    }

    protected String getOwnerName(Cell cell) {
        Player owner = ((OwnedCell) cell).getOwner();
        String ownerName = "";
        if(owner != null) {
            ownerName = owner.getName();
        }
        return ownerName;
    }

}