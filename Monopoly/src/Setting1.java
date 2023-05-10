import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Setting1 extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel label1, label2, label3, label4, label5;
    private JButton btnSetting, btnPlayGame;
    private JComboBox<Dice> diceComboBox;
    private JComboBox<Map> mapJComboBox;
    private File avatarFile;
    private File diceFile;

    public Setting1() {
        super("Monopoly Game Setting");

        panel = new JPanel();
        panel.setLayout(null);

        label1 = 
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
