
package calculus;

import java.util.Scanner;

class Calculus{
    
	public static void main(String[] args){
            String Name;
            double a,b,c,x;
			
            Scanner scan;
			
            scan=new Scanner(System.in);
			
            System.out.println("Enter the User name: ");
            Name=scan.nextLine();
			
            System.out.println("enter the coefficient a: ");
            a=scan.nextDouble();
			
            System.out.println("enter the coefficient b: ");
            b=scan.nextDouble();
			
            System.out.println("enter the coefficient c: ");
            c=scan.nextDouble();

            System.out.println("the equation you have entered is: ");
            System.out.println( (a)+"x^2+"+(b)+"x+"+(c) );
			
            System.out.println("The Derivative of the equation is: ");
            System.out.println( (2*a)+"x+"+b );
			
            System.out.println("The integral of the equation is: ");
            System.out.println( (a/3)+"x^3+"+(b/2)+"x^2+"+ (c) +"x");
			

            System.out.println("Enter the value for x: ");
            x=scan.nextDouble();
			
            System.out.println("The Derivative of the equation at "+x+" is: ");
            System.out.println( (2*a)*(x)+b );
			
            System.out.println("The integral of the equation at "+x+" is: ");
            System.out.println( ((a/3)*(x*x*x)) + ((b/2)*(x*x)) + (c*x) );
			
            System.out.println(Name+ " owes Waleed a Dinner.");
	
	}
}