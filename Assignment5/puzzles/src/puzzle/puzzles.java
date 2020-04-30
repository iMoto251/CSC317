package puzzle;

//import java.io.*;
import java.util.*;

public class puzzles {

	public static void main(String args[]) {
		System.out.print("1. Eight Puzzle\n2. Pitchers Puzzle\n3. Exit\nSelect a game: ");
		Scanner selection = new Scanner(System.in);
		String s = selection.next();
		
		if(s.equals("1")) {
			System.out.println(" ");
			eightPuzzle.game();
		}
		else if(s.equals("2")) {
			System.out.println("Game 2");
			pitcherPuzzle.game();
		}
		else {
			System.out.println("Invalid Selection");
		}
		
		
		
		
		selection.close();
	}

	
}
