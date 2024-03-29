import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GUI{
    private Koma[][] BoardGraph = new Koma[9][9];
    private JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] boardSquares = new JButton[9][9];
    private JPanel board;
    private JLabel message = new JLabel("Player's Turn");
    private JButton b1;

    public GUI() {
        System.out.print("\f");
        Gui();
    }

    public void Gui(){ 
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(b1 = new JButton("New"));
        tools.addSeparator();
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Popup newPopup = new Popup("Resign?");
                if(newPopup.getResult()){
                    BoardGraphics newBoard = new BoardGraphics();
                    BoardGraph = newBoard.getBoard();
                }
                newPopup.disposeWindow();
            }
        });
        
        tools.add(message);


        board = new JPanel(new GridLayout(0, 10));
        board.setBorder(new LineBorder(Color.BLACK));
        gui.add(board);

        printBoardSquares();
        
    }
    

    public ImageIcon getImage(ImageIcon icon){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("koma_pics1/王将.png"));
        } catch (IOException ex) {
            // handle exception...
        }
        ImageIcon img = new ImageIcon(image);
        return img;
    }

    public JComponent getGui(){
        return gui;
    }
    
    public void printBoardSquares(){
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);

                ImageIcon icon = new ImageIcon();
                icon = getImage(icon);
                b.setIcon(icon);
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
}