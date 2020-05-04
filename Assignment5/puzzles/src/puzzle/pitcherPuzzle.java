package puzzle;

import java.util.*;
//import java.io.*;

public class pitcherPuzzle {
	
	public static void disp(int amount[]) {
		System.out.print("Current configuration: [");
		for(int i = 0; i< amount.length; i++) {
			if(i == amount.length - 1) {
				System.out.print(amount[i]);
			}
			else {
				System.out.print(amount[i] + ", ");
			}
		}
		System.out.println("]");
	}
	
	public static void fill(int cap, int position, int amount[]) {
		amount[position] = cap;
	}
	
	public static void empty(int position, int amount[]) {
		amount[position] = 0;
	}
	
	public static void pour() {
		
	}
	
	public static ArrayList<String> dispChoices(int[] cap, int[] amount) {
		ArrayList<String> choices = new ArrayList<String>();
		
		int inc = 0;
		
		for(int i = 0; i < cap.length; i++) {
			if(amount[i] != cap[i]) {
				String arr1 = ("Fill pitcher " + (i+1) + "\n");
				choices.add(arr1);
				inc++;
			}
		}
		
		for(int i=0;i<cap.length; i++) {
			if (amount[i] != 0) {
				String arr2 = ("Empty pitcher " + (i+1) + "\n");
				choices.add(arr2);
				inc++;
			}
		}
		
		
		for(int i=0; i<cap.length; i++) {
			if(amount[i] != 0) {
				for(int j = 0; j< cap.length;j++) {
					if(amount[j] == 0) {
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


	public static boolean check (int amount[], int pitchers, int goal) {
		for(int i = 0; i< pitchers; i++){
			if(amount[i] == goal){
				//System.out.print("Game won");
				return true;
			}
		}
		return false;
	}
	
	public static void game() {
		
		System.out.print("Enter the number of pitchers: ");
		Scanner pitchNum = new Scanner(System.in);
		int pitchers = pitchNum.nextInt();	
		int cap[] = new int[pitchers];
		int amount[] = new int[pitchers];
		
		System.out.println("Enter the capacities of the " + pitchers + " on seperate lines (gallons)");
		Scanner entry = new Scanner(System.in);
		for(int i =0; i< pitchers; i++) {
			if(i != pitchers) {
				System.out.print("Pitcher " + (i+1) + ": ");
				int gallons = entry.nextInt();
				cap[i] = gallons;
			}			
		}
		
		System.out.print("Enter the goal (gallons): ");
		int goal = entry.nextInt();
		disp(amount);
		Scanner sc = new Scanner(System.in);
		while (true) {
			
			System.out.println("Please select your move from the following choices:");
			ArrayList<String> choiceArray = dispChoices(cap, amount);
			int s=sc.nextInt();
					
			String pick = choiceArray.get((s-1));
			System.out.println(pick);
			
			char function = pick.charAt(0);
			int pitcher = Character.getNumericValue(pick.charAt((pick.length()) - 2) - 1);
			
			//System.out.println(function + " " + pitcher);
		
			if(function == 'F') {
				fill(cap[pitcher],pitcher,amount);
			}
			else if(function == 'E') {
				empty(pitcher, amount);
			}

			
			disp(amount);
			
			if(check(amount, pitchers, goal)){
				System.out.println("Game won!");
				break;
			}
		}
		sc.close();
		entry.close();
		pitchNum.close();
	}
}
