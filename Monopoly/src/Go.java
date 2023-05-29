/**
 * Class to represent the Go location
 */
public class Go extends Special{

    final static int salary = 200;
    /**
     * Constructs a Go Cell
     * @param ID
     * @param name
     */
    public Go(int ID, String name) {
        super(ID, name);

    }
    public Option trigger(Player player) {
        player.addMoney(salary);
        return null;
    }
}