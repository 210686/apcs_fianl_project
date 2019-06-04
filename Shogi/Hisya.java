public class Hisya extends Koma{
    public boolean[][] getMove(){
        boolean[][] moves = new boolean[3][3];
        
        moves[0][1] = true;
        moves[1][0] = true;
        moves[1][2] = true;
        moves[2][1] = true;
        
        return moves;
    }
}