import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Setting1 extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel label1, label2;
    private JButton btnSetting, btnPlayGame;

    private JComboBox<File> cbPlayerAvatar;

    private ArrayList<File> pawnFiles = new ArrayList<File>();
    private File P1 = new File("./assets/Pawn/Boot.png");
    private File P2 = new File("./assets/Pawn/Car.png");
    private File P3 = new File("./assets/Pawn/Chair.png");
    private File P4 = new File("./assets/Pawn/Hat.png");
    private File P5 = new File("./assets/Pawn/Motorbike.png");
    private File P6 = new File("./assets/Pawn/Ship.png");
    private File P7 = new File("./assets/Pawn/SpaceShip.png");
    private File P8 = new File("./assets/Pawn/Tank.png");
    private JSlider  sliderNumPlayers, sliderNumTurns;

    public Setting1() {
        super("Monopoly Game Setting");

        panel = new JPanel();
        panel.setLayout(null);
        pawnFiles.add(P1);
        pawnFiles.add(P2);
        pawnFiles.add(P3);
        pawnFiles.add(P4);
        pawnFiles.add(P5);
        pawnFiles.add(P6);
        pawnFiles.add(P7);
        pawnFiles.add(P8);

        label1 = new JLabel("Player Avatar: ");
        label1.setBounds(20,20,100,20);
        panel.add(label1);

        cbPlayerAvatar = new JComboBox<File>(pawnFiles);
        cbPlayerAvatar.setBounds(130,20,100,20);
        panel.add(cbPlayerAvatar);

        label2 = new JLabel("Number of Players:");
        label2.setBounds(20, 140, 100, 20);
        panel.add(label2);

        sliderNumPlayers = new JSlider(JSlider.HORIZONTAL, 2, 6, 4);
        sliderNumPlayers.setBounds(130, 140, 100, 20);
        panel.add(sliderNumPlayers);

        JLabel labelNumTurns = new JLabel("Number of Turns:");
        labelNumTurns.setBounds(20, 170, 100, 20);
        panel.add(labelNumTurns);

        sliderNumTurns = new JSlider(JSlider.HORIZONTAL, 10, 50, 30);
        sliderNumTurns.setBounds(130, 170, 100, 20);
        panel.add(sliderNumTurns);

        btnSetting = new JButton("Default Setting");
        btnSetting.setBounds(20, 210, 100, 30);
        btnSetting.addActionListener(this);
        panel.add(btnSetting);

        btnPlayGame = new JButton("Play Game");
        btnPlayGame.setBounds(130, 210, 100, 30);
        btnPlayGame.addActionListener(this);
        panel.add(btnPlayGame);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSetting) {
            String playerAvatar = (String) cbPlayerAvatar.getSelectedItem();
            int numPlayers = sliderNumPlayers.getValue();
            int numTurns = sliderNumTurns.getValue();

            try {
                FileWriter writer = new FileWriter("setting.txt");
                writer.write("Player Avatar: " + playerAvatar + "\n");
                writer.write("Number of Players: " + numPlayers + "\n");
                writer.write("Number of Turns: " + numTurns + "\n");
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == btnPlayGame) {
            DefaultSetting defaultSetting = new DefaultSetting();
            startGame(defaultSetting);

        }
    }
    private void startGame(DefaultSetting settings) {
        String playerAvatar = settings.playerAvatar;
        int numPlayers = settings.numPlayers;
        int numTurns = settings.numTurns;
    }
}
