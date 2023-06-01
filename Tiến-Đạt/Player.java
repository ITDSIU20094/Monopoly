package gui;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;


public class Player {
    //the key of colorGroups is the name of the color group.
    private Hashtable colorGroups = new Hashtable();
    private boolean inJail;
    private int money;
    private String name;

    private Cell position;
    private ArrayList properties = new ArrayList();
    private ArrayList railroads = new ArrayList();
    private ArrayList utilities = new ArrayList();

    public Player() {
        GameBoard gb = GameMaster.instance().getGameBoard();
        inJail = false;
        if(gb != null) {
            position = gb.queryCell("Go");
        }
    }

    public void buyProperty(IOwnable property, int amount) {
        property.setOwner(this);
        verifyPurchaseProperty(property);
        setMoney(getMoney() - amount);
    }

    private void verifyPurchaseProperty(IOwnable property) {
        if(property instanceof UtilityCell) {
            utilities.add(property);
            colorGroups.put(
                    UtilityCell.COLOR_GROUP,
                    new Integer(getPropertyNumberForColor(UtilityCell.COLOR_GROUP)+1));
        }
        if(property instanceof RailRoadCell) {
            railroads.add(property);
            colorGroups.put(
                    RailRoadCell.COLOR_GROUP,
                    new Integer(getPropertyNumberForColor(RailRoadCell.COLOR_GROUP)+1));
        }
        if(property instanceof PropertyCell) {
            PropertyCell cell = (PropertyCell)property;
            properties.add(cell);
            colorGroups.put(
                    cell.getColorGroup(),
                    new Integer(getPropertyNumberForColor(cell.getColorGroup())+1));
        }
    }


    public boolean canBuyHouse() {
        return (getMonopolies().length != 0);
    }

    public boolean checkProperty(String property) {
        for(int i=0;i<properties.size();i++) {
            Cell cell = (Cell)properties.get(i);
            if(cell.getName().equals(property)) {
                return true;
            }
        }
        return false;

    }

    public void exchangeProperty(Player player) {
        for(int i = 0; i < getPropertyNumber(); i++ ) {
            PropertyCell cell = getProperty(i);
            cell.setOwner(player);
            if(player == null) {
                cell.setAvailable(true);
                cell.setNumHouses(0);
            }
            else {
                player.properties.add(cell);
                colorGroups.put(
                        cell.getColorGroup(),
                        new Integer(getPropertyNumberForColor(cell.getColorGroup())+1));
            }
        }
        properties.clear();
    }

    public IOwnable[] getAllProperties() {
        ArrayList list = new ArrayList();
        list.addAll(properties);
        list.addAll(utilities);
        list.addAll(railroads);
        return (IOwnable[])list.toArray(new IOwnable[list.size()]);
    }

    public int getMoney() {
        return this.money;
    }

    public String[] getMonopolies() {
        ArrayList monopolies = new ArrayList();
        Enumeration colors = colorGroups.keys();
        while(colors.hasMoreElements()) {
            String color = (String)colors.nextElement();
            if(isPropertyCell(color)) {
                Integer num = (Integer)colorGroups.get(color);
                GameBoard gameBoard = GameMaster.instance().getGameBoard();
                if(num.intValue() == gameBoard.getPropertyNumberForColor(color)) {
                    monopolies.add(color);
                }
            }
        }
        return (String[])monopolies.toArray(new String[monopolies.size()]);
    }

    private boolean isPropertyCell(String color) {
        return !(color.equals(RailRoadCell.COLOR_GROUP)) && !(color.equals(UtilityCell.COLOR_GROUP));
    }

    public String getName() {
        return name;
    }

    public void getOutOfJail() {
        money -= JailCell.BAIL;
        if(isBankrupt()) {
            money = 0;
            exchangeProperty(null);
        }
        inJail = false;
        GameMaster.instance().updateGUI();
    }

    public Cell getPosition() {
        return this.position;
    }

    public PropertyCell getProperty(int index) {
        return (PropertyCell)properties.get(index);
    }

    public int getPropertyNumber() {
        return properties.size();
    }

    private int getPropertyNumberForColor(String name) {
        Integer number = (Integer)colorGroups.get(name);
        if(number != null) {
            return number.intValue();
        }
        return 0;
    }

    public boolean isBankrupt() {
        return money <= 0;
    }

    public boolean isInJail() {
        return inJail;
    }

    public int numberOfRR() {
        return getPropertyNumberForColor(RailRoadCell.COLOR_GROUP);
    }

    public int numberOfUtil() {
        return getPropertyNumberForColor(UtilityCell.COLOR_GROUP);
    }

    public void payRentTo(Player owner, int rentValue) {
        if(money < rentValue) {
            owner.money += money;
            money -= rentValue;
        }
        else {
            money -= rentValue;
            owner.money +=rentValue;
        }
        if(isBankrupt()) {
            money = 0;
            exchangeProperty(owner);
        }
    }

    public void purchase() {
        if(getPosition() instanceof OwnedCell){
            if(((OwnedCell) getPosition()).isAvailable()) {
                Cell c = getPosition();
                ((OwnedCell) c).setAvailable(false);
                isPropertyCell(c);
                isRailRoadCell(c);
                isUtilityCell(c);
            }
        }
    }

    private void isUtilityCell(Cell c) {
        if(c instanceof UtilityCell) {
            UtilityCell cell = (UtilityCell)c;
            purchaseUtility(cell);
        }
    }

    private void isRailRoadCell(Cell c) {
        if(c instanceof RailRoadCell) {
            OwnedCell cell = (OwnedCell)c;
            purchaseRailRoad(cell);
        }
    }

    private void isPropertyCell(Cell c) {
        if(c instanceof PropertyCell) {
            PropertyCell cell = (PropertyCell)c;
            purchaseProperty(cell);
        }
    }

    public void purchaseHouse(String selectedMonopoly, int houses) {
        GameBoard gb = GameMaster.instance().getGameBoard();
        PropertyCell[] cells = gb.getPropertiesInMonopoly(selectedMonopoly);
        if(hasMoney(houses, cells)) {
            for(int i = 0; i < cells.length; i++) {
                int newNumber = cells[i].getNumHouses() + houses;
                if (newNumber <= 5) {
                    cells[i].setNumHouses(newNumber);
                    this.setMoney(money - (cells[i].getHousePrice() * houses));
                    GameMaster.instance().updateGUI();
                }
            }
        }
    }

    private boolean hasMoney(int houses, PropertyCell[] cells) {
        return money >= (cells.length * (cells[0].getHousePrice() * houses));
    }

    private void purchaseProperty(PropertyCell cell) {
        buyProperty(cell, cell.getPrice());
    }

    private void purchaseRailRoad(OwnedCell cell) {
        buyProperty(cell, cell.getPrice());
    }

    private void purchaseUtility(UtilityCell cell) {
        buyProperty(cell, cell.getPrice());
    }

    public void sellProperty(IOwnable property, int amount) {
        property.setOwner(null);
        if(property instanceof PropertyCell) {
            properties.remove(property);
        }
        if(property instanceof RailRoadCell) {
            railroads.remove(property);
        }
        if(property instanceof UtilityCell) {
            utilities.remove(property);
        }
        setMoney(getMoney() + amount);
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(Cell newPosition) {
        this.position = newPosition;
    }

    public String toString() {
        return name;
    }

    public void resetProperty() {
        properties = new ArrayList();
        railroads = new ArrayList();
        utilities = new ArrayList();
    }
}
