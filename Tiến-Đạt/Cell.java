package gui;
public abstract class Cell {
    private String name;
    public String getName() {
        return name;
    }

    public int getPrice() {
        return 0;
    }

    public abstract void playAction();

    void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
