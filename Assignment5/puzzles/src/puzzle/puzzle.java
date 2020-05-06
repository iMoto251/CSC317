package puzzle;

import java.util.Scanner;

public interface puzzle {
	
	public static void main(String args[]) {
		
		System.out.print("1. Eight Puzzle\n2. Pitchers Puzzle\n3. Exit\nSelect a game: ");
		Scanner selection = new Scanner(System.in);
		String s = selection.next();
		
		
		if(s.equals("1")) {
			System.out.println("Enter your file name: ");
			Scanner file = new Scanner(System.in);
			String fName = file.nextLine();
			eightPuzzle.game(fName);
			file.close();
		}
		else if(s.equals("2")) {
			pitcherPuzzle.game();
		}
		else if(s.equals("3")) {}
		else {
			System.out.println("Invalid Selection");
		}
		selection.close();
	}
}
