package Domain.Model;

import Domain.Model.Cards.Card;
import Domain.Model.Square.PropertySquare;
import Domain.Model.Square.UtilitySquare;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class Player implements Serializable {
    private String name;
    private String ClientID;
    private int money = 2000;
    private LinkedList<Integer> path = null;
    private boolean inJail;
    private int ID;
    private boolean bot = false;
    private int rentMultiplier = 1;
    private int placeHolder;
    private boolean direction = true;
    private int targetPosition = 0;
    private int position = 0;
    private ArrayList<Card> cardList;
    private ArrayList<PropertySquare> propertySquares;
    private int botBehaviourNumber = 1;
    private ArrayList<UtilitySquare> utilityList;
    private HashMap<String, ArrayList<PropertySquare>> propertyCardsMap;
    public Player(String name,int ID,int placeHolder) {
        this.name = name;
        this.ID = ID;
        propertyCardsMap = new HashMap<>();
        propertySquares = new ArrayList<>();
        utilityList = new ArrayList<>();
        cardList = new ArrayList<>();
    }
    public static int generateRandomID() {
        Random random = new Random();
        return random.nextInt(1,4);
    }
    public int getID(int i) {
        return ID;
    }
    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public void setPath(LinkedList<Integer> path)
    {
        this.path = path;
    }

    public void receiveMoney(int amount){
        money += amount;
    }
    public boolean isInJail() {
        return inJail;
    }
    public void setinJail(boolean b) {
        inJail = b;
    }

    public void setTargetPosition(int targetIndex) {
        this.targetPosition = position;
    }

    public void setPosition(int newPos) {

        position = newPos;
    }
    public ArrayList<Card> getCardList() {
        return cardList;
    }
    public ArrayList<PropertySquare> getPropertySquares() {
        return propertySquares;
    }

    public boolean isBot()
    {
        return this.bot;
    }


    public int getPosition() {
        return position;
    }

    public HashMap<String, ArrayList<PropertySquare>> getPropertyCardsMap() {
        return propertyCardsMap;
    }
    public String getName() {
        if(bot){
            return "Bot | " + name;
        }
        return name;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int newmoney) {
        money = newmoney;
    }


    public int getPlaceHolder() {
        return placeHolder;
    }
    public int getTargetPosition() {
        return targetPosition;
    }
    public ArrayList<UtilitySquare> getUtilityList() {
        return this.utilityList;
    }
    public void addSquare(PropertySquare propertySquare) {
        // propertyCardsMap.put(propertySquare)
        propertySquares.add(propertySquare);
        if(propertyCardsMap.get(propertySquare.getColor()) != null) {
            propertyCardsMap.get(propertySquare.getColor()).add(propertySquare);
        } else {
            ArrayList<PropertySquare> pSA = new ArrayList<PropertySquare>();
            propertyCardsMap.put(propertySquare.getColor(),pSA);
            propertyCardsMap.get(propertySquare.getColor()).add(propertySquare);
        }
        System.out.println(propertyCardsMap.get(propertySquare.getColor()));
    }
    public void addCard(Card card) {
        cardList.add(card);
    }
    public int getRentMultiplier()
    {
        return rentMultiplier;
    }
    public boolean repOk() {
        if(name != null && money >= 0 && propertySquares != null && utilityList != null && cardList != null) {
            return  true;
        }
        return false;
    }

    public void setBot()
    {
        this.bot = true;
    }

    public void setPerson()
    {
        this.bot = false;
    }
    @Override
    public String toString() {
        String playerProps = "";
        for(PropertySquare pSq : this.getPropertySquares()) {
            playerProps += pSq.toString() + "\n";
        }
        String playerUtils = "";
        for(UtilitySquare uSq : this.getUtilityList()) {
            playerUtils += uSq.getName() + "\n";
        }
        return "Name: " + this.getName() + "\n" +
                "Money: " + this.getMoney() + "\n"+
                "Properties: \n" + playerProps +
                "Utilities: \n" + playerUtils +
                "Is Bot? \t" + ((isBot()) ? "yes\nBehaviour Index:\t" + getBotBehaviourNumber() : "no") + "\n";


    }
    public int getBotBehaviourNumber() {
        return botBehaviourNumber;
    }

    public void setBotBehaviourNumberManually(int botBehaviourNumber) {
        this.botBehaviourNumber = botBehaviourNumber;
    }

    public void setBotBehaviourNumber() {
        Random rand = new Random();
        this.botBehaviourNumber = rand.nextInt(3) + 1;
    }
}
