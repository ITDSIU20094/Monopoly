import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
public class Pawn implements Drawable{
    private Point position;
    private Path myPath;
    private int positionIndex;
    private Player player;
    private Image pawnImage;
    // Animator animator = Animator.getInstance();
    ArrayList<Integer> path = new ArrayList<>();
    HashMap<Integer, Point[]> squareMap = Board.getInstance().getSquareMap();

    public Pawn (Point point, Player player, File imFile) {
        this.position = new Point(point.x, point.y);
        this.player= player;
        setupPawnImage(imFile);
        //animator.addDrawable(this);

    }
    public  Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
    public void setupPawnImage(File imFile) {

    }

    @Override
    public void draw(Graphics g) {

    }
}
