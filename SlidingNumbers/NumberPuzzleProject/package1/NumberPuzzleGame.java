package package1;

import java.util.Scanner;
import java.util.Vector;

public class NumberPuzzleGame
{	
	/**
	 * The size of the game's matrix is always the same (3x3).
	 */
	private static final int MATRIX_SIZE = 3;
	
	
	// ***************************************************************************
	// The Elements of the game are (also) static. 
	// This way we do not have to create new elements for each new (cloned) game.
	// ***************************************************************************
	
	/**
	 * This is the empty element. It also has a value which is 0.
	 */
	private static Element empty = new Element(0);
	
	private static Element one = new Element(1);
	private static Element two = new Element(2);
	// There is no element "three"...
	private static Element four = new Element(4);
	private static Element five = new Element(5);
	private static Element six = new Element(6);
	private static Element seven = new Element(7);
	private static Element eight = new Element(8);
	private static Element nine = new Element(9);
	
	/**
	 * Every instance of a NumberPuzzleGame has its own matrix.
	 */
	private Element[][] matrix;
	
	
	//***************************************************************
	//************************** METHODS ****************************
	//***************************************************************
	
	
	/**
	 * Creates a default game where the user plays the game.
	 */
	public NumberPuzzleGame() 
	{
		matrix = new Element[MATRIX_SIZE][MATRIX_SIZE]; 
	}
	
	/**
	 * The constructor which takes another NumberPuzzleGame as a parameter
	 * and creates a "clone" of it. 
	 * @param game
	 */
	public NumberPuzzleGame(NumberPuzzleGame game) 
	{	 
		matrix = new Element[MATRIX_SIZE][MATRIX_SIZE];
		
		for (int i=0; i<3; i++)
		{	
			for (int j=0; j<3; j++)
			{	
				int val = game.getMatrix()[i][j].getValue();
				switch (val)
				{
				// The new NumberPuzzleGame references the same static fields (Elements).
				case 0:
					matrix[i][j]=empty;
					continue;
				case 1:
					matrix[i][j]=one;
					continue;
				case 2:
					matrix[i][j]=two;
					continue;
				case 4:
					matrix[i][j]=four;
					continue;
				case 5:
					matrix[i][j]=five;
					continue;
				case 6:
					matrix[i][j]=six;
					continue;
				case 7:
					matrix[i][j]=seven;
					continue;
				case 8:
					matrix[i][j]=eight;
					continue;
				case 9:
					matrix[i][j]=nine;
					continue;
				}
			}
		}
	}
	
	/*public Elements[][] makeCopy()
	{	
		Elements[][] matrix= new Elements[MATRIX_SIZE][MATRIX_SIZE];
		Elements empty = new Elements(0);
		Elements one = new Elements(1);
		Elements two = new Elements(2);
		Elements four = new Elements(4);
		Elements five = new Elements(5);
		Elements six = new Elements(6);
		Elements seven = new Elements(7);
		Elements eight = new Elements(8);
		Elements nine = new Elements(9);
		System.err.println("cloning......");
		for (int i=0; i<3; i++)
		{	
			for (int j=0; j<3; j++)
			{	
				int val = this.getMatrix()[i][j].getValue();
				switch (val)
				{
				case 0:
					matrix[i][j]=empty;
					continue;
				case 1:
					matrix[i][j]=one;
					continue;
				case 2:
					matrix[i][j]=two;
					continue;
				case 4:
					matrix[i][j]=four;
					continue;
				case 5:
					matrix[i][j]=five;
					continue;
				case 6:
					matrix[i][j]=six;
					continue;
				case 7:
					matrix[i][j]=seven;
					continue;
				case 8:
					matrix[i][j]=eight;
					continue;
				case 9:
					matrix[i][j]=nine;
					continue;
				}
			}
		}
		return matrix;
	}
	*/
	
	/**
	 * This method returns the game's matrix.
	 * @return
	 */
	public Element[][] getMatrix()
	{
		return this.matrix;
	}
	
	/**
	 * This method returns the game's matrix size (it is 3).
	 * @return
	 */
	public int getMatrixSize()
	{
		return this.MATRIX_SIZE;
	}
	
	/**
	 * This method fills the game's matrix cells according to the user's choice.
	 * (So the user can start a game as he wants to).
	 * @throws WrongInputException
	 */
	public void fillTheMatrix() throws WrongInputException 
	{
		System.err.println("******INSTRUCTIONS******");
		System.err.println("Your input has to be a sequence of nine numbers.");
		System.err.println("Numbers must be separated by spaces.");
		System.err.println("The empty cell is represented by number 0.");
		System.err.println("Number 3 should not be in your input.");
		System.err.println("Please input the numbers to fill the matrix:");
				
		Scanner sc = new Scanner(System.in);
		
		int number;
		for (int i=0; i<9; i++)
		{	
			number = sc.nextInt();  //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Could throw more error messages...
			int mod = i%3;
			int div = i/3;
			
			switch (number)
			{
				case 0:
					matrix[div][mod] = empty;
					//empty.setCurrentPosition(div, mod);
					continue;
				case 1: 
					matrix[div][mod] = one;
					//one.setCurrentPosition(div, mod);
					continue;
				case 2: 
					matrix[div][mod] = two;
					//two.setCurrentPosition(div, mod);
					continue;
				case 4: 
					matrix[div][mod] = four;
					//four.setCurrentPosition(div, mod);
					continue;
				case 5: 
					matrix[div][mod] = five;
					//five.setCurrentPosition(div, mod);
					continue;
				case 6: 
					matrix[div][mod] = six;
					//six.setCurrentPosition(div, mod);
					continue;
				case 7: 
					matrix[div][mod] = seven;
					//seven.setCurrentPosition(div, mod);
					continue;
				case 8: 
					matrix[div][mod] = eight;
					//eight.setCurrentPosition(div, mod);
					continue;
				case 9: 
					matrix[div][mod] = nine;
					//nine.setCurrentPosition(div, mod);
					continue;
				default:
					throw new WrongInputException("Numbers must be in the range 0-9 (where 0 represents the empty cell)\n" +
													"3 cannot be one of the numbers");
			}
		}
	}

	/**
	 * This method validates the input matrix (which was given by the user).
	 * @throws WrongInputException
	 */
	public void validateMatrix() throws WrongInputException  
	{	
		// Check for duplicate values in the matrix...
		Vector v1 = new Vector();
		for (int i=0; i<MATRIX_SIZE; i++)
		{
			for (int j=0; j<MATRIX_SIZE; j++)
			{
				if (v1.contains(matrix[i][j]))
				{
					throw new WrongInputException("Duplicate numbers are not allowed. ");
				}
				v1.add(matrix[i][j]);
			}
		}
		//check if 0 is not contained...
		if (!v1.contains(empty))
		{
			throw new WrongInputException("Zero (the empty cell) has to be in the matrix. ");
		}
		//check if  the game has ended before it begins!...
		if (hasGameEnded())
		{
			throw new WrongInputException("The game has already ended!");
		}
		
		// If everything is OK...
		System.err.println("It is a valid matrix!");
		System.err.println();
	}
	
	/**
	 * This method prints the current state of the matrix to the console.
	 */
	public void printMatrix()  
	{
		System.err.println();
		for (int i=0; i<MATRIX_SIZE; i++)
		{
			System.err.print("|  ");
			for (int j=0; j<MATRIX_SIZE; j++)
			{
				System.err.print(matrix[i][j].getValue() + "  |  ");
			}
			System.err.println();
		}
		System.err.println();
	}
	
	/**
	 * This method checks if the game has ended.
	 * @return
	 */
	public boolean hasGameEnded()
	{
		if ( matrix[0][0].getValue() == 1 && matrix[0][1].getValue() == 2 && matrix[0][2].getValue() == 0 
				&& matrix[1][0].getValue() == 4 && matrix[1][1].getValue() == 5 && matrix[1][2].getValue() == 6
				&& matrix[2][0].getValue() == 7 && matrix[2][1].getValue() == 8 && matrix[2][2].getValue() == 9 )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	///////////////////////////////// "Getter" methods (3) of the matrix (START) /////////////////////////////////////////
	
	/**
	 * This method takes a value (integer). 
	 * A reference to the corresponding Element object is returned.
	 * @param elem
	 * @return
	 */
	public Element getElement(int elem)  
	{
		for (int i=0; i<MATRIX_SIZE; i++)
		{
			for (int j=0; j<MATRIX_SIZE; j++)
			{
				if (matrix[i][j].getValue() == elem)
				{	
					return matrix[i][j]; 
				}
			}
		}
		return null;
	}
	
	/**
	 * This method takes a value (integer).
	 * The coordinates of the corresponding Element object on the matrix are returned,
	 * as a two dimentional array of ints.
	 * @param elem
	 * @return
	 */
	public int[] getElementPosition(int elem)  
	{	
		int[] res = new int[2];
		for (int i=0; i<MATRIX_SIZE; i++)
		{
			for (int j=0; j<MATRIX_SIZE; j++)
			{
				if (matrix[i][j].getValue() == elem)
				{	
					res[0]= i;
					res[1]=j;
				}
			}
		}
		return res;
	}
	
	/**
	 * This method takes two coordinates.
	 * A reference to the corresponding Element object is returned.
	 * @param line
	 * @param column
	 * @return
	 */
	public Element getElementAt(int line, int column)
	{
		return this.matrix[line][column];
	}
	
	/////////////////////////////////////////// "Getter" methods (3) of the matrix (END) ///////////////////////////////////////////
	
	
	/**
	 * This method checks whether the element that the user wishes to move, has a legal move or not.
	 * If the element has a legal move then the method returns the coordinates of the cell where the element will be moved.
	 * If the user wanted to move non-existing Element-3, then the method returns {-3, -3}. 
	 * If the element has no legal move (it is blocked by other Elements), then the method returns {-1, -1}.
	 * @param elem
	 * @return
	 */
	public int[] checkMove(int elem)	
	{
		int[] coordinates = getElementPosition(elem); 	// the element's initial position.
		int[] destination = new int[2];					// the element's next position (if move is possible).
		
		if (elem == 3)	// if the user wants to move the non-existing Element 3...
		{
			destination[0] = -3;
			destination[1] = -3;
			return destination;
		}
		
		if ( coordinates[0] == 0 && coordinates[1] == 0)
		{	
			// for this position of the element (upper-left), we 'll have to check all its neighbours...
			
			// if the element is blocked by its neighbours...
			if ( (getElementAt(0, 1).getValue() != 0) && (getElementAt(1, 0).getValue() != 0) )
			{
				destination[0] = -1;
				destination[1] = -1;
				return destination;
			}
			// but if it can move...
			else if (getElementAt(0, 1).getValue() == 0)
			{
				destination[0] = 0;
				destination[1] = 1;
				return destination;
			}
			else
			{
				destination[0] = 1;
				destination[1] = 0;
				return destination;
			}
		}
		else if ( coordinates[0] == 0 && coordinates[1] == 1)
		{	
			//...the same motif here...and all the way down...
			if ( (getElementAt(0, 0).getValue() != 0) && (getElementAt(0, 2).getValue() != 0) 
					&& (getElementAt(1, 1).getValue() != 0))
			{
				destination[0] = -1;
				destination[1] = -1;
				return destination;
			}
			else if (getElementAt(0, 0).getValue() == 0)
			{
				destination[0] = 0;
				destination[1] = 0;
				return destination;
			}
			else if (getElementAt(0, 2).getValue() == 0)
			{
				destination[0] = 0;
				destination[1] = 2;
				return destination;
			}
			else
			{
				destination[0] = 1;
				destination[1] = 1;
				return destination;
			}
		}
		else if ( coordinates[0] == 0 && coordinates[1] == 2)
		{
			if ( (getElementAt(0, 1).getValue() != 0) && (getElementAt(1, 2).getValue() != 0) )
			{
				destination[0] = -1;
				destination[1] = -1;
				return destination;
			}
			else if (getElementAt(0, 1).getValue() == 0)
			{
				destination[0] = 0;
				destination[1] = 1;
				return destination;
			}
			else
			{
				destination[0] = 1;
				destination[1] = 2;
				return destination;
			}
		}
		else if ( coordinates[0] == 1 && coordinates[1] == 0)
		{
			if ( (getElementAt(0, 0).getValue() != 0) && (getElementAt(1, 1).getValue() != 0) 
					&& (getElementAt(2, 0).getValue() != 0))
			{
				destination[0] = -1;
				destination[1] = -1;
				return destination;
			}
			else if (getElementAt(0, 0).getValue() == 0)
			{
				destination[0] = 0;
				destination[1] = 0;
				return destination;
			}
			else if (getElementAt(1, 1).getValue() == 0)
			{
				destination[0] = 1;
				destination[1] = 1;
				return destination;
			}
			else 
			{
				destination[0] = 2;
				destination[1] = 0;
				return destination;
			}
		}
		else if ( coordinates[0] == 1 && coordinates[1] == 1)
		{
			if ( (getElementAt(0, 1).getValue() != 0) && (getElementAt(1, 0).getValue() != 0) 
					&& (getElementAt(1, 2).getValue() != 0) && (getElementAt(2, 1).getValue() != 0) )
			{
				destination[0] = -1;
				destination[1] = -1;
				return destination;
			}
			else if (getElementAt(0, 1).getValue() == 0)
			{
				destination[0] = 0;
				destination[1] = 1;
				return destination;
			}
			else if (getElementAt(1, 0).getValue() == 0)
			{
				destination[0] = 1;
				destination[1] = 0;
				return destination;
			}
			else if (getElementAt(1, 2).getValue() == 0)
			{
				destination[0] = 1;
				destination[1] = 2;
				return destination;
			}
			else 
			{
				destination[0] = 2;
				destination[1] = 1;
				return destination;
			}
		}
		else if ( coordinates[0] == 1 && coordinates[1] == 2)
		{
			if ( (getElementAt(0, 2).getValue() != 0) && (getElementAt(1, 1).getValue() != 0) 
					&& (getElementAt(2, 2).getValue() != 0))
			{
				destination[0] = -1;
				destination[1] = -1;
				return destination;
			}
			else if (getElementAt(0, 2).getValue() == 0)
			{
				destination[0] = 0;
				destination[1] = 2;
				return destination;
			}
			else if (getElementAt(1, 1).getValue() == 0)
			{
				destination[0] = 1;
				destination[1] = 1;
				return destination;
			}
			else
			{
				destination[0] = 2;
				destination[1] = 2;
				return destination;
			}
		}
		else if ( coordinates[0] == 2 && coordinates[1] == 0)
		{
			if ( (getElementAt(1, 0).getValue() != 0) && (getElementAt(2, 1).getValue() != 0) )
			{
				destination[0] = -1;
				destination[1] = -1;
				return destination;
			}
			else if (getElementAt(1, 0).getValue() == 0)
			{
				destination[0] = 1;
				destination[1] = 0;
				return destination;
			}
			else 
			{
				destination[0] = 2;
				destination[1] = 1;
				return destination;
			}
		}
		else if ( coordinates[0] == 2 && coordinates[1] == 1)
		{
			if ( (getElementAt(2, 0).getValue() != 0) && (getElementAt(1, 1).getValue() != 0) 
				&& (getElementAt(2, 2).getValue() != 0))
			{
				destination[0] = -1;
				destination[1] = -1;
				return destination;
			}
			else if (getElementAt(1, 1).getValue() == 0)
			{
				destination[0] = 1;
				destination[1] = 1;
				return destination;
			}
			else if (getElementAt(2, 0).getValue() == 0)
			{
				destination[0] = 2;
				destination[1] = 0;
				return destination;
			}
			else
			{
				destination[0] = 2;
				destination[1] = 2;
				return destination;
			}
		}
		else if ( coordinates[0] == 2 && coordinates[1] == 2)
		{
			if ( (getElementAt(2, 1).getValue() != 0) && (getElementAt(1, 2).getValue() != 0) )
			{
				destination[0] = -1;
				destination[1] = -1;
				return destination;
			}
			else if (getElementAt(1, 2).getValue() == 0)
			{
				destination[0] = 1;
				destination[1] = 2;
				return destination;
			}
			else
			{
				destination[0] = 2;
				destination[1] = 1;
				return destination;
			}
		}	
		
		return destination;
	}
	
	/**
	 * This method processes/executes the move that will be played.
	 * If the computer plays: The AI has previously decided what the move will be.
	 * If the user plays: His move has previously been checked. 
	 * @param elem
	 * @param destination
	 */
	public void processMove(int elem, int[] destination)
	{		
		int[] elemPos = getElementPosition(elem);
		
		matrix[elemPos[0]][elemPos[1]] = empty;		// the cell where the number to move was, will become the empty cell!
		
		//empty.setCurrentPosition(getElementPosition(elem)[0] , getElementPosition(elem)[1]);
		//empty.incrementTimes_moved();
			
		switch (elem)
		{
			case 1:
				matrix[destination[0]][destination[1]]= one;
				//one.setCurrentPosition(destination[0], destination[1]);
				//one.incrementTimes_moved();
				break;
			case 2:
				matrix[destination[0]][destination[1]]= two;
				//two.setCurrentPosition(destination[0], destination[1]);
				//two.incrementTimes_moved();
				break;
			case 4:
				matrix[destination[0]][destination[1]]= four;
				//four.setCurrentPosition(destination[0], destination[1]);
				//four.incrementTimes_moved();
				break;
			case 5:
				matrix[destination[0]][destination[1]]= five;
				//five.setCurrentPosition(destination[0], destination[1]);
				//five.incrementTimes_moved();
				break;
			case 6:
				matrix[destination[0]][destination[1]]= six;
				//six.setCurrentPosition(destination[0], destination[1]);
				//six.incrementTimes_moved();
				break;
			case 7:
				matrix[destination[0]][destination[1]]= seven;
				//seven.setCurrentPosition(destination[0], destination[1]);
				//seven.incrementTimes_moved();
				break;
			case 8:
				matrix[destination[0]][destination[1]]= eight;
				//eight.setCurrentPosition(destination[0], destination[1]);
				//eight.incrementTimes_moved();
				break;
			case 9:
			matrix[destination[0]][destination[1]]= nine;
				//nine.setCurrentPosition(destination[0], destination[1]);
				//nine.incrementTimes_moved();
				break;
			default:
				break;
		}
	
		return;
	}
	
	/**
	 * This method returns a Vector with all the numbers (values of elements) that can be moved. 
	 * @return
	 */
	public Vector findValidMoves()
	{
		Vector validMoves = new Vector();
		
		// Our starting point are the coordinates of the cell that has the "empty" Element. 
		int[] emptyPosition = this.getElementPosition(0);
		
		if (emptyPosition[0]==0 && emptyPosition[1]==0)
		{
			validMoves.add(new Integer(this.getMatrix()[0][1].getValue()));
			validMoves.add(new Integer(this.getMatrix()[1][0].getValue()));
		}
		else if (emptyPosition[0]==0 && emptyPosition[1]==1)
		{
			validMoves.add(new Integer(this.getMatrix()[0][0].getValue()));
			validMoves.add(new Integer(this.getMatrix()[0][2].getValue()));
			validMoves.add(new Integer(this.getMatrix()[1][1].getValue()));
		}
		else if (emptyPosition[0]==0 && emptyPosition[1]==2)
		{
			validMoves.add(new Integer(this.getMatrix()[0][1].getValue()));
			validMoves.add(new Integer(this.getMatrix()[1][2].getValue()));
		}
		else if (emptyPosition[0]==1 && emptyPosition[1]==0)
		{
			validMoves.add(new Integer(this.getMatrix()[0][0].getValue()));
			validMoves.add(new Integer(this.getMatrix()[1][1].getValue()));
			validMoves.add(new Integer(this.getMatrix()[2][0].getValue()));
		}
		else if (emptyPosition[0]==1 && emptyPosition[1]==1)
		{
			validMoves.add(new Integer(this.getMatrix()[0][1].getValue()));
			validMoves.add(new Integer(this.getMatrix()[1][0].getValue()));
			validMoves.add(new Integer(this.getMatrix()[1][2].getValue()));
			validMoves.add(new Integer(this.getMatrix()[2][1].getValue()));
		}
		else if (emptyPosition[0]==1 && emptyPosition[1]==2)
		{
			validMoves.add(new Integer(this.getMatrix()[0][2].getValue()));
			validMoves.add(new Integer(this.getMatrix()[1][1].getValue()));
			validMoves.add(new Integer(this.getMatrix()[2][2].getValue()));
		}
		else if (emptyPosition[0]==2 && emptyPosition[1]==0)
		{
			validMoves.add(new Integer(this.getMatrix()[1][0].getValue()));
			validMoves.add(new Integer(this.getMatrix()[2][1].getValue()));
		}
		else if (emptyPosition[0]==2 && emptyPosition[1]==1)
		{
			validMoves.add(new Integer(this.getMatrix()[1][1].getValue()));
			validMoves.add(new Integer(this.getMatrix()[2][0].getValue()));
			validMoves.add(new Integer(this.getMatrix()[2][2].getValue()));
		}
		else if (emptyPosition[0]==2 && emptyPosition[1]==2)
		{
			validMoves.add(new Integer(this.getMatrix()[1][2].getValue()));
			validMoves.add(new Integer(this.getMatrix()[2][1].getValue()));
		}
		
		return validMoves;
	}
	
	/**
	 * THE BASIC METHOD OF THIS CLASS.
	 * 
	 * This method is called in the application's main() method to start playing the game,
	 * after "all preparations are made".
	 * It calls either the humanPlaysGame() method or the computerPlaysGame() method,
	 */
	public void playTheGame()
	{
		System.err.println("If you want to play this game, press 1.");
		System.err.println("If you want the computer to play this game, press 2.");
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		while (!s1.equals("1") && !s1.equals("2"))
		{
			System.err.println("If you want to play this game, press 1.");
			System.err.println("If you want the machine to play this game, press 2.");
			s1 = sc.next();
		}
		if (s1.equals("1"))
		{
			/////////////////
			humanPlaysGame();
			/////////////////
		}
		else if (s1.equals("2"))
		{
			///////////////////
			machinePlaysGame();
			///////////////////
		}
	}
	
	/**
	 * Starts a new game for a human player.
	 * @return
	 */
	public void humanPlaysGame()
	{
		Scanner scan = new Scanner(System.in);
		int playerMove;
		
		this.printMatrix();
		System.err.println("Please enter a number to move: ");
		
		while (!hasGameEnded())
		{
			playerMove = Integer.parseInt(scan.next());  //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& more checking needed here!...
			
			//////////////////////////////////////////////////////////////////////////////
			int[] destin = checkMove(playerMove); 	// CHECKS THE USER MOVE HERE!!!
			//////////////////////////////////////////////////////////////////////////////
			
			if (destin[0] == -3 && destin[1] == -3)
			{
				System.err.println("There is no number 3 in the matrix!");
				printMatrix();
				System.err.println("Please enter a number to move: ");
				continue;
			}
			
			else if (destin[0] == -1 && destin[1] == -1)
			{
				System.err.println("Element " + playerMove + " can't be moved!");
				printMatrix();
				System.err.println("Please enter a number to move: ");
				continue;
			}
			else
			{
				///////////////////////////////////////////////////////////////////////////////
				processMove(playerMove, destin); 	 	// Execute the player's (valid) move!
				///////////////////////////////////////////////////////////////////////////////
				
				printMatrix();
				System.err.println("Please enter a number to move: ");
			}
			
		}
		
		System.err.println();
		System.err.println("********** CONGRATULATIONS! YOU'VE SOLVED THE PUZZLE!!! **********");
		System.err.println();
		
		return;
	}
	
	/**
	 * This method lets the computer play the game 
	 * (beginning with the matrix that the user has previously entered).
	 *@return
	 */
	public void machinePlaysGame()
	{	
		/**
		 * The Evaluator object we will use in order to find the best moves at any position.
		 */
		Evaluator myEvaluator = new Evaluator();
		
		/**
		 * myEvaluator.getBestMove() is used to set this variable...
		 */
		int bestMv = -5; 	
		
		/**
		 * Used so that the user can stop the computer's game at any time.
		 */
		String again;
		
		
		Scanner sc = new Scanner(System.in);
		
		while (!this.hasGameEnded())
		{	
			// We want to have a "clean" Evaluator object again...
			myEvaluator.clearEvaluatorData();
			
			
			/////////////////////////////
			this.deepSearch(myEvaluator);		// Now the myEvaluator object contains all the info we need!
			/////////////////////////////
			
			
			// If the computer found a path leading to a solution,
			// the matrix is displayed as each move is being executed in a row.
			if (myEvaluator.foundSolution)
			{
				System.err.println("I found the solution! It is:\n");
				for (int i=0; i<myEvaluator.bestPath.size(); i++)
				{
					int[] dest = this.checkMove(Integer.parseInt(myEvaluator.bestPath.elementAt(i).toString()));
					this.processMove(Integer.parseInt(myEvaluator.bestPath.elementAt(i).toString()), dest);
					this.printMatrix();
				}
				System.err.println("Am I good or not?... :-)");
				System.err.println();
				return;
			}
			
			// If the computer didn't find a path to a solution, it plays "the best move possible"...
			else
			{
				bestMv = myEvaluator.getBestMove();
				int[] dest = this.checkMove(bestMv);	// %%%%%%%%%%%%%%%%%Perhaps some redundancy here, but OK...
				this.processMove(bestMv, dest);
				myEvaluator.setLastMove(bestMv); 		// A way to know the last move, so that later 
														// we don't even consider moving the same element again.
		
				this.printMatrix();
					
				System.err.println("I just moved number " + bestMv + "...");
				System.err.println();
				System.err.println("Press 'c' to see the continuation...");
					
				again = sc.next();
				if (!again.equals("c"))
				{
					System.err.println("Stopping...");
					return; // &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&Has to be modified (to be better)...
				}	
			}
		}
	}

	/**
	 * This RECURSIVE  method searches all the variations of the game until a specific
	 * depth in the analysis is reached (this depth is specified by the integer variable
	 * max_depth in the Evaluator class).
	 * All the info of the analysis (primarily the "best path") is stored in the
	 * Evaluator object it takes as argument.
	 * The same object is continiously used until the end of the analysis (for 1 move).
	 * 
	 * @return
	 */
	public void deepSearch(Evaluator myEval) 
	{	
		Vector validMoves = this.findValidMoves(); 	// &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& PERHAPS REDUNDANT!!!
														//  PERHAPS MAKE IT A METHOD OF HIS CLASS!!!
		
		NumberPuzzleGame gameClone;
		
		
		for (int i=0; i<validMoves.size(); i++)
		{
			// check this valid move in the vector...
			int currentMove = Integer.parseInt(validMoves.elementAt(i).toString());
			
			// IMPROVEMENT (1)! 	This way we don't even consider moving the same element after we have previously moved it... 
			if (myEval.getLastMove()==currentMove && myEval.currentDepth==0)
			{
				continue;
			}
			
			// IMPROVEMENT (2)! 	This way we don't even consider moving the same element when "building" a path of moves.
			if (myEval.currentPath.size()!=0 && Integer.parseInt(myEval.currentPath.lastElement().toString())==currentMove)
			{
				continue;
			}
			
			int[] currentDestination = this.checkMove(currentMove); 	// &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& PERHAPS REDUNDANT!!!
																		// It will certainly return some "valid" target coordinates.
			
			///////////////////////////////////
			//	START OF DIFFICULT PART!!
			///////////////////////////////////
			
			// Create a clone of the game (for each valid move)... 
			gameClone = new NumberPuzzleGame(this);
				
			
			
			// play that move in the clone and increment the depth...
			gameClone.processMove(currentMove, currentDestination); 
			
			myEval.currentDepth++;						// standard change !!!
			myEval.currentPath.addElement(currentMove);	// ...the same here !!!
			
			// HAVE WE FOUND A BETTER PATH??
			
			// Has the game been solved (at some point)?
			if (gameClone.hasGameEnded())
			{
				myEval.bestEvaluation = 10000;
				myEval.bestPath = (Vector) myEval.currentPath.clone();
				myEval.foundSolution = true;
				return;			
			}
			
			//Only if we are at the leaves we should evaluate!...
			if (myEval.currentDepth == Evaluator.getMax_depth())
			{	
				int eval = myEval.evaluatePosition(gameClone);
		
				if (eval > myEval.bestEvaluation)
				{
					myEval.bestEvaluation = eval; 
						 
					myEval.bestPath = (Vector) myEval.currentPath.clone();
				}
			}
			else 
			{
				// RECURSION!!!
				gameClone.deepSearch(myEval);
				
				// This way, if a path leading to a solution is found at some point,
				// we exit from all the deepcopy calls...
				if (myEval.foundSolution)
				{
					return;
				}
			}
			myEval.currentDepth--;
			myEval.currentPath.removeElementAt(myEval.currentPath.size()-1);
		}//for
		
		return;
	}
}//class NumberPuzzleGame

