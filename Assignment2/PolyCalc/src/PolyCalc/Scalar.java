package PolyCalc;

public class Scalar {

    private double value;
    private String indication;
	
	public Scalar add(Scalar s) {
        return valueCheck(((Scalar) s).getValue() + getValue());
    }
	
	public Scalar mult(Scalar s) {
        return valueCheck(((Scalar) s).getValue() * getValue());
    }
	
	public Scalar pow(int exponent) {
        double newValue = value;
        while (exponent != 1) {
            newValue = newValue * value;
            exponent = exponent - 1;
        }
        return valueCheck(newValue);
    }
	
	public Scalar neg() {
        return valueCheck(getValue() * (-1));
    }
	
	public boolean equals(Scalar s) {
        return ((Scalar) s).getValue() == getValue();
    }
	
	//Added helpers
    public Scalar(double value, String indication) {
        this.value = value;
        this.indication = indication;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Scalar multInt(int exponent) {
        return valueCheck(getValue() * exponent);
    }

    public String getIndication(){
        return this.indication;
    }

    public String toString() {

        String number = Double.toString(getValue());
        String integer = number.substring(0, number.indexOf('.'));
        String fraction = number.substring(number.indexOf('.') + 1);

        String output;

        if (fraction.length() > 3) {
            fraction = fraction.substring(0, 3);
        }

        if(fraction.equals("0")){
            output = integer;
        } else {
            output = integer + "." + fraction;
        }

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
