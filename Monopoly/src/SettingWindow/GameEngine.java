package SettingWindow;

public class GameEngine {
    private static GameEngine _instance;
    private boolean paused = false;
    public static GameEngine getInstance() {
        if (_instance == null) {
            _instance = new GameEngine();
        }
        return _instance;
    }
    public boolean isPaused() {
        return paused;
    }
}
