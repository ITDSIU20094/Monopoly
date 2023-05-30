public class Festival extends Special {

    public Festival(int ID, String name) {
        super(ID, name);
    }

    @Override
    public Option trigger(Player player) {
        return null;
    }
}
