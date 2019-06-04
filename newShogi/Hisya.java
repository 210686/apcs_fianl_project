import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class Hisya implements Koma{
    private int[][] moveSet = new int[2][8];
    private int order;
    
    public int[][] getMoveSet(){
        if(order == 1){
            return getMoveSet1();
        }
        else{
            return getMoveSet2();
        }
    }
    public int[][] getMoveSet1(){
        return moveSet;
    }
    public int[][] getMoveSet2(){
        return moveSet;
    }
    
    public ImageIcon getKoma(){
        BufferedImage image = null;
        try {
            if(order == 1){
                image = ImageIO.read(new File("koma_pics/飛車.png"));
            }
            else{
                image = ImageIO.read(new File("koma_pics1/飛車.png"));
            }
        } catch (IOException e) {}
        
        ImageIcon img = new ImageIcon(image);
        return img;
    }
    
    public Hisya(int order){
        this.order = order;
    }
}