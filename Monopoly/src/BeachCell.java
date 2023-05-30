public class BeachCell extends Cell {
    private Player owner;
    private int beachCount;

    public BeachCell(int ID, String name) {
        super(ID,name);
        this.owner = null;
        this.beachCount = 0;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getBeachCount() {
        return beachCount;
    }

    public void addBeach() {
        beachCount++;
    }

    public boolean isFullyOwned() {
        return beachCount >= 4;
    }

    @Override
    public Option trigger(Player player) {
        if (owner == null) {
            // The beach cell is unowned, so the player can choose to buy it
            // Implement the logic for purchasing the cell here
        } else if (owner == player) {
            // The player already owns this beach cell, so no action is required
        } else {
            // The beach cell is owned by another player, so the player needs to pay rent
            // Implement the logic for paying rent here
        }
        return null;
    }
}