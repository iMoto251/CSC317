package polyCal;

public interface Scalar {
		
	public Scalar add(Scalar s);
	public Scalar mult(Scalar s);
	public Scalar mult(int num); 
	public Scalar pow(int exponent);
	public Scalar neg();	
	public boolean equals(Scalar s);
	public String toString();
	
}