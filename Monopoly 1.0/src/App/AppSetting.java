package App;

import javax.swing.*;
import java.awt.*;

public class AppSetting extends JFrame {
    public AppSetting(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
        setLocationRelativeTo(null);
    }
}
