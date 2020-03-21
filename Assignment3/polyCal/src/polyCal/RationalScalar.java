package polyCal;

public class RationalScalar implements Scalar{

	private int numerator;
	private int divisor;
	
	public RationalScalar(int numerator, int divisor) {
		if (divisor == 0) 
		    System.out.println("You can't divide by zero");
		
		int gcd=getGCD(Math.abs(numerator),Math.abs(divisor));
		
		this.numerator=numerator/gcd;
		this.divisor=divisor/gcd;
	}
	
	public int getNumerator() { return numerator; }	
	public int getDivisor() { return divisor; }
	public void setNumerator(int a) { numerator=a; }	
	public void setDivisor(int b) { divisor=b; }
	
	//find the great common divisor and edit the rational scalar respectively
	private int getGCD(int a,int b) {
	    int m = a;
	    int n = b;
	    int r = m%n;
	    while (r != 0) {
			m=n;
	        n=r; 
	        r = m%n;
	    }
	    return n;
	}
	
	public Scalar add(Scalar s) {
		int a,b;
		
		if(!(s instanceof RationalScalar))
			System.out.println("Not a rational Scalar");
		
		RationalScalar scalar=(RationalScalar)s;
		
		a=(numerator*scalar.getDivisor())+(divisor*scalar.getNumerator());
		b=this.divisor*scalar.getDivisor();
		
		int gcd=getGCD(Math.abs(numerator),Math.abs(divisor));
		
		return new RationalScalar(a/gcd, b/gcd);
	}
	
	public Scalar mult(int num) {
		Scalar pos=new RationalScalar(num, 1);
		return mult(pos);
	}
	
	public Scalar mult(Scalar s) {
		int a,b;
		
		if(!(s instanceof RationalScalar))
			System.out.println("Not a rational Scalar");
		
		RationalScalar scalar=(RationalScalar)s;
		
		a=numerator*scalar.getNumerator();
		b=this.divisor*scalar.getDivisor();
		
		int gcd=getGCD(Math.abs(numerator),Math.abs(divisor));
		
		return new RationalScalar(a/gcd, b/gcd);
		} 
	
	public Scalar pow(int exponent) {
		int a = 1;
		int b = 1;
		
		for(int i=0;i<exponent;i++) {
			a*=numerator;
			b*=divisor;
		}
		
		int gcd=getGCD(Math.abs(numerator),Math.abs(divisor));
		
		return new RationalScalar(a/gcd, b/gcd);
		} 
	
	public Scalar neg() {		
		int a=(-1)*numerator;
		
		return new RationalScalar(a, getDivisor());
	} 
	
	public boolean equals(Scalar s) {
		if(!(s instanceof RationalScalar))
			System.out.println("Not a rational Scalar");
		
		RationalScalar scalar=(RationalScalar)s;
		
		return numerator==scalar.getNumerator() & divisor==scalar.getDivisor();	
	} 
	
	public String toString() {
		if(divisor==1) {
			if(numerator==-1)
				return "-";
			
			else
				return numerator+"";
		}
		
		return numerator+"/"+divisor;
	}
}
