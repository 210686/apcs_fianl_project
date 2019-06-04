import java.awt.*;
import javax.swing.*;
public class Game {
    private GUI gui;
    private static JFrame f;
    private static Game cb;
    public Game() {
        gui = new GUI();
    }

    public Game(Koma[][] oldBoard) {
        f.getContentPane().removeAll();
        f.repaint();
        
        gui = new GUI(oldBoard);
        f.add(getGameGui());
    }

    public JComponent getGameGui(){
        return gui.getGui();
    }

    public static void main(String[] args) {
        Runnable r = new Runnable()
            {
                @Override
                public void run() {
                    cb = new Game();
                    f = new JFrame("Shogi");
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