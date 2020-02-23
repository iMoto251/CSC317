package PolyCalc;

public class Polyterm {

    private Scalar scalar;
    private int exponent;
    private String indication;

    public Polyterm(Scalar scalar, int exponent) {
        this.scalar = scalar;
        this.exponent = exponent;
        this.indication = scalar.getIndication();
    }

    public Scalar getScalar() {
        return scalar;
    }

    public int getExponent() {
        return exponent;
    }

    public void setScalar(Scalar scalar) {
        this.scalar = scalar;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public boolean canAdd(Polyterm pt) {
        return pt.getExponent() == exponent;
    }

    public Polyterm add(Polyterm pt) {
        if (canAdd(pt)) {
            Polyterm output = new Polyterm(pt.getScalar().add(scalar), exponent);
            return output;
        } else {
            return this;
        }
    }

    public String getIndication() {
        return this.indication;
    }

    public Polyterm mul(Polyterm pt) {

        Polyterm output = new Polyterm(getScalar().mul(pt.getScalar()), getExponent() + pt.getExponent());
        return output;
    }

    public Scalar evaluate(Scalar scalar) {
        Scalar output = (scalar.pow(getExponent())).mul(getScalar());
        return output;
    }

    public Polyterm derivate() {
        Polyterm output;
        if (getExponent() != 0) {
            output = new Polyterm(getScalar().mulInt(exponent), exponent - 1);
        } else {
            output = new Polyterm(getScalar().mulInt(0), 1);
        }
        return output;
    }

    public boolean equals(Polyterm polyTerm) {
        return (getScalar().equals(polyTerm.getScalar()) &
                getExponent() == polyTerm.getExponent());
    }

    public int compareTo(Polyterm poly) {
        return getExponent() - poly.getExponent();
    }

    public String toString() {
        String s;
        if (getScalar().isZero()) {
            return "";
        }
        if (getExponent() == 0) {
            s = this.getScalar().toString();
        }
        else if (getExponent()!=1){
            if (getScalar().toString().equals("1")) {
                s = "x^" + getExponent();
            } else if (getScalar().toString().equals("-1")) {
                s = "-x^" + getExponent();
            } else {
                s =  getScalar().toString()  + "x^" + getExponent();
            }
        }
        else{
            if (getScalar().toString().equals("1")) {
                s = "x";
            } else if (getScalar().toString().equals("-1")) {
                s = "-x";
            } else {
                s =  getScalar().toString()  + "x";
            }
        }
        return s;
    }
}
