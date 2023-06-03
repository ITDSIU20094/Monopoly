package gui;
import gui.Cell;
import gui.OwnedCell;
import gui.Player;
import gui.UtilityCell;

public class UtilCellInfoFormatter extends OwnedCellInfoFormatter {

    public String format(Cell cell) {
        UtilityCell c = (UtilityCell)cell;
        StringBuffer buf = new StringBuffer();
        String ownerName = getOwnerName(cell);
        buf.append("<html><b><font color='olive'>")
                .append(cell.getName())
                .append("</font></b><br>")
                .append("$").append(c.getPrice())
                .append("<br>Owner: ").append(ownerName)
                .append("</html>");
        return buf.toString();
    }

}
