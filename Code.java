/////////////////////////Waleed Ahmed, COMP102, Section B, Assignment#4, 21/4/2012///////////////////////////


/*///////////Development of an educational software to help someones's little brother.
who is having 
trouble with arithmetic. His parents realize 
that after taking a few weeks of Java programming 
course, that I could potentially write a computer program 
that will allow him to practice his arithmetic skills.
*/


import java.util.Scanner;
public class task1 {	//public class
	
	//the method for calculation of points
	public static int numPoints(double timeAG, double score_guess){
		System.out.println("\n\n\n\n\n\n..............POINTS CHART..............");
		
		
		int AGS= Math.round( (int)(timeAG) );	//rounds off the points taken in arithmetic game
		System.out.println("\nPoints scored in Arithmetic game = " + AGS);
		
		int GGS= Math.round( (int)(score_guess) );	////rounds off the points taken in guessing game
		System.out.println("\nPoints scored in Guess Game = " + GGS);
		
		int total=AGS+GGS;	
		//returns the total points
		return total;
		
			
	}
	
	//the method for counting the digits
	public static int numDigits(int number){
		int Digits=1;
		int temp1=number;
		while(temp1!=1){
			temp1=temp1/10;		//divides the number by 10
			Digits++;
		}
		//return the number of digits in the number provided by the user in the method
		return Digits;
	}
	
	//the method for conversion of time into points according to the table given in the assignment
	public static int scoreTimeConverter(double TIME){
		if (TIME < 1)
			return 10;
		else if(TIME>=1 && TIME<2)
			return 9;
		else if(TIME>=2 && TIME<3)
			return 8;
		else if(TIME>=3 && TIME<4)
			return 7;
		else if(TIME>=4 && TIME<5)
			return 6;
		else if(TIME>=5 && TIME<6)
			return 5;
		else if(TIME>=6 && TIME<7)
			return 4;
		else if(TIME>=7 && TIME<8)
			return 3;
		else if(TIME>=8 && TIME<9)
			return 2;
		else if(TIME>=9 && TIME<10)
			return 1;
		else
			return 0;
			
	}
	
	//the game play for Guessing Game 
	public static double guessGame(int max){
	
		int no_of_Digits=numDigits(max);	//the first step to count the number of digits
		
		Scanner scan=new Scanner(System.in);
		int temp;
		//generation of random number between 1 and max
		int rand=1+ (int)( (max-1) * Math.random() );
		
		System.out.println("Okay I have guessed a number between 1 and " + max + "..... take your chances");
		//check on the time start
		long start=System.currentTimeMillis();
		
		while(true){
			System.out.print("Enter your guess: ");
			temp=scan.nextInt();
			
			if(temp==rand){	//checks if the number guessed is right
				System.out.println("Bingo! You have guessed the number");
				break;
			}
			else if(temp>rand)	//checks if the number is high
				System.out.println("Guess is to high. Go for it again");
			else	//checks if the number is low
				System.out.println("Guess is to low. Go for it again");
		}
		
		
		//marks the end of the time
		long end=System.currentTimeMillis();
		
		//calculation of total time taken during the problem
		int timeSpent = (int) (end - start);
            double timespent=timeSpent/1000;		//conversion into seconds
			
			int points=scoreTimeConverter(timespent);	//type cast to int
			System.out.println("Points according to the points table is: " + points);
			
			double score=timespent/(no_of_Digits * 2);	//the points according to criteria #2
			System.out.println("Time is = " + timespent + "seconds");
            return score;	//returns the score
		
	}
	
	//guessing game simulator
	public static double guessGameSimulator(){
		//simple enough
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Welcome to the Number Guessing game:");
		System.out.print("Enter the maximum value of integer: ");
		int Max=scan.nextInt();
		double SCORE=guessGame(Max);
		System.out.println("Score is = " + SCORE + " points");
       
	   return SCORE;
	}
	
	//the game play for the arithmetic game
    public static double arithGame(int max, int quantity, int op){
        
        
        System.out.println("Welcome to the Calculations Game: ");
        int penSec=0;	//the variable for calculation of penalty seconds 
        Scanner scan=new Scanner(System.in);
        int ans;
        int count=0;	//counter for the attempts
        
            if(op==1){		//case->addition
        
				long start=System.currentTimeMillis();
        
				for(int i=0; i<quantity ; i++){
        
					//generation of random numbers
					int rand1=(-max)+ (int)( (2*max)* Math.random() );
					int rand2=(-max)+ (int)( (2*max)* Math.random() );
        
					System.out.print(rand1 + " + " + rand2 + " = " );
					ans=scan.nextInt();
            //if the answer is right
					if(( (rand1)+(rand2) )== ans){
						System.out.println("Right Answer");
						count++;
					}
					else{		//incase the answer is wrong
						penSec+=5;	//adding the penalty seconds
						System.out.println("Wrong Answer");
					}
            
            }
            long end=System.currentTimeMillis();
            int timeSpent = (int) (end - start);		//calculation of the time taken
            double timespent=(timeSpent/1000) + penSec;	//total time with the penalty seconds
			System.out.println("Total Time Taken is = " + timespent + "seconds");	
			double score=timespent/count;	//scores calculation
            return score;	
            }
            
			
			else{		//case->multiplication
          
            
				long start=System.currentTimeMillis();
        
					for(int i=0; i<quantity ; i++){
						//generation of random numbers
						int rand1=(-max)+ (int)( (2*max)* Math.random() );
						int rand2=(-max)+ (int)( (2*max)* Math.random() );
                    
						System.out.print(rand1 + " x " + rand2 + " = " );
						ans=scan.nextInt();
            //if the answer is right
						if(( (rand1)*(rand2) )== ans){
							System.out.println("Right Answer");
							count++;
						}
						else{		//incase the answer is wrong
							penSec+=5;	//adding the penalty seconds
							System.out.println("Wrong Answer");
						}
                
            }
			
            long end=System.currentTimeMillis();
            int timeSpent = (int) (end - start);		//calculation of the time taken
            double timespent=(timeSpent/1000) + penSec;	//total time with the penalty seconds
			System.out.println("Total Time Taken is = " + timespent + "seconds");
			double score=timespent/count;		//scores calculation
            return score;

        }
		
    }
    
	//Arithmetic game simulator
    public static double playArithmetic(){
        Scanner scan=new Scanner(System.in);
        final int ADD=1;	//constant for addition
		final int MULT=2;	//constant for multiplication
        int newChoice;
        System.out.println("Would you like, 1)Addition or 2)Multiplication?");
        newChoice=scan.nextInt();
        //number of problems
        System.out.print("How many problems you want to do:");
        int quan=scan.nextInt();
        //range
        System.out.print("What should be the maximum range:");
        int ran=scan.nextInt();
        //score
		
       double scorE= arithGame(ran, quan, newChoice);
       System.out.println("Score is = " + scorE + " points");
        
		return scorE;
    }
    
	//Menu Display
    public static int menu(){
           Scanner scan=new Scanner(System.in);
           int choice;
           System.out.println("what do you want to do:");
           System.out.println("1. Play Arithmetic Game.");
           System.out.println("2. Play Guessing Game.");
           System.out.println("3. Print Score.");
           System.out.println("4. Quit.");
           
           choice=scan.nextInt();
           
           return choice;		//returns the choice selected by user
    }
   
	//main funtion    
    public static void main(String[] args){
	
        Scanner scan=new Scanner(System.in);
        int Menu=10;
        double s1=0.0, s2=0.0;		//variables for arithGame and guessGame scores
		
		//final int ADD=1;
		//final int MUL=2;
        
		//loop for continuous execution unless user quits
		while(Menu!=4){
			Menu=menu();
			 
			switch(Menu){
				case 1:		//calls the arithmetic game simulator
				s1=playArithmetic(); 
				break;
			
				case 2:		//calls the guessing game simulator
					s2=guessGameSimulator();
					break;
					
				case 3:		//calls the method to print scores
				{
					int points=numPoints(s1,s2);
					System.out.println("Total score is = " + points);
					break;
				}
			
				case 4:		//exits if user selects option 4
					break;
					
				default:	//incase a wrong options is entered by the user
					System.out.println("You have selected an invalid option");
					break;
			}
		}
		
		//if loop breaks
		System.out.println("\n\n\n\n.......GOOD BYE!...... Thanks for playing mate.");
        
    }
    
}
