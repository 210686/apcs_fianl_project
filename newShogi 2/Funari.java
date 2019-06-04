import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class Funari implements Koma{
    private int[][] moveSet;
    public int[][] getMoveSet(){
        return moveSet;
    }
    
    public ImageIcon getKoma(){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("koma_pics/王将.png"));
        } catch (IOException ex) {}
        
        ImageIcon img = new ImageIcon(image);
        return img;
    }
    
    public static void main(String[] args){
        
    }
}