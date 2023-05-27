package SettingWindow;
import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;
import java.util.Vector;

public class Animator extends JPanel implements Runnable {
    private static Animator _instance;
    Vector elementsToDraw = new Vector();

    public Animator(JPanel jFrame) {
        animFrame = jFrame;
        setPreferredSize(new Dimension(1, 1));
        setOpaque(false);
        _instance = this;

    }
    public static Animator getInstance() {
        return _instance;
    }
    private JPanel animFrame;
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                System.out.println("Program Interrupted");
                System.exit(0);
            }

            if (!GameEngine.getInstance().isPaused()) {
                animFrame.repaint();
            }
        }
    }
    @Override
    public void paint(Graphics g) {
        //System.out.println("Paint Method Called");
        Enumeration e = elementsToDraw.elements();
        while (e.hasMoreElements()) {
            Object o = e.nextElement();
            if(o instanceof Drawable)
                ((Drawable) o).draw(g);
            else {
                System.out.println("[Animator]: " + o);
            }
        }
    }
    public void addDrawable(Drawable d) {
        elementsToDraw.addElement(d);
    }
    public void deleteDrawable(Drawable d) {
        elementsToDraw.remove(d);
    }

    public void removeDrawable(Drawable d) {
        elementsToDraw.removeElement(d);
    }
}
