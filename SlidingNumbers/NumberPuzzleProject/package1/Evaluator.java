package package1;

import java.util.Vector;

public class Evaluator {

	//////////////////////////////////////////////////////// FIELDS ///////////////////////////////////////////////////////////////////////
	
	static int max_depth = 19;
	
	
	public int currentDepth;
	public Vector currentPath;
	
	public int bestEvaluation;
	public Vector bestPath; 

	/**
	 * This variable holds the computer's last executed move.
	 * This way it is told later not to try moving the same element again.
	 */
	public int lastMove;
	
	boolean foundSolution;
	
	
	//int bestMove = 0;
	//int bestDestination[] = null;
	
	/////////////////////////////////////////////////////// METHODS ///////////////////////////////////////////////////////////////////////
	
	/**
	 * Constructor
	 */
	public Evaluator()
	{
		currentDepth = 0;
		currentPath = new Vector();
		bestEvaluation = -10000;
		bestPath = new Vector();
		lastMove = -1;
		foundSolution = false;
	}
	
	public void setLastMove(int lastMv)
	{
		this.lastMove = lastMv; 
	}
	
	public int getLastMove()
	{
		return this.lastMove; 
	}
	
	/**
	 * Clears data from the Evaluator object so that it can be
	 * used again to find the best move.
	 *@return
	 */
	public void clearEvaluatorData() 
	{
		currentDepth = 0;
		currentPath.clear();
		bestEvaluation = -10000;
		bestPath.clear();
		// The value of the lastMove variable must not change here!
		foundSolution = false;
	}
	
	/**
	 * Returns the best move for the current situation in the game.
	 * It is the first element in the bestPath Vector.
	 */
	public int getBestMove() 
	{
		return Integer.parseInt(bestPath.elementAt(0).toString());
	}
	
	/**
	 * This method returns the maximum depth that the AI uses for its calculations.
	 * @return
	 */
	public static int getMax_depth()
	{
		return max_depth;
	}
	
	/**
	 * This method sets the maximum depth that the AI uses for its calculations.
	 * @param depth
	 */
	private static void setMax_depth(int depth)
	{
		max_depth = depth;
	}
	
	
	/**
	 * Takes as parameter a NumberPuzzleGame 
	 * and it returns the AI's evaluation of its position.
	 * @param game
	 * @return
	 */
	public static int evaluatePosition(NumberPuzzleGame game)
	{	
		int evaluation = 0;
		Element[][] matrix = game.getMatrix();
		
		if (game.hasGameEnded())
		{
			evaluation = 10000;
			return evaluation;
		}
		
		///////////////////////////////////////////////////////////////////////////////////////		
		//if the first line has 7, 8 and 9 its very bad.
		if ( (matrix[0][0].getValue()==7 || matrix[0][0].getValue()==8 || matrix[0][0].getValue()==9)
				&& (matrix[0][1].getValue()==7 || matrix[0][1].getValue()==8 || matrix[0][1].getValue()==9)
				&& (matrix[0][2].getValue()==7 || matrix[0][2].getValue()==8 || matrix[0][2].getValue()==9) )
		{
			evaluation -= 500;
		}
		
		
		//if the first line has two of the numbers 7, 8 and 9 its bad.
		else if ( (matrix[0][0].getValue()==7 || matrix[0][0].getValue()==8 || matrix[0][0].getValue()==9)
					&& ( (matrix[0][1].getValue()==7 || matrix[0][1].getValue()==8 || matrix[0][1].getValue()==9)
							|| (matrix[0][2].getValue()==7 || matrix[0][2].getValue()==8 || matrix[0][2].getValue()==9) ) )
		{
			evaluation -= 300;
		}
		else if ( (matrix[0][1].getValue()==7 || matrix[0][1].getValue()==8 || matrix[0][1].getValue()==9)
					&& (matrix[0][2].getValue()==7 || matrix[0][2].getValue()==8 || matrix[0][2].getValue()==9) ) 
		{
			evaluation -= 300;
		}
		
		
		//if the first line has one of the numbers 7, 8 and 9:
		else if ( (matrix[0][0].getValue()==7 || matrix[0][0].getValue()==8 || matrix[0][0].getValue()==9)
					|| (matrix[0][1].getValue()==7 || matrix[0][1].getValue()==8 || matrix[0][1].getValue()==9)
					|| (matrix[0][2].getValue()==7 || matrix[0][2].getValue()==8 || matrix[0][2].getValue()==9) )
		{
			evaluation -= 150;
		}
		
		//////////////////////////////////////////////////////////////////
		//if the last line has both 1 and 2 it is bad.
		if ( (matrix[2][0].getValue()==1 || matrix[2][0].getValue()==2)
				&& ( (matrix[2][1].getValue()==1 || matrix[2][1].getValue()==2)
						|| (matrix[2][2].getValue()==1 || matrix[2][2].getValue()==2) ) )
		{
			evaluation -= 300;
		}
		else if ( (matrix[2][1].getValue()==1 || matrix[2][1].getValue()==2)
				&&  (matrix[2][2].getValue()==1 || matrix[2][2].getValue()==2) )
		{
			evaluation -= 300;
		}
		
		
		//if the last line has one of the numbers 1 and 2:
		else if ( (matrix[2][0].getValue()==1 || matrix[2][0].getValue()==2)
				|| (matrix[2][1].getValue()==1 || matrix[2][1].getValue()==2)
				|| (matrix[2][2].getValue()==1 || matrix[2][2].getValue()==2) )
		{
			evaluation -= 150;
		}
		///////////////////////////////////////////////////////////////////////////////
		
		///////////////////////////////////////////////////////////////////////////////
		// GOOD SIGNS:
		if ( matrix[2][0].getValue()==7 && matrix[2][1].getValue()==8
				&& matrix[2][2].getValue()==9 )	
		{
			evaluation += 4000;	
		}
		else if (matrix[2][0].getValue()==7 && matrix[2][2].getValue()==9 )
		{
			evaluation += 2000;	
		}
		else if (matrix[2][1].getValue()==8 && matrix[2][2].getValue()==9 )
		{
			evaluation += 2000;	
		}
		//////////
		if (matrix[1][0].getValue()==4 && matrix[1][2].getValue()==6 )
		{
			evaluation += 2000;	
		}
		
		return evaluation;
	}

}
