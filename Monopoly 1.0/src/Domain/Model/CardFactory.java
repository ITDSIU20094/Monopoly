package Model;

import Model.Cards.*;

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
                return new ChanceGoToSpecialCell(ChanceCard_names[index],goToSpecialCell);
            case 1:
                return new ReceiveMoneyFromTheBank(ChanceCard_names[index],receiveMoneyFromtheBank);
            case 2:
                return new ChanceReceiveThePrisonTicket(ChanceCard_names[index],receiveThePrisonticket);
            case 3:
                return new GoodLuckNextTime(ChanceCard_names[index], goodLuckNextTime);
            case 4:
                return new ChanceReceiveArollTurn(ChanceCard_names[index], receiveArollTurn);
            default:
                return null;
        }

    }

}
