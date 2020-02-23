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
        String[] newPolinom = getPoly().split("(?=[+-])");
        List<Polyterm> listP = new ArrayList<>();
        String negN = "-";
        String posN = "+";
        
            for (int i = 0; i < newPolinom.length; i = i + 1) {

                // with X

                if (newPolinom[i].contains("x")) {

                    // negative number

                    if (newPolinom[i].charAt(0) == '-') {

                        if (!newPolinom[i].contains("/")) {

                            String scalar = newPolinom[i].substring(0, newPolinom[i].indexOf('x'));
                            String exponent = newPolinom[i].substring(newPolinom[i].indexOf('^') + 1);

                            if(exponent.contains("x")){ exponent = "1"; }

                            if(scalar.equals("-")) { scalar = "-1"; }

                            double newScalar = Double.parseDouble(scalar);
                            int newExponent = Integer.parseInt(exponent);

                            Scalar s  = new Scalar(newScalar,negN);
                            Polyterm poly = new Polyterm(s, newExponent);
                            listP.add(poly);

                        }
                        else if (newPolinom[i].indexOf('/')!=newPolinom[i].length()-1) {

                            String numerator = newPolinom[i].substring(0, newPolinom[i].indexOf('/'));
                            String denominator = newPolinom[i].substring(newPolinom[i].indexOf('/') + 1, newPolinom[i].indexOf('x'));
                            String exponent = newPolinom[i].substring(newPolinom[i].indexOf('^') + 1);

                            if(exponent.contains("x")){ exponent = "1"; }

                            double newNumerator = Double.parseDouble(numerator);
                            double newDenominator = Double.parseDouble(denominator);
                            int newExponent = Integer.parseInt(exponent);

                            Scalar s = new Scalar(newNumerator / newDenominator,negN);
                            Polyterm poly = new Polyterm(s, newExponent);
                            listP.add(poly);
                        }
                        else{
                            String numerator = newPolinom[i].substring(0, newPolinom[i].indexOf('/'));
                            String denominator = newPolinom[i+1].substring(0, newPolinom[i+1].indexOf('x'));
                            String exponent = newPolinom[i+1].substring(newPolinom[i+1].indexOf('^') + 1);

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

                            if (!newPolinom[i].contains("/")) {

                                String scalar = newPolinom[i].substring(1, newPolinom[i].indexOf('x'));
                                String exponent = newPolinom[i].substring(newPolinom[i].indexOf('^') + 1);

                                if(exponent.contains("x")){ exponent = "1"; }

                                if(scalar.equals("")) { scalar = "1"; }

                                double newScalar = Double.parseDouble(scalar);
                                int newExponent = Integer.parseInt(exponent);

                                Scalar s  = new Scalar(newScalar,posN);
                                Polyterm poly = new Polyterm(s, newExponent);
                                listP.add(poly);

                            }
                            else if (newPolinom[i].indexOf('/')!=newPolinom[i].length()-1){

                                String numerator = newPolinom[i].substring(1, newPolinom[i].indexOf('/'));
                                String denominator = newPolinom[i].substring(newPolinom[i].indexOf('/') + 1, newPolinom[i].indexOf('x'));
                                String exponent = newPolinom[i].substring(newPolinom[i].indexOf('^') + 1);

                                double newNumerator = Double.parseDouble(numerator);
                                double newDenominator = Double.parseDouble(denominator);
                                int newExponent = Integer.parseInt(exponent);

                                Scalar s = new Scalar(newNumerator / newDenominator,posN);
                                Polyterm poly = new Polyterm(s, newExponent);
                                listP.add(poly);

                            }
                            else{
                                String numerator = newPolinom[i].substring(0, newPolinom[i].indexOf('/'));
                                String denominator = newPolinom[i+1].substring(0, newPolinom[i+1].indexOf('x'));
                                String exponent = newPolinom[i+1].substring(newPolinom[i+1].indexOf('^') + 1);

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

                            if (!newPolinom[i].contains("/")) {

                                String scalar = newPolinom[i].substring(0, newPolinom[i].indexOf('x'));
                                String exponent = newPolinom[i].substring(newPolinom[i].indexOf('^') + 1);

                                if(exponent.contains("x")){ exponent = "1"; }

                                if(scalar.equals("")) { scalar = "1"; }

                                double newScalar = Double.parseDouble(scalar);
                                int newExponent = Integer.parseInt(exponent);

                                Scalar s  = new Scalar(newScalar,posN);
                                Polyterm poly = new Polyterm(s, newExponent);
                                listP.add(poly);

                            } else if (newPolinom[i].indexOf('/')!=newPolinom[i].length()-1){

                                String numerator = newPolinom[i].substring(0, newPolinom[i].indexOf('/'));
                                String denominator = newPolinom[i].substring(newPolinom[i].indexOf('/') + 1, newPolinom[i].indexOf('x'));
                                String exponent = newPolinom[i].substring(newPolinom[i].indexOf('^') + 1);

                                if(exponent.contains("x")){ exponent = "1"; }

                                double newNumerator = Double.parseDouble(numerator);
                                double newDenominator = Double.parseDouble(denominator);
                                int newExponent = Integer.parseInt(exponent);

                                Scalar s = new Scalar(newNumerator / newDenominator,posN);
                                Polyterm poly = new Polyterm(s, newExponent);
                                listP.add(poly);

                            }
                            else{
                                String numerator = newPolinom[i].substring(0, newPolinom[i].indexOf('/'));
                                String denominator = newPolinom[i+1].substring(0, newPolinom[i+1].indexOf('x'));
                                String exponent = newPolinom[i+1].substring(newPolinom[i+1].indexOf('^') + 1);

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

                    if (newPolinom[i].charAt(0) == '-') {

                        // negative number

                        if (!newPolinom[i].contains("/")) {

                            String scalar = newPolinom[i];
                            String exponent = "0";

                            if (scalar.equals("-")) { scalar ="-1"; }

                            double newScalar = Double.parseDouble(scalar);
                            int newExponent = Integer.parseInt(exponent);

                            Scalar s  = new Scalar(newScalar,negN);
                            Polyterm poly = new Polyterm(s, newExponent);
                            listP.add(poly);

                        } else if (newPolinom[i].indexOf('/')!=newPolinom[i].length()-1){

                            String numerator = newPolinom[i].substring(0, newPolinom[i].indexOf('/'));
                            String denominator = newPolinom[i].substring(newPolinom[i].indexOf('/') + 1);
                            String exponent = "0";

                            double newNumerator = Double.parseDouble(numerator);
                            double newDenominator = Double.parseDouble(denominator);
                            int newExponent = Integer.parseInt(exponent);

                            Scalar s = new Scalar(newNumerator / newDenominator,negN);
                            Polyterm poly = new Polyterm(s, newExponent);
                            listP.add(poly);

                        }
                        else {
                            String numerator = newPolinom[i].substring(0, newPolinom[i].indexOf('/'));
                            String denominator = newPolinom[i+1].substring(0, newPolinom[i+1].indexOf('x'));
                            String exponent = newPolinom[i+1].substring(newPolinom[i+1].indexOf('^') + 1);

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

                            if (!newPolinom[i].contains("/")) {

                                String scalar = newPolinom[i].substring(1);
                                String exponent = "0";

                                if (scalar.equals("")) {
                                    scalar = "1";
                                }

                                double newScalar = Double.parseDouble(scalar);
                                int newExponent = Integer.parseInt(exponent);

                                Scalar s  = new Scalar(newScalar,posN);
                                Polyterm poly = new Polyterm(s, newExponent);
                                listP.add(poly);

                            } else if (newPolinom[i].indexOf('/')!=newPolinom[i].length()-1){

                                String numerator = newPolinom[i].substring(1, newPolinom[i].indexOf('/'));
                                String denominator = newPolinom[i].substring(newPolinom[i].indexOf('/') + 1);
                                String exponent = "0";

                                double newNumerator = Double.parseDouble(numerator);
                                double newDenominator = Double.parseDouble(denominator);
                                int newExponent = Integer.parseInt(exponent);

                                Scalar s = new Scalar(newNumerator / newDenominator,posN);
                                Polyterm poly = new Polyterm(s, newExponent);
                                listP.add(poly);

                            }
                            else{
                                String numerator = newPolinom[i].substring(0, newPolinom[i].indexOf('/'));
                                String denominator = newPolinom[i+1].substring(0, newPolinom[i+1].indexOf('x'));
                                String exponent = newPolinom[i+1].substring(newPolinom[i+1].indexOf('^') + 1);

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
                            if (!newPolinom[i].contains("/")) {

                                String scalar = newPolinom[i];
                                String exponent = "0";

                                double newScalar = Double.parseDouble(scalar);
                                int newExponent = Integer.parseInt(exponent);

                                Scalar s = new Scalar(newScalar,posN);
                                Polyterm poly = new Polyterm(s, newExponent);
                                listP.add(poly);

                            } else if (newPolinom[i].indexOf('/')!=newPolinom[i].length()-1){

                                String numerator = newPolinom[i].substring(0, newPolinom[i].indexOf('/'));
                                String denominator = newPolinom[i].substring(newPolinom[i].indexOf('/') + 1);
                                String exponent = "0";

                                double newNumerator = Double.parseDouble(numerator);
                                double newDenominator = Double.parseDouble(denominator);
                                int newExponent = Integer.parseInt(exponent);

                                Scalar s = new Scalar(newNumerator / newDenominator,posN);
                                Polyterm poly = new Polyterm(s, newExponent);
                                listP.add(poly);

                            }
                            else{
                                String numerator = newPolinom[i].substring(0, newPolinom[i].indexOf('/'));
                                String denominator = newPolinom[i+1].substring(0, newPolinom[i+1].indexOf('x'));
                                String exponent = newPolinom[i+1].substring(newPolinom[i+1].indexOf('^') + 1);

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
