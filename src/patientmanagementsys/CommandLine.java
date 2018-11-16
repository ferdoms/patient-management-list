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
    PatientControl pControl = null;
    
    public void start(){
        System.out.println("Splash \n Screen");
        pControl = new PatientControl();
    }
    public void awaitCommand(){
        String command;
        System.out.print("PMS > ");
        command = kb.nextLine();
        String[] words = command.toLowerCase().split(" ");
        
        try{
            switch(words[0]){
                case "add":
                    if(words.length != 2){
                        errCommand(command);
                        break;
                    }
                    if(words[1].equals("new")){
                        System.out.println("Patient Details");
                        //First Name
                        System.out.print("First Name: ");
                        String fName = kb.nextLine();
                        //Last Name
                        System.out.print("Last Name: ");
                        String lName = kb.nextLine();
                        //PPS
                        System.out.print("PPS: ");
                        String ppsNumber = kb.nextLine();
                        //mobileNumber
                        System.out.print("Mobile Number: ");
                        String mobileNumber = kb.nextLine();
                        //Email
                        System.out.print("Email: ");
                        String email = kb.nextLine();
                        //City
                        System.out.print("City: ");
                        String city = kb.nextLine();
                        
                        Patient patient = new Patient(fName, lName, ppsNumber, mobileNumber, email, city);
                        pControl.add(patient);
                        System.out.println("Patient added: "+ patient.getFullName());
                    }else if((words[1].equals("at"))){
                        int position=0;
                        System.out.print("Position: ");
                        try {
                            position = Integer.parseInt(kb.nextLine());
                        }catch(Exception e){ System.err.println("It has to be a valid number.");}
                        
                        System.out.println("patient placed at position " + position);
                        
                    }else{
                        errCommand(command);
                    }
                    break;
                    
                case "list":
                    if(words.length != 1){
                        errCommand(command);
                        break;
                    }
                    System.out.println(pControl.toList());
                    break;
                case "search":
                    if(words.length != 2){
                        errCommand(command);
                        break;
                    }
                    if(words[1].equals("name")){
                        System.out.println("located by name");
                    }else if((words[1].equals("id"))){
                        System.out.println("located by id");
                    }else{
                        errCommand(command);
                    }
                    break;
                case "remove":
                    if(words.length != 2){
                        errCommand(command);
                        break;
                    }
                    if(words[1].equals("patient")){
                        System.out.println("removed by name");
                    }else if((words[1].equals("id"))){
                        System.out.println("removed by id");
                    }else{
                        errCommand(command);
                    }
                    break;
                case "update":
                    if(words.length != 2){
                        errCommand(command);
                        break;
                    }
                    if(words[1].equals("name")){
                        System.out.println("removed by name");
                    }else if((words[1].equals("id"))){
                        System.out.println("removed by id");
                    }else{
                        errCommand(command);
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
        System.err.println("ERROR: \""+ command +"\" is not a valid command, please try again or type help to list available commands");
    }
   
}
            
