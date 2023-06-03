package gui;
public class GameBoardCCJail extends GameBoardCC {

    public GameBoardCCJail() {
        super();

        Card ccCard1 = new JailCard(Card.TYPE_CC);
        Card chanceCard1 = new JailCard(Card.TYPE_CHANCE);



        addCard(ccCard1);


    }
}
