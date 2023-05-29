package SettingWindow;

import App.Board;
import App.RegularDie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class GameEngine {

    private RegularDie regularDie = RegularDie.getInstance();
    private boolean paused = false;

    private MoneyController moneyController = MoneyController.getInstance();
    private PlayerController playerController = PlayerController.getInstance();
    private DomainBoard domainBoard;
    private boolean gameStarted = false;
    private int chosenSquareIndex = -1;
    private static GameEngine _instance;
    int doublesCnt = 0;
    ArrayList<Observer> observers = new ArrayList<Observer>();
    private GameEngine() {
        domainBoard = new DomainBoard();
    }
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
    public RegularDie getRegularDie() {
        return regularDie;
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
    public int getChosenSquareIndex() {
        return chosenSquareIndex;
    }
    public DomainBoard getDomainBoard() {
        return domainBoard;
    }
    public void setSquareUnselected() {
        this.chosenSquareIndex = -1;
    }
    public int calculateMoveAmount() {
        int total = 0;
        total += regularDie.getLastValues().get(0);
        total += regularDie.getLastValues().get(1);
        return total;
    }
    public void evaluateSquare() {
        Player currentPlayer = playerController.getCurrentPlayer();
        Square square = domainBoard.getSquareAt(currentPlayer.getTargetPosition());
        square.evaluateSquare(this);
        if (square.getType() != "ChanceCardSquare" && square.getType() != "MiniGame") {
            if (regularDie.getLastValues().get(0) == regularDie.getLastValues().get(1)) {
                publishEvent("doubles");
            } else {
                publishEvent("endTurn");
            }
        }

    }
    /**public ArrayList<Integer> rollDice() {
        regularDie.roll(2);
        ArrayList<Integer> list = new ArrayList<Integer>(3);
        list.add(regularDie.getLastValues().get(0));
        list.add(regularDie.getLastValues().get(1));
        if (regularDie.getLastValues().get(0) == regularDie.getLastValues().get(1)) {
            doublesCnt++;
            if (doublesCnt == 3) {
                CommunicationController.getInstance().sendClientMessage("penalty");
            }
        }
        return list;
    }**/
    public void resume() {
        paused = false;
        System.out.println("Game Engine: Game resumed");
        publishEvent("resume");
    }
    public void pause() {
        paused = true;
        System.out.println("Game Engine: Game paused");
        publishEvent("pause");
    }
    public boolean isMyTurn() {
        Player player = playerController.getCurrentPlayer();
        if (player == null) {
            return false;
        }

        return false;
    }
    public void setCurrentPlayer(Player p) {
        playerController.setCurrentPlayerIndex(playerController.getPlayers().indexOf(p));
    }
    public boolean isBot() {
        Player currentPlayer = playerController.getCurrentPlayer();
        if (currentPlayer == null) {
            return false;
        }
        if (currentPlayer != null && currentPlayer.isBot()) {
            return true;
        }


        return false;
    }

    public LinkedList<Integer> calculatePath() {
        publishEvent("refresh");
        LinkedList<Integer> path = new LinkedList<Integer>();
        HashMap<Integer, Square> squares = domainBoard.getSquareMap();
        HashMap<Integer, ArrayList<Integer>> connections = domainBoard.getConnectionsMap();
        Player currentPlayer = playerController.getCurrentPlayer();
        int currentPos;
        int regularDiceTotal = calculateMoveAmount();
        int target = -2;
        if (currentPlayer != null) {

            for (int i = 0; i < regularDiceTotal; i++) {
                currentPos = currentPlayer.getTargetPosition();

                int placeToGo = connections.get(currentPos).get(0);

                if (domainBoard.getSquareAt(currentPos).getType().equals("RailroadTransitSquare") && regularDiceTotal % 2 == 0) {
                    if (connections.get(currentPos).get(1) != -1) placeToGo = connections.get(currentPos).get(1);
                    else System.out.println("[GameEngine]: There seems to be a problem.");
                }


                //playerController.changeCurrentPosition(currentPlayer, placeToGo);
                path.add(placeToGo);
                target = placeToGo;
                playerController.movePlayer(target);
            }

            playerController.movePlayer(target);

            if (path.getLast() == 114) {
                path.add(14);
                playerController.movePlayer(14);
            } else if (path.getLast() == 14) {
                path.add(114);
                playerController.movePlayer(114);
            }

            publishEvent("path/" + path);

            playerController.setPath(currentPlayer, path);
            for (int j = 0; j < path.size() - 1; j++) {
                int i = path.get(j);
                Square onTheWay = squares.get(i);
                if (onTheWay.getFlyover()) {
                    onTheWay.evaluateSquare(this, "flyover");
                }
            }
        }

        evaluateSquare();
        return path;
    }
}
