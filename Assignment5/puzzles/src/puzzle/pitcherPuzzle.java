package puzzle;

import java.util.*;
//import java.io.*;

public class pitcherPuzzle {
	
	public static void disp(int arr[], int pCount) {
		System.out.print("Current configuration: [");
		for(int i = 0; i< pCount; i++) {
			if(i == pCount - 1) {
				System.out.print(arr[i]);
			}
			else {
				System.out.print(arr[i] + ", ");
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
	
	public static void dispChoices(int choiceNum, String[] choices) {
		Scanner entry = new Scanner(System.in);
		
		for(int i =0; i< choiceNum; i++) {
			if(i != choiceNum) {
				System.out.print((i+1) +". ");
				String gallons = entry.nextLine();
				choices[i] = gallons;
			}			
		}
		
		for(int i =0; i< choiceNum; i++) {
			if(i != choiceNum) {
				System.out.println(choices[i]);
			}			
		}
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
		int choiceNum = (int) (Math.pow(pitchers, 2) + pitchers);
		String choices[] = new String[choiceNum];
		
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
		disp(amount, pitchers);
		Scanner sc = new Scanner(System.in);
		while (true) {
		
			
			dispChoices(choiceNum, choices);
			
			System.out.println("Please select your move from the following choices:");
			
			String s=sc.next();
			
		
			if(s.equals("1"))
			{
				fill(cap[1], 1, amount);
			}
		
			else if(s.equals("2"))
			{
				empty(1, amount);
			}
		
			else if(s.equals("3"))
			{
				
			}
		
			else if (s.equals("4"))
			{
				
			}
			
			else
				System.out.println("Illegal Move. Try again!");
			
			disp(amount, pitchers);
			
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
