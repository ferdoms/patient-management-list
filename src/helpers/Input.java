/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.util.Scanner;

/**
 *
 * @author Fernando Marinho da Silva
 */
public class Input {

    Scanner kb;

    /**
     * Gets text data from the user as a input field with label and validation. Numbers not allowed.
     * @param inputLabel The inputLabel for the input field.
     * @returns The entry string if validated.
     */
    public String text(String inputLabel) {
        kb = new Scanner(System.in);
        String input = "";
        System.out.print(inputLabel + ": ");
        if (!kb.hasNext("^[a-zA-Z' -]+")) {
            System.err.println("Wrong entry, only letter are allowed with no space.");
            return text(inputLabel);
        }
        input = kb.nextLine();
        return input;
    }
    /**
     * Gets integer data from the user as a input field with label and validation. Text, and numbers bellow 1 are not allowed.
     * @param inputLabel The inputLabel for the input field.
     * @returns The entry int if validated.
     */

    public int number(String inputLabel) {
        kb = new Scanner(System.in);
        int input = 0;
        System.out.print(inputLabel + ": ");
        try {
            String valid = kb.next();
            if (Integer.parseInt(valid) > 0) {
                return Integer.parseInt(valid);
            } else {
                System.err.println("Wrong entry, only numbers greater than 0 allowed.");
                return number(inputLabel);
            }
        } catch (Exception e) {
            System.err.println("Wrong entry, only numbers greater than 0 allowed.");
            return number(inputLabel);
        }
    }
    /**
     * Gets email data from the user as a input field with label and validation.
     * @param inputLabel The inputLabel for the input field.
     * @returns The entry email as string if validated.
     */
    public String email(String inputLabel) {
        kb = new Scanner(System.in);
        String input = "";
        System.out.print(inputLabel + ": ");
        while (!kb.hasNext("([a-zA-Z0-9._-])+@+[a-z0-9.-]+.+[a-z]{2,6}")) {
            System.err.println("Wrong entry, invalid email.");
            return email(inputLabel);
        }
        input = kb.nextLine();

        return input;
    }
    /**
     * Gets pps data from the user as a input field with label and validation. 
     * It has to be 7 numbers followed by a uppercase letter.
     * @param inputLabel The inputLabel for the input field.
     * @returns The entry pps number as string if validated.
     */
    public String pps(String inputLabel) {
        kb = new Scanner(System.in);
        String input = "";
        System.out.print(inputLabel + ": ");
        while (!kb.hasNext("([0-9]){1,7}+([A-Z0-9]){1,1}")) {
            System.err.println("Wrong entry, PPS number pattern is 7 digits followed by a uppercase letter.");
            return pps(inputLabel);
        }
        input = kb.nextLine();

        return input;
    }
    /**
     * Gets mobile number data from the user as a input field with label and validation. 
     * It has to be 10 digits.
     * @param inputLabel The inputLabel for the input field.
     * @returns The entry mobile number as string if validated.
     */
    public String mobile(String inputLabel) {
        kb = new Scanner(System.in);
        String input = "";
        System.out.print(inputLabel + ": ");
        while (!kb.hasNext("([0-9]){1,10}")) {
            System.err.println("Wrong entry, mobile number must have 10 digits.");
            return mobile(inputLabel);
        }
        input = kb.nextLine();

        return input;
    }
}
