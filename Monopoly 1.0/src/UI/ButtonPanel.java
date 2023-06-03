package UI;

import Domain.Controller.CommunicationController;
import Domain.Model.GameEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    protected JButton purchaseButton;
    protected JButton drawButton;
    protected JButton playCardButton;
    protected JButton improveButton;
    protected JButton rollDice;
    protected JButton endTurn;
    protected JButton pauseButton;
    private Panel pausePanel;
    private CommunicationController communicationController = CommunicationController.getInstance();

    private GameEngine gameEngine = GameEngine.getInstance();

    public ButtonPanel() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        setOpaque(false);
        purchaseButton = new JButton("Buy");
        //purchaseButton = new CustomButton("Buy Property");
        drawButton = new JButton("Draw card");
        playCardButton = new JButton("Play card");
        improveButton = new JButton("Improve Property");
        rollDice = new JButton("Roll Dice");
        endTurn = new JButton("End Turn");
        pauseButton = new JButton("Pause");

        panel.add(rollDice);
        panel.add(endTurn);
        panel.add(purchaseButton, BorderLayout.CENTER);
        panel.add(drawButton);
        panel.add(playCardButton);
        panel.add(improveButton);
        panel.add(pauseButton);

        pausePanel = new Panel();

        this.setMaximumSize(panel.getMaximumSize());

        this.add(panel);

        purchaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("purchase");
                communicationController.sendClientMessage("purchase");
                purchaseButton.setEnabled(false);
            }
        });

        drawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("drawCard");
                communicationController.sendClientMessage("card/draw");
                drawButton.setEnabled(false);
            }
        });

        playCardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                communicationController.sendClientMessage("playCard");
                playCardButton.setEnabled(false);
            }
        });

        improveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                communicationController.sendClientMessage("improveProperty");
            }
        });



        rollDice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameEngine.rollDice();
                communicationController.sendClientMessage("dice/" + gameEngine.getLastDiceValues());
                rollDice.setEnabled(false);
            }
        });

        endTurn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                communicationController.sendClientMessage("player/next");
                endTurn.setEnabled(false);
                purchaseButton.setEnabled(false);
                improveButton.setEnabled(false);
            }
        });

        purchaseButton.setEnabled(false);
        endTurn.setEnabled(false);
        drawButton.setEnabled(false);
        playCardButton.setEnabled(false);
        improveButton.setEnabled(false);
        rollDice.setEnabled(false);
        pauseButton.setEnabled(true);
        this.setVisible(true);

    }
}
