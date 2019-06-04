import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class Kakugyo implements Koma{
    private int[][] moveSet = new int[2][32];
    private int order;

    public int[][] getMoveSet(){
        for(int i = 0; i < 8; i++){
            moveSet[0][i*4] = -(i+1);
            moveSet[1][i*4] = (i+1);

            moveSet[0][i*4+1] = (i+1);
            moveSet[1][i*4+1] = (i+1);

            moveSet[0][i*4+2] = -(i+1);
            moveSet[1][i*4+2] = -(i+1);

            moveSet[0][i*4+3] = (i+1);
            moveSet[1][i*4+3] = -(i+1);
        }

        return moveSet;
    }

    public ImageIcon getKoma(){
        BufferedImage image = null;
        try {
            if(order == 1){
                image = ImageIO.read(new File("koma_pics/角行.png"));
            }
            else{
                image = ImageIO.read(new File("koma_pics1/角行.png"));
            }
        } catch (IOException e) {}

        ImageIcon img = new ImageIcon(image);
        return img;
    }

    public Kakugyo(int order){
        this.order = order;
    }

    public int getOrder(){
        return order;
    }

    public String getName(){
        return "角";
    }
}