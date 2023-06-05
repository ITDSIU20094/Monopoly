package UI;

import Domain.Controller.CommunicationController;
import Domain.Model.GameEngine;
import Domain.Observer;
import Domain.Server.ServerInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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

        JPanel enterpane = new JPanel();
        enterpane.setPreferredSize(new Dimension(width, 50));
        enterpane.setOpaque(false);

        textEnter = new JTextField();
        textEnter.setPreferredSize(new Dimension(width - 110, 30));
        ActionListener actionListener = e -> {
            if (textEnter.getText() != "") {
                String message = textEnter.getText();
                if(message.length()>180)
                    message = message.substring(0,100);
                //communicationController.sendClientMessage("message/" + messageWithCilent(message));
            }
        };


    }

    @Override
    public void onEvent(String message) {

    }
 //   public String messageWithClient(String message) {
        //String client = ServerInfo.getInstance().getClientID();
        //return "Computer " + (ServerInfo.getInstance().getClientList().indexOf(client) + 1) + " : " + message;

 //   }
}
