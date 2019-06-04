public class GameInfo{
    private String p1, p2, winner;
    public GameInfo(String p1, String p2, String winner){
        this.p1 = p1;
        this.p2 = p2;
        this.winner = winner;
    }
    public String getP1(){
        return p1;
    }
    public String getP2(){
        return p2;
    }
    public String getWinner(){
        return winner;
    }
}