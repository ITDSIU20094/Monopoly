package SettingWindow;

public abstract class ChanceCard extends Card{
    public ChanceCard(String title, boolean isImmediate) {
        super(title, isImmediate);
    }
    public abstract void playCard(GameEngine gameEngine);

}
