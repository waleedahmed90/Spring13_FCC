//package GuessingGame;

import java.util.Scanner;

class CodeCracker{

	public static void main(String []args){

		Scanner scan=new Scanner(System.in);
		
		System.out.println("Welcome to Code Cracker by Waleed");
		System.out.println("Can you crack the code?");
		
		

		int code = 100 + ( int ) ( 899 * Math.random() );
		System.out.println("The computer has thought of 3 numbers consisting of 0-9");
		//code=355;				//remove the comment if you want to check the working
		int x,y,z;				//split variables for random code

		x=code/100;	//formula to obtain the most significant digit    
		y=code/10;   //formula to obtain the middle number
		y=y%10;     //same thing as the above
		z=code%10;	//formula to obtain the least significant digit

		//System.out.println(code);
		//cout<<code<<endl;

		int RP, WP;			//counters for rightly placed and the wrongly placed digits
		int a,b,c;			//split variables for the guess
		int guess;			//variable for the guess
		int count=0;		//counter for the guess attempts

		int ra,rb,rc;		//counter for the rightly place first digit, second digit, and the third digit
		int wa,wb,wc;		//counter for the wrongly place first digit, second digit, and the third digit	

		while(true){		//the infinite loop until the RP counter is three and loop is broken from the inside

		
		//reseting all the counters
			RP=WP=0;		
			ra=rb=rc=0;
			wa=wb=wc=0;

			System.out.print("Enter your Guess: ");
			guess=scan.nextInt();
			System.out.println("You guessed: "+ guess);
			count++;

			a=guess/100;    b=guess/10;   b=b%10;     c=guess%10;



			if(a-x==0)		//if the first number matches
				ra++;
			if(b-y==0)		//if the second number matches
				rb++;
			if(c-z==0)		//if the third number matches
				rc++;


			//if the ra is zero and the counter rb is not set and first number matches any of the digits except the first 
			if((ra==0) && (y-a==0) && (rb!=1)){
				wa++;
			}
			else if((ra==0) && (z-a==0) && (rc!=1)){
				wa++;
			}
			
			//if the rb is zero and the counter ra is not set and second number matches any of the digits except the second  
			if((rb==0) && (x-b==0) && (ra!=1)){		
				wb++;
			}
			else if((rb==0) && (z-b==0) && (rc!=1)){
				wb++;
			}
			
			//if the rc is zero and the counter ra is not set and third number matches any of the digits except the third 
			if((rc==0) && (x-c==0) && (ra!=1)){
				wc++;
			}
			else if((rc==0) && (y-c==0) && (rb!=1)){
				wc++;
			}


			//accumulating the individual counters to the original counter
			RP=ra+rb+rc;
			WP=wa+wb+wc;	
			
			System.out.println("There are "+RP+" numbers in the right place");
			System.out.println("And "+WP+" other number(s) which are right, but in the wrong place");

			if(RP==3){		//in-case the counter for the Rightly placed digits are rightly placed  (ie the counter is 3)
				System.out.println("Well done! You have cracked the code in "+count+" attempts !");
				break;
			}

		}
	}
}
