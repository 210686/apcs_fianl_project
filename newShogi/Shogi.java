import java.util.ArrayList;
public class Shogi{
    private String p1, p2, winner;
    public Shogi(String p1, String p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    public GameInfo info(){
        return new GameInfo(p1, p2, winner);
    }
}