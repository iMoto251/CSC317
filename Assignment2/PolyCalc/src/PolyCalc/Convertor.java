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

                        if (!newPoly[i].contains("/")) {

                            String scalar = newPoly[i].substring(0, newPoly[i].indexOf('x'));
                            String exp = newPoly[i].substring(newPoly[i].indexOf('^') + 1);

                            if(exp.contains("x")){ exp = "1"; }

                            if(scalar.equals("-")) { scalar = "-1"; }

                            double newScalar = Double.parseDouble(scalar);
                            int newExp = Integer.parseInt(exp);

                            Scalar s  = new Scalar(newScalar,negN);
                            Polyterm poly = new Polyterm(s, newExp);
                            listP.add(poly);

                        }
                        else if (newPoly[i].indexOf('/')!=newPoly[i].length()-1) {

                            String numerator = newPoly[i].substring(0, newPoly[i].indexOf('/'));
                            String denominator = newPoly[i].substring(newPoly[i].indexOf('/') + 1, newPoly[i].indexOf('x'));
                            String exp = newPoly[i].substring(newPoly[i].indexOf('^') + 1);

                            if(exp.contains("x")){ exp = "1"; }

                            double newNumerator = Double.parseDouble(numerator);
                            double newDenominator = Double.parseDouble(denominator);
                            int newExp = Integer.parseInt(exp);

                            Scalar s = new Scalar(newNumerator / newDenominator,negN);
                            Polyterm poly = new Polyterm(s, newExp);
                            listP.add(poly);
                        }
                        else{
                            String numerator = newPoly[i].substring(0, newPoly[i].indexOf('/'));
                            String denominator = newPoly[i+1].substring(0, newPoly[i+1].indexOf('x'));
                            String exp = newPoly[i+1].substring(newPoly[i+1].indexOf('^') + 1);

                            if(exp.contains("x")){ exp = "1"; }

                            double newNumerator = Double.parseDouble(numerator);
                            double newDenominator = Double.parseDouble(denominator);
                            int newExp = Integer.parseInt(exp);

                            Scalar s = new Scalar(newNumerator/newDenominator,posN);
                            Polyterm poly = new Polyterm(s, newExp);
                            listP.add(poly);
                            i=i+1;
                        }

                    } else {

                        // positive number


                        if (i != 0) {

                            // not the first number

                            if (!newPoly[i].contains("/")) {

                                String scalar = newPoly[i].substring(1, newPoly[i].indexOf('x'));
                                String exp = newPoly[i].substring(newPoly[i].indexOf('^') + 1);

                                if(exp.contains("x")){ exp = "1"; }

                                if(scalar.equals("")) { scalar = "1"; }

                                double newScalar = Double.parseDouble(scalar);
                                int newExp = Integer.parseInt(exp);

                                Scalar s  = new Scalar(newScalar,posN);
                                Polyterm poly = new Polyterm(s, newExp);
                                listP.add(poly);

                            }
                            else if (newPoly[i].indexOf('/')!=newPoly[i].length()-1){

                                String numerator = newPoly[i].substring(1, newPoly[i].indexOf('/'));
                                String denominator = newPoly[i].substring(newPoly[i].indexOf('/') + 1, newPoly[i].indexOf('x'));
                                String exp = newPoly[i].substring(newPoly[i].indexOf('^') + 1);

                                double newNumerator = Double.parseDouble(numerator);
                                double newDenominator = Double.parseDouble(denominator);
                                int newExp = Integer.parseInt(exp);

                                Scalar s = new Scalar(newNumerator / newDenominator,posN);
                                Polyterm poly = new Polyterm(s, newExp);
                                listP.add(poly);

                            }
                            else{
                                String numerator = newPoly[i].substring(0, newPoly[i].indexOf('/'));
                                String denominator = newPoly[i+1].substring(0, newPoly[i+1].indexOf('x'));
                                String exp = newPoly[i+1].substring(newPoly[i+1].indexOf('^') + 1);

                                if(exp.contains("x")){ exp = "1"; }

                                double newNumerator = Double.parseDouble(numerator);
                                double newDenominator = Double.parseDouble(denominator);
                                int newExp = Integer.parseInt(exp);

                                Scalar s = new Scalar(newNumerator/newDenominator,negN);
                                Polyterm poly = new Polyterm(s, newExp);
                                listP.add(poly);
                                i=i+1;
                            }
                        } else {

                            // first number

                            if (!newPoly[i].contains("/")) {

                                String scalar = newPoly[i].substring(0, newPoly[i].indexOf('x'));
                                String exp = newPoly[i].substring(newPoly[i].indexOf('^') + 1);

                                if(exp.contains("x")){ exp = "1"; }

                                if(scalar.equals("")) { scalar = "1"; }

                                double newScalar = Double.parseDouble(scalar);
                                int newExp = Integer.parseInt(exp);

                                Scalar s  = new Scalar(newScalar,posN);
                                Polyterm poly = new Polyterm(s, newExp);
                                listP.add(poly);

                            } else if (newPoly[i].indexOf('/')!=newPoly[i].length()-1){

                                String numerator = newPoly[i].substring(0, newPoly[i].indexOf('/'));
                                String denominator = newPoly[i].substring(newPoly[i].indexOf('/') + 1, newPoly[i].indexOf('x'));
                                String exp = newPoly[i].substring(newPoly[i].indexOf('^') + 1);

                                if(exp.contains("x")){ exp = "1"; }

                                double newNumerator = Double.parseDouble(numerator);
                                double newDenominator = Double.parseDouble(denominator);
                                int newExp = Integer.parseInt(exp);

                                Scalar s = new Scalar(newNumerator / newDenominator,posN);
                                Polyterm poly = new Polyterm(s, newExp);
                                listP.add(poly);

                            }
                            else{
                                String numerator = newPoly[i].substring(0, newPoly[i].indexOf('/'));
                                String denominator = newPoly[i+1].substring(0, newPoly[i+1].indexOf('x'));
                                String exp = newPoly[i+1].substring(newPoly[i+1].indexOf('^') + 1);

                                if(exp.contains("x")){ exp = "1"; }

                                double newNumerator = Double.parseDouble(numerator);
                                double newDenominator = Double.parseDouble(denominator);
                                int newExp = Integer.parseInt(exp);

                                Scalar s = new Scalar(newNumerator/newDenominator,negN);
                                Polyterm poly = new Polyterm(s, newExp);
                                listP.add(poly);
                                i=i+1;
                            }

                        }
                    }
                }

                // without X

                else {

                    if (newPoly[i].charAt(0) == '-') {

                        // negative number

                        if (!newPoly[i].contains("/")) {

                            String scalar = newPoly[i];
                            String exp = "0";

                            if (scalar.equals("-")) { scalar ="-1"; }

                            double newScalar = Double.parseDouble(scalar);
                            int newExp = Integer.parseInt(exp);

                            Scalar s  = new Scalar(newScalar,negN);
                            Polyterm poly = new Polyterm(s, newExp);
                            listP.add(poly);

                        } else if (newPoly[i].indexOf('/')!=newPoly[i].length()-1){

                            String numerator = newPoly[i].substring(0, newPoly[i].indexOf('/'));
                            String denominator = newPoly[i].substring(newPoly[i].indexOf('/') + 1);
                            String exp = "0";

                            double newNumerator = Double.parseDouble(numerator);
                            double newDenominator = Double.parseDouble(denominator);
                            int newExp = Integer.parseInt(exp);

                            Scalar s = new Scalar(newNumerator / newDenominator,negN);
                            Polyterm poly = new Polyterm(s, newExp);
                            listP.add(poly);

                        }
                        else {
                            String numerator = newPoly[i].substring(0, newPoly[i].indexOf('/'));
                            String denominator = newPoly[i+1].substring(0, newPoly[i+1].indexOf('x'));
                            String exp = newPoly[i+1].substring(newPoly[i+1].indexOf('^') + 1);

                            if(exp.contains("x")){ exp = "1"; }

                            double newNumerator = Double.parseDouble(numerator);
                            double newDenominator = Double.parseDouble(denominator);
                            int newExp = Integer.parseInt(exp);

                            Scalar s = new Scalar(newNumerator/newDenominator,posN);
                            Polyterm poly = new Polyterm(s, newExp);
                            listP.add(poly);
                            i=i+1;
                        }
                    } else {

                        // positive number

                        if (i != 0) {

                            // not the first number

                            if (!newPoly[i].contains("/")) {

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

                            } else if (newPoly[i].indexOf('/')!=newPoly[i].length()-1){

                                String numerator = newPoly[i].substring(1, newPoly[i].indexOf('/'));
                                String denominator = newPoly[i].substring(newPoly[i].indexOf('/') + 1);
                                String exp = "0";

                                double newNumerator = Double.parseDouble(numerator);
                                double newDenominator = Double.parseDouble(denominator);
                                int newExp = Integer.parseInt(exp);

                                Scalar s = new Scalar(newNumerator / newDenominator,posN);
                                Polyterm poly = new Polyterm(s, newExp);
                                listP.add(poly);

                            }
                            else{
                                String numerator = newPoly[i].substring(0, newPoly[i].indexOf('/'));
                                String denominator = newPoly[i+1].substring(0, newPoly[i+1].indexOf('x'));
                                String exp = newPoly[i+1].substring(newPoly[i+1].indexOf('^') + 1);

                                if(exp.contains("x")){ exp = "1"; }

                                double newNumerator = Double.parseDouble(numerator);
                                double newDenominator = Double.parseDouble(denominator);
                                int newExp = Integer.parseInt(exp);

                                Scalar s = new Scalar(newNumerator/newDenominator,negN);
                                Polyterm poly = new Polyterm(s, newExp);
                                listP.add(poly);
                                i=i+1;
                            }
                        }

                        // first number

                        else {
                            if (!newPoly[i].contains("/")) {

                                String scalar = newPoly[i];
                                String exp = "0";

                                double newScalar = Double.parseDouble(scalar);
                                int newExp = Integer.parseInt(exp);

                                Scalar s = new Scalar(newScalar,posN);
                                Polyterm poly = new Polyterm(s, newExp);
                                listP.add(poly);

                            } else if (newPoly[i].indexOf('/')!=newPoly[i].length()-1){

                                String numerator = newPoly[i].substring(0, newPoly[i].indexOf('/'));
                                String denominator = newPoly[i].substring(newPoly[i].indexOf('/') + 1);
                                String exp = "0";

                                double newNumerator = Double.parseDouble(numerator);
                                double newDenominator = Double.parseDouble(denominator);
                                int newExp = Integer.parseInt(exp);

                                Scalar s = new Scalar(newNumerator / newDenominator,posN);
                                Polyterm poly = new Polyterm(s, newExp);
                                listP.add(poly);

                            }
                            else{
                                String numerator = newPoly[i].substring(0, newPoly[i].indexOf('/'));
                                String denominator = newPoly[i+1].substring(0, newPoly[i+1].indexOf('x'));
                                String exp = newPoly[i+1].substring(newPoly[i+1].indexOf('^') + 1);

                                if(exp.contains("x")){ exp = "1"; }

                                double newNumerator = Double.parseDouble(numerator);
                                double newDenominator = Double.parseDouble(denominator);
                                int newExp = Integer.parseInt(exp);

                                Scalar s = new Scalar(newNumerator/newDenominator,negN);
                                Polyterm poly = new Polyterm(s, newExp);
                                listP.add(poly);
                                i=i+1;
                            }
                        }
                    }
                }
            }
        return listP;
    }
}
