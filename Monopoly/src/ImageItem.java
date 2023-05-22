import java.awt.Image;
public class ImageItem {
    private Image image;
    private String name;
    public ImageItem(Image image, String name) {
        this.image= image;
        this.name = name;

    }

    public Image getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
