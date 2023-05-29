package SettingWindow;

import App.Board;

import java.util.ArrayList;

public class GameEngine {
    private static GameEngine _instance;
    private boolean paused = false;
    ArrayList<Observer> observers = new ArrayList<Observer>();
    private MoneyController moneyController = MoneyController.getInstance();
    private PlayerController playerController = PlayerController.getInstance();
    private boolean gameStarted = false;
    private int chosenSquareIndex = -1;
    public static GameEngine getInstance() {
        if (_instance == null) {
            _instance = new GameEngine();
        }
        return _instance;
    }
    public boolean isPaused() {
        return paused;
    }
    public void publishEvent(String message) {
        observers.forEach(listener -> listener.onEvent(message));
    }
    public PlayerController getPlayerController() {
        return playerController;
    }
    public void payRent(Player player, Player owner, int amount) {
        moneyController.decreaseMoney(player, amount);
        if (player.getMoney() < 0) {
            player.setMoney(0);
            moneyController.increaseMoney(owner, player.getMoney());
            publishEvent("bankrupt");
        } else {
            moneyController.increaseMoney(owner, amount);
        }
    }
    public void initPlayers() {
        publishEvent("initializePawns");
        publishEvent("initializePlayers");
    }
    public void gameStopped() {
        gameStarted = false;
    }
    public void startGame() {
        if (!isGameStarted()) {
            publishEvent("screen/gameScreen");
            initPlayers();
            publishEvent("rollDice");
        }
        gameStarted();
    }
    public boolean isGameStarted() {
        return gameStarted;
    }
    public void gameStarted() {
        gameStarted = true;
    }


    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void setChosenSquareIndex(int squareIndex) {
        this.chosenSquareIndex = squareIndex;
    }
}
