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
    Scanner kb = new Scanner(System.in);
    
    public String string(String inputLabel){
        String input = "";
        System.out.print(inputLabel+": ");
        while(!kb.hasNext("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")){
            System.err.println("Wrong entry, only letter are allowed with no space.");
            System.out.print(inputLabel+": ");
            input = kb.nextLine();
        }
        input = kb.nextLine();
        
        return input;
    }
    public int number(String inputLabel){
        String input = null;
        boolean err=false;
        System.out.print(inputLabel+": ");
        
        while((!kb.hasNextInt()) || err == true ){
            
            try{
            System.err.println("Wrong entry, only numbers greater than 0 allowed.");
            System.out.print(inputLabel+": ");
            input = kb.nextLine();
            if(Integer.parseInt(input)<1){
                err = true;
            }else{
                err=false;
            }
            
            
            
            }catch(Exception e){
                err = true;
            }
            
        }
        
        input = kb.next();
        return Integer.parseInt(input);
    }
    public String email(String inputLabel){
        String input = "";
        System.out.print(inputLabel+": ");
        while(!kb.hasNext("([a-zA-Z0-9._-])+@+[a-z0-9.-]+.+[a-z]{2,6}")){
            System.err.println("Wrong entry, invalid email.");
            System.out.print(inputLabel+": ");
            input = kb.nextLine();
        }
        input = kb.nextLine();
        
        return input;
    }
    public String pps(String inputLabel){
        String input = "";
        System.out.print(inputLabel+": ");
        while(!kb.hasNext("([0-9]){1,7}+([A-Z0-9]){1,1}")){
            System.err.println("Wrong entry, PPS number pattern is 7 digits followed by a uppercase letter.");
            System.out.print(inputLabel+": ");
            input = kb.nextLine();
        }
        input = kb.nextLine();
        
        return input;
    }
    public String mobile(String inputLabel){
        String input = "";
        System.out.print(inputLabel+": ");
        while(!kb.hasNext("([0-9]){1,10}")){
            System.err.println("Wrong entry, mobile number must have 10 digits.");
            System.out.print(inputLabel+": ");
            input = kb.nextLine();
        }
        input = kb.nextLine();
        
        return input;
    }
}
