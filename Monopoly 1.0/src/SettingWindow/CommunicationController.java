package SettingWindow;

import App.RegularDie;

import java.util.ArrayList;

public class CommunicationController {
    private static CommunicationController _instance;
    private GameEngine gameEngine = GameEngine.getInstance();
    private RegularDie regularDie = RegularDie.getInstance();
    private MoneyController moneyController = MoneyController.getInstance();
    private CommunicationController() {

    }
    public static CommunicationController getInstance() {
        if (_instance == null) {
            _instance = new CommunicationController();
        }
        return _instance;
    }
    public void processInput(Object objectInput) {
        if (objectInput instanceof String) {
            String input = (String) objectInput;
            if (input.contains("game")) {
                if (includes(rest(input), "start")) {
                    gameEngine.startGame();
                }
            } else if (input.contains("player")) {
                if (includes(rest(input), "create")) {

                } else if (includes(rest(input), "next")) {
                    gameEngine.nextTurn();
                }
            } else if (input.indexOf("message") != -1) {
                gameEngine.publishEvent("message/" + rest(input));
            } else if (input.contains("dice")) {
                ArrayList<Integer> regularDice = new ArrayList<>();
                String[] values = input.split("/");
                regularDice.add(Integer.parseInt(values[1]));
                regularDice.add(Integer.parseInt(values[2]));
                regularDie.setLastValues(regularDice);

                gameEngine.calculatePath();
            } else if (input.contains("penalty")) {
                PlayerController.getInstance().putInJail();
                PlayerController.getInstance().movePlayer(10);
                GameEngine.getInstance().publishEvent("teleport"+10);
            }else if (input.contains("purchase")) {
                gameEngine.buy();
            } else if (input.contains("card")) {
                if (rest(input).contains("draw")) {
                    gameEngine.drawCard();
                } else if (rest(input).contains("play")) {
                    gameEngine.playCard();
                }
            } else if (input.contains("improve/")) {
                gameEngine.improveProperty(Integer.parseInt(rest(input)));
            } else if (input.contains("teleport/")) {
                PlayerController.getInstance().movePlayer(Integer.parseInt(rest(input)));
                gameEngine.publishEvent("teleport" + Integer.parseInt(rest(input)));
            } else if (input.contains("demolished/")) {
                gameEngine.downgradeProperty(Integer.parseInt(rest(input)));
            } else if (input.contains("improveProperty")) {
                gameEngine.tryImproveProperty();
            } else if (input.contains("resume")) {
                gameEngine.resume();
            } else if (input.contains("pause")) {
                gameEngine.pause();

            }

        } else if (objectInput instanceof PlayerController) {
            PlayerController.getInstance().exchangePlayerControllerData((PlayerController) objectInput);
            gameEngine.publishEvent("refreshPlayerDisplay");
        } else if (objectInput instanceof DomainBoard) {
            gameEngine.getDomainBoard().exchangeDomainBoardData((DomainBoard) objectInput);
            gameEngine.publishEvent("refreshPlayerDisplay");
        } else if (objectInput instanceof MoneyController) {
            moneyController.exchangeMoneyControllerData((MoneyController) objectInput);
        }
    }
    private String rest(String word) {
        int slashIndex = word.indexOf('/');
        if (slashIndex == -1)
            return word;
        return word.substring(slashIndex + 1);
    }

    private boolean includes(String sentence, String word) {
        return (sentence.indexOf(word) != -1);
    }
}
