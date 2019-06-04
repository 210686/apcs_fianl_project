import javax.swing.*;
public class BoardGraphics{
    private Koma[][] board = new Koma[9][9];
    public BoardGraphics(){
        //set initial board
        for(int i = 0; i < 81; i++){
            board[i/9][i%9] = new Funari();
        }
    }
    public BoardGraphics(boolean first, String str){
        //get move for initial click
        
        
        //get move for moving click
        
    }
    public ImageIcon getImage(int i, int j){
        return board[i][j].getKoma();
    }
}