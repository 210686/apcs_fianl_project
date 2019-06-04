public class Keima extends Koma{
    public boolean[][] getMove(){
        boolean[][] moves = new boolean[5][5];
        
        moves[0][3] = true;
        moves[0][1] = true;
        
        return moves;
    }
}