package gui;
import gui.Cell;
import gui.PropertyCell;

public class PropertyCellInfoFormatter extends OwnedCellInfoFormatter {
    public String format(Cell cell) {
        PropertyCell c = (PropertyCell)cell;
        StringBuffer buf = new StringBuffer();
        String ownerName = getOwnerName(cell);
        buf.append("<html><b><font color='")
                .append(c.getColorGroup())
                .append("'>")
                .append(cell.getName())
                .append("</font></b><br>")
                .append("$").append(c.getPrice())
                .append("<br>Owner: ").append(ownerName)
                .append("<br>* ").append(c.getNumHouses())
                .append("</html>");
        return buf.toString();
    }
}
