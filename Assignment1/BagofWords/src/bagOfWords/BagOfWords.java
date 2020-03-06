package bagOfWords;

import java.io.*;
import java.util.*;

public class BagOfWords {
	//test
	//Variables needed everywhere
    static String text_file_name;
    static ArrayList<String> list = new ArrayList<String>();
    
    //main
    public static void main(String args[]) throws Exception {
    	//initialize BoW
    	new BagOfWords(text_file_name);
    	//first selection
    	System.out.print("\n1. Expand\n2. Print Term Frequencies\n3. Close\nEnter Choice: ");
        Scanner choice = new Scanner(System.in);
        
        int selection = choice.nextInt();
        //while loop for switch
        while(selection != 3) {
        	//switch to decide which function to run
            switch (selection) {
            	case 1: new BagOfWords(text_file_name);
                    	break;
            	case 2: new BagOfWords();
                    	break;
            	default:
                    	System.out.println("Invalid choice.");
                    	break;
            	}
            	//asks for selection to loop around to the top if the switch
            	System.out.print("\n1. Expand\n2. Print Term Frequencies\n3. Close\nEnter Choice: ");
            	selection = choice.nextInt();
        	}
        	choice.close();
        }
    
    //This reads the words into an array
    public BagOfWords(String text_file_name) throws FileNotFoundException {
        System.out.print("Enter file name: ");
        
        //Enter the file name to add to array
        Scanner fileName = new Scanner(System.in); 
		text_file_name = fileName.nextLine();
		File f = new File(text_file_name);
			
		//checks to see if the entered file exists
		if(f.exists()) {				
        	//creates the scanner to add words from file
        	Scanner words = new Scanner(f);
			//adds words to the list
			while (words.hasNext()) {
				list.add(words.next());
			}  
			words.close();
		}
			//no file exists
		else {
			System.out.println("File does not exist");
		}
		
		fileName.close();
    }
    
    
    //This outputs term frequencies
    public BagOfWords() throws Exception{
    	
    	//measures frequency
    	Set<String> distinct = new HashSet<>(list);
    	for (String s: distinct) {
    		//writes to screen
    		System.out.println(s + ": " + Collections.frequency(list, s));
        	}
        }
    }
