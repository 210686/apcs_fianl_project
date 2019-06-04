import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class Kyosya implements Koma{
    private int[][] moveSet;
    private int order;
    
    public int[][] getMoveSet(){
        return moveSet;
    }
    
    public ImageIcon getKoma(){
        BufferedImage image = null;
        try {
            if(order == 1){
                image = ImageIO.read(new File("koma_pics/香車.png"));
            }
            else{
                image = ImageIO.read(new File("koma_pics1/香車.png"));
            }
        } catch (IOException e) {}
        
        ImageIcon img = new ImageIcon(image);
        return img;
    }
    
    public Kyosya(int order){
        this.order = order;
    }
}