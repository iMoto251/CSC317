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
	
	public static void game() {
		System.out.print("Enter the number of pitchers: ");
		Scanner pitchNum = new Scanner(System.in);
		int pitchers = pitchNum.nextInt();	
		int arr[] = new int[pitchers];
		
		System.out.print("Enter the capacities of the " + pitchers + " on seperate lines (gallons): ");
		Scanner entry = new Scanner(System.in);
		for(int i =0; i< pitchers; i++) {
			if(i != pitchers) {
				int gallons = entry.nextInt();
				arr[i] = gallons;
			}			
		}
		entry.close();
		
		disp(arr, pitchers);
		pitchNum.close();
	}

}
