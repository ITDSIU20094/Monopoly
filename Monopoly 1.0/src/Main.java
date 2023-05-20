import App.AppWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AppWindow appWindow = new AppWindow();
                appWindow.setVisible(true);
            }
        });
    }
}