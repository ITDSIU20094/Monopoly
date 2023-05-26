package SettingWindow;


import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Pawn {


    public static List<String> getPawnImages() {
        String pathToPawnImages = "/Monopoly/Monopoly/.assets/Pawn/";
        List<String> pawnImages = new ArrayList<>();

        File folder = new File(pathToPawnImages);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file: files) {
                if (file.isFile() && file.getName().endsWith(".png")) {
                    pawnImages.add(file.getName());
                }
            }
        }
        return pawnImages;
    }

}
