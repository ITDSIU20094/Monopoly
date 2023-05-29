package SettingWindow;

import java.io.Serializable;

public class CardFactory implements Serializable {
    private static CardFactory _instance;

    public static CardFactory getInstance() {
        if (_instance == null) {
            _instance = new CardFactory();
        }
        return _instance;
    }
    public String CCCard_names[] =[];
}
