package App;
import SettingWindow.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Random;

public class Board extends JFrame implements Observer {
    private Image image;
    private File imageSrc = new File("BoardGame.png");

    private int lastDiceOne;
    private int lastDiceTwo;
    private JTextArea playerInfoTextArea;
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



    public Board() {
        setTitle("Monopoly");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1200, 740));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        addGuiComponents();
    }


    private void addGuiComponents() {
        JPanel jPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                BufferedImage backgroundImage;
                try {
                    InputStream inputStream = ImageService.class.getResourceAsStream("BoardGame.png");

                    backgroundImage = ImageIO.read(inputStream);
                    g.drawImage(backgroundImage, 0, 0, null);
                } catch (IOException e) {
                    System.out.println("Error loading background image: " + e);
                }
            }
        };
        jPanel.setLayout(null);

        // Dices
        /**JLabel diceOneImg = ImageService.loadImage("dice1.png");
        diceOneImg.setBounds(220, 250, 200, 200);
        jPanel.add(diceOneImg);

        JLabel diceTwoImg = ImageService.loadImage("dice2.png");
        diceTwoImg.setBounds(280, 250, 200, 200);
        jPanel.add(diceTwoImg);

        // Roll Button
        Random random = new Random();
        JButton rollButton = new JButton("Roll");
        rollButton.setBounds(870, 600, 90, 40);
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollButton.setEnabled(false);
                // roll 3 seconds
                long startTime = System.currentTimeMillis();
                Thread rollThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long endTime = System.currentTimeMillis();
                        try {
                            while ((endTime - startTime) / 1000F < 3) {
                                int diceOne = random.nextInt(1, 7);
                                int diceTwo = random.nextInt(1, 7);

                                lastDiceOne = diceOne;
                                lastDiceTwo = diceTwo;

                                // update dice images
                                ImageService.updateImage(diceOneImg, "dice" + diceOne + ".png");
                                ImageService.updateImage(diceTwoImg, "dice" + diceTwo + ".png");

                                repaint();
                                revalidate();

                                // sleep thread
                                Thread.sleep(60);
                                endTime = System.currentTimeMillis();
                            }

                            rollButton.setEnabled(true);
                            printLastRollDiceNumbers();
                        } catch (InterruptedException e) {
                            System.out.println("Threading Error: " + e);
                        }
                    }
                });
                rollThread.start();
            }
        });
        jPanel.add(rollButton);**/

        // Background Player
        JLabel backgroundPlayer = ImageService.loadImage("a2.png");
        backgroundPlayer.setBounds(600, 100, 400, 600);
        jPanel.add(backgroundPlayer);
        //

        //Table of Player
        playerInfoTextArea = new JTextArea();
        playerInfoTextArea.setEditable(false);
        playerInfoTextArea.setBounds(800, 250, 300, 200);
        playerInfoTextArea.setBackground(Color.lightGray);
        jPanel.add(playerInfoTextArea);
        initializePlayerInfo();
        //
        this.getContentPane().add(jPanel);
    }
    public int getLastValues(){
        return lastDiceOne + lastDiceTwo ;
    }

    private void initializePlayerInfo() {
        playerInfoTextArea.append("Player 1: \n");
        playerInfoTextArea.append("Money: $1500\n");
        playerInfoTextArea.append("Properties: Park Place");
    }

    private void printLastRollDiceNumbers() {
        System.out.println("Last Roll Dice Numbers: " + lastDiceOne + ", " + lastDiceTwo);
    }

    @Override
    public void onEvent(String message) {

    }

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
        try {
            image = ImageIO.read(imageSrc);
            image = image.getScaledInstance(length, length, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        instance = this;

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
    /**public void paint(Graphics g) {
        //g.setColor(color);
        g.fillRect(position.x, position.y, length, length);
        g.drawImage(image, position.x, position.y, length, length, null);

        drawBuildings(g);
    }**/
    public void addNewPawn(Player player, File file) {

        int xCoord = (squareMap.get(player.getTargetPosition())[0].x + squareMap.get(player.getTargetPosition())[1].x) / 2;
        int yCoord = (squareMap.get(player.getTargetPosition())[0].y + squareMap.get(player.getTargetPosition())[1].y) / 2;

        Point position = new Point(xCoord, yCoord);

        pawnList.add(new Pawn(position, player, file));
        repaint();
    }
    public void drawBuildings(Graphics g) {

    }

}