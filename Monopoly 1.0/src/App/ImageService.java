package App;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class ImageService {
    public static JLabel loadImage(String filePath){
        BufferedImage image;
        JLabel imageContainer;
        try {
            InputStream inputStream = ImageService.class.getResourceAsStream(filePath);
            assert inputStream != null;
            image = ImageIO.read(inputStream);
            imageContainer = new JLabel(new ImageIcon(image));
            return imageContainer;
        } catch(Exception e){
            System.out.println("Error: "+e);
            return null;
        }
    }

    public static void updateImage(JLabel imageContainer, String filePath){
        BufferedImage image;
        try{
            InputStream inputStream = ImageService.class.getResourceAsStream(filePath);
            assert inputStream != null;
            image = ImageIO.read(inputStream);
            imageContainer.setIcon(new ImageIcon(image));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
