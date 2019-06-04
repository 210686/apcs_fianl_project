import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        System.out.print("\f");
        
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        String n1 = "", n2 = "";
        while(!done){
            System.out.println("Enter P1 Name");
            n1 = sc.nextLine();
            System.out.println("Enter P2 Name");
            n2 = sc.nextLine();
        }
        Shogi newGame = new Shogi(n1, n2);
    }
}