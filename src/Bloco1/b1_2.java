package Bloco1;

import java.util.Scanner;
import java.util.Stack;

public class b1_2 {

    public static void main(String[] args) {
        System.out.println("Calculadora:");
        Scanner sc=new Scanner(System.in);
        System.out.println("Operation (number op number):");
        Stack<Double> stack= new Stack<>();
        String input=sc.nextLine();
        Scanner sc_1=new Scanner(input);

        while (sc_1.hasNextDouble()){
            stack.push(sc_1.nextDouble());
            System.out.println(stack);
        }

        while (sc_1.hasNext() && stack.size()>1){
            String operador=sc_1.next();
            double num1=stack.pop();
            double num2=stack.pop();
            double result=0;
            switch (operador){
                case "+": result=num1+num2; break;
                case "-": result=num1-num2; break;
                case "*": result=num1*num2; break;
                case "/": result=num1/num2; break;

                default: {
                    System.err.println("Operator not valid");
                    System.exit(1);
                }

            }
            stack.push(result);
            System.out.println(stack);
        }











    }

}
