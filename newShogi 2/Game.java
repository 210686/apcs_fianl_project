import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import javax.swing.*;
import javax.swing.border.*;

public class Game {
    private String[][] Koma = new String[9][9];
    private JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] boardSquares = new JButton[9][9];
    private JPanel board;
    private JLabel message = new JLabel(
            "Player's Turn");

    public Game() {
        Gui();
    }

    public void Gui() {
        
        
        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(new JButton("Resign")); // TODO - add functionality!
        tools.addSeparator();
        tools.add(message);

        board = new JPanel(new GridLayout(0, 10));
        board.setBorder(new LineBorder(Color.BLACK));
        gui.add(board);

        // create the chess board squares
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                // our chess pieces are 64x64 px in size, so we'll
                // 'fill this in' using a transparent icon..
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                b.setText();
                
                b.setFont(new Font("Arial", Font.PLAIN, 40));
                b.setForeground(Color.RED);
                boardSquares[j][i] = b;
            }
        }

        board.add(new JLabel(""));
        for (int i = 0; i < 9; i++) {
            board.add(
                new JLabel(String.valueOf(i + 1), SwingConstants.CENTER));
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                switch (j) {
                    case 0:
                    if(i == 0){board.add(new JLabel("一",
                                SwingConstants.CENTER));}
                    if(i == 1){board.add(new JLabel("二",
                                SwingConstants.CENTER));}
                    if(i == 2){board.add(new JLabel("三",
                                SwingConstants.CENTER));}
                    if(i == 3){board.add(new JLabel("四",
                                SwingConstants.CENTER));}
                    if(i == 4){board.add(new JLabel("五",
                                SwingConstants.CENTER));}
                    if(i == 5){board.add(new JLabel("六",
                                SwingConstants.CENTER));}
                    if(i == 6){board.add(new JLabel("七",
                                SwingConstants.CENTER));}
                    if(i == 7){board.add(new JLabel("八",
                                SwingConstants.CENTER));}
                    if(i == 8){board.add(new JLabel("九",
                                SwingConstants.CENTER));}

                    default:
                    board.add(boardSquares[j][i]);
                }
            }
        }
    }

    public final JComponent getboard() {
        return board;
    }
    public final JComponent getGui() {
        return gui;
    }
    public static void main(String[] args) {
        Runnable r = new Runnable()
            {
                @Override
                public void run() {
                    Game cb =
                        new Game();
                    JFrame f = new JFrame("ChessChamp");
                    f.add(cb.getGui());
                    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    f.setLocationByPlatform(true);
                    // ensures the frame is the minimum size it needs to be
                    // in order display the components within it
                    f.pack();
                    // ensures the minimum size is enforced.
                    f.setMinimumSize(f.getSize());
                    f.setMaximumSize(f.getSize());
                    f.setLocationRelativeTo(null);
                    f.setVisible(true);
                }
            };
        SwingUtilities.invokeLater(r);
    }
}