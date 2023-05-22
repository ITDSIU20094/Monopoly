package App;
import javax.swing.*;
import java.awt.*;

public class joinGame extends JFrame{
    public joinGame() {
        setTitle("Monopoly");
        ImageIcon imageIcon = new ImageIcon("Image/Board.jpg");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0,0,imageIcon.getIconWidth(),imageIcon.getIconHeight());

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
        layeredPane.add(imageLabel, Integer.valueOf(0));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 740);
        setLocationRelativeTo(null);
        getContentPane().add(layeredPane);
    }
}
