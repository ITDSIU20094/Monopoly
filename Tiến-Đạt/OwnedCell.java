package gui;
public abstract class OwnedCell extends Cell implements IOwnable{

    private boolean available = true;
    protected Player owner;

    public OwnedCell() {
        super();
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public Player getOwner() {
        return owner;
    }

    @Override
    public void setOwner(Player owner) {
        this.owner = owner;
    }

}
