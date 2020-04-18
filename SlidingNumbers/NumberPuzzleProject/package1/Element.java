package package1;

/**
 * This class represents an element of the matrix.
 * Though it doesn't hold a lot of info (in the current version of the project)
 * it can be enrichened if we want to (eg. Each element could have a different color).
 * @author Dionisis
 *
 */
public class Element 
{
	private int value;
	private int times_moved;
	//private int[] currentPosition;
	
	public Element()
	{
		
	}
	
	public Element(int val)
	{
		this.value = val;
		this.times_moved = 0;  
		//currentPosition = new int[2];
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void incrementTimes_moved()
	{
		this.times_moved++;
	}
	
	public int getTimes_moved()
	{
		return this.times_moved;
	}
	
	/*public void setCurrentPosition(int line, int column)
	{
		this.currentPosition[0] = line;
		this.currentPosition[1] = column;
	}
	
	public int[] getCurrentPosition()
	{
		return this.currentPosition;
	}
	*/
	
}    


