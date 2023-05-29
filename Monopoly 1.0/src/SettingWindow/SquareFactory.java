package SettingWindow;

import java.io.Serializable;

public class SquareFactory implements Serializable {
    private static SquareFactory _instance;

    private SquareFactory() {

    }

    public static SquareFactory getInstance() {
        if(_instance == null) {
            _instance = new SquareFactory();
        }
        return _instance;
    }
}
