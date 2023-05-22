package SettingWindow;

import java.util.List;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ImageUtils {
    public static List<ImageItem> loadImagesFromDirectory(String directoryPath) {
        List<ImageItem> imageItems = new ArrayList<>();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null ) {
            for (File file : files ) {
                if(file.isFile()) {
                    try {
                        Image image = ImageIO.read(file);
                        String name = file.getName();
                        ImageItem imageItem = new ImageItem(image,name);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return imageItems;
    }
}
