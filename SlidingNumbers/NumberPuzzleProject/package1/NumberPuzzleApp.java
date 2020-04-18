package package1;

import java.util.Scanner;

public class NumberPuzzleApp 
{
	private static Scanner scan = new Scanner(System.in);
	
	public static void main (String[] args)
	{
		NumberPuzzleGame game = null;
		String answer;
		
		System.err.println("Do you want to play the NumberPuzzle game? ");
		System.err.println("Press Y to play, N to exit. ");
		
		answer = scan.next();
		
		while ( (!answer.equals("y")) && (!answer.equals("Y")) && (!answer.equals("n")) && (!answer.equals("N")) )
		{
			System.err.println("Press Y to play, or N to exit. ");
			answer = scan.next();
		}	
		
		// to play one game and more...
		while (!answer.equals("N") && !answer.equals("n"))	
		{
			if (!answer.equals("Y") && !answer.equals("y"))
			{
				System.err.println("Do you want to play another game? ");
				System.err.println("Press Y to play, N to exit. ");
				answer = scan.next();
				continue;
			}
			
			game = new NumberPuzzleGame();
			
			/////////////////////////////////////////////////////////
			//FILL THE MATRIX FOLLOWING THE USER'S COMMANDS
			/////////////////////////////////////////////////////////
			
			try
			{
				game.fillTheMatrix();
			}	
			catch (WrongInputException w)
			{
				w.printErrorMsg();
				return;
			}
			
			/////////////////////////////////////////////////////////
			//SHOW INPUT MATRIX BY THE USER
			/////////////////////////////////////////////////////////
			
			System.err.println("You have entered the following matrix: ");
			game.printMatrix();
				
			/////////////////////////////////////////////////////////
			//VALIDATE INPUT MATRIX BY THE USER
			/////////////////////////////////////////////////////////
			
			try
			{
				game.validateMatrix();
			}
			catch (WrongInputException w)
			{
				w.printErrorMsg();
				return;
			}
			
			/////////////////////////////////////////////////////////
			//PLAY THE GAME
			/////////////////////////////////////////////////////////
			
			game.playTheGame();
			
			System.err.println("Do you want to play another game? ");
			System.err.println("Press Y to play, N to exit. ");
				
			answer = scan.next();
		}	
		
		System.err.println("See you later!..");	
		return;
		
	}
}
