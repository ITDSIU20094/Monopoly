package SettingWindow;


import App.joinGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;
import javax.swing.*;


public class Setting extends JFrame {
    private static PlayerAvatar avatar;
    private static int numPlayers;
    private static int numTurns;
    private JButton playbtn;
    private JButton defaultbtn;
    private JLabel backgroundLabel;
    private JComboBox jComboBox1;
    private JSlider jSlider1;
    private JSlider jSlider2;
    public Setting() {
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        JButton defaultbtn = new JButton();
        JButton playbtn = new JButton();
        JLabel jLabel2 = new JLabel();

        jComboBox1  = new JComboBox<>();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        jSlider1 = new JSlider();
        jSlider2 = new JSlider();
        JLabel jLabel5 = new JLabel();
        JScrollPane jScrollPane2 = new JScrollPane();
        JTextArea jTextArea2 = new JTextArea();
        JLabel jLabel6 = new JLabel();
        JLabel jLabel7 = new JLabel();
        JLabel jLabel8 = new JLabel();
        JLabel jLabel9 = new JLabel();
        JLabel jLabel10 = new JLabel();
        JLabel jLabel11 = new JLabel();
        JLabel jLabel12 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Setting");
        jLabel1.setToolTipText("");

        defaultbtn.setText("Default");
        defaultbtn.addActionListener(this::defaultbtnActionPerformed);

        playbtn.setText("Play Game");
        playbtn.addActionListener(this::playbtnActionPerformed);

        jLabel2.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        jLabel2.setText("Number of Players :");

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Tank", "Ship", "SpaceShip", "Motorbike","Boot","Car", "Chair","Hat"}));
        jComboBox1.setRenderer(new ImageComboBoxRenderer());
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        jLabel3.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        jLabel3.setText("Player Avatar :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        jLabel4.setText("Number of Turns :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        jLabel5.setText("Game Rule");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("- Monopoly, real-estate board game for two to four players,\n in which the player’s goal is to remain financially solvent \nwhile forcing opponents into bankruptcy by buying and developing \npieces of property.\n- Each side of the square board is divided into 10 small rectangles\n representing specific game function such as prison, bus station and\n various other places.\n- At the start of the game, each player is given a fixed amount of play\n money; the players then move around the board according to the \nthrow of a pair of dice. Any player who lands on an unowned property\n may buy it, but, if he or she lands on a property owned by another\n player, rent must be paid to that player. \n- Certain nonproperty squares require the player landing on them\n to draw a card that may be favorable or unfavorable. If a player \nacquires a monopoly—that is, all of a particular group of properties-\nthat player may purchase improvements for those properties;\n improvements add substantially to a property’s rental fee.\n - A player continues to travel around the board until he or she is bankrupt. \nBankruptcy results in elimination from the game. The last player \nremaining on the board is the winner.\n- There are some special case make player win and end the game even \nthough he or she is not the last player.\n3.2 Special Win Game Rule\nPlayer will win the game if:\n- Player has buildings which are located on one of four square sides \n- Player has four beaches.\n- Player has a highest property when the number of turns equals the\n chosen limitation of turn\n");
        jScrollPane2.setViewportView(jTextArea2);

        jLabel6.setText("1");

        jLabel7.setText("2");

        jLabel8.setText("4");

        jLabel9.setText("3");

        jLabel10.setText("40");

        jLabel11.setText("30");

        jLabel12.setText("50");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel4))
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(27, 27, 27)
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jSlider1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(defaultbtn)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                        .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                                                                                        .addGap(73, 73, 73)
                                                                                        .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(jSlider2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(35, 35, 35)
                                                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(42, 42, 42)
                                                                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(45, 45, 45)
                                                                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(69, 69, 69)
                                                                .addComponent(playbtn))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                .addGap(305, 305, 305))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(162, 162, 162))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))
                                                .addGap(72, 72, 72)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel9))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jSlider1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(49, 49, 49)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel11)
                                                        .addComponent(jLabel12))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jSlider2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(defaultbtn)
                                        .addComponent(playbtn))
                                .addGap(21, 21, 21))
        );

        jSlider1.setMinimum(1);
        jSlider1.setMaximum(4);
        jSlider1.setPaintTicks(true);
        jSlider1.setPaintTrack(true);
        jSlider1.setMajorTickSpacing(1);
        jSlider1.setPaintLabels(true);
        jSlider2.setMinimum(30);
        jSlider2.setMaximum(50);
        jSlider2.setMajorTickSpacing(10);
        jSlider2.setPaintTrack(true);
        jSlider2.setPaintTicks(true);
        jSlider2.setMinorTickSpacing(1);
        jSlider2.setPaintLabels(true);


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );


        pack();
    }

    private void playbtnActionPerformed(ActionEvent event) {
        if (event.getSource() == playbtn) {
            String selectedAvatar = (String) jComboBox1.getSelectedItem();
            int numPlayers = jSlider1.getValue();
            int numTurns = jSlider2.getValue();

            PlayerAvatar avatar = new PlayerAvatar(selectedAvatar);
            Setting.setAvatar(avatar);
            Setting.setNumPlayers(numPlayers);
            Setting.setNumTurns(numTurns);
            // Thực hiện các thao tác khởi chạy trò chơi ở đây
            //Game game = new joinGame(avatar, numPlayers, numTurns);
            //game.start();
        }
    }

    private void defaultbtnActionPerformed(ActionEvent e) {
        if (e.getSource() == defaultbtn ) {
            PlayerAvatar defaultAvatar = new PlayerAvatar("hat.png");
            int defaultNumPlayers = 4;
            int defaultNumTurns = 30;

            //Game game = new Game(defaultAvatar, defaultNumPlayers, defaultNumTurns);
            //game.start();
        }
    }

    private void jComboBox1ActionPerformed(ActionEvent e) {

        String selectedValue = (String) jComboBox1.getSelectedItem();
            if (jComboBox1 != null) {
                selectedValue = selectedValue.trim();
                int dotIndex = selectedValue.lastIndexOf(".");
                if (dotIndex > 0) {
                    selectedValue = selectedValue.substring(0, dotIndex);
                }
                jComboBox1.setSelectedItem(selectedValue);
                switch (selectedValue) {
                    case "Tank1.png" -> {
                // Set AvatarPlayer image to "Tank.png"
                        ImageIcon avatarIcon = new ImageIcon(getClass().getResource("/Pawn/Tank1.png"));
                        avatar.setIcon(avatarIcon);

                }
                    case "Hat1.png" -> {
                        ImageIcon avatarIcon = new ImageIcon(getClass().getResource("/Pawn/Hat1.png"));
                        avatar.setIcon(avatarIcon);
                }
                    case "Car1.png" -> {
                        ImageIcon avatarIcon = new ImageIcon(getClass().getResource("/Pawn/Car1.png"));
                        avatar.setIcon(avatarIcon);
                }
                    case "Chair1.png" -> {
                        ImageIcon avatarIcon = new ImageIcon(getClass().getResource("/Pawn/Chair1.png"));
                        avatar.setIcon(avatarIcon);
                }
                    case "Boot1.png" -> {
                        ImageIcon avatarIcon = new ImageIcon(getClass().getResource("/Pawn/Boot1.png"));
                        avatar.setIcon(avatarIcon);
                }
                    case "Motorbike1.png" -> {
                        ImageIcon avatarIcon = new ImageIcon(getClass().getResource("/Pawn/Motorbike1.png"));
                        avatar.setIcon(avatarIcon);
                }
                    case "Ship1.png" -> {
                        ImageIcon avatarIcon = new ImageIcon(getClass().getResource("/Pawn/Ship1.png"));
                        avatar.setIcon(avatarIcon);
                }
                    case "SpaceShip1.png" -> {
                        ImageIcon avatarIcon = new ImageIcon(getClass().getResource("/Pawn/SpaceShip1.png"));
                        avatar.setIcon(avatarIcon);
                }
            }
        }
    }
    public static void setAvatar(PlayerAvatar avatar){
        Setting.avatar = avatar;
    }
    public static void setNumPlayers(int numPlayers) {
        Setting.numPlayers = numPlayers;
    }

    public static void setNumTurns(int numTurns) {
        Setting.numTurns = numTurns;
    }

}

