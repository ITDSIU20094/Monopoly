package App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppWindow extends JFrame {
        public AppWindow() {
                ImageIcon imageIcon = new ImageIcon("Image/demo.png");
                JLabel imageLabel = new JLabel(imageIcon);
                imageLabel.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());

                JButton startButton = new JButton("Start Game");
                startButton.setBounds(450, 250, 100, 40);
                startButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                setVisible(false);
                                dispose();
                                EventQueue.invokeLater(new Runnable() {
                                        @Override
                                        public void run() {
                                                new joinGame().setVisible(true);
                                        }
                                });
                        }
                });

                JButton settingButton = new JButton("Setting");
                settingButton.setBounds(450, 300, 100, 40);
                settingButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                EventQueue.invokeLater(new Runnable() {
                                        @Override
                                        public void run() {
                                                new AppSetting().setVisible(true);
                                        }
                                });
                        }
                });

                JLayeredPane layeredPane = new JLayeredPane();
                layeredPane.setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
                layeredPane.add(imageLabel, Integer.valueOf(0));
                layeredPane.add(startButton, Integer.valueOf(1));
                layeredPane.add(settingButton, Integer.valueOf(1));

                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
                setLocationRelativeTo(null);
                getContentPane().add(layeredPane);
        }
}








