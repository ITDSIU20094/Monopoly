package gui;
public class GameBoardCCLoseMoney extends GameBoardCC {
    public GameBoardCCLoseMoney() {
        super();

        Card ccCard1 = new MoneyCard("Pay $20", -20, Card.TYPE_CC);
        Card chanceCard1 = new MoneyCard("Pay $30", -30, Card.TYPE_CHANCE);


        addCard(ccCard1);


    }
}