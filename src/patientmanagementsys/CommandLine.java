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
        pControl.add(p1);
        pControl.add(p2);
        pControl.add(p3);
        pControl.add(p4);
        pControl.add(p5);
    }
    public void awaitCommand(){
        String command;
        System.out.print("cmd > ");
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
                        this.addPatient();
                    }else if((words[1].equals("at"))){
                        int position=0;
                        
                        while(position<=0 || (position>pControl.size())){
                            
                            try {
                                System.out.print("Position: ");
                                position = Integer.parseInt(kb.nextLine());
                            }catch(Exception e){ 
                            	System.err.println("ERROR: It has to be a valid number.");}
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
                case "help":
                    if(words.length != 1){
                        errCommand(command);
                        break;
                    }
                    this.help();
                    break;
                case "search":
                    if(words.length != 2){
                        errCommand(command);
                        break;
                    }
                    if(words[1].equals("name")){
                        System.out.print("Name: ");
                        String name = kb.nextLine();
                        this.searchName(name);
                    }else if((words[1].equals("id"))){
                        int id = 0;
                        try {
                                System.out.print("Id: ");
                                id = Integer.parseInt(kb.nextLine());
                                this.searchPID(id);
                            }catch(Exception e){ System.err.println("ERROR: It has to be a valid number.");}
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
                        System.out.print("Name: ");
                        String name = kb.nextLine();
                        this.removePatient(name);
                    }else if((words[1].equals("id"))){
                        int id = 0;
                        try {
                            System.out.print("Id: ");
                            id = Integer.parseInt(kb.nextLine());
                            this.removePatient(id);
                        }catch(Exception e){ 
                            System.err.println("ERROR: "+ e);
                            System.err.println("ERROR: It has to be a valid number.");}
                    }else{
                        errCommand(command);
                    }
                    break;
                case "update":
                    if(words.length != 2){
                        errCommand(command);
                        break;
                    }
                    if(words[1].equals("patient")){
                        System.out.print("Name: ");
                        String name = kb.nextLine();
                        this.updatePatient(name);
                    }else if((words[1].equals("id"))){
                        int id = 0;
                        try {
                            System.out.print("Id: ");
                            id = Integer.parseInt(kb.nextLine());
                            this.updatePatient(id);
                        }catch(Exception e){ 
                            System.err.println("ERROR: "+ e);
                            System.err.println("ERROR: It has to be a valid number.");}
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
        System.err.println("ERROR: \""+ command +"\" is not a valid command, please try again or type help for command list");
    }
    private void addPatient(){
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
    private void addPatientAt(int position){
        int index = position-1;
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
        pControl.add(position, patient);
        System.out.println("Patient added at position "+ position);
        System.out.println(patient.toString());
    }
    /**
	 *
	 * @method list returns resumed patient details
	 */
    private void list(){
        System.out.println(pControl.toList());
    }
    /**
	 *
	 * @method searchName allows user to retrieve full patient`s data
	 */
    private void searchName(String name){
        String[] words = name.toLowerCase().split(" ");
        PatientControl tempList = new PatientControl();
        
        for(int i=0; i<pControl.size();i++){
            Patient tempPatient = pControl.get(i);
            for(String word:words){
                if(tempPatient.getFname().toLowerCase().equals(word) || tempPatient.getLname().toLowerCase().equals(word)){
                    tempList.add(tempPatient);
                }
            }
        }
        if(tempList.size()==0){
        }else{
            System.out.println(tempList.toString());
        }
        
    }
    /**
	 *
	 * @method searchPID allows user to retrieve patient ID + name to the user 
	 */
    private void searchPID(int id){
        Patient tempPatient = null;
        for(int i=0; i<pControl.size();i++){
            if(pControl.get(i).getPatientId() == id){
                tempPatient = pControl.get(i);
                break;
            }
        }
        if(tempPatient==null){
            System.err.println("ERROR: Patient " + id + " " + "not found\n");
        }else{
            System.out.println("\n" + tempPatient.resumePatient() + "\n");
        }
        
    }
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
            System.out.print("First Name: ");
            String fName = kb.nextLine();
            tempPatient.setFname(fName);
            //Last Name
            System.out.print("Last Name: ");
            String lName = kb.nextLine();
            tempPatient.setLname(lName);
            //PPS
            System.out.print("PPS: ");
            String ppsNumber = kb.nextLine();
            tempPatient.setPpsNumber(ppsNumber);
            //mobileNumber
            System.out.print("Mobile Number: ");
            String mobileNumber = kb.nextLine();
            tempPatient.setMobileNumber(mobileNumber);
            //Email
            System.out.print("Email: ");
            String email = kb.nextLine();
            //City
            tempPatient.setEmail(email);
            System.out.print("City: ");
            String city = kb.nextLine();
            tempPatient.setCity(city);
            
            pControl.set(i, tempPatient);
            System.out.println("Patient Update: " + pControl.get(i).getFullName());
        }
        
    }
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
            System.out.print("First Name: ");
            String fName = kb.nextLine();
            tempPatient.setFname(fName);
            //Last Name
            System.out.print("Last Name: ");
            String lName = kb.nextLine();
            tempPatient.setLname(lName);
            //PPS
            System.out.print("PPS: ");
            String ppsNumber = kb.nextLine();
            tempPatient.setPpsNumber(ppsNumber);
            //mobileNumber
            System.out.print("Mobile Number: ");
            String mobileNumber = kb.nextLine();
            tempPatient.setMobileNumber(mobileNumber);
            //Email
            System.out.print("Email: ");
            String email = kb.nextLine();
            //City
            tempPatient.setEmail(email);
            System.out.print("City: ");
            String city = kb.nextLine();
            tempPatient.setCity(city);
            
            pControl.set(i, tempPatient);
            System.out.println("Patient Update: " + pControl.get(i).getFullName());
        }
        
    }
   
}