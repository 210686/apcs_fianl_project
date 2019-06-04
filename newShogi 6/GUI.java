import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

public class GUI{
    private JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] boardSquares = new JButton[9][9];
    private JPanel board;
    private final JLabel message = new JLabel("Player");
    private JButton b1;
    private BoardGraphics boardGui = new BoardGraphics();
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
                public void actionPerformed(ActionEvent e) {
                    Popup newPopup = new Popup("Resign?");
                    if(newPopup.getResult()){
                        boardGui = new BoardGraphics();
                        printBoardSquares();
                    }
                    newPopup.disposeWindow();
                }
            });

        board = new JPanel(new GridLayout(0, 10));
        board.setBorder(new LineBorder(Color.BLACK));
        gui.add(board);

        printBoardSquares();
    }

    public JComponent getGui(){
        return gui;
    }

    public void printBoardSquares(){
        ActionListener listener = new ActionListener(){
            int count = 0;
            int x,y;
                public void actionPerformed(ActionEvent e){
                    Object source = e.getSource();
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) { 
                            if (source == boardSquares[i][j]) {
                                int newMoveSet[][] = boardGui.getMoves(i, j);
                                if(count == 1){
                                    for(int k = 0; k < newMoveSet.length; k++){
                                        if(x - i == newMoveSet[0][k] && y - j == newMoveSet[1][k]){
                                            boardGui.changeLocation(i, j , newMoveSet[0][k], newMoveSet[1][k]);
                                        }
                                    }
                                    count = 0;
                                    x = 0;
                                    y = 0;
                                }
                                if(count == 0){
                                    x = i;
                                    y = j;
                                    count++;
                                }
                                System.out.println(count);
                            }
                        }
                    }
                }
            };

        Insets buttonMargin = new Insets(0,0,0,0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                ImageIcon icon = new ImageIcon();
                icon = boardGui.getImage(i,j);
                b.setIcon(icon);
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
                    boardSquares[i][j].addActionListener(listener);
                    board.add(boardSquares[j][i]);
                }
            }
        }
    }
}