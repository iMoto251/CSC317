package PolyCalc;

public class Scalar {

    private double value;
    private String indication;
	
    //Default methods
	public Scalar add(Scalar s) {
        return valueCheck(((Scalar) s).getValue() + getValue());
    }
	
	public Scalar mult(Scalar s) {
        return valueCheck(((Scalar) s).getValue() * getValue());
    }
	
	public Scalar pow(int exp) {
        double newValue = value;
        while (exp != 1) {
            newValue = newValue * value;
            exp = exp - 1;
        }
        return valueCheck(newValue);
    }
	
	public Scalar neg() {
        return valueCheck(getValue() * (-1));
    }
	
	public boolean equals(Scalar s) {
        return ((Scalar) s).getValue() == getValue();
    }
	
	//Constructor
    public Scalar(double value, String indication) {
        this.value = value;
        this.indication = indication;
    }

    
    //Added helpers
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Scalar multInt(int exp) {
        return valueCheck(getValue() * exp);
    }

    public String getIndication(){
        return this.indication;
    }

    public String toString() {

        String number = Double.toString(getValue());
        String integer = number.substring(0, number.indexOf('.'));
        String output;
        
        
        output = integer;

        return output;
    }

    public static Scalar valueCheck(double newValue){
        if (newValue >= 0) {
            String posNumber = "+";
            return new Scalar(newValue, posNumber);
        } else {
            String negNumber = "-";
            return new Scalar(newValue, negNumber);
        }
    }
    public boolean isZero(){
        return getValue()==0;
    }
}
