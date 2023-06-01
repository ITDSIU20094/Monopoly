package gui;
public abstract class Card {
    /*
     * Pulled up type variable and getCardType to abstract class, removed cardType variable in MoneyCard
     */
    public static int TYPE_CHANCE = 1;
    public static int TYPE_CC = 2;
    protected int type;

    public abstract String getLabel();
    public abstract void applyAction();
    public int getCardType() {
        return type;
    }
}
