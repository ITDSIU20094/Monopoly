package SettingWindow;


import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Pawn implements Drawable {
    private Point position;
    private Path myPath;
    private int positionIndex;
    //private Player player;
    private Image pawnImage;
    Animator animator = Animator.getInstance();
    ArrayList<Integer> path = new ArrayList<>();
    //HashMap<Integer, Point[]> squareMap = Board.getInstance().getSquareMap();


    @Override
    public void draw(Graphics g) {

    }
}
