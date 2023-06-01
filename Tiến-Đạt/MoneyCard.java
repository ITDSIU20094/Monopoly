package gui;
public class MoneyCard extends Card {
    private int amount;

    private String label;

    public MoneyCard(String label, int amount, int cardType){
        this.label = label;
        this.amount = amount;
        this.type = cardType;
    }

    public void applyAction() {
        Player currentPlayer = GameMaster.instance().getCurrentPlayer();
        currentPlayer.setMoney(currentPlayer.getMoney() + amount);
    }


    public String getLabel() {
        return label;
    }
}