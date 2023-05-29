package SettingWindow;

public class ChanceCardSquare extends Square {

    public ChanceCardSquare(String name, String type) {
        super(name, type);
    }

    @Override
    public void evaluateSquare(GameEngine gameEngine) {
        gameEngine.publishEvent("drawCard");

    }

}