/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsys;

import helpers.Input;
import java.util.Scanner;

/**
 *
 * @author fernandoms
 */
public class CommandLine {
    
    Scanner kb = new Scanner(System.in);
    Input input = new Input();
    boolean exit = false;
    
    PatientControl pControl = null;
    /**
     * Initiate the program, set up a new list for patient control, prints splash screen.
     */
    public void start(){

        System.out.println("   ___       __  _          __    _____          __           __\r\n" + 
        		"  / _ \\___ _/ /_(_)__ ___  / /_  / ___/__  ___  / /________  / /\r\n" + 
        		" / ___/ _ `/ __/ / -_) _ \\/ __/ / /__/ _ \\/ _ \\/ __/ __/ _ \\/ / \r\n" + 
        		"/_/   \\_,_/\\__/_/\\__/_//_/\\__/  \\___/\\___/_//_/\\__/_/  \\___/_/version 1.0" + "\n");
        pControl = new PatientControl();
        Patient p1 = new Patient("Fernando", "Marinho", "5544568-B", "0899546449", "MarinhoFernando@gmail.com", "Dubin");
        Patient p2 = new Patient("Joao", "Haddad", "6547365-H", "0899674536", "joao-pedrohaddad@hotmail.com", "Dublin");
        Patient p3 = new Patient("Gustavo", "Lessa", "8775637-K", "0876543356", "Lessag@hotmail.com", "Cork");
        Patient p4 = new Patient("Fabio", "Valegio", "9882310-H", "0856744500", "vlgio@gmail.com", "Bray");
        Patient p5 = new Patient("Sancho", "Panca", "6655473-B", "0878964532", "sanchop@hotmail.com", "Galway");
        Patient p6 = new Patient("Fernando", "Silva", "123", "123", "123", "123");

        pControl.add(p1);
        pControl.add(p2);
        pControl.add(p3);
        pControl.add(p4);
        pControl.add(p5);
        pControl.add(p6);
    }
    /**
     * Listen to a console input. It validates the command showing a relevant error
     * case the typed command is unknown.
     */
    public void awaitCommand(){
        String command;
        System.out.print("cmd > ");
        command = kb.nextLine();
        String[] words = command.toLowerCase().split(" " , 3);
        /** Skips case no command is inserted */
        if(!command.equals("")){
            /** Switches between commands*/
            switch(words[0]){
                case "add":
                    if(words.length != 2){
                        errCommand(command);
                        break;
                    }
                    if(words[1].equals("new")){
                        this.addPatient();
                    }else if((words[1].equals("at"))){
                        int position=0;

                        while(position<=0 || (position>pControl.size())){

                            try {

                                position = input.number("Position");
                            }catch(Exception e){ System.err.println("ERROR: It has to be a valid number.");}

                            if(position<=0 || (position>pControl.size())){
                            System.err.println("ERROR: The position number has to be between 1 and " + pControl.size());}
                        }
                        this.addPatientAt(position);
                    }else{
                        errCommand(command);
                    }
                    break;

                case "list":
                    if(words.length != 1){
                        errCommand(command);
                        break;
                    }
                    this.list();

                    break;
                case "search":
                    if(words.length != 3){
                        errCommand(command);
                        break;
                    }
                    if(words[1].equals("name")){
                        this.searchName(words[2]);
                    }else if((words[1].equals("id"))){

                        try {
                            int id = Integer.parseInt(words[2]);
                            this.searchPID(id);
                            }catch(Exception e){ System.err.println("ERROR: It has to be a valid number.");}
                    }else{
                        errCommand(command);
                    }
                    break;
                case "remove":
                    if(words.length != 3){
                        errCommand(command);
                        break;
                    }
                    if(words[1].equals("patient")){
                        this.removePatient(words[2]);
                    }else if((words[1].equals("id"))){
                        try {
                            int id = Integer.parseInt(words[2]);
                            this.removePatient(id);
                        }catch(Exception e){
                            System.err.println("ERROR: It has to be a valid number.");
                        }
                    }else if((words[1].equals("last"))){
                        try {
                            this.removeLast(Integer.parseInt(words[2]));
                        }catch(Exception e){ 
                            System.err.println("ERROR: It has to be a valid number.");}

                    }else{
                        errCommand(command);
                    }
                    break;
                case "update":
                    if(words.length != 3){
                        errCommand(command);
                        break;
                    }
                    if(words[1].equals("patient")){
                        this.updatePatient(words[2]);
                    }else if((words[1].equals("id"))){

                        try {
                            int id = Integer.parseInt(words[2]);
                            this.updatePatient(id);
                        }catch(Exception e){ 
                            System.err.println("ERROR: It has to be a valid number.");}
                    }else{
                        errCommand(command);
                    }
                    break;
                case "help":
                    if(words.length != 1){
                        errCommand(command);
                        break;
                    }
                    this.helpCommand();
                    break;
                case "quit":
                    this.exit =! this.exit;
                    break;
                default: 
                    errCommand(words[0]);
            }        
        }
    }
    /**
     * Ends the command line program.
     */
    public boolean exit(){
        return this.exit;
    }
    /**
     * Prints a command not valid error to console.
     * @param string The invalid command.
     */
    private void errCommand(String command){
        System.err.println("ERROR: \""+ command +"\" is not a valid command, please try again or type help for command list");
    }
    /**
     * Adds a new patient to the program, placing it at the end of the queue.
     */
    private void addPatient(){
        System.out.println("Patient Details");
        //First Name
        String fName = input.string("First Name: ");
        //Last Name
        String lName = input.string("Last Name: ");
        //PPS
        String ppsNumber =  input.pps("PPS: ");
        //mobileNumber
        String mobileNumber = input.mobile("Mobile Number: ");
        //Email
        String email = input.email("Email: ");
        //City
        String city = input.string("City: ");

        Patient patient = new Patient(fName, lName, ppsNumber, mobileNumber, email, city);
        pControl.add(patient);
        System.out.println("Patient added:\n"+ patient.toString());
    }

    private void help() {
    	System.out.println("\nLIST OF COMMANDS \n"
    			+ "----------------\n"
    			+ "add new\r\n" + 
    			"add at\r\n" + 
    			"list\r\n" + 
    			"search name\r\n" + 
    			"search id\r\n" + 
    			"remove patient\r\n" + 
    			"remove id\r\n" + 
    			"update patient\r\n" + 
    			"update id\n");
    }

    /**
     * Adds a new patient to the program, placing it at a given position.
     * @param int The position that the patient is to be placed in.
     */

    private void addPatientAt(int position){
        int index = position-1;
        System.out.println("Patient Details");
        //First Name
        String fName = input.string("First Name: ");
        //Last Name
        String lName = input.string("Last Name: ");
        //PPS
        String ppsNumber =  input.pps("PPS: ");
        //mobileNumber
        String mobileNumber = input.mobile("Mobile Number: ");
        //Email
        String email = input.email("Email: ");
        //City
        String city = input.string("City: ");

        Patient patient = new Patient(fName, lName, ppsNumber, mobileNumber, email, city);
        pControl.add(index , patient);
        System.out.println("Patient added at position "+ position);
        System.out.println(patient.toString());
    }
    /**

     * Prints to the console all the patient in the waiting list.
     */
    private void list(){
        System.out.println(pControl.toList());
    }
    /**

     * Searches a patient in the list by name, pondering both first name and last name.
     * Prints to the console the names found
     * @param String The Name to be searched
     */

    private void searchName(String name){
        String[] words = name.toLowerCase().split(" ");
        PatientControl tempList = new PatientControl();
        
        for(int i=0; i<pControl.size();i++){
            Patient tempPatient = pControl.get(i);
            innerloop:
            for(String word:words){
                if(tempPatient.getFname().toLowerCase().equals(word) || tempPatient.getLname().toLowerCase().equals(word)){
                    
                    System.out.println("Position: " + (1+i) +" Patient: " + tempPatient.resumePatient());
                    tempList.add(tempPatient);
                    break innerloop;
                }
            }
        }
        if(tempList.size()==0){
            System.err.println("ERROR: Patient not found with name \"" + name +"\"");
        }
        
    }
    /**
     * Remove the item at the specified position in the list. Shifts
     * any squsequent items to the left (subtracts one from their
     * indicies). Returns the tiem that was removed.
     * @param index The index of the item to be removed
     * @returns The item that was at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private void searchPID(int id){
        Patient tempPatient = null;
        int i;
        for(i=0; i<pControl.size();i++){
            if(pControl.get(i).getPatientId() == id){
                tempPatient = pControl.get(i);
                break;
            }
        }
        if(tempPatient==null){
            System.err.println("ERROR: Patient " + id + " " + "not found\n");
        }else{
            System.out.println("\n" + tempPatient.toString() + "\n");
        }
        
    }
    /**
     * Remove the item at the specified position in the list. Shifts
     * any squsequent items to the left (subtracts one from their
     * indicies). Returns the tiem that was removed.
     * @param index The index of the item to be removed
     * @returns The item that was at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private void removePatient(String fullName){
        
        Patient tempPatient = null;
        for(int i=0; i<pControl.size();i++){
            
            if(pControl.get(i).getFullName().toLowerCase().equals(fullName.toLowerCase())){
                tempPatient = pControl.get(i);
                break;
            }
            
        }
        if(tempPatient==null){
            System.err.println("ERROR: Patient not found named: " + fullName);
        }else{
            pControl.remove(tempPatient);
            System.out.println("Patient removed: " + tempPatient.getFullName());
        }
        
    }
    /**
     * Remove the item at the specified position in the list. Shifts
     * any squsequent items to the left (subtracts one from their
     * indicies). Returns the tiem that was removed.
     * @param index The index of the item to be removed
     * @returns The item that was at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private void removePatient(int id){
        Patient tempPatient = null;
        for(int i=0; i<pControl.size();i++){
            if(pControl.get(i).getPatientId() == id){
                tempPatient = pControl.get(i);
            }
        }
        if(tempPatient==null){
            System.err.println("ERROR: Patient not found with id: " + id);
        }else{
            pControl.remove(tempPatient);
            System.out.println("Patient removed: " + tempPatient.getFullName());
        }
        
    }
    /**
     * Remove the item at the specified position in the list. Shifts
     * any squsequent items to the left (subtracts one from their
     * indicies). Returns the tiem that was removed.
     * @param index The index of the item to be removed
     * @returns The item that was at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private void updatePatient(String fullName){
        
        Patient tempPatient = null;
        int i;
        for(i=0; i<pControl.size();i++){
            
            if(pControl.get(i).getFullName().toLowerCase().equals(fullName.toLowerCase())){
                tempPatient = pControl.get(i);
                break;
            }
            
        }
        if(tempPatient==null){
            System.err.println("ERROR: Patient not found named: " + fullName);
        }else{
            //First Name
            String fName = input.string("First Name: ");
            tempPatient.setFname(fName);
            //Last Name
            String lName = input.string("Last Name: ");
            tempPatient.setLname(lName);
            //PPS
            String ppsNumber =  input.pps("PPS: ");
            tempPatient.setPpsNumber(ppsNumber);
            //mobileNumber
            String mobileNumber = input.mobile("Mobile Number: ");
            tempPatient.setMobileNumber(mobileNumber);
            //Email
            String email = input.email("Email: ");
            tempPatient.setEmail(email);
            //City
            String city = input.string("City: ");
            tempPatient.setCity(city);
            
            pControl.set(i, tempPatient);
            System.out.println("Patient Update: " + pControl.get(i).getFullName());
        }
        
    }
    /**
     * Remove the item at the specified position in the list. Shifts
     * any squsequent items to the left (subtracts one from their
     * indicies). Returns the tiem that was removed.
     * @param index The index of the item to be removed
     * @returns The item that was at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private void updatePatient(int id){
        Patient tempPatient = null;
        int i;
        for(i=0; i<pControl.size();i++){
            if(pControl.get(i).getPatientId() == id){
                tempPatient = pControl.get(i);
                break;
            }
        }
        if(tempPatient==null){
            System.err.println("ERROR: Patient not found with id: " + id);
        }else{
            //First Name
            String fName = input.string("First Name: ");
            tempPatient.setFname(fName);
            //Last Name
            String lName = input.string("Last Name: ");
            tempPatient.setLname(lName);
            //PPS
            String ppsNumber =  input.pps("PPS: ");
            tempPatient.setPpsNumber(ppsNumber);
            //mobileNumber
            String mobileNumber = input.mobile("Mobile Number: ");
            tempPatient.setMobileNumber(mobileNumber);
            //Email
            String email = input.email("Email: ");
            tempPatient.setEmail(email);
            //City
            String city = input.string("City: ");
            tempPatient.setCity(city);
            
            pControl.set(i, tempPatient);
            System.out.println("Patient Update: " + pControl.get(i).getFullName());
        }
        
    }
    /**
     * Remove the item at the specified position in the list. Shifts
     * any squsequent items to the left (subtracts one from their
     * indicies). Returns the tiem that was removed.
     * @param index The index of the item to be removed
     * @returns The item that was at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private void removeLast(int number){
        if(pControl.size() < number || number < 1){
            System.err.println("ERROR: It has to be a number between 1 and " + pControl.size());
        }else{
            int index = pControl.size()-number;
            for(int i=number;i>0;i--){
                System.out.println(pControl.remove(index).resumePatient());
            }
        }
    }
    /**
     * Remove the item at the specified position in the list. Shifts
     * any squsequent items to the left (subtracts one from their
     * indicies). Returns the tiem that was removed.
     * @param index The index of the item to be removed
     * @returns The item that was at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private void helpCommand(){
        System.out.println("patientmanagementsys.CommandLine.helpCommand()");
    }
   
}