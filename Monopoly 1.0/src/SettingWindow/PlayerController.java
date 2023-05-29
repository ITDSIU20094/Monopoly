package SettingWindow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class PlayerController implements Serializable {
    private static PlayerController _instance;
    private ArrayList<Player> players = new ArrayList<Player>(4);
    private int currentPlayer = 0;
    private Player chosenPlayer = null;

    public Player getChosen() {
        return chosenPlayer;
    }
    public void setChosen(Player choose) {
        this.chosenPlayer = choose;
    }
    private PlayerController() {

    }
    public static synchronized PlayerController getInstance() {
        if (_instance == null) {
            _instance = new PlayerController();
        }
        return _instance;
    }

    public Player getCurrentPlayer() {
        if (players.size() > 0 && currentPlayer < players.size()) {
            return players.get(currentPlayer);
        }
        return null;
    }
    public int getCurrentPlayerIndex() {
        return currentPlayer;
    }
    public void setCurrentPlayerIndex(int cP) {
        this.currentPlayer = cP;
    }
    public Player nextPlayer() {
        if (players.size() > 0) {
            currentPlayer = (currentPlayer + 1) % players.size();
        }
        if (currentPlayer < players.size() && currentPlayer > -1) {
            return players.get(currentPlayer);
        }

        return null;

    }
    public void putInJail() {
        players.get(currentPlayer).setinJail(true);
    }
    public void getOutFromJail() {
        players.get(currentPlayer).setinJail(false);
    }
    public void movePlayer(int targetIndex) {
        getCurrentPlayer().setTargetPosition(targetIndex);
    }

    public void changeCurrentPosition(Player player, int newPos) {
        player.setPosition(newPos);
    }

    public void increaseCurrentPosition(Player player) {
        player.setPosition((player.getPosition() + 1) % 120);
    }

    public void removeProperty(PropertySquare propertySquare) {
        players.get(currentPlayer).getPropertyCardsMap().remove(propertySquare.getColor(), propertySquare);
    }
    public void removePlayer(Player player) {
        players.remove(player);
    }
    public void setPath(Player p, LinkedList<Integer> path) {
        p.setPath(path);
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }

}
