package PolyCalc;

import java.util.Scanner;

public class Calculator {
    //private static final String R = "R";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int operation = -1;

        while (operation != 5) {

            System.out.println("Please select an operation:");
            System.out.println("  1.Addition");
            System.out.println("  2.Multiplication");
            System.out.println("  3.Evaluation");
            System.out.println("  4.Derivative");
            System.out.println("  5.Exit");

            operation = scanner.nextInt();

            String poly_1;
            String poly_2;
            Polynomial p_1;
            Polynomial p_2;
            double scalar;

            switch (operation) {

                case 1: {
                            System.out.println("Please insert the first polynomial");
                            poly_1 = scanner.next();
                            System.out.println("Please insert the second polynomial");
                            poly_2 = scanner.next();
                            System.out.println("The solution is:");


                            p_1 = new Polynomial(new Convertor(poly_1).stringToPolynomial());
                            p_2 = new Polynomial(new Convertor(poly_2).stringToPolynomial());
                            System.out.println((p_1.add(p_2)).toString());
                            System.out.println();
                            break;
                }    	
                case 2: {
                            System.out.println("Please insert the first polynomial");
                            poly_1 = scanner.next();
                            System.out.println("Please insert the second polynomial");
                            poly_2 = scanner.next();
                            System.out.println("The solution is:");

                            p_1 = new Polynomial(new Convertor(poly_1).stringToPolynomial());
                            p_2 = new Polynomial(new Convertor(poly_2).stringToPolynomial());
                            System.out.println(p_1.mult(p_2));
                            System.out.println();
                            break;
                }
                case 3: {
                            System.out.println("Please insert the first polynomial");
                            poly_1 = scanner.next();
                            System.out.println("Please insert the scalar");
                            scalar = scanner.nextDouble();
                            System.out.println("The solution is:");

                            p_1 = new Polynomial(new Convertor(poly_1).stringToPolynomial());
                            Scalar rS;
                            if(scalar<0) {
                                rS = new Scalar(scalar,"-");
                            } else {
                                rS = new Scalar(scalar,"+");
                            }
                            System.out.println(p_1.evaluate(rS));
                            System.out.println();
                            break;
                }
                case 4: {
                            System.out.println("Please insert the first polynomial");
                            poly_1 = scanner.next();
                            System.out.println("The derivative polynomial is:");

                            p_1 = new Polynomial(new Convertor(poly_1).stringToPolynomial());
                            System.out.println(p_1.derivative());
                            System.out.println();
                            break;
                }
                case 5:{
                    break;
                }
            }
        }
        scanner.close();
    }
}
