package SettingWindow;

import java.io.OptionalDataException;
import java.io.Serializable;

public class CardFactory implements Serializable {
    private static CardFactory _instance;


    public static CardFactory getInstance() {
        if (_instance == null) {
            _instance = new CardFactory();
        }
        return _instance;
    }
    public String ChanceCard_names[] = {"Go to Special Cell","Receive Money From the Bank","Receive the Prison ticket",
                                            "Good luck next time","Receive a roll turn"};

    public boolean goToSpecialCell= true;
    public boolean receiveMoneyFromtheBank = true;
    public boolean receiveThePrisonticket = true;
    public boolean goodLuckNextTime = true;
    public boolean receiveArollTurn = true;

    public ChanceCard createChanceCard(int index) {
        switch (index) {
            case 0:
                return new ChanceGoToSpecialCell();
        }
    }

}
