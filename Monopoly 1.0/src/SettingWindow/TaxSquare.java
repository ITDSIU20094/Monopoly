package SettingWindow;

public class TaxSquare extends Square{
    public TaxSquare(String n, String t) {
        super(n, t);

    }


    @Override
    public void evaluateSquare(GameEngine gameEngine) {
        Player currentPlayer = gameEngine.getPlayerController().getCurrentPlayer();
        MoneyController.getInstance().decreaseMoney(currentPlayer,200);
        gameEngine.publishEvent("empty");
    }
}
