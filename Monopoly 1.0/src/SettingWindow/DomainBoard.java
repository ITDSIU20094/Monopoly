package SettingWindow;

import java.io.Serializable;
import java.util.*;

public class DomainBoard implements Serializable {
    private SquareFactory squareFactory = SquareFactory.getInstance();
    private CardFactory cardFactory = CardFactory.getInstance();
    private int numSquares = 40;
    private HashMap<Integer, Square> domainSquareMap;
    private HashMap<Integer, ArrayList<Integer>> connectionsMap;
    private Queue<Card> CCCards, ChanceCards, Roll3Cards;
    private int layerbegin = 0;
    private int layerend = 39;

    public DomainBoard() {
        domainSquareMap = new HashMap<Integer, Square>(numSquares);
        connectionsMap = new HashMap<Integer, ArrayList<Integer>>(numSquares);
        CCCards = new LinkedList<Card>();
        ChanceCards = new LinkedList<Card>();
        createConnectionsMap();
        createSquares();
        createCards();

    }
    private void createCardsReal() {
        int ChanceLength = cardFactory.ChanceCard_names.length;
        ArrayList<Integer> ChanceIndexList = new ArrayList<Integer>(ChanceLength);
        for (int index = 0; index < ChanceLength; index++) {
            ChanceIndexList.add(index);
        }
        Collections.shuffle(ChanceIndexList);
        for (int j = 0; j < ChanceLength; j++) {
            ChanceCards.add(cardFactory.createChanceCard(ChanceIndexList.get(j)));
        }

    }

    private void createCards() {
    }

    private void createConnectionsMap() {
        for (int i = 0; i < 39; i++) {
            connectionsMap.put(i, new ArrayList<Integer>(Arrays.asList(i + 1, -1, i - 1)));
        }
        connectionsMap.get(0).set(2, 39);
        connectionsMap.put(39, new ArrayList<Integer>(Arrays.asList(0, -1, 38)));
    }

    private void createSquares() {
    }
    public HashMap<Integer, Square> getSquareMap() {
        return domainSquareMap;
    }
    public HashMap<Integer, ArrayList<Integer>> getConnectionsMap() {
        return connectionsMap;
    }
    public Square getSquareAt(int pos) {
        return domainSquareMap.get(pos);
    }
    public void exchangeDomainBoardData(DomainBoard domainBoard){
        domainSquareMap = domainBoard.getSquareMap();

    }
    public Queue<Card> getChanceCards() {
        return ChanceCards;
    }


    public void setChanceCards(Queue<Card> chanceCards) {
        ChanceCards = chanceCards;
    }




}
