package UI;

import Domain.Controller.CommunicationController;
import Domain.Controller.PlayerController;
import Domain.Model.GameEngine;
import Domain.Model.Player;
import Domain.Observer;
import Domain.Server.ServerInfo;
import Utils.ColorSet;

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
import java.util.*;
import java.util.List;
import java.util.Random;
public class ServerWindow extends JPanel implements Observer{
    private JButton startGame, addPlayer, loadGame, quitServer, rightButton, leftButton;
    private CommunicationController communicationController = CommunicationController.getInstance();
    private PlayerController playerController = PlayerController.getInstance();
    private GameEngine gameEngine = GameEngine.getInstance();

    private Navigator navigator = Navigator.getInstance();
    private JPanel buttonPanel, playerPanel, cPanel, pPanel;
    private JScrollPane scrollPane;
    private JTextField textField;

    private ArrayList<CustomButton> bList = new ArrayList<CustomButton>();
    private ArrayList<Image> pawnImages = new ArrayList<Image>();
    private ArrayList<File> pawnFiles = new ArrayList<File>();
    private int cnt = 0;
    private int countMod = 0;
    private int buttonHeight = 40;
    private int buttonWidth = 180;


    private int pButtonHeight = 50;
    private int pButtonWidth = 200;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    @Override
    public void onEvent(String message) {

    }
}
