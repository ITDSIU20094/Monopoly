package gui;
import gui.Cell;

public interface CellInfoFormatter {
    public String format(Cell cell);
}
 class CCCellInfoFormatter implements CellInfoFormatter {
    public String format(Cell cell) {
        return "<html><font color='white'><b>" + cell.getName() + "</b></font></html>";
    }
}