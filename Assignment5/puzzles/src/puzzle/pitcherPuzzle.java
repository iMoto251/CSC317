package puzzle;

import java.util.*;
//import java.io.*;

public class pitcherPuzzle {
	
	public static void disp(int level[]) {
		System.out.print("Current configuration: [");
		for(int i = 0; i< level.length; i++) {
			if(i == level.length - 1) {
				System.out.print(level[i]);
			}
			else {
				System.out.print(level[i] + ", ");
			}
		}
		System.out.println("]");
	}
	
	public static void fill(int cap, int position, int level[]) {
		level[position] = cap;
	}
	
	public static void empty(int position, int level[]) {
		level[position] = 0;
	}
	
	//cap 1 is the pitcher being poured into
	//cap 2 is the pitcher being poured from
	public static void pour(int cap1, int cap2, int position1, int position2, int level[]) {

		if(cap1 < level[position2]) {
			level[position2] = level[position2] - cap1;
			fill(cap1, position1, level);
		}
		
		if(cap1 > level[position2]) {
			level[position1] = level[position1] + level[position2];
			empty(position2, level);
		}

	}
	
	public static ArrayList<String> dispChoices(int[] cap, int[] level) {
		ArrayList<String> choices = new ArrayList<String>();
		
		int inc = 0;
		
		for(int i = 0; i < cap.length; i++) {
			if(level[i] != cap[i]) {
				String arr1 = ("Fill pitcher " + (i+1) + "\n");
				choices.add(arr1);
				inc++;
			}
		}
		
		for(int i=0;i<cap.length; i++) {
			if (level[i] != 0) {
				String arr2 = ("Empty pitcher " + (i+1) + "\n");
				choices.add(arr2);
				inc++;
			}
		}
		
		
		for(int i=0; i<cap.length; i++) {
			if(level[i] != 0) {
				for(int j = 0; j< cap.length;j++) {
					if(level[j] < cap[j]) {
						String arr3 = ("Pour pitcher " + (i+1) + " to " + (j+1) + "\n");
						choices.add(arr3);
						inc++;
					}
				}	
			}
		}
		
		for(int i =0; i<inc; i++) {
				System.out.print((i+1) + ". " + choices.get(i));		
		}
		return choices;
	}


	public static boolean check (int level[], int pitchers, int goal) {
		for(int i = 0; i< pitchers; i++){
			if(level[i] == goal){
				return true;
			}
		}
		return false;
	}

	
	public static void game() {
		
		System.out.print("Enter the number of pitchers: "); 
		Scanner pitchNum = new Scanner(System.in); //Read in number of pitchers
		int pitchers = pitchNum.nextInt();	
		int cap[] = new int[pitchers]; //capacity of pitchers
		int level[] = new int[pitchers]; //amounts in the pitchers
		int y=0;
		
		System.out.println("Enter the capacities of the " + pitchers + " (gallons) [x,x,x,...,n]: ");
		Scanner entry = new Scanner(System.in);
		String input = entry.nextLine();
		
		//not working
		if(input.charAt(0) == '[') {
			for(int i=0;i<input.length();i++) {
				if(input.charAt(i) == ']') {
					break;
				}
				else if(Character.isDigit(input.charAt(i+1))) {
					cap[y] = Character.getNumericValue(input.charAt(i+1));
				}
			}y++;
			//System.out.println(input);
		}
		
		for(int i=0;i<pitchers;i++)
			System.out.println(cap[i]);
			
		
		
		/*
		 if(input.charAt(0) == '[') {
			for(int i=0;i<input.length();i++) {
				if(input.charAt(i) == ',' && i!=input.length()-1) {
					if(Character.isDigit(input.charAt(i+1))){
						cap[i] = Character.getNumericValue(input.charAt(i+1));						
					}
				}
			}
		}
		
		//Working, but not how Banerjee wants it.
		System.out.println("Enter the capacities of the " + pitchers + " on seperate lines (gallons)");
		Scanner entry = new Scanner(System.in);
		for(int i =0; i< pitchers; i++) {
			if(i != pitchers) {
				System.out.print("Pitcher " + (i+1) + ": ");
				int gallons = entry.nextInt();
				cap[i] = gallons;
			}			
		}
		*/
		
		System.out.print("Enter the goal (gallons): ");
		int goal = entry.nextInt();
		disp(level);
		Scanner sc = new Scanner(System.in);
		while (true) {
			
			System.out.println("Please select your move from the following choices:");
			ArrayList<String> choiceArray = dispChoices(cap, level);
			int s=sc.nextInt();
					
			String pick = choiceArray.get((s-1));
			System.out.println(pick);
			
			char function = pick.charAt(0);
			int pitcher1 = Character.getNumericValue(pick.charAt((pick.length()) - 2) - 1);
			int pitcher2 = Character.getNumericValue(pick.charAt((pick.length()) - 7) - 1);

			
			//System.out.println(function + " " + pitcher1 + " " + pitcher2);
		
			if(function == 'F') {
				fill(cap[pitcher1],pitcher1,level);
			}
			else if(function == 'E') {
				empty(pitcher1, level);
			}
			else if(function == 'P')
			{
				pour(cap[pitcher1],cap[pitcher2],pitcher1,pitcher2,level);
			}

			
			disp(level);
			
			if(check(level, pitchers, goal)){
				System.out.println("Game won!");
				break;
			}
		}
		sc.close();
		entry.close();
		pitchNum.close();
	}
}
