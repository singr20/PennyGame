import java.util.*;

public class PennyGame2
{
    String[] p1 = new String[3];
    String[] p2 = new String[3];
    String[] coin = new String[3];
    double flip;
    int flipInt;
    String flipString;
    boolean notFound = true;
    int p1wins = 0;
    int p2wins = 0;
    int counter = 0;
    
    public PennyGame2(){
        System.out.println("Player 1: " + Arrays.toString(playerOneSequence()));
        System.out.println("Player 2: " + Arrays.toString(playerTwoSequence()));
        
        coin[0] = flipTheCoin();
        coin[1] = flipTheCoin();
        coin[2] = flipTheCoin();
        
        while(p1wins + p2wins < 20){
            if((coin[0] + coin[1] + coin[2]).equals(p1[0] + p1[1] + p1[2])){
                p1wins ++;
                coinSequence();
            }
            else if((coin[0] + coin[1] + coin[2]).equals(p2[0] + p2[1] + p2[2])){
                p2wins ++;
                coinSequence();
            }
            coinSequence();
        }
        
        System.out.println("Player 1 Wins: " + p1wins);
        System.out.println("Player 2 Wins: " + p2wins);
    } 
    public String[] coinSequence(){
        coin[0] = coin[1];
        coin[1] = coin[2];
        coin[2] = flipTheCoin();
        return coin;
    }
    public String[] playerOneSequence(){
        for(int a = 0; a < p1.length; a ++){
            p1[a] = flipTheCoin();
        }
        return p1;    
    }
    public String[] playerTwoSequence(){
        if(p1[1].equals("H")){
           p2[0] = "T";
        }
        if(p1[1].equals("T")){
           p2[0] = "H";
        }
        p2[1] = p1[0];
        p2[2] = p1[1];
        return p2;    
    }
    public String flipTheCoin(){
        flip = Math.random() * 1.99;
        flipInt = (int)flip;
        if(flipInt == 0){
           flipString = "H";
        }
        if(flipInt == 1){
            flipString = "T";
        }
        return flipString;
    }
}
