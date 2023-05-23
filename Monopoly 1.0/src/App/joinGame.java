package App;
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

//    public joinGame() {
//        setTitle("Monopoly");
//        ImageIcon imageIcon = new ImageIcon("Image/Board.jpg");
//        JLabel imageLabel = new JLabel(imageIcon);
//        imageLabel.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
//
//        JLayeredPane layeredPane = new JLayeredPane();
//        layeredPane.setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
//        layeredPane.add(imageLabel, Integer.valueOf(0));
//
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(1200, 740);
//        setLocationRelativeTo(null);
//        getContentPane().add(layeredPane);
//    }

    public joinGame(){
        setTitle("Monopoly");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1200, 740));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        addGuiComponents();
    }


    private void addGuiComponents() {
        JPanel jPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                BufferedImage backgroundImage;
                try {
                    InputStream inputStream = ImageService.class.getResourceAsStream("Board.jpg");
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
        diceOneImg.setBounds(800, 200, 200, 200);
        jPanel.add(diceOneImg);

        JLabel diceTwoImg = ImageService.loadImage("dice2.png");
        diceTwoImg.setBounds(860, 200, 200, 200);
        jPanel.add(diceTwoImg);

        // Roll Button
        Random random = new Random();
        JButton rollButton = new JButton("Roll");
        rollButton.setBounds(870, 350, 120, 50);
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
        this.getContentPane().add(jPanel);
    }

    private void printLastRollDiceNumbers() {
        System.out.println("Last Roll Dice Numbers: " + lastDiceOne + ", " + lastDiceTwo);
    }
}