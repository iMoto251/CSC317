package PolyCalc;

import java.util.*;

public class Convertor {
    
    private String poly;

    public Convertor(String poly) {
        this.poly = poly;
    }

    public String getPoly() {
        return poly;
    }

    public List<Polyterm> stringToPolynomial() {
        String[] newPoly = getPoly().split("(?=[+-])");
        List<Polyterm> listP = new ArrayList<>();
        String negN = "-";
        String posN = "+";
        
        for (int i = 0; i < newPoly.length; i = i + 1) {

        // with X

        if (newPoly[i].contains("x")) {

        // negative number

        	if (newPoly[i].charAt(0) == '-') {
                      
        		String scalar = newPoly[i].substring(0, newPoly[i].indexOf('x'));
                String exp = newPoly[i].substring(newPoly[i].indexOf('^') + 1);

                if(exp.contains("x")){ exp = "1"; }

                if(scalar.equals("-")) { scalar = "-1"; }

                double newScalar = Double.parseDouble(scalar);
                int newExp = Integer.parseInt(exp);

                Scalar s  = new Scalar(newScalar,negN);
                Polyterm poly = new Polyterm(s, newExp);
                listP.add(poly);


        } else {

        	// positive number

        	if (i != 0) {

                            // not the first number


                String scalar = newPoly[i].substring(1, newPoly[i].indexOf('x'));
                String exp = newPoly[i].substring(newPoly[i].indexOf('^') + 1);

                if(exp.contains("x")){ exp = "1"; }

                if(scalar.equals("")) { scalar = "1"; }

                double newScalar = Double.parseDouble(scalar);
                int newExp = Integer.parseInt(exp);

                Scalar s  = new Scalar(newScalar,posN);
                Polyterm poly = new Polyterm(s, newExp);
                listP.add(poly);
                           
        	} else {

        	// first number                            

                String scalar = newPoly[i].substring(0, newPoly[i].indexOf('x'));
                String exp = newPoly[i].substring(newPoly[i].indexOf('^') + 1);

                if(exp.contains("x")){ exp = "1"; }

                if(scalar.equals("")) { scalar = "1"; }

                double newScalar = Double.parseDouble(scalar);
                int newExp = Integer.parseInt(exp);

                Scalar s  = new Scalar(newScalar,posN);
                Polyterm poly = new Polyterm(s, newExp);
                listP.add(poly);
                          
                        }
                    }
                }

                // without X

                else {

                    if (newPoly[i].charAt(0) == '-') {

                        // negative number

                            String scalar = newPoly[i];
                            String exp = "0";

                            if (scalar.equals("-")) { scalar ="-1"; }

                            double newScalar = Double.parseDouble(scalar);
                            int newExp = Integer.parseInt(exp);

                            Scalar s  = new Scalar(newScalar,negN);
                            Polyterm poly = new Polyterm(s, newExp);
                            listP.add(poly);
                        
                    } else {

                        // positive number

                        if (i != 0) {

                            // not the first number

                                String scalar = newPoly[i].substring(1);
                                String exp = "0";

                                if (scalar.equals("")) {
                                    scalar = "1";
                                }

                                double newScalar = Double.parseDouble(scalar);
                                int newExp = Integer.parseInt(exp);

                                Scalar s  = new Scalar(newScalar,posN);
                                Polyterm poly = new Polyterm(s, newExp);
                                listP.add(poly);                            
                        }

                        // first number

                        else {                           

                                String scalar = newPoly[i];
                                String exp = "0";

                                double newScalar = Double.parseDouble(scalar);
                                int newExp = Integer.parseInt(exp);

                                Scalar s = new Scalar(newScalar,posN);
                                Polyterm poly = new Polyterm(s, newExp);
                                listP.add(poly);
                           
                        }
                    }
                }
            }
        return listP;
    }
}
