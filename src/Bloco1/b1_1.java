package Bloco1;

import java.util.Arrays;
import java.util.Scanner;

public class b1_1 {
    public static void main(String[] args) {
        System.out.println("Calculadora:");
        Scanner sc=new Scanner(System.in);
        System.out.println("Operation (number op number):");
        int n_op=0;
        String tokens [];
        String input="";

        String operador="";
        double num1=0,num2=0;
        for (int n=0; n<3; n++){
            String local_str="";
            if(sc.hasNextDouble() && n==0){
                num1=sc.nextDouble();

            }
            else if(sc.hasNext() && n==1){
                operador=sc.next();
            }
            else if(n==2 && sc.hasNextDouble() ){
                num2=sc.nextDouble();
            }

        }



        double result=0;
        switch (operador){
            case "+": result=num1+num2; break;
            case "-": result=num1-num2; break;
            case "x": result=num1*num2; break;
            case "/": result=num1/num2; break;

            default: {
                System.err.println("Operator not valid");
                System.exit(1);
            }

        }

        System.out.println(num1+" "+operador+" "+num2+" = "+result);

    }

}
