package UI;

import Domain.Model.Bot.BotBehaviour;
import Domain.Model.GameEngine;
import Domain.Observer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AppWindow extends JFrame implements Observer {
        private GameWindow gameWindow;
        private Setting settingWindow;
        private ServerWindow serverWindow;
        private JButton startButton = null;
        private JButton settingButton = null;

        private GameEngine gameEngine = GameEngine.getInstance();
        private Navigator navigator = Navigator.getInstance();
        private final CardLayout mainLayout = new CardLayout();
        private final JPanel panels = new JPanel(mainLayout);
        private final Border border = BorderFactory.createEmptyBorder(-10, 60, 60, 60);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        public AppWindow() {
                super("Monopoly");
                this.setExtendedState(JFrame.MAXIMIZED_BOTH);

                int width = screenSize.width;   //used to be screenSize.width - 15
                int height = screenSize.height;  //used to be screenSize.height - 30
                addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                                System.exit(0);
                        }
                });
                GameEngine.getInstance().subscribe(this);
                JToolBar toolBar = new JToolBar();
                addButtons(toolBar);
                settingWindow = new Setting();
                gameWindow = new GameWindow(width, height);
                serverWindow = new ServerWindow();
                new BotBehaviour();

                JPanel contentPane = new JPanel();
                contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
                contentPane.setPreferredSize(new Dimension(width, height));

                setContentPane(contentPane);

                Setting settingPanel = settingWindow;
                panels.add(settingPanel, "Setting");

                JPanel gamePanel = gameWindow;
                gamePanel.setBorder(border);
                panels.add(gamePanel, "Game Panel");

                JPanel serverPanel = serverWindow;
                serverPanel.setBorder(border);
                panels.add(serverPanel, "Server Panel");

                gameEngine.subscribe(this::onEvent);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        protected void addButtons(JToolBar toolBar) {
                settingButton = new JButton("Setting");
                settingButton.setToolTipText("Setting window");
                settingButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                navigator.menuScreen();
                        }
                });
                toolBar.add(settingButton);

                startButton = new JButton("Game");
                startButton.setToolTipText("Game window");
                startButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                navigator.gameScreen();
                        }
                });
                toolBar.add(startButton);

        }

        @Override
        public void onEvent(String message) {

        }
}