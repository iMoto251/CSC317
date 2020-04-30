package puzzle;

import java.util.*;
import java.io.*;

public class eightPuzzle {
	
	public static void disp(int maze[][]) {   // To print the maze after each user input
		
		for(int i=0; i<3;i++) {
			System.out.print("-------------\n| ");
			for(int j=0; j<3;j++) {
				if(maze[i][j] != -1)
					System.out.print(maze[i][j]+" | ");
				else
					System.out.print("  | ");
				
				
			}
			System.out.print("\n");
		}
		System.out.println("-------------");
		
	}
	
	public static boolean check (int maze[][]){ // Checks the maze for validity
		int copy=0;
		for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					if((i==0 && j==0 && maze[i][j]==-1) || (i==2 && j==2 && maze[i][j]==-1)) {}
					
					else if(maze[i][j]>copy)
						copy=maze[i][j];
					
					else if(maze[i][j]<copy){
					return false;
					}
				}
			}
		return true;
	}
	
	public static void game() {
		int maze[][]=new int[3][3];
		int x=0,y=0;
		int r=0,c=0;
		
		try {
			File myObj = new File("input.txt");
			Scanner sc = new Scanner(myObj);
			
			while (sc.hasNextLine()) {
				String data = sc.nextLine();
				if(data.charAt(0)=='|'){
					for(int i=0;i<data.length();i++){
						if(data.charAt(i)=='|' && i!=data.length()-1){
							if(Character.isDigit(data.charAt(i+2)))
								maze[r][c]=Character.getNumericValue(data.charAt(i+2));
							else{
								maze[r][c]=-1;
								x=r;y=c;
							}
							c++;
						}
					}r++;c=0;
				}
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
		}
		
		disp(maze);
		// Games begins
		Scanner sc = new Scanner(System.in);
		//String s="";
		while (true) {
		
			System.out.println("Enter your move:");
			if(x>0)
				System.out.println("1. Up");
			if(x<2)
				System.out.println("2. Down");
			if(y>0)
				System.out.println("3. Left");
			if(y<2)
				System.out.println("4. Right");
			String s=sc.next();
			
		
			// This checks whether the blank cell is  already at the top or not. If yes then it cannot be moved further
			if(s.equals("up") || s.equals("Up") || s.equals("1") && x>0)
			{
				maze[x][y]=maze[x-1][y];
				maze[x-1][y]=-1;
				x=x-1;
			}
		
			// This checks whether the blank cell is already at the bottom or not.
			else if(s.equals("down") || s.equals("Down") || s.equals("2") && x<2)
			{
				maze[x][y]=maze[x+1][y];
				maze[x+1][y]=-1;
				x=x+1;
			}
		
			// This checks whether the blank cell is already at the extreme left or not.
			else if(s.equals("left") || s.equals("Left") || s.equals("3") && y>0)
			{
				maze[x][y]=maze[x][y-1];
				maze[x][y-1]=-1;
				y=y-1;
			}
		
			// This checks whether the blank cell is at the extreme right or not.
			else if (s.equals("right") || s.equals("Right") || s.equals("4") && y<2)
			{
				maze[x][y]=maze[x][y+1];
				maze[x][y+1]=-1;
				y=y+1;
			}
			else
				System.out.println("Illegal Move. Try again!");
			
			disp(maze);
			if((x==0 && y==0) || (x==2 && y==2))
			  if(check(maze))
				{
					System.out.println("Game won!");
					break;
				}
		}
		sc.close();
	
	}
	
	public static void main(String args[]){
		
	}
}
