package UI;
import App.ImageService;
import Domain.Controller.CommunicationController;
import Domain.Observer;
import Domain.Model.GameEngine;
import Domain.Model.Player;
import Domain.Model.Square.PropertySquare;
import Domain.Model.Square.Square;
import Domain.Controller.PlayerController;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board extends JFrame implements Observer {
    private Image image;
    private Point position;
    private int length;
    private List<Pawn> pawnList;
    private List<Player> playerList = new ArrayList<>();
    private int smallSide;
    private Point initialPosition;
    private PlayerController playerController = PlayerController.getInstance();
    private GameEngine gameEngine = GameEngine.getInstance();
    private HashMap<Integer, Point[]> squareMap = new HashMap<Integer, Point[]>();
    private ArrayList<Integer> currentPath = new ArrayList<Integer>();
    private ArrayList<File> pawnFiles = new ArrayList<File>();
    private File P1Src = new File("Hat1.png");
    private File P2Src = new File("Motorbike1.png");
    private File P3Src = new File("SpaceShip1.png");
    private File P4Src = new File("Chair1.png");
    private File P5Src = new File("Ship1.png");
    private File P6Src = new File("Tank1.png");
    private File P7Src = new File("Car1.png");
    private File P8Src = new File("Boot1.png");

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
        instance = this ;
        try {
            File imageSrc = new File("BoardGame.jpg");
            image = ImageIO.read(imageSrc);
            image = image.getScaledInstance(length, length, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }


        this.position = position;
        this.length = length;
        setPreferredSize(new Dimension(length, length));

        pawnList = new ArrayList<>();
        pawnFiles.add(P1Src);
        pawnFiles.add(P2Src);
        pawnFiles.add(P3Src);
        pawnFiles.add(P4Src);
        pawnFiles.add(P5Src);
        pawnFiles.add(P6Src);
        pawnFiles.add(P7Src);
        pawnFiles.add(P8Src);
        smallSide = length / 13;
        initialPosition = new Point(9 * smallSide - 20, 9 * smallSide - 20);
        gameEngine.subscribe(this);
        initializeSquarePositions();

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point clicked = new Point(e.getX(), e.getY());
                int squareIndex = findSquare(clicked);
                gameEngine.setChosenSquareIndex(squareIndex);
            }
        });
    }


    private void proccessPath(String message) {
        //path/[57, 58, 59, 60, 61, 62, 63]
        ArrayList<Integer> path = new ArrayList<Integer>();
        message = message.substring(6, message.length() - 1);
        message = message.replaceAll("\\s+", "");
        String[] parts = message.split(",");
        for (String string : parts) {
            path.add(Integer.parseInt(string));
        }
        currentPath = path;
    }

    @Override
    public void onEvent(String message) {
        if (message.equals("initializePawns")) {
            initializePawns();
            repaint();
        } else if (message.contains("path")) {
            proccessPath(message);
            pawnList.get(playerController.getCurrentPlayerIndex()).setPath(currentPath);
        } else if (message.contains("teleport")) {
            currentPath.clear();
            currentPath.add(playerController.getCurrentPlayer().getTargetPosition());
            playerController.getCurrentPlayer().setPosition(playerController.getCurrentPlayer().getTargetPosition());
            pawnList.get(playerController.getCurrentPlayerIndex()).setPath(currentPath);
        } else if (message.contains("refresh")) {
            repaint();
        } else if (message.contains("improve/")) {
            CommunicationController.getInstance().sendClientMessage(message);
        }
    }


    private Point[] createPointArray(Point startRightBottom, Point startLeftTop) {
        return new Point[]{new Point(startRightBottom.x, startRightBottom.y),
                new Point(startLeftTop.x, startLeftTop.y)};
    }

    private int findSquare(Point p) {
        for (int i = 0; i < squareMap.keySet().size(); i++) {
            Point rightBottom = squareMap.get(i)[0];
            Point leftTop = squareMap.get(i)[1];
            int rightBottomX = rightBottom.x;
            int rightBottomY = rightBottom.y;
            int leftTopX = leftTop.x;
            int leftTopY = leftTop.y;
            int x = p.x;
            int y = p.y;
            if (x > leftTopX && x < rightBottomX && y > leftTopY && y < rightBottomY)
                return i;
        }
        return -1;
    }

    public void initializeSquarePositions() {
        int x = smallSide;
        Point startRightBottom = new Point(13 * x, 13 * x); //(13x,13x)
        Point startLeftTop = new Point(11 * x, 11 * x); //(11x,11x)
        squareMap.put(0, createPointArray(startRightBottom, startLeftTop));

        //outer layer
        startRightBottom.x -= 2 * x; //(11x,13x)
        startLeftTop.x -= x; //(10x,11x)
        for (int i = 1; i < 9; i++) {
            squareMap.put(i, createPointArray(startRightBottom, startLeftTop));
            startRightBottom.x -= x;
            startLeftTop.x -= x;
        }
        squareMap.put(9, createPointArray(startRightBottom, startLeftTop)); // (2x,11x) + (3x,13x)

        startRightBottom.x -= x;//(2x,13x)
        startLeftTop.x -= 2 * x;//(0x,11x)
        squareMap.put(10, createPointArray(startRightBottom, startLeftTop));

        startRightBottom.y -= 2 * x; //(2x,11x)
        startLeftTop.y -= x;    //(0x,10x)
        for (int i = 11; i < 19; i++) {
            squareMap.put(i, createPointArray(startRightBottom, startLeftTop));
            startRightBottom.y -= x;
            startLeftTop.y -= x;
        }
        squareMap.put(19, createPointArray(startRightBottom, startLeftTop)); //(0x,2x) + (2x,3x)

        startRightBottom.y -= x;//(2x,2x)
        startLeftTop.y -= 2 * x; //(0x,0x)
        squareMap.put(20, createPointArray(startRightBottom, startLeftTop));

        startRightBottom.x += x; //(3x,2x)
        startLeftTop.x += 2 * x; // (2x,0x)
        for (int i = 21; i < 29; i++) {
            squareMap.put(i, createPointArray(startRightBottom, startLeftTop));
            startRightBottom.x += x; //(10x,2x)
            startLeftTop.x += x; //(11x,0x)
        }
        squareMap.put(29, createPointArray(startRightBottom, startLeftTop));

        startRightBottom.x += 2 * x; //(13x,2x)
        startLeftTop.x += x; //(11x,0x)
        squareMap.put(30, createPointArray(startRightBottom, startLeftTop));

        startRightBottom.y += x; //(13x,3x)
        startLeftTop.y += 2 * x; //(11x,2x)
        for (int i = 31; i < 39; i++) {
            squareMap.put(i, createPointArray(startRightBottom, startLeftTop));
            startRightBottom.y += x;
            startLeftTop.y += x;
        }
        squareMap.put(39, createPointArray(startRightBottom, startLeftTop));
    }
    public void initializePawns() {
        pawnList.forEach(pawn -> {
            pawn.delete();
            pawn = null;
        } );
        pawnList = new ArrayList<>();
        playerList = playerController.getPlayers();
        playerList.forEach(player -> addNewPawn(player, pawnFiles.get(player.getPlaceHolder())));
        repaint();
    }
    public void paint(Graphics g) {
        //g.setColor(color);
        g.fillRect(position.x, position.y, length, length);
        g.drawImage(image, position.x, position.y, length, length, null);

        drawBuildings(g);
    }
    public void addNewPawn(Player player, File file) {

        int xCoord = (squareMap.get(player.getTargetPosition())[0].x + squareMap.get(player.getTargetPosition())[1].x) / 2;
        int yCoord = (squareMap.get(player.getTargetPosition())[0].y + squareMap.get(player.getTargetPosition())[1].y) / 2;

        Point position = new Point(xCoord, yCoord);

        pawnList.add(new Pawn(position, player, file));
        repaint();
    }
    public void drawBuildings(Graphics g) {
        for (int i = 0; i < 40; i++) {
            Square currentSquare = gameEngine.getDomainBoard().getSquareAt(i);
            if (currentSquare != null && "PropertySquare".equals(currentSquare.getType())) {
                int numHouses = ((PropertySquare) currentSquare).numHouses();
                Point[] points = squareMap.get(i);
                Point center = new Point((points[0].x + points[1].x) / 2,
                        (points[0].y + points[1].y) / 2);
                if (numHouses != 0) {
                    if (numHouses == 1)
                        g.fillOval(center.x, center.y, 5, 5);
                    else if (numHouses == 2) {
                        g.fillOval(center.x, center.y, 5, 5);
                        g.fillOval(center.x - 6, center.y, 5, 5);
                    } else if (numHouses == 3) {
                        g.fillOval(center.x, center.y, 5, 5);
                        g.fillOval(center.x - 6, center.y, 5, 5);
                        g.fillOval(center.x - 12, center.y, 5, 5);
                    }
                }
            }
        }
    }

}