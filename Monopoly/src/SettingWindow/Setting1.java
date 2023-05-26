package SettingWindow;

import java.awt.*;
import java.util.List;


public class Setting1 extends javax.swing.JFrame {
    private static PlayerAvatar avatar;
    private static int numPlayers;
    private static int numTurns;


    public Setting1() {
        initComponents();
    }


    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        // Variables declaration - do not modify
        javax.swing.JButton defaultbtn = new javax.swing.JButton();
        javax.swing.JButton playbtn = new javax.swing.JButton();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        List<String> pawnImages = Pawn.getPawnImages();
        jComboBox1 = new javax.swing.JComboBox<>(pawnImages.toArray(new String[0]));
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jSlider2 = new javax.swing.JSlider();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        javax.swing.JTextArea jTextArea2 = new javax.swing.JTextArea();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel11 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Setting");
        jLabel1.setToolTipText("");

        defaultbtn.setText("Default");
        defaultbtn.addActionListener(evt -> defaultbtnActionPerformed());

        playbtn.setText("Play Game");
        playbtn.addActionListener(evt -> playbtnActionPerformed());

        jLabel2.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        jLabel2.setText("Number of Players :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tank", "Ship", "SpaceShip", "Motorbike","Boot","Car", "Chair","Hat"}));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel4))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(27, 27, 27)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(defaultbtn)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGap(73, 73, 73)
                                                                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(35, 35, 35)
                                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(42, 42, 42)
                                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(45, 45, 45)
                                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(69, 69, 69)
                                                                .addComponent(playbtn))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(305, 305, 305))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(162, 162, 162))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))
                                                .addGap(72, 72, 72)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel9))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(49, 49, 49)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel11)
                                                        .addComponent(jLabel12))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(defaultbtn)
                                        .addComponent(playbtn))
                                .addGap(21, 21, 21))
        );

        jSlider1.setMinimum(1);
        jSlider1.setMaximum(4);
        jSlider1.setMajorTickSpacing(1);
        jSlider2.setMinimum(30);
        jSlider2.setMaximum(50);
        jSlider2.setMajorTickSpacing(10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void defaultbtnActionPerformed() {
        PlayerAvatar defaultAvatar = new PlayerAvatar("hat.png");
        int defaultNumPlayers = 4;
        int defaultNumTurns = 30;

        //Game game = new Game(defaultAvatar, defaultNumPlayers, defaultNumTurns);
        //game.start();
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent ignoredEvt) {

        String selectedAvatar = (String) jComboBox1.getSelectedItem();
        int numPlayers = jSlider1.getValue();
        int numTurns = jSlider2.getValue();

        PlayerAvatar avatar = new PlayerAvatar(selectedAvatar);
        Setting1.setAvatar(avatar);
        Setting1.setNumPlayers(numPlayers);
        Setting1.setNumTurns(numTurns);

        //Game game = new Game(avatar, numPlayers, numTurns);
        //game.start();
    }

    private void playbtnActionPerformed() {
        String selectedAvatar = (String) jComboBox1.getSelectedItem();
        int numPlayers = jSlider1.getValue();
        int numTurns =  jSlider2.getValue();

        PlayerAvatar avatar = new PlayerAvatar(selectedAvatar);
        Setting1.setAvatar(avatar);
        Setting1.setNumPlayers(numPlayers);
        Setting1.setNumTurns(numTurns);
        // Thực hiện các thao tác khởi chạy trò chơi ở đây
        //Game game = new Game(avatar, numPlayers, numTurns);
        //game.start();
    }


    public static void setAvatar(PlayerAvatar avatar) {
        Setting1.avatar= avatar;
    }
    public static void setNumPlayers(int numPlayers) {
        Setting1.numPlayers = numPlayers;
    }

    public static void setNumTurns(int numTurns) {
        Setting1.numTurns = numTurns;
    }
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Setting1().setVisible(true);
            }
        });
    }

    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;

}