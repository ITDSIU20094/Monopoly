package Domain.Model.Square;

import Domain.Model.GameEngine;
import Domain.Model.Player;

import javax.swing.text.html.Option;

public class PropertySquare extends Square {
    private Player owner = null;
    private int price;
    private String color;
    private int rentFactor;
    private int rentListIndex;
    private int[] rentList;
    private boolean isMortgaged;

    public PropertySquare(String n, String t, int p, String color, int[] rentList) {
        super(n, t);
        setOwner(null);
        setPrice(p);
        setRentList(rentList);
        setMortgage(false);
        setRentListIndex(0);
        setRentFactor(1);
        setColor(color);
    }

    public int getRent() {
        return calculateRent();
    }
    private int calculateRent()
    {
        if (getRentListIndex() <= 3) return rentFactor * rentList[getRentListIndex()];
        else return 0;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int numHouses()
    {
        if (getRentListIndex() <= 3) return getRentListIndex();
        else return 0;
    }



    public boolean getMortgaged()
    {
        return isMortgaged;
    }

    public void mortgage() {
        if (!isMortgaged) {
            setMortgage(true);
            rentListIndex = 3;
        }
    }
    public void removeMortgage() {
        if (isMortgaged) {
            setMortgage(false);
            rentListIndex = 0;
        }
    }

    private void setMortgage(boolean mortgageVal) {
        this.isMortgaged = mortgageVal;
    }
    public boolean canBeImproved() {
        return (getRentListIndex() < 3);
    }

    public boolean canBeDowngraded() {
        return (getRentListIndex() > 0);
    }
    public void improve() {
        //change inventory
        if (canBeImproved()) setRentListIndex(rentListIndex + 1);
    }
    public void downgrade() {
        //change inventory
        if (canBeDowngraded()) setRentListIndex(rentListIndex - 1);
    }
    public int getPrice() {
        return price;
    }

    public int getHousePrice()
    {
        return rentList[4];
    }
    public void setPrice(int newPrice) {
        this.price = newPrice;
    }

    public Player getOwner() {
        return owner;
    }
    public void setOwner(Player owner) {
        if (!isOwned()) this.owner = owner;
    }

    public int getRentFactor() {
        return rentFactor;
    }
    public void setRentFactor(int rentFactor) {
        this.rentFactor = rentFactor;
    }

    public int getRentListIndex() {
        return rentListIndex;
    }

    public void setRentListIndex(int rentListIndex) {
        this.rentListIndex = rentListIndex;
    }

    public int[] getRentList() {
        return rentList;
    }
    public void setRentList(int[] rentList) {
        this.rentList = rentList;
    }

    public boolean isOwned() {
        return owner != null;
    }
    @Override
    public void evaluateSquare(GameEngine gameEngine) {
        if (this.getOwner() == null) {
            gameEngine.publishEvent("buy");
        } else {
            Player currentPlayer = gameEngine.getPlayerController().getCurrentPlayer();
            if(!this.getOwner().getName().equals(currentPlayer.getName())) {
                gameEngine.payRent(currentPlayer, this.getOwner() , this.getRent());
                gameEngine.publishEvent("message/" + "[System]: " + currentPlayer.getName()+ " paid rent to " + this.getOwner().getName());
            }
        }

    }

    @Override
    public Option trigger(Player player) {
        return null;
    }

    public boolean repOk() {
        if(this.getName() != null && price > 0 && color != null && rentFactor > 0 && rentList != null && rentList.length == 4) {
            for(int rentPrice : this.getRentList()) {
                if(rentPrice <= 0) return false;
            }
            return  true;
        }
        return false;
    }
    @Override
    public String toString() {
        return this.getName() + ", " + this.getColor() + "( Current rent: " + this.getRent() + ")";
    }

}
