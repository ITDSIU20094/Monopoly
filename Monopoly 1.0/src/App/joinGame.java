package App;
import SettingWindow.PlayerAvatar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class joinGame extends JFrame {
    private int lastDiceOne;
    private int lastDiceTwo;
    private JTextArea playerInfoTextArea;


    public joinGame(){
        setTitle("Monopoly");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1200, 740));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        addGuiComponents();
    }

    public joinGame(PlayerAvatar avatar, int numPlayers, int numTurns) {

    }

    private void addGuiComponents() {
        JPanel jPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                BufferedImage backgroundImage;
                try {
                    InputStream inputStream = ImageService.class.getResourceAsStream("BoardGame.png");
                    backgroundImage = ImageIO.read(inputStream);
                    g.drawImage(backgroundImage,0,0,null);
                } catch (IOException e) {
                    System.out.println("Error loading background image: " + e);
                }
            }
        };
        jPanel.setLayout(null);

        // Dices
        JLabel diceOneImg = ImageService.loadImage("dice1.png");
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
        jPanel.add(rollButton);

        // Background Player
        JLabel backgroundPlayer = ImageService.loadImage("a2.png");
        backgroundPlayer.setBounds(600,100,400,600);
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

    private  void initializePlayerInfo(){
        playerInfoTextArea.append("Player 1: \n");
        playerInfoTextArea.append("Money: $1500\n");
        playerInfoTextArea.append("Properties: Park Place");
    }

    private void printLastRollDiceNumbers() {
        System.out.println("Last Roll Dice Numbers: " + lastDiceOne + ", " + lastDiceTwo);
    }
}