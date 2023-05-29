import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * enums to represent pieces that each player has
 */
public enum Piece {
    Hat, Car, Dog, Iron;
    public static Image getImage(Player player){
        try {
            switch(player.getPiece()){
                case Hat:
                    return ImageIO.read(new File("src/tokens/monopoly_token_hat.png"));
                case Car:
                    return ImageIO.read(new File("src/tokens/monopoly_token_car.png"));
                case Dog:
                    return ImageIO.read(new File("src/tokens/monopoly_token_dog.png"));
                case Iron:
                    return ImageIO.read(new File("src/tokens/monopoly_token_iron.png"));
                default:
                    throw new Exception();
            }
        } catch (Exception e) {e.printStackTrace();}
        return null;
    }
}