import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Board extends JPanel {
    private Image image;
    private File imageSrc = new File("./Image/MonopolyBoard.png");

    private Point position;
    private int length;
    private List<Pawn> pawnList;
    private List<Player> playerList = new ArrayList<>();

    private int smallSide;
    private Point initialPosition;
    private HashMap<Integer, Point[]> squareMap = new HashMap<Integer, Point[]>();
    private ArrayList<Integer> currentPath = new ArrayList<Integer>();
    private ArrayList<File> pawnFiles = new ArrayList<File>();

    public static Board instance;

    public ArrayList<Integer> getCurrentPath() {
        return currentPath;
    }

    public HashMap<Integer, Point[]> getSquareMap() {
        return squareMap;
    }

    public static Board getInstance() {
        return instance;
    }



}