package gui;
import gui.Cell;
import gui.OwnedCell;
import gui.Player;

public class RRCellInfoFormatter extends OwnedCellInfoFormatter {
    public String format(Cell cell) {
        OwnedCell c = (OwnedCell)cell;
        StringBuffer buf = new StringBuffer();
        String ownerName = getOwnerName(cell);
        buf.append("<html><b><font color='lime'>")
                .append(cell.getName())
                .append("</font></b><br>")
                .append("$").append(c.getPrice())
                .append("<br>Owner: ").append(ownerName)
                .append("</html>");
        return buf.toString();
    }

}