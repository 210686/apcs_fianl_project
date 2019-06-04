public class Gin extends Koma{
    public boolean[][] getMove(){
        boolean[][] moves = new boolean[3][3];
        
        moves[0][0] = true;
        moves[0][1] = true;
        moves[0][2] = true;
        moves[2][0] = true;
        moves[2][2] = true;
        
        return moves;
    }
}