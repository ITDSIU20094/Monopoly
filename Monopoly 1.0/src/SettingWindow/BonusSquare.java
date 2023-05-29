package SettingWindow;

public class BonusSquare extends Square {

    public BonusSquare(String n, String t) {
        super(n, t);
        this.setFlyover(true);
    }


    @Override
    public void evaluateSquare(GameEngine gameEngine) {
        Player currentPlayer = gameEngine.getPlayerController().getCurrentPlayer();
        MoneyController.getInstance().increaseMoney(currentPlayer, 300);

        gameEngine.publishEvent("empty");
    }


    @Override
    public void evaluateSquare(GameEngine gameEngine, String args) throws IllegalArgumentException
    {
        if (args.equals("flyover"))
        {
            Player currentPlayer = gameEngine.getPlayerController().getCurrentPlayer();
            MoneyController.getInstance().increaseMoney(currentPlayer, 250);
        }
        else
        {
            throw new IllegalArgumentException("Illegal argument: " + args);
        }
    }
}