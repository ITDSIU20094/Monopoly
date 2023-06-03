package gui;
import gui.Cell;

public class GoCellInfoFormatter implements CellInfoFormatter {

    public static final String GO_CELL_LABEL = "<html><b>Go</b></html>";

    public String format(Cell cell) {
        return GO_CELL_LABEL;
    }
}
