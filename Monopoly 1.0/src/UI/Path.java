package UI;

import java.awt.*;

public interface Path {
    public boolean hasMoreSteps();

    public Point nextPosition();
}
