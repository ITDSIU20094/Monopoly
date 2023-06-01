package UI;

import Domain.Controller.CommunicationController;
import Domain.Model.GameEngine;
import Domain.Observer;

import javax.swing.*;
import java.awt.*;

public class MessageBox extends JPanel implements Observer {
    private JScrollPane scrollpane;
    private JTextField textEnter;
    private JButton submit;
    private JPanel panel;
    private CommunicationController communicationController = CommunicationController.getInstance();
    private GameEngine gameEngine = GameEngine.getInstance();

    public MessageBox(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.setOpaque(false);
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        panel.setBackground(Color.WHITE);
        panel.validate();
        scrollpane = new JScrollPane();
        scrollpane.setOpaque(false);
        scrollpane.setPreferredSize(new Dimension(width, height - 100));
        //scrollpane.setBounds(0,0,500,200);

        JPanel contentPane = new JPanel();
        contentPane.setOpaque(false);
        contentPane.setPreferredSize(new Dimension(width, height - 100));
        contentPane.add(scrollpane);
        this.add(contentPane);


    }

    @Override
    public void onEvent(String message) {

    }
}
