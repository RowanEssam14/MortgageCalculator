package com.codewithrowan;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt){ //this method is just added to cover course topics
        System.out.print(prompt + ": ");
        return scanner.nextDouble();
    }

    public static double readNumber(String prompt,double min,double max){
        double value;
        while(true){
            System.out.print(prompt + ": ");
            value = scanner.nextDouble(); //correction of old code
            if(value >= min && value <= max)
                break;
            System.out.println("Please enter a number between "+min+"and "+max);
        }
        return value;
    }

}