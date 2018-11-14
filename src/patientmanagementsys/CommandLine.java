/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsys;

import java.util.Scanner;

/**
 *
 * @author fernandoms
 */
public class CommandLine {
    
    Scanner kb = new Scanner(System.in);
    boolean exit = false;
    
    public void start(){
        System.out.println("Splash \n Screen");
    }
    public void awaitCommand(){
        String command;
        System.out.print("PMS > ");
        command = kb.nextLine().toLowerCase();
        String[] words = command.split(" ");
        
        try{
            switch(words[0]){
                case "add":
//                    if(words[1].equals("new")){
//                        System.out.println("Patient Details");
//                        //First Name
//                        System.out.print("First Name: ");
//                        String fName = kb.next();
//                        //Last Name
//                        System.out.print("Last Name: ");
//                        String lName = kb.next();
//                        //PPS
//                        System.out.print("PPS: ");
//                        String ppsNumber = kb.next();
//                        //mobileNumber
//                        System.out.print("Mobile Number: ");
//                        String mobileNumber = kb.next();
//                        //Email
//                        System.out.print("Email: ");
//                        String email = kb.next();
//                        //City
//                        System.out.print("City: ");
//                        String city = kb.next();
//                        
//                        //Patient newPatient = new Patient(fName, lName, ppsNumber, mobileNumber, email,  city );
//		
//                        
//                        
//                        
//                        System.out.println("patient added");
//                        break;
//                    }else if((words[1].equals("at"))){
//                        String position = "0";
//                        System.out.println("patient placed at position " + position);
//                        break;
//                    }else{
//                        errCommand(words[1]);
//                        break;
//                    }
                    break;
                case "list":
                    System.out.println("list");
                    break;
                case "search":
                    if(words[1].equals("name")){
                        System.out.println("located by name");
                    }else if((words[1].equals("id"))){
                        System.out.println("located by id");
                    }else{
                        errCommand(words[1]);
                    }
                    break;
                case "remove":
                    if(words[1].equals("name")){
                        System.out.println("removed by name");
                    }else if((words[1].equals("id"))){
                        System.out.println("removed by id");
                    }else{
                        errCommand(words[1]);
                    }
                    break;
                case "update":
                    if(words[1].equals("name")){
                        System.out.println("removed by name");
                    }else if((words[1].equals("id"))){
                        System.out.println("removed by id");
                    }else{
                        errCommand(words[1]);
                    }
                    break;
                case "quit":
                    this.exit =! this.exit;
                    break;
                default: 
                    errCommand(words[0]);
            }
        }catch(Exception e){
             System.err.println("ERROR: " + e);
        }
    }
    
    public boolean exit(){
        return this.exit;
    }
    private void errCommand(String command){
        System.err.println("ERROR: \""+ command +"\" isn't a command, please try again or type help to list commands available");
    }
   
}
            
