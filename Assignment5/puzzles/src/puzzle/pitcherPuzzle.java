package puzzle;

import java.util.Scanner;

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
		System.out.print("]");
	}
	
	public static void fill(int cap[]) {
		
	
	}
	
	public void empty() {
		
	}
	
	public void pour() {
		
	}
	
	public static boolean check (int amount[], int pitchers, int goal) {
		for(int i = 0; i< pitchers; i++){
			if(amount[i] == goal){
				System.out.print("Game won");
				return true;
			}
		}
		return false;
	}
	
	public static void game() {
		System.out.print("Enter the number of pitchers: ");
		Scanner pitchNum = new Scanner(System.in);
		int numOpitchers = pitchNum.nextInt();	
		int cap[] = new int[numOpitchers];
		int amount[] = new int[numOpitchers];
		
		System.out.println("Enter the capacities of the " + numOpitchers + " on seperate lines (gallons)");
		Scanner entry = new Scanner(System.in);
		for(int i =0; i< numOpitchers; i++) {
			if(i != numOpitchers) {
				System.out.print("Pitcher " + (i+1) + ": ");
				int gallons = entry.nextInt();
				cap[i] = gallons;
			}			
		}
		
		System.out.print("Enter the goal (gallons): ");
		int goal = entry.nextInt();
		entry.close();
		
		fill(cap);
		
		disp(amount, numOpitchers);
		check(amount, numOpitchers, goal);
		
		pitchNum.close();
	
	}

}
