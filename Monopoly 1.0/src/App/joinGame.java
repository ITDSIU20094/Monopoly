package App;
import javax.swing.*;
import java.awt.*;

public class joinGame extends JFrame{
    public joinGame() {
        setTitle("Monopoly");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        getContentPane().add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 1000);
        setLocationRelativeTo(null);
    }
}
