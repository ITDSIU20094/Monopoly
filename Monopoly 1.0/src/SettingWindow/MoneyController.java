package SettingWindow;

import java.io.Serializable;

public class MoneyController implements Serializable {
    private static MoneyController _instance;
    private PlayerController playerController = PlayerController.getInstance();
    private int poolMoney = 0;
    private MoneyController() {

    }
    public static MoneyController getInstance() {
        if (_instance == null) {
            _instance = new MoneyController();
        }
        return _instance;
    }
    public void increaseMoney(Player player, int amount) {
        player.setMoney(player.getMoney() + amount);
    }
    public void decreaseMoney(Player player, int amount) {
        player.setMoney(player.getMoney() - amount);

        if(player.getMoney()<0) {
            System.out.println("[Money Controller]: Player is bankrupted");
            (playerController).removePlayer(player);
            //System.out.println(playerController.getPlayers().toString());
        }
    }
    public void transferMoney(Player payer, Player receiver, int amount) {
        decreaseMoney(payer, amount);
        increaseMoney(receiver, amount);
    }
    public void getMoneyFromAllPlayers(Player player, int amount) {
        int gain = 0;
        for (Player p : playerController.getPlayers()) {
            if (!p.equals(player)) {
                decreaseMoney(p, amount);
                gain += amount;
            }
        }
        increaseMoney(player, gain);
    }
    public int getPoolMoney() {
        return poolMoney;
    }
    public void setPoolMoney(int poolMoney) {
        this.poolMoney = poolMoney;
    }

    public void increasePoolMoney(int poolMoney) {
        this.poolMoney += poolMoney;
    }

    public void decreasePoolMoney(int poolMoney) {
        this.poolMoney -= poolMoney;
    }
    public boolean hasEnoughMoney(Player player, int amount) {
        if (player.getMoney() >= amount) {
            return true;
        } else {
            return false;
        }
    }
    public boolean repOk() {
        if (poolMoney >= 0)
            return true;
        return false;

    }
    public void exchangeMoneyControllerData(MoneyController moneyController) {
        this.poolMoney = moneyController.getPoolMoney();
    }

}
