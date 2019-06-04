import java.awt.*;
import javax.swing.*;
public class Game {
    private GUI gui;
    public Game() {
        gui = new GUI();
    }
    public JComponent getGameGui(){
        return gui.getGui();
    }

    public static void main(String[] args) {
        Runnable r = new Runnable()
            {
                @Override
                public void run() {
                    Game cb = new Game();
                    JFrame f = new JFrame("Shogi");
                    f.add(cb.getGameGui());
                    
                    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    f.setLocationByPlatform(true);
                    f.pack();
                    f.setMinimumSize(f.getSize());
                    f.setMaximumSize(f.getSize());
                    f.setLocationRelativeTo(null);
                    f.setVisible(true);
                }
            };
        SwingUtilities.invokeLater(r);
    }
}