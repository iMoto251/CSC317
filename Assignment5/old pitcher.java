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
	
	public static boolean check (int p[]) {
		int copy = 0;
		
		
		
		return true;
	}
	
	public static void game() {
		System.out.print("Enter the number of pitchers: ");
		Scanner pitchNum = new Scanner(System.in);
		int pitchers = pitchNum.nextInt();	
		int p[] = new int[pitchers];
		int cap[] = new int[pitchers];
		
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
		entry.close();
		
		
		
		disp(cap, pitchers);
		
		for(int i = 0; i< pitchers; i++){
			if(cap[i] == goal){
				System.out.print("Game won");
			}
		}
		pitchNum.close();
	
	}

}
