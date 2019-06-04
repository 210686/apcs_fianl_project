import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class Keima implements Koma{
    private int[][] moveSet;
    private int order;
    
    public int[][] getMoveSet(){
        return moveSet;
    }
    
    public ImageIcon getKoma(){
        BufferedImage image = null;
        try {
            if(order == 1){
                image = ImageIO.read(new File("koma_pics/桂馬.png"));
            }
            else{
                image = ImageIO.read(new File("koma_pics1/桂馬.png"));
            }
        } catch (IOException e) {}
        
        ImageIcon img = new ImageIcon(image);
        return img;
    }
    
    public Keima(int order){
        this.order = order;
    }
}