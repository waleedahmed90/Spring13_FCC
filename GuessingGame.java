


import java.util.Scanner;
public class GuessingGame {
//this is a number guessing game for two players
    public static void main(String[] args) {
        Scanner scan;
        
        String Player1,Player2;
        scan=new Scanner(System.in);
        System.out.print("Enter the Player-1 Name: ");
        Player1=scan.nextLine();
        
        System.out.print("Enter the Player-2 Name: ");
        Player2=scan.nextLine();
        
        int rand;                                           //the random number
        int p1;                                             //Player 1's guess
        int p2;                                             //Player 2's guess
        
        
        int d1;                                             //player 1's difference
        int d2;                                             //player 2's difference
        
        rand= 1+ (int)((99)* Math.random());    //generation of the random number netween 1 and 100
        
        //guessing messages        
        System.out.println("Hmmmmm let me think of a number between 1 and 100");
        System.out.println("........................");
        System.out.println("Okay I have guessed the number. Now is your turn");
        
        System.out.print(Player1+" ! Time to enter your guess (1-100): ");
        p1=scan.nextInt();
        
        System.out.print(Player2+" ! Time to enter your guess (1-100): ");
        p2=scan.nextInt();
        
        System.out.println("The secret number was "+ rand);
        
        d1=rand-p1;          //for player-1 
        
        d2=rand-p2;          //for player-2 
        
        System.out.println(Player1+ " had "+p1+" with a difference "+rand+" - "+p1+" = "+d1);
        System.out.println(Player2+ " had "+p2+" with a difference "+rand+" - "+p2+" = "+d2);
        
        
        if(p1==p2){
            System.out.println("Since both the guesses are the same so the player who had the first");
            System.out.println("turn wins and that happens to be "+Player1);
            System.out.println(Player1+" wins!!!");
        }
        else if(d1==d2){
            if(p1>p2){
                System.out.println("Since the difference is the same for both players so as");
                System.out.println("per rule the player whose guess was smaller wins");
                System.out.println("and that happens to be "+Player2);
                System.out.println(Player2+" wins!!!");
            }
            else{
                System.out.println("Since the difference is the same for both players so as");
                System.out.println("per rule the player whose guess was smaller wins");
                System.out.println("and that happens to be "+Player1);
                System.out.println(Player1+" wins!!!");
            }
        }
        else if(d1>d2){
            System.out.println(Player2+" wins!!!");
        }
        else
            System.out.println(Player1+" wins!!!");
    }
        
}
        
  
    


