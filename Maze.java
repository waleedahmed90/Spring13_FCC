/////////////////////////Waleed Ahmed, COMP102, Section B, Assignment#5, 21/4/2012///////////////////////////


//////Generating a 2D Maze that is navigatable

import java.util.Scanner;

class Maze{

//METHOD+RANDOM+MAZE+GENERATOR	
	public static void randomizer(char [][]arr){
		
		int boxes=(2*(arr.length-1))-1;	//total number of empty boxes
		
		int rand;
		
		for(int i=1;i<(arr.length-1);i++){
			for(int j=1;j<(arr.length-1);j++){
				rand=1 + (int) ( (arr.length-2) * Math.random() );
				if(arr[i][j]=='@'){}
				else if(rand%2==0){
					arr[i][j]='#';
				}
			}
		}
		
		
		
	}
	
//METHOD+INPUT+DIMENSIONS
	public static int inDim(){
		Scanner scan=new Scanner(System.in);
		int dim;
		//taking in the dimension
		System.out.print("Enter the dimension for the maze: ");
		dim=scan.nextInt();
		
		while( (dim%2==0) || (dim<5)){
			System.out.println("Sorry! The number must be odd and greater than equal to 5: ");
			System.out.print("Enter the dimension for the maze: ");
			dim=scan.nextInt();
		}
		
		return dim;
	}	

//METHOD+PLACING+#+BOUNDARIES
	public static void bound(char [][]arr){
		
		for(int i=0;i<arr.length;i++){
			if( (arr[i][0]!='e') && (arr[i][0]!='s') && (arr[i][0]!='@') ){
				arr[i][0]='#';
			}
		}
		
		for(int i=0;i<arr.length;i++){
			if( (arr[arr.length-1][i]!='e') && (arr[arr.length-1][i]!='s') && (arr[arr.length-1][i]!='@') ){
				arr[arr.length-1][i]='#';
			}
		}
		
		for(int i=0;i<arr.length;i++){
			if( (arr[0][i]!='e') && (arr[0][i]!='s') && (arr[0][i]!='@') ){
				arr[0][i]='#';
			}
		}
		
		for(int i=0;i<arr.length;i++){
			if( (arr[i][arr.length-1]!='e') && (arr[i][arr.length-1]!='s') && (arr[i][arr.length-1]!='@') ){
				arr[i][arr.length-1]='#';
			}
		}
	}
	
//SPACE+PLACER
	public static void spaces(char [][]arr){
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if( (arr[i][j]!='e') && (arr[i][j]!='s') && (arr[i][j]!='@') && (arr[i][j]!='#') ){
					arr[i][j]=' ';
				}
			}
		}
	}

//PRINTING+OUT+MAZE
	public static void PRINT(char [][]arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
					System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

//INPUT+KEY
	public static int position(){
	
		Scanner scan=new Scanner(System.in);
			char key; int K;
			System.out.print("Enter up=i, down=m, right=l, left=j: (q=Quit): ");
			key=scan.nextLine().charAt(0);
			K=key;
			
			return K;
	}

//UP-105
	public static void up(char [][]arr, int []locate){
			
			if( arr[(locate[0])-1][locate[1]]=='#' ){
					System.out.println("Can't move up: You have to enter again: ");
					return;
				}
				else{
					arr[locate[0]][locate[1]]=' ';
					(locate[0])--;
					arr[locate[0]][locate[1]]='@';
					System.out.println("You moved up:");
					System.out.println("STATUS: ");
					PRINT(arr);
					return;
				}
		}

//DOWN-109
	public static void down(char [][]arr, int []locate){
			if(arr[(locate[0])+1][locate[1]]=='#'){
					System.out.println("Can't move down: You have to enter again: ");
					return;
				}
				else{
					arr[locate[0]][locate[1]]=' ';
					(locate[0])++;
					arr[locate[0]][locate[1]]='@';
					System.out.println("You moved down:");
					System.out.println("STATUS: ");
					PRINT(arr);
					return;
				}
		}

//RIGHT-108
	public static boolean right(char [][]arr, int []locate){
			
				if(arr[locate[0]][(locate[1])+1]=='e'){
					arr[locate[0]][(locate[1])]=' ';
					arr[locate[0]][(locate[1])+1]='@';
					System.out.println("You have successfully accomplished the maze:");
					return true;
					
				}
				if(arr[locate[0]][(locate[1])+1]=='#'){
					System.out.println("Can't move right: You have to enter again: ");
					return false;
				}
				else{
					arr[locate[0]][locate[1]]=' ';
					(locate[1])++;
					arr[locate[0]][locate[1]]='@';
					System.out.println("You moved right:");
					System.out.println("STATUS: ");
					PRINT(arr);
					return false;
				}
		}

//LEFT-106
	public static void left(char [][]arr, int []locate){
			if( (arr[locate[0]][(locate[1])-1]=='#') || (arr[locate[0]][(locate[1])-1]=='s') ){
					System.out.println("Can't move left: You have to enter again: ");
					return;
				}
				else{
					arr[locate[0]][locate[1]]=' ';
					(locate[1])--;
					arr[locate[0]][locate[1]]='@';
					System.out.println("You moved left:");
					System.out.println("STATUS: ");
					PRINT(arr);
					return;
				}
		}		

//THE GAME SIMULATOR
	public static void simulator(char [][]arr, int r){
		Scanner scan=new Scanner(System.in);
		
		int R,C;
		int []locate=new int[2];
		R=r; C=1;
		locate[0]=R;
		locate[1]=C;
		
		char key;
		int K;
			while(true){
				K=position();
				//up24-down25-right26-left27
				if(K==105){	//i-up
					up(arr, locate);	
				}
				else if(K==109){	//m-down
					down(arr, locate);
				}
				else if(K==108){	//l-right
					boolean a=right(arr, locate);
					if(a){
						PRINT(arr);
						//the message to display at the end of the game
						System.out.println("GOOD JOB!");	//
						return;
					}
				}
				else if(K==106){	//j-left
					left(arr, locate);
				}
				else if(K==113){	//q-quit
					System.out.println("You chose to quit:");
					System.out.println("The present status is: ");
					PRINT(arr);
					break;
				}
				else{
					//wrong input
					System.out.println("Wrong key pressed. Enter again");
				}
		
			}
		return;
		
	}

//THE MAIN FUNCTION	
	public static void main(String []args){
		Scanner scan=new Scanner(System.in);
		
		int dim=inDim();	//the dimension
		
		//declaring the maze array
		char [][]maze=new char[dim][dim];
		//determining the start
		int s= 1 + ( int )( (dim-2) * Math.random() );
		
		
		maze[s][0]='s';//placing the start
		maze[s][1]='@';	//placing the @ which will show the position on the path 
		
		
		int e= 1 + ( int )( (dim-2) * Math.random() );	//determining the end
		maze[e][dim-1]='e';//placing the end
		maze[e][dim-2]=' '; //placing a space before the end
		
		
		//placing # on the boundaries
		bound(maze);
		
		
		//placing spacing where there is no hashes
		spaces(maze);
		
		//randomizer
		randomizer(maze);
		
		//printing out the maze
		System.out.println("This is the maze at ab-initio: \n\n");
		PRINT(maze);
		
		
		
		//the game simulation
		simulator(maze,s);
		
		
	}
}
