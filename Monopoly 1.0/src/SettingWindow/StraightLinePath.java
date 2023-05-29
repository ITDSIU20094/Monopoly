package SettingWindow;

import java.awt.Point;

public class StraightLinePath implements Path{
    int startX, startY, endX, endY, steps;
    int currentStep = -1;
    double deltaX, deltaY;


    public StraightLinePath(int X1, int Y1, int X2, int Y2, int numSteps) {
        startX = X1;
        startY = Y1;
        endX = X2;
        endY = Y2;
        steps = numSteps;
        deltaX = ((double)(X2 - X1)) / steps;
        deltaY = ((double)(Y2 - Y1)) / steps;
    }


    public boolean hasMoreSteps() {
        if (currentStep > steps)
            return false;
        return true;
    }


    public Point nextPosition() {
        currentStep++;
        if (currentStep > steps)
            return new Point(endX, endY);
        return new Point((int)(startX + (deltaX * currentStep)),
                (int)(startY + (deltaY * currentStep)));
    }
}