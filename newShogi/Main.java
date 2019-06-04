import java.util.Scanner;
import java.util.ArrayList;
public class Main{
    private static Scanner sc;
    private static Shogi newGame;
    private static ArrayList<GameInfo> res;
    public static void main(String[] args){
        System.out.print("\f");
        sc = new Scanner(System.in);
        res = new ArrayList<GameInfo>();
        while(true){
            System.out.println("Player 1 Name");
            String p1 = sc.nextLine();
            System.out.println("Player 2 Name");
            String p2 = sc.nextLine();
            
            newGame = new Shogi(p1, p2);
            res.add(newGame.info());
            
            System.out.println("See results?");
            if(sc.nextLine().toUpperCase().equals("Y")){
                PrintResult pRes = new PrintResult(res);
            }
            
            System.out.println("End game?");
            if(sc.nextLine().toUpperCase().equals("Y")){
                break;
            }
        }
    }
}