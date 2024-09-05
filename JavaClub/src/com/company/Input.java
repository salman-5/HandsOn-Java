package com.company;

import java.util.Scanner;

public class Input {

    public static int addInteger (String prompt) throws NumberFormatException{

        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        return Integer.parseUnsignedInt(input.nextLine());
    }

    public static String addString (String prompt){

        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        return input.nextLine();
    }
}
