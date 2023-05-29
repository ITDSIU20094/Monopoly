import java.awt.Image;

/**
 *  A class to represent Railway or BusStation cell depending on how you call on the board game.
 */
public abstract class Railway extends Property {
    private boolean plotAvailable; // Track if the plot of land is available for purchase

    public Railway(int ID, String name, int propertyValue, Color color, Image img) {
        super(ID, name, propertyValue, color, img);
        plotAvailable = true; // The plot of land is initially available
    }

    public void enterTile(Player player) {
        if (plotAvailable) {
            // Display prompt to the player to buy the plot of land
            boolean buyPlot = displayBuyPlotPrompt(player);

            if (buyPlot) {
                // Set the owner of the plot to the player
                setOwner(player);

                // Teleport the player to this tile
                player.setPosition(getID());

                // Mark the plot as unavailable
                plotAvailable = false;
            }
        }
    }

    private boolean displayBuyPlotPrompt(Player player) {
        return false;
        // Implement the logic to display a prompt to the player and return their choice
        // You can use any UI framework or console input methods here
        // Return true if the player chooses to buy the plot, false otherwise
    }
}