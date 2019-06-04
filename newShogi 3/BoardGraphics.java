public class BoardGraphics{
    private Koma[][] board = new Koma[9][9];
    public BoardGraphics(){
        //set initial board
    }
    public BoardGraphics(Koma[][] board){
        this.board = board;
        //get move
    }
    public Koma[][] getBoard(){
        return board;
    }
}