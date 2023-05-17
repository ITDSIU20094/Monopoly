package App;

import javax.swing.*;
import java.awt.*;

public class Setting {
    private JFrame jFrame;
    public Setting(){
        jFrame = new JFrame();
        jFrame.setSize(1920, 1080);
        jFrame.setLayout(new BorderLayout());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
