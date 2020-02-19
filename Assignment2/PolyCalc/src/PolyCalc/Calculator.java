package PolyCalc;

//import java.io.*;
import java.util.*;

public class Calculator {
	
	public static void main(String[] args) {
		System.out.print("1. Addition\n2. Multiplication\n3. Evaluation\n4. Derivative\n5. Exit\nEnter Choice: ");
		Scanner choice = new Scanner(System.in);
		
		int selection = choice.nextInt();
		//while loop for switch
		while(selection != 5) {
			//switch to decide which function to run
			switch(selection) {
			case 1: System.out.println("C1");
				break;
			case 2: System.out.println("C2");
				break;
			case 3: System.out.println("C3");
				break;
			case 4: System.out.println("C4");
				break;
			default:System.out.println("Invalid choice");
				break;
			}
			//asks for selection to loop around to the top if the switch
        	System.out.print("1. Addition\n2. Multiplication\n3. Evaluation\n4. Derivative\n5. Exit\nEnter Choice: ");
        	selection = choice.nextInt();
		}
		
		
		choice.close();
	}
	
}
