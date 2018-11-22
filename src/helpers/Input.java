/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.util.Scanner;

/**
 *
 * @author fernandoms
 */
public class Input {
    Scanner kb;
    
    public String string(String inputLabel){
        kb = new Scanner(System.in);
        String input = "";
        System.out.print(inputLabel+": ");
        if(!kb.hasNext("^[a-zA-Z]+(([',. -][a-zA-Z])?[a-zA-Z]*)*$")){
            System.err.println("Wrong entry, only letter are allowed with no space.");
            return string(inputLabel);
        }
        input = kb.nextLine();
        return input;
    }
    public int number(String inputLabel){
        kb = new Scanner(System.in);
        int input = 0;
        System.out.print(inputLabel+": ");
        try{
            String valid = kb.next();
            if(Integer.parseInt(valid)>0){
                return Integer.parseInt(valid);
            }else{
                System.err.println("Wrong entry, only numbers greater than 0 allowed.");
                return number(inputLabel);
            }
        }catch(Exception e){
            System.err.println("Wrong entry, only numbers greater than 0 allowed.");
            return number(inputLabel);
        }
    }
    public String email(String inputLabel){
        kb = new Scanner(System.in);
        String input = "";
        System.out.print(inputLabel+": ");
        while(!kb.hasNext("([a-zA-Z0-9._-])+@+[a-z0-9.-]+.+[a-z]{2,6}")){
            System.err.println("Wrong entry, invalid email.");
            return email(inputLabel);
        }
        input = kb.nextLine();
        
        return input;
    }
    public String pps(String inputLabel){
        kb = new Scanner(System.in);
        String input = "";
        System.out.print(inputLabel+": ");
        while(!kb.hasNext("([0-9]){1,7}+([A-Z0-9]){1,1}")){
            System.err.println("Wrong entry, PPS number pattern is 7 digits followed by a uppercase letter.");
            return pps(inputLabel);
        }
        input = kb.nextLine();
        
        return input;
    }
    public String mobile(String inputLabel){
        kb = new Scanner(System.in);
        String input = "";
        System.out.print(inputLabel+": ");
        while(!kb.hasNext("([0-9]){1,10}")){
            System.err.println("Wrong entry, mobile number must have 10 digits.");
            return mobile(inputLabel);
        }
        input = kb.nextLine();
        
        return input;
    }
}
