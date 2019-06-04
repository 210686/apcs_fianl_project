import java.util.Scanner;
import java.util.ArrayList;
import java.text.*;
public class PrintResult{
    private Scanner sc;
    private ArrayList<GameInfo> arr;
    public PrintResult(ArrayList<GameInfo> arr){
        sc = new Scanner(System.in);

        this.arr = arr;
        printPerGame();
        printPerPlayer();
        sc.nextLine();
    }

    public void printPerGame(){
        System.out.println("Game|     P1     | |     P2     | |");
        for(int i = 0; i < arr.size(); i++){
            if(i>arr.size()-10){
                System.out.print("   " + (i + 1) + "|");

                
                System.out.print(printWithStr(12, arr.get(i).getP1()) + "|");
                if(arr.get(i).getWinner().equals(arr.get(i).getP1())){
                    System.out.print("○|");
                }
                else{System.out.print("✖|");}

                System.out.print(printWithStr(12, arr.get(i).getP2()) + "|");
                if(arr.get(i).getWinner().equals(arr.get(i).getP2())){
                    System.out.print("○|");
                }
                else{System.out.print("✖|");}
            }

            System.out.println("–––––" + "–––––––––––––" + "––" + "–––––––––––––" + "––");
        }
        System.out.println("\n");
    }

    public void printPerPlayer(){
        ArrayList<String> pList = new ArrayList<String>();
        for(int i = 0; i < arr.size(); i++){
            if(pList.contains(arr.get(i).getP1()) 
            && pList.contains(arr.get(i).getP2())){}
            else{
                if(pList.contains(arr.get(i).getP1())){
                    pList.add(arr.get(i).getP2());
                }
                else{
                    pList.add(arr.get(i).getP1());
                }
            }
        }

        int[][] numWins = new int[2][pList.size()];
        for(int i = 0; i < arr.size(); i++){
            int index = pList.indexOf(arr.get(i).getWinner());
            numWins[0][index]++;

            if(arr.get(i).getWinner().equals(arr.get(i).getP1())){
                index = pList.indexOf(arr.get(i).getP2());
                numWins[1][index]++;
            }
            else{
                index = pList.indexOf(arr.get(i).getP1());
                numWins[1][index]++;
            }
        }

        int count = 0;
        int index = 0;
        int highIndex = 0;
        while(count != numWins.length){
            count = 0;
            for(int i = 1; i < numWins.length; i++){
                if(numWins[0][i-1]/numWins[1][i-1]
                > numWins[0][i]/numWins[1][i]){count++;}
            }
            if(count == numWins.length){break;}

            for(int i = 0; i < numWins.length; i++){
                if(numWins[0][highIndex]/numWins[1][highIndex]
                < numWins[0][i]/numWins[1][i]){highIndex = i;}
            }
            pList.add(0, pList.remove(highIndex));
            int temp1 = numWins[0][highIndex];
            int temp2 = numWins[1][highIndex];
            numWins[0][highIndex] = numWins[0][index];
            numWins[1][highIndex] = numWins[1][index];
            numWins[0][index] = temp1;
            numWins[1][index] = temp2;

            index++;
        }

        System.out.println(printWithStr(12, "Player Name") + "Wins" + "Loss" + "Rate");
        for(int i = 0; i < pList.size(); i++){
            System.out.print(printWithStr(12, pList.get(i)) + ":");
            System.out.print(printWithInt(4, numWins[0][i]));
            System.out.print(printWithInt(4, numWins[1][i]));
            System.out.print(printWithDec((double)numWins[0][i]/numWins[1][i]));
            System.out.println();
        }
    }
    
    public String printWithInt(int spaces, int str){
        return printWithStr(spaces, String.valueOf(str));
    }
    public String printWithDec(double str){
        DecimalFormat df = new DecimalFormat("#.##");
        try{
            return String.valueOf(df.format(str));
        }catch(ArithmeticException e){return " NA ";}
    }
    public String printWithStr(int spaces, String str){
        int space = (spaces - str.length())/2;
        String word = "";
        for(int k = 0; k < spaces; k++){
            if(k<=space){word += " ";}
            else if(k==space + 1){
                word += str; 
                k += str.length() - 1;
            }
            else{word += " ";}
        }
        
        return word;
    }
}