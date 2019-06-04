import javax.swing.*;
import java.awt.image.BufferedImage;
public class BoardGraphics{
    private Koma[][] board = new Koma[9][9];
    public BoardGraphics(){

    }

    public ImageIcon getImage(int i, int j){
        try{
            return board[i][j].getKoma();
        } catch(NullPointerException e){
            return new ImageIcon(
                new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
        }
    }

    public int[][] getMoves(int i, int j){
        try{
            return board[j][i].getMoveSet();
        } catch(NullPointerException e){return new int[0][0];}
    }

    public void changeLocation(int x, int y, int newX, int newY){
        Koma temp = board[y][x];
        board[y][x] = null;
        board[y - newY][x - newX] = temp;
        
        System.out.println(y - newY + " " + (x - newX));
    }

    public void setInitialBoard(){
        //set initial board
        for(int i = 0; i < 9; i++){
            board[0][4] = new Osho(-1);
            board[8][4] = new Osho(1);

            board[0][3] = new Kinsho(-1);
            board[0][5] = new Kinsho(-1);
            board[8][3] = new Kinsho(1);
            board[8][5] = new Kinsho(1);

            board[0][2] = new Ginsho(-1);
            board[0][6] = new Ginsho(-1);
            board[8][2] = new Ginsho(1);
            board[8][6] = new Ginsho(1);

            board[0][1] = new Keima(-1);
            board[0][7] = new Keima(-1);
            board[8][1] = new Keima(1);
            board[8][7] = new Keima(1);

            board[0][0] = new Kyosya(-1);
            board[0][8] = new Kyosya(-1);
            board[8][0] = new Kyosya(1);
            board[8][8] = new Kyosya(1);

            board[1][1] = new Hisya(-1);
            board[7][7] = new Hisya(1);

            board[1][7] = new Kakugyo(-1);
            board[7][1] = new Kakugyo(1);

            board[2][i] = new Fu(-1);
            board[6][i] = new Fu(1);
        }
    }

    public void changeBoard(Koma[][] newBoard){
        this.board = newBoard;
    }

    public Koma[][] getBoard(){
        for(int i = 0; i < 81; i++){
            try{
                String str = board[i / 9][i % 9].toString();
                str = str.substring(0,3);
                System.out.print(str + " ");
            } catch(Exception e){System.out.print("nul ");}
            if(i % 9 == 8){System.out.println();}
        }
        System.out.println();
        return board;
    }
}