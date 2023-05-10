import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

public class Setting extends Component {
    private JLabel avatarLabel;
    private JButton avatarBtn;
    private JComboBox<Dice> diceComboBox;
    private JLabel diceLabel;
    private JButton diceBtn;
    private JComboBox<Map> mapComboBox;
    private JSpinner numPlayersSpinner;
    private JSpinner numTurnsSpinner;
    private JButton startGameBtn;

    private File avatarFile;
    private File diceFile;
    private JLabel mapLabel;

    private JButton avatarButton;

    private JSlider volumeSlider;
    private JLabel numPlayersLabel;

    private JLabel numTurnsLabel;
    private JButton defaultButton;
    private JButton startGameButton;
    // Variables to store user selections

    private Dice defualtDice = Dice.BLACK;
    private Map defaultMap = Map.SOUTHSIDE;
    private int numPlayers = 4;
    private int numTurns = 30;

    public Setting() {
        avatarLabel = new JLabel("Player Avatar:");
        avatarButton = new JButton("Select Avatar Image");
        avatarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));
                int result = fileChooser.showOpenDialog(getWindow());
                if (result == JFileChooser.APPROVE_OPTION) {
                    avatarFile = fileChooser.getSelectedFile();
                    try {
                        Image avatarImage = ImageIO.read(avatarFile).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                        avatarLabel.setIcon(new ImageIcon(avatarImage));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        diceLabel = new JLabel("Dice:");
        diceComboBox = new JComboBox<String>(new String[]{"Black", "White", "Red", "Green"});
        diceComboBox.setSelectedItem("Black");
        diceComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String selectedDiceStr = (String) diceComboBox.getSelectedItem();
                defualtDice = Dice.valueOf(selectedDiceStr.toUpperCase());
            }
        });

        mapLabel = new JLabel("Map:");
        mapComboBox = new JComboBox<String>(new String[]{"Southside", "Downtown", "Uptown", "Suburbia"});
        mapComboBox.setSelectedItem("Southside");
        mapComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String selectedMapStr = (String) mapComboBox.getSelectedItem();
                defaultMap = Map.valueOf(selectedMapStr.toUpperCase());
            }
        });

        volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        // Initialize GUI components
        initComponents();

        // Set up event listeners
        initListeners();
        private void setUpEventListeners() {
            // Player avatar customization
            avatarBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Open file chooser dialog to select player avatar image file
                    JFileChooser fileChooser = new JFileChooser();
                    int result = fileChooser.showOpenDialog(Setting.this);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        // TODO: Update player avatar image based on selected file
                    }
                }
            });

            // Dice customization
            diceBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Open file chooser dialog to select dice image file
                    JFileChooser fileChooser = new JFileChooser();
                    int result = fileChooser.showOpenDialog(Setting.this);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        // TODO: Update dice image based on selected file
                    }
                }
            });

            // Map customization
            mapComboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Open file chooser dialog to select map image file
                    JFileChooser fileChooser = new JFileChooser();
                    int result = fileChooser.showOpenDialog(Setting.this);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        // TODO: Update map image based on selected file
                    }
                }
            });

            // Volume control
            volumeSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    int volume = volumeSlider.getValue();
                    // TODO: Update game volume based on slider value
                }
            });
            numTurnsSpinner.addAncestorListener(new AncestorListener() {
                @Override
                public void ancestorAdded(AncestorEvent event) {

                }

                @Override
                public void ancestorRemoved(AncestorEvent event) {

                }

                @Override
                public void ancestorMoved(AncestorEvent event) {

                }
            });
            // Number of players customization
            numPlayersSpinner.addAncestorListener(new AncestorListener() {
                @Override
                public void ancestorAdded(AncestorEvent event) {

                }

                @Override
                public void ancestorRemoved(AncestorEvent event) {

                }

                @Override
                public void ancestorMoved(AncestorEvent event) {

                }
            });



            // Default button
            defaultButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO: Set all settings to default values
                }
            });

            // Start game button
            startGameButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO: Start game with selected settings
                }
            });
        }

    }

    private void initComponents() {
        // Create main panel
        JPanel mainPanel = new JPanel(new GridLayout(7, 2, 10, 10));

        // Create GUI components
        avatarLabel = new JLabel("Player Avatar:");
        avatarBtn = new JButton("Select Avatar Image");
        avatarBtn.setEnabled(false);
        diceComboBox = new JComboBox<>(Dice.values());
        diceLabel = new JLabel("Dice:");
        diceBtn = new JButton("Select Dice Image");
        diceBtn.setEnabled(false);
        mapComboBox = new JComboBox<>(Map.values());
        JLabel mapLabel = new JLabel("Map:");
        numPlayersSpinner = new JSpinner(new SpinnerNumberModel(4, 2, 6, 1));
        numTurnsSpinner = new JSpinner(new SpinnerNumberModel(30, 10, 50, 10));
        startGameBtn = new JButton("Start Game");

        // Add components to main panel
        mainPanel.add(avatarLabel);
        mainPanel.add(avatarBtn);
        mainPanel.add(diceLabel);
        mainPanel.add(diceComboBox);
        mainPanel.add(mapLabel);
        mainPanel.add(mapComboBox);
        mainPanel.add(new JLabel("Number of Players:"));
        mainPanel.add(numPlayersSpinner);
        mainPanel.add(new JLabel("Number of Turns:"));
        mainPanel.add(numTurnsSpinner);
        mainPanel.add(new JLabel());
        mainPanel.add(startGameBtn);

        // Create window and add main panel
        JFrame window = new JFrame("Settings");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(mainPanel);
        window.pack();
        window.setLocationRelativeTo(null);
    }

    private void initListeners() {
        avatarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "png"));
                int result = fileChooser.showOpenDialog((Component) e.getSource());
                if (result == JFileChooser.APPROVE_OPTION) {
                    avatarFile = fileChooser.getSelectedFile();
                    avatarLabel.setIcon(new ImageIcon(avatarFile.getPath()));
                }
            }
        });

        diceBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "png"));
                int result = fileChooser.showOpenDialog((Component) e.getSource());
                if (result == JFileChooser.APPROVE_OPTION) {
                    diceFile = fileChooser.getSelectedFile();
                    diceLabel.setIcon(new ImageIcon(diceFile.getPath()));
                }
            }
        });

        startGameBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get settings
                File avatar = avatarFile;
                Dice dice = (Dice) diceComboBox.getSelectedItem();
                Map map = (Map) mapComboBox.getSelectedItem();
                int numPlayers = (int) numPlayersSpinner.getValue();
                int numTurns = (int) numTurnsSpinner.getValue();

                // If default settings, use null values
                if (avatar == null && dice == Dice.BLACK && map == Map.SOUTHSIDE
                        && numPlayers == 4 && numTurns == 30) {
                    avatar = null;
                    dice = null;
                    map = null;
                }

                // Start game with settings
                new Game(avatar, dice, map, numPlayers, numTurns);
            }
        });
    }

    public static void main(String[] args) {
        // Create new instance of setting application
        Setting settingApp = new Setting();

        // Show window
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                settingApp.getWindow().setVisible(true);
            }
        });
    }

    private JFrame getWindow() {
        return (JFrame) SwingUtilities.getWindowAncestor(startGameBtn);
    }

    private enum Dice {
        BLACK, WHITE, RED, GREEN
    }

    private enum Map {
        SOUTHSIDE, DOWNTOWN, UPTOWN, SUBURBIA
    }
}
