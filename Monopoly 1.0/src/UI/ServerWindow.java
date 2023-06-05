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
    private Image background, rightButtonImg, leftButtonImg, p1, p2, p3, p4, p5, p6,p7,p8;
    private File backgroundSrc = new File("background_menu.png");
    private File RBISrc = new File("b1.png");
    private File LBISrc = new File("b2.png");
    private File P1Src = new File("Hat1.png");
    private File P2Src = new File("Motorbike1.png");
    private File P3Src = new File("SpaceShip1.png");
    private File P4Src = new File("Chair1.png");
    private File P5Src = new File("Ship1.png");
    private File P6Src = new File("Tank1.png");
    private File P7Src = new File("Car1.png");
    private File P8Src = new File("Boot1.png");
    private List<ClientDisplay> clientDisplayList;

    private ImageIcon dispImg;
    private Image logo;
    private File logoSrc = new File("monopolyLogo-in.png");
    JLabel back, buffer, logoIcon;

    private boolean botBox = false;
    public ServerWindow() {
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(buttonWidth, 4* buttonHeight));
        buttonPanel.setOpaque(false);
        this.add(buttonPanel);
        addButtons(buttonPanel);

        gameEngine.subscribe(this);

        try {
            logo = ImageIO.read(logoSrc);
            logo = logo.getScaledInstance(600,400,Image.SCALE_SMOOTH);
            background = ImageIO.read(backgroundSrc);
            background = background.getScaledInstance(screenSize.width,screenSize.height,Image.SCALE_SMOOTH);
        } catch (IOException e){
            e.printStackTrace();
        }

        createClientDisplay();
        createPlayerDisplay();

        ImageIcon backgroundIcon = new ImageIcon(background);

        ImageIcon logoImage = new ImageIcon(logo);
        logoIcon = new JLabel();
        logoIcon.setIcon(logoImage);
        add(logoIcon);
        back = new JLabel();
        back.setIcon(backgroundIcon);
        add(back);
        this.setOpaque(false);
    }

    private void addButtons(JPanel panel) {
        startGame = new CustomButton("Start Game");
        startGame.setToolTipText("Start the Game");
        startGame.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startServer();
                System.out.println("Game started with "+ GameEngine.getInstance().getPlayerController().getPlayers().size() + "players." );
            }
        });
        panel.add(startGame);
    }
    private void startServer() {
        communicationController.sendClientMessage("game/start");
    }
    /**public List<ClientDisplay> createClientDisplay() {
        List<String> clientList = serverInfo.getClientList();
        clientDisplayList = new ArrayList<>();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        for (int i = 0; i < clientList.size(); i++) {
            if (i % 2 == 0) {
                ClientDisplay clientDisplay = new ClientDisplay("Computer " + (i + 1), new Point(50, i * (height - 200) / 12 + 100), ColorSet.getPlayerColors().get(i));
                clientDisplayList.add(clientDisplay);
            } else {
                ClientDisplay clientDisplay = new ClientDisplay("Computer " + (i + 1), new Point(300, (i - 1) * (height - 200) / 12 + 100), ColorSet.getPlayerColors().get(i));
                clientDisplayList.add(clientDisplay);
            }
        }
        return clientDisplayList;
    }**/
    private int generateRandomID() {
        Random random = new Random();
        return random.nextInt(1,4);
    }

    public List<ClientDisplay> createClientDisplay() {
        List<String> clientList = getIDList();
        clientDisplayList = new ArrayList<>();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        for (int i = 0; i < clientList.size(); i++) {
            if (i % 2 == 0) {
                ClientDisplay clientDisplay = new ClientDisplay("Computer " + (i + 1), new Point(50, i * (height - 200) / 12 + 100), ColorSet.getPlayerColors().get(i));
                clientDisplayList.add(clientDisplay);
            } else {
                ClientDisplay clientDisplay = new ClientDisplay("Computer " + (i + 1), new Point(300, (i - 1) * (height - 200) / 12 + 100), ColorSet.getPlayerColors().get(i));
                clientDisplayList.add(clientDisplay);
            }
        }
        return clientDisplayList;
    }
    public void addClient() {
        createClientDisplay();
    }

    public void createPlayerDisplay() {
        int paneWidth = pButtonWidth + 53;
        int paneHeight = 6*(pButtonHeight + 5);
        playerPanel = new JPanel();
        playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
        playerPanel.setBackground(ColorSet.SERVERBACKGROUND_LIGHT);
        cPanel = new JPanel();
        cPanel.setPreferredSize(new Dimension(paneWidth, 500));
        cPanel.setOpaque(false);
        scrollPane = new JScrollPane(playerPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(paneWidth,paneHeight));
        scrollPane.setBorder(BorderFactory.createLineBorder(ColorSet.SERVERBACKGROUND_LIGHT,2,true));
        initTextField();
        initPawnImages();
        addPlayer = new CustomButton("Add Player");
        addPlayer.setToolTipText("Press to add your player!");
        addPlayer.setPreferredSize(new Dimension(230,buttonHeight));
        addPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText() != null && !textField.getText().equals("Enter player name here!") && !textField.getText().equals("")){
                    int randomID = Player.generateRandomID();
                    Player player = new Player(textField.getText(),randomID,countMod);
                    player.setPerson();
                    if(botBox) {
                        player.setBot();
                        player.setBotBehaviourNumber();
                        player.setClientID("bot");
                    }
                    communicationController.sendClientMessage(player);
                    textField.setText("Enter player name here!");

                }
            }
        });
        JPanel checkBox = new JPanel();
        checkBox.setPreferredSize(new Dimension(230, 30));
        checkBox.setOpaque(false);

        JCheckBox botCheckBox = new JCheckBox("Bot Player");
        botCheckBox.setFont(new Font("Tahoma", Font.BOLD,20));
        botCheckBox.setForeground(ColorSet.ButtonPrimary);
        botCheckBox.setIcon(new SimpleCheckboxStyle(20));
        botCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botBox = !botBox;
            }
        });
        checkBox.add(botCheckBox,BorderLayout.WEST);

        initSelectionButtons();
        cPanel.add(textField);
        cPanel.add(checkBox);
        cPanel.add(leftButton);
        cPanel.add(pPanel);
        cPanel.add(rightButton);
        cPanel.add(addPlayer);
        this.add(scrollPane);
        this.add(cPanel);

    }
    public void initTextField(){
        textField = new JTextField("Enter player name here!");
        textField.setPreferredSize(new Dimension(230, 50));
        textField.setFont(new Font("Corbel", Font.PLAIN, 15));
        textField.setBackground(ColorSet.SERVERBACKGROUND_LIGHT);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                textField.setText("");
            }

        });
    }
    public void initPawnImages(){
        try {
            p1 = ImageIO.read(P1Src);
            p1 = p1.getScaledInstance(((BufferedImage) p1).getWidth() / 8, ((BufferedImage) p1).getHeight() /8,Image.SCALE_SMOOTH);
            pawnImages.add(p1);
            pawnFiles.add(P1Src);
            p2 = ImageIO.read(P2Src);
            p2 = p2.getScaledInstance(((BufferedImage) p2).getWidth() / 8, ((BufferedImage) p2).getHeight() / 8, Image.SCALE_SMOOTH);
            pawnImages.add(p2);
            pawnFiles.add(P2Src);
            p3 = ImageIO.read(P3Src);
            p3 = p3.getScaledInstance(((BufferedImage) p3).getWidth() / 8, ((BufferedImage) p3).getHeight() / 8, Image.SCALE_SMOOTH);
            pawnImages.add(p3);
            pawnFiles.add(P3Src);
            p4 = ImageIO.read(P4Src);
            p4 = p4.getScaledInstance(((BufferedImage) p4).getWidth() / 8, ((BufferedImage) p4).getHeight() / 8, Image.SCALE_SMOOTH);
            pawnImages.add(p4);
            pawnFiles.add(P4Src);
            p5 = ImageIO.read(P5Src);
            p5 = p5.getScaledInstance(((BufferedImage) p5).getWidth() / 8, ((BufferedImage) p5).getHeight() / 8, Image.SCALE_SMOOTH);
            pawnImages.add(p5);
            pawnFiles.add(P5Src);
            p6 = ImageIO.read(P6Src);
            p6 = p6.getScaledInstance(((BufferedImage) p6).getWidth() / 8, ((BufferedImage) p6).getHeight() / 8, Image.SCALE_SMOOTH);
            pawnImages.add(p6);
            pawnFiles.add(P6Src);
            p7 = ImageIO.read(P7Src);
            p7 = p6.getScaledInstance(((BufferedImage) p7).getWidth() / 8, ((BufferedImage) p7).getHeight() / 8, Image.SCALE_SMOOTH);
            pawnImages.add(p7);
            pawnFiles.add(P7Src);
            p8 = ImageIO.read(P8Src);
            p8 = p8.getScaledInstance(((BufferedImage) p8).getWidth() / 8, ((BufferedImage) p8).getHeight() / 8, Image.SCALE_SMOOTH);
            pawnImages.add(p8);
            pawnFiles.add(P8Src);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initSelectionButtons(){
        rightButton = new JButton();
        leftButton = new JButton();
        try {
            rightButtonImg = ImageIO.read(RBISrc);
            rightButtonImg = rightButtonImg.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
            rightButton.setIcon(new ImageIcon(rightButtonImg));
            leftButtonImg = ImageIO.read(LBISrc);
            leftButtonImg = leftButtonImg.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
            leftButton.setIcon(new ImageIcon(leftButtonImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pPanel = new JPanel();
        pPanel.setPreferredSize(new Dimension(100,45));
        pPanel.setBackground(ColorSet.SERVERBACKGROUND_LIGHT);
        pPanel.setBorder(BorderFactory.createLineBorder(ColorSet.ButtonPrimary,2,true));
        dispImg = new ImageIcon(pawnImages.get(countMod));
        buffer = new JLabel();
        buffer.setIcon(dispImg);
        pPanel.add(buffer);
        rightButton.setBorder(null);
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cnt++;
                countMod = cnt % pawnImages.size();
                cnt = countMod;
                dispImg = new ImageIcon(pawnImages.get(countMod));

                buffer.setIcon(dispImg);
                validate();
                repaint();
            }
        });
        leftButton.setBorder(null);
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cnt--;
                countMod = (cnt + pawnImages.size()) % pawnImages.size();
                cnt = countMod;
                dispImg = new ImageIcon(pawnImages.get(countMod));
                buffer.setIcon(dispImg);
                validate();
                repaint();
            }
        });
    }
    public void updateButtonColor() {
        playerPanel.removeAll();
        playerPanel.validate();
        repaint();
        ArrayList<Player> pList = PlayerController.getInstance().getPlayers();
        for (Player player : pList) {
            addPlayerButton(player);
        }
        playerPanel.validate();
        repaint();
    }
    private List<String> getIDList() {
        List<String> idList = new ArrayList<>();
        List<Player> players = PlayerController.getInstance().getPlayers();
        for (Player player : players) {
            int id = player.getID(generateRandomID());
            idList.add(String.valueOf(id));
        }

        return idList;
    }
    public void addPlayerButton(Player player) {
        List<String> idList = getIDList();
        CustomButton newButton = new CustomButton(player.getName());
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player.getID(generateRandomID());
                player.setPerson();
                communicationController.sendClientMessage(PlayerController.getInstance());
            }
        });
        int clientPosition = getIDList().indexOf(player.getID(generateRandomID()));
        if (clientPosition == -1) {
            clientPosition = 12;
            player.setPerson();
            player.setBot();
        }
        newButton.setPrimaryColor(ColorSet.getPlayerColors().get(clientPosition));
        newButton.setPreferredSize(new Dimension(pButtonWidth + 47, pButtonHeight));
        newButton.setMaximumSize(new Dimension(pButtonWidth + 47, pButtonHeight));
        newButton.setMinimumSize(new Dimension(pButtonWidth + 47, pButtonHeight));
        bList.add(newButton);

        playerPanel.add(newButton);
        playerPanel.add(Box.createRigidArea(new Dimension(5, 5)));

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }
    public void addPlayer() {
        ArrayList<Player> pList = playerController.getPlayers();
        if (pList.size() > 0) {
            Player player = pList.get(pList.size() - 1);
            addPlayerButton(player);
        }
    }
    public void paint(Graphics g) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        super.paint(g);
        //g.drawImage(background, 0, 0, null);
        back.setLocation(0, 0);
        clientDisplayList.forEach(clientDisplay -> clientDisplay.paint(g));
        //bList.forEach(customButton -> customButton.paint(g));
        buttonPanel.setLocation((screenSize.width - buttonPanel.getWidth()) / 2, 400);
        scrollPane.setLocation((screenSize.width) / 4 * 3, screenSize.height / 2 - 270);
        cPanel.setLocation((screenSize.width) / 4 * 3, scrollPane.getHeight() + scrollPane.getY());

        Point position = new Point((screenSize.width - logo.getWidth(null)) / 2, 0);
        logoIcon.setLocation(position.x, position.y);
    }
    @Override
    public void onEvent(String message) {
        if (message.equals("newClient")) {
            this.addClient();
            repaint();
        } else if (message.equals("newPlayer")) {
            addPlayer();
        } else if (message.equals("refreshPlayerDisplay")) {
            //playerController = PlayerController.getInstance();
            //addOtherPlayers();
            updateButtonColor();
            repaint();
        }
    }
}

class ClientDisplay {
    String clientName;
    Point position;
    int width = 200;
    int height = 80;
    Random rand = new Random();
    Color clientColor;
    ClientDisplay(String name, Point position, Color color) {
        clientName = name;
        this.position = position;
        clientColor = color;
    }
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(clientColor);
        g2.setFont(new Font("Corbel", Font.PLAIN, 20));
        g2.drawString(clientName, position.x + 50, position.y + height / 2);
        g2.setStroke(new BasicStroke(2.0F));
        g2.drawRoundRect(position.x, position.y, width, height, 5, 5);
    }
}
class SimpleCheckboxStyle implements Icon {

    int dimension = 10;

    public SimpleCheckboxStyle(int dimension) {
        this.dimension = dimension;
    }

    protected int getDimension() {
        return dimension;
    }

    public void paintIcon(Component component, Graphics g, int x, int y) {
        ButtonModel buttonModel = ((AbstractButton) component).getModel();

        int y_offset = (int) (component.getSize().getHeight() / 2) - (int) (getDimension() / 2);
        int x_offset = 2;

        if (buttonModel.isRollover()) {
            g.setColor(new Color(0, 60, 120));
        } else if (buttonModel.isRollover()) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(Color.DARK_GRAY);
        }

        g.setColor(ColorSet.ButtonPrimary);
        int fontsize = 20;
        g.fillRect(x_offset, y_offset, fontsize, fontsize);

        if (buttonModel.isPressed()) {
            g.setColor(ColorSet.ButtonPrimary);
        } else if (buttonModel.isRollover()) {
            g.setColor(new Color(240, 240, 250));
        } else {
            g.setColor(Color.WHITE);
        }
        g.fillRect(1 + x_offset, y_offset + 1, fontsize - 2, fontsize - 2);
        if (buttonModel.isSelected()) {
            int r_x = 1;
            g.setColor(ColorSet.ButtonPrimary);
            g.fillRect(x_offset + r_x + 3, y_offset + 3 + r_x, fontsize - (7 + r_x), fontsize - (7 + r_x));
        }
    }

    public int getIconWidth() {
        return getDimension();
    }

    public int getIconHeight() {
        return getDimension();
    }
}
