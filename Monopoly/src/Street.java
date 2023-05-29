import java.awt.Image;

/**
 * Class to represent street objects which is a subclass of property.
 */
public class Street extends Property {

    private int houses = 0;// 6 houses represents a hotel.
    private int rent;
    private int housePrice;

    /**
     * Constructs a street object
     * @param ID
     * @param name
     * @param propertyValue
     * @param color
     * @param rent
     * @param housePrice
     */
    public Street(int ID, String name, int propertyValue,Color color,int rent,int housePrice,Image img) {
        super(ID, name, propertyValue,color,img);
        this.rent = rent;
        this.housePrice = housePrice;

        color.addStreet(this);
    }

    /**
     * Adds a house to a property iff there is not more than 5 houses.
     */
    public boolean addHouse(int amount){
        if(this.getOwner().getMoneyAmount() >= housePrice * amount){
            if(amount == 0 || (houses + amount) > 6){
                return false;
            }
            houses += amount;
            this.getOwner().addMoney(-(housePrice * amount));
            return true;
        }
        return false;
    }
    /**
     * Gets the amount of houses on the property
     * @return
     */
    public int getHouses(){
        return houses;
    }

    public int rent(Player player) {
        int numberOfHousesInProgress = houses; // Get the number of houses in progress

        // Calculate the rent amount based on the number of houses in progress and the plot price
        int rentAmount = (int) (rent + (housePrice * 1.2 * numberOfHousesInProgress));

        // Deduct the rent amount from the player's money and add it to the property owner's money
        player.addMoney(-rentAmount);
        getOwner().addMoney(rentAmount);

        return rentAmount;
    }
}