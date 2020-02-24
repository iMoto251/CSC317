package PolyCalc;

public class Polyterm {

    private Scalar scalar;
    private int exp;
    private String indication;
	
	public boolean canAdd(Polyterm pt) {
        return pt.getExp() == exp;
    }

    public Polyterm add(Polyterm pt) {
        if (canAdd(pt)) {
            Polyterm output = new Polyterm(pt.getScalar().add(scalar), exp);
            return output;
        } else {
            return this;
        }
    }
	
	public Polyterm mult(Polyterm pt) {

        Polyterm output = new Polyterm(getScalar().mult(pt.getScalar()), getExp() + pt.getExp());
        return output;
    }
	
	public Scalar evaluate(Scalar scalar) {
        Scalar output = (scalar.pow(getExp())).mult(getScalar());
        return output;
    }
	
	public Polyterm derivative() {
        Polyterm output;
        if (getExp() != 0) {
            output = new Polyterm(getScalar().multInt(exp), exp - 1);
        } else {
            output = new Polyterm(getScalar().multInt(0), 1);
        }
        return output;
    }
	
	public boolean equals(Polyterm polyTerm) {
        return (getScalar().equals(polyTerm.getScalar()) & getExp() == polyTerm.getExp());
    }
	
	//Constructor
    public Polyterm(Scalar scalar, int exp) {
        this.scalar = scalar;
        this.exp = exp;
        this.indication = scalar.getIndication();
    }

    //Added helpers
    public Scalar getScalar() {
        return scalar;
    }

    public int getExp() {
        return exp;
    }

    public void setScalar(Scalar scalar) {
        this.scalar = scalar;
    }

    public void setexp(int exp) {
        this.exp = exp;
    }

    public String getIndication() {
        return this.indication;
    }

    public int compareTo(Polyterm poly) {
        return getExp() - poly.getExp();
    }

    public String toString() {
        String poly;
        if (getScalar().isZero()) {
            return "";
        }
        
        if (getExp() == 0) {
            poly = this.getScalar().toString();
        }
        
        else if (getExp()!=1){
            if (getScalar().toString().equals("1")) {
                poly = "x^" + getExp();
            } else if (getScalar().toString().equals("-1")) {
                poly = "-x^" + getExp();
            } else {
                poly =  getScalar().toString()  + "x^" + getExp();
            }
        }
        
        else{
            if (getScalar().toString().equals("1")) {
                poly = "x";
            } else if (getScalar().toString().equals("-1")) {
                poly = "-x";
            } else {
                poly =  getScalar().toString()  + "x";
            }
        }
        return poly;
    }
}
