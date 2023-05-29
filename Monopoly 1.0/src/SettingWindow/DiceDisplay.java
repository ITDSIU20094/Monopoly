package SettingWindow;

import App.RegularDie;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DiceDisplay extends JPanel implements Observer {
    private RegularDie regularDie = RegularDie.getInstance();

    private GameEngine gameEngine = GameEngine.getInstance();
    private JPanel regular1Panel, regular2Panel;
    private int panelSize = 40;
    private ImageIcon dispDie1, dispDie2;
    private JLabel buffer1, buffer2;
    private int regDie1, regDie2;
    private Image  die1, die2, die3, die4, die5, die6;
    private File die1Src = new File("die1.png");
    private File die2Src = new File("die2.png");
    private File die3Src = new File("die3.png");
    private File die4Src = new File("die4.png");
    private File die5Src = new File("die5.png");
    private File die6Src = new File("die6.png");
    private ArrayList<Image> diceImages = new ArrayList<Image>();

    public DiceDisplay() {
        this.setLayout(new BorderLayout());
        this.setMaximumSize(new Dimension(4 * panelSize, panelSize));
        this.setBackground(Color.pink);

        Dimension panelSizeSquare = new Dimension(panelSize, panelSize);

        initDiceImages();
        regular1Panel = new JPanel();
        regular2Panel = new JPanel();

        regular1Panel.setMaximumSize(panelSizeSquare);
        //regular1Panel.setBackground(Color.RED);
        regular1Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        dispDie1 = new ImageIcon(diceImages.get(regDie1));

        buffer1 = new JLabel();
        buffer1.setIcon(dispDie1);
        regular1Panel.add(buffer1);
        this.add(regular1Panel, BorderLayout.WEST);

        regular2Panel.setMaximumSize(panelSizeSquare);
        //regular2Panel.setBackground(Color.GREEN);
        regular2Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        dispDie2 = new ImageIcon(diceImages.get(regDie2));
        buffer2 = new JLabel();
        buffer2.setIcon(dispDie2);
        regular2Panel.add(buffer2);
        this.add(regular2Panel, BorderLayout.CENTER);

        gameEngine.subscribe(this::onEvent);
    }
    public void initDiceImages() {
        try {
            die1 = ImageIO.read(die1Src);
            die1 = die1.getScaledInstance(((BufferedImage) die1).getWidth() / 15, ((BufferedImage) die1).getHeight() / 15, Image.SCALE_SMOOTH);
            diceImages.add(die1);
            die2 = ImageIO.read(die2Src);
            die2 = die2.getScaledInstance(((BufferedImage) die2).getWidth() / 15, ((BufferedImage) die2).getHeight() / 15, Image.SCALE_SMOOTH);
            diceImages.add(die2);
            die3 = ImageIO.read(die3Src);
            die3 = die3.getScaledInstance(((BufferedImage) die3).getWidth() / 15, ((BufferedImage) die3).getHeight() / 15, Image.SCALE_SMOOTH);
            diceImages.add(die3);
            die4 = ImageIO.read(die4Src);
            die4 = die4.getScaledInstance(((BufferedImage) die4).getWidth() / 15, ((BufferedImage) die4).getHeight() / 15, Image.SCALE_SMOOTH);
            diceImages.add(die4);
            die5 = ImageIO.read(die5Src);
            die5 = die5.getScaledInstance(((BufferedImage) die5).getWidth() / 15, ((BufferedImage) die5).getHeight() / 15, Image.SCALE_SMOOTH);
            diceImages.add(die5);
            die6 = ImageIO.read(die6Src);
            die6 = die6.getScaledInstance(((BufferedImage) die6).getWidth() / 15, ((BufferedImage) die6).getHeight() / 15, Image.SCALE_SMOOTH);
            diceImages.add(die6);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void paint() {
        //diceValues.setText("Total of dice: "+ regularDie.getLastValues().toString());
        if (regularDie.getLastValues().size() != 0) {
            regDie1 = regularDie.getLastValues().get(0);
            regDie2 = regularDie.getLastValues().get(1);
        } else {
            regDie1 = 0;
            regDie2 = 0;
        }


        dispDie1 = new ImageIcon(diceImages.get(regDie1));
        buffer1 = new JLabel();
        buffer1.setIcon(dispDie1);
        regular1Panel.removeAll();
        regular1Panel.add(buffer1);


        dispDie2 = new ImageIcon(diceImages.get(regDie2));
        buffer2 = new JLabel();
        buffer2.setIcon(dispDie2);
        regular2Panel.removeAll();
        regular2Panel.add(buffer2);

        repaint();
    }


    @Override
    public void onEvent(String message) {
        if (message.equals("refresh")) {
            this.paint();
        }
    }
}
