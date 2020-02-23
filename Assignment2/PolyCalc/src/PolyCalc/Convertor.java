package PolyCalc;

import java.util.*;

public class Convertor {
    
    private String poly;
    private String field;

    public Convertor(String poly, String field) {
        this.poly = poly;
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public String getPoly() {
        return poly;
    }

    public List<Polyterm> stringToPolynomial() {
        String[] newPoli = getPoly().split("(?=[+-])");
        List<Polyterm> listP = new ArrayList<>();
        String negN = "-";
        String posN = "+";
        
            for (int i = 0; i < newPoli.length; i = i + 1) {

                // with X

                if (newPoli[i].contains("x")) {

                    // negative number

                    if (newPoli[i].charAt(0) == '-') {

                        if (!newPoli[i].contains("/")) {

                            String scalar = newPoli[i].substring(0, newPoli[i].indexOf('x'));
                            String exponent = newPoli[i].substring(newPoli[i].indexOf('^') + 1);

                            if(exponent.contains("x")){ exponent = "1"; }

                            if(scalar.equals("-")) { scalar = "-1"; }

                            double newScalar = Double.parseDouble(scalar);
                            int newExponent = Integer.parseInt(exponent);

                            Scalar s  = new Scalar(newScalar,negN);
                            Polyterm poly = new Polyterm(s, newExponent);
                            listP.add(poly);

                        }
                        else if (newPoli[i].indexOf('/')!=newPoli[i].length()-1) {

                            String numerator = newPoli[i].substring(0, newPoli[i].indexOf('/'));
                            String denominator = newPoli[i].substring(newPoli[i].indexOf('/') + 1, newPoli[i].indexOf('x'));
                            String exponent = newPoli[i].substring(newPoli[i].indexOf('^') + 1);

                            if(exponent.contains("x")){ exponent = "1"; }

                            double newNumerator = Double.parseDouble(numerator);
                            double newDenominator = Double.parseDouble(denominator);
                            int newExponent = Integer.parseInt(exponent);

                            Scalar s = new Scalar(newNumerator / newDenominator,negN);
                            Polyterm poly = new Polyterm(s, newExponent);
                            listP.add(poly);
                        }
                        else{
                            String numerator = newPoli[i].substring(0, newPoli[i].indexOf('/'));
                            String denominator = newPoli[i+1].substring(0, newPoli[i+1].indexOf('x'));
                            String exponent = newPoli[i+1].substring(newPoli[i+1].indexOf('^') + 1);

                            if(exponent.contains("x")){ exponent = "1"; }

                            double newNumerator = Double.parseDouble(numerator);
                            double newDenominator = Double.parseDouble(denominator);
                            int newExponent = Integer.parseInt(exponent);

                            Scalar s = new Scalar(newNumerator/newDenominator,posN);
                            Polyterm poly = new Polyterm(s, newExponent);
                            listP.add(poly);
                            i=i+1;
                        }

                    } else {

                        // positive number


                        if (i != 0) {

                            // not the first number

                            if (!newPoli[i].contains("/")) {

                                String scalar = newPoli[i].substring(1, newPoli[i].indexOf('x'));
                                String exponent = newPoli[i].substring(newPoli[i].indexOf('^') + 1);

                                if(exponent.contains("x")){ exponent = "1"; }

                                if(scalar.equals("")) { scalar = "1"; }

                                double newScalar = Double.parseDouble(scalar);
                                int newExponent = Integer.parseInt(exponent);

                                Scalar s  = new Scalar(newScalar,posN);
                                Polyterm poly = new Polyterm(s, newExponent);
                                listP.add(poly);

                            }
                            else if (newPoli[i].indexOf('/')!=newPoli[i].length()-1){

                                String numerator = newPoli[i].substring(1, newPoli[i].indexOf('/'));
                                String denominator = newPoli[i].substring(newPoli[i].indexOf('/') + 1, newPoli[i].indexOf('x'));
                                String exponent = newPoli[i].substring(newPoli[i].indexOf('^') + 1);

                                double newNumerator = Double.parseDouble(numerator);
                                double newDenominator = Double.parseDouble(denominator);
                                int newExponent = Integer.parseInt(exponent);

                                Scalar s = new Scalar(newNumerator / newDenominator,posN);
                                Polyterm poly = new Polyterm(s, newExponent);
                                listP.add(poly);

                            }
                            else{
                                String numerator = newPoli[i].substring(0, newPoli[i].indexOf('/'));
                                String denominator = newPoli[i+1].substring(0, newPoli[i+1].indexOf('x'));
                                String exponent = newPoli[i+1].substring(newPoli[i+1].indexOf('^') + 1);

                                if(exponent.contains("x")){ exponent = "1"; }

                                double newNumerator = Double.parseDouble(numerator);
                                double newDenominator = Double.parseDouble(denominator);
                                int newExponent = Integer.parseInt(exponent);

                                Scalar s = new Scalar(newNumerator/newDenominator,negN);
                                Polyterm poly = new Polyterm(s, newExponent);
                                listP.add(poly);
                                i=i+1;
                            }
                        } else {

                            // first number

                            if (!newPoli[i].contains("/")) {

                                String scalar = newPoli[i].substring(0, newPoli[i].indexOf('x'));
                                String exponent = newPoli[i].substring(newPoli[i].indexOf('^') + 1);

                                if(exponent.contains("x")){ exponent = "1"; }

                                if(scalar.equals("")) { scalar = "1"; }

                                double newScalar = Double.parseDouble(scalar);
                                int newExponent = Integer.parseInt(exponent);

                                Scalar s  = new Scalar(newScalar,posN);
                                Polyterm poly = new Polyterm(s, newExponent);
                                listP.add(poly);

                            } else if (newPoli[i].indexOf('/')!=newPoli[i].length()-1){

                                String numerator = newPoli[i].substring(0, newPoli[i].indexOf('/'));
                                String denominator = newPoli[i].substring(newPoli[i].indexOf('/') + 1, newPoli[i].indexOf('x'));
                                String exponent = newPoli[i].substring(newPoli[i].indexOf('^') + 1);

                                if(exponent.contains("x")){ exponent = "1"; }

                                double newNumerator = Double.parseDouble(numerator);
                                double newDenominator = Double.parseDouble(denominator);
                                int newExponent = Integer.parseInt(exponent);

                                Scalar s = new Scalar(newNumerator / newDenominator,posN);
                                Polyterm poly = new Polyterm(s, newExponent);
                                listP.add(poly);

                            }
                            else{
                                String numerator = newPoli[i].substring(0, newPoli[i].indexOf('/'));
                                String denominator = newPoli[i+1].substring(0, newPoli[i+1].indexOf('x'));
                                String exponent = newPoli[i+1].substring(newPoli[i+1].indexOf('^') + 1);

                                if(exponent.contains("x")){ exponent = "1"; }

                                double newNumerator = Double.parseDouble(numerator);
                                double newDenominator = Double.parseDouble(denominator);
                                int newExponent = Integer.parseInt(exponent);

                                Scalar s = new Scalar(newNumerator/newDenominator,negN);
                                Polyterm poly = new Polyterm(s, newExponent);
                                listP.add(poly);
                                i=i+1;
                            }

                        }
                    }
                }

                // without X

                else {

                    if (newPoli[i].charAt(0) == '-') {

                        // negative number

                        if (!newPoli[i].contains("/")) {

                            String scalar = newPoli[i];
                            String exponent = "0";

                            if (scalar.equals("-")) { scalar ="-1"; }

                            double newScalar = Double.parseDouble(scalar);
                            int newExponent = Integer.parseInt(exponent);

                            Scalar s  = new Scalar(newScalar,negN);
                            Polyterm poly = new Polyterm(s, newExponent);
                            listP.add(poly);

                        } else if (newPoli[i].indexOf('/')!=newPoli[i].length()-1){

                            String numerator = newPoli[i].substring(0, newPoli[i].indexOf('/'));
                            String denominator = newPoli[i].substring(newPoli[i].indexOf('/') + 1);
                            String exponent = "0";

                            double newNumerator = Double.parseDouble(numerator);
                            double newDenominator = Double.parseDouble(denominator);
                            int newExponent = Integer.parseInt(exponent);

                            Scalar s = new Scalar(newNumerator / newDenominator,negN);
                            Polyterm poly = new Polyterm(s, newExponent);
                            listP.add(poly);

                        }
                        else {
                            String numerator = newPoli[i].substring(0, newPoli[i].indexOf('/'));
                            String denominator = newPoli[i+1].substring(0, newPoli[i+1].indexOf('x'));
                            String exponent = newPoli[i+1].substring(newPoli[i+1].indexOf('^') + 1);

                            if(exponent.contains("x")){ exponent = "1"; }

                            double newNumerator = Double.parseDouble(numerator);
                            double newDenominator = Double.parseDouble(denominator);
                            int newExponent = Integer.parseInt(exponent);

                            Scalar s = new Scalar(newNumerator/newDenominator,posN);
                            Polyterm poly = new Polyterm(s, newExponent);
                            listP.add(poly);
                            i=i+1;
                        }
                    } else {

                        // positive number

                        if (i != 0) {

                            // not the first number

                            if (!newPoli[i].contains("/")) {

                                String scalar = newPoli[i].substring(1);
                                String exponent = "0";

                                if (scalar.equals("")) {
                                    scalar = "1";
                                }

                                double newScalar = Double.parseDouble(scalar);
                                int newExponent = Integer.parseInt(exponent);

                                Scalar s  = new Scalar(newScalar,posN);
                                Polyterm poly = new Polyterm(s, newExponent);
                                listP.add(poly);

                            } else if (newPoli[i].indexOf('/')!=newPoli[i].length()-1){

                                String numerator = newPoli[i].substring(1, newPoli[i].indexOf('/'));
                                String denominator = newPoli[i].substring(newPoli[i].indexOf('/') + 1);
                                String exponent = "0";

                                double newNumerator = Double.parseDouble(numerator);
                                double newDenominator = Double.parseDouble(denominator);
                                int newExponent = Integer.parseInt(exponent);

                                Scalar s = new Scalar(newNumerator / newDenominator,posN);
                                Polyterm poly = new Polyterm(s, newExponent);
                                listP.add(poly);

                            }
                            else{
                                String numerator = newPoli[i].substring(0, newPoli[i].indexOf('/'));
                                String denominator = newPoli[i+1].substring(0, newPoli[i+1].indexOf('x'));
                                String exponent = newPoli[i+1].substring(newPoli[i+1].indexOf('^') + 1);

                                if(exponent.contains("x")){ exponent = "1"; }

                                double newNumerator = Double.parseDouble(numerator);
                                double newDenominator = Double.parseDouble(denominator);
                                int newExponent = Integer.parseInt(exponent);

                                Scalar s = new Scalar(newNumerator/newDenominator,negN);
                                Polyterm poly = new Polyterm(s, newExponent);
                                listP.add(poly);
                                i=i+1;
                            }
                        }

                        // first number

                        else {
                            if (!newPoli[i].contains("/")) {

                                String scalar = newPoli[i];
                                String exponent = "0";

                                double newScalar = Double.parseDouble(scalar);
                                int newExponent = Integer.parseInt(exponent);

                                Scalar s = new Scalar(newScalar,posN);
                                Polyterm poly = new Polyterm(s, newExponent);
                                listP.add(poly);

                            } else if (newPoli[i].indexOf('/')!=newPoli[i].length()-1){

                                String numerator = newPoli[i].substring(0, newPoli[i].indexOf('/'));
                                String denominator = newPoli[i].substring(newPoli[i].indexOf('/') + 1);
                                String exponent = "0";

                                double newNumerator = Double.parseDouble(numerator);
                                double newDenominator = Double.parseDouble(denominator);
                                int newExponent = Integer.parseInt(exponent);

                                Scalar s = new Scalar(newNumerator / newDenominator,posN);
                                Polyterm poly = new Polyterm(s, newExponent);
                                listP.add(poly);

                            }
                            else{
                                String numerator = newPoli[i].substring(0, newPoli[i].indexOf('/'));
                                String denominator = newPoli[i+1].substring(0, newPoli[i+1].indexOf('x'));
                                String exponent = newPoli[i+1].substring(newPoli[i+1].indexOf('^') + 1);

                                if(exponent.contains("x")){ exponent = "1"; }

                                double newNumerator = Double.parseDouble(numerator);
                                double newDenominator = Double.parseDouble(denominator);
                                int newExponent = Integer.parseInt(exponent);

                                Scalar s = new Scalar(newNumerator/newDenominator,negN);
                                Polyterm poly = new Polyterm(s, newExponent);
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
