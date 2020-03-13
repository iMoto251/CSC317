package polyCal;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int operation = -1;
        //String scalarChoice;

        while (operation != 5) {

            System.out.println("Please select an operation:");
            System.out.println("  1.Addition");
            System.out.println("  2.Multiplication");
            System.out.println("  3.Evaluation");
            System.out.println("  4.Derivative");
            System.out.println("  5.Exit");

            operation = scanner.nextInt();
            
            //System.out.println("Is your polynomial Real (R) or Rational (Q)?");
            //scalarChoice = scanner.next();

            String p1;
            String p2;
            String number;

            switch (operation) {

                case 1: {
                            System.out.println("Please insert the first polynomial");
                            p1 = scanner.next();
                            
                            System.out.println("Please insert the second polynomial");
                            p2 = scanner.next();
                            
                            
                            System.out.println("The solution is:");
                            
                            Polynomial poly1=new Polynomial(p1,false);
        					Polynomial poly2=new Polynomial(p2,false);
        					System.out.println(poly1.add(poly2));
        					
                            break;
                }    	
                case 2: {
		                	System.out.println("Please insert the first polynomial");
		                    p1 = scanner.next();
		                    
		                    System.out.println("Please insert the second polynomial");
		                    p2 = scanner.next();
		                    
		                    
		                    System.out.println("The solution is:");
		                    
		                	Polynomial poly1=new Polynomial(p1,false);
							Polynomial poly2=new Polynomial(p2,false);
							System.out.println(poly1.mul(poly2));
							
                            break;
                }
                case 3: {
		                	System.out.println("Please insert the first polynomial");
		                    p1 = scanner.next();
		                    
		                    System.out.println("Please insert the scalar");
		                    number = scanner.next();
		                    
		                    
		                    System.out.println("The solution is:");
		                    
		                    Polynomial poly1=new Polynomial(p1,false);
							Scalar scalar= new RealScalar(Double.parseDouble(number));
							System.out.println(poly1.evaluate(scalar));
                            
                            break;
                }
                case 4: {
		                	System.out.println("Please insert the polynomial ");
		    				p1=scanner.next();
		    				
		                	Polynomial poly1=new Polynomial(p1,false);
							System.out.println("The derivative polynomial is:");
							System.out.println(poly1.derivate());

							break;
                }
                case 5:{
                    break;
                }
                default:{
                	System.out.println("Invalid input");
                }
            }
        }
        scanner.close();
    }
}
