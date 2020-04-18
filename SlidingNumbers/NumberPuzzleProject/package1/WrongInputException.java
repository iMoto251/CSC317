package package1;

public class WrongInputException extends Exception 
{	
	private String errorMsg;
	
	public WrongInputException(String msg)
	{
		this.errorMsg = msg;
	}
	
	public void printErrorMsg()
	{
		System.err.println(errorMsg);
	}
}
