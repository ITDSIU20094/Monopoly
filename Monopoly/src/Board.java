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
    private File imageSrc = new File("./assets/MonopolyBoard.png");

    private Point position;
    private int length;
    private List<Pawn> pawnList;
    private List<Player> playerList = new ArrayList<>();

    private int smallSide;
    private Point initialPosition;
    private HashMap<Integer, Point[]> squareMap = new HashMap<Integer, Point[]>();
    private ArrayList<Integer> currentPath = new ArrayList<Integer>();
    private ArrayList<File> pawnFiles = new ArrayList<File>();
    private File P1 = new File("./assets/Pawn/Boot.png");
    private File P2 = new File("./assets/Pawn/Car.png");
    private File P3 = new File("./assets/Pawn/Chair.png");
    private File P4 = new File("./assets/Pawn/Hat.png");
    private File P5 = new File("./assets/Pawn/Motorbike.png");
    private File P6 = new File("./assets/Pawn/Ship.png");
    private File P7 = new File("./assets/Pawn/SpaceShip.png");
    private File P8 = new File("./assets/Pawn/Tank.png");

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

    public Board(Point position, int length) {
        instance = this;
        try {
            image = ImageIO.read(imageSrc);
            image = image.getScaledInstance(length, length, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.position = position;
        this.length = length;

        setPreferredSize(new Dimension(length, length));

        pawnFiles = new ArrayList<>();
        pawnFiles.add(P1);
        pawnFiles.add(P2);
        pawnFiles.add(P3);
        pawnFiles.add(P4);
        pawnFiles.add(P5);
        pawnFiles.add(P6);
        pawnFiles.add(P7);
        pawnFiles.add(P8);
        smallSide = length / 17;

    }

}