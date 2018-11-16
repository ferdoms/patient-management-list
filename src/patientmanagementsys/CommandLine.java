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
        Patient p1 = new Patient("Fernando", "Marinho", "123", "123", "123", "123");
        Patient p2 = new Patient("Joao", "Haddad", "123", "123", "123", "123");
        Patient p3 = new Patient("Gustavo", "Lessa", "123", "123", "123", "123");
        Patient p4 = new Patient("Fabio", "Valegio", "123", "123", "123", "123");
        Patient p5 = new Patient("Sancho", "Panca", "123", "123", "123", "123");
        pControl.add(p1);
        pControl.add(p2);
        pControl.add(p3);
        pControl.add(p4);
        pControl.add(p5);
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
                        this.addPatient();
                    }else if((words[1].equals("at"))){
                        int position=0;
                        
                        while(position<=0 || (position>pControl.size())){
                            
                            try {
                                System.out.print("Position: ");
                                position = Integer.parseInt(kb.nextLine());
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
        System.err.println("ERROR: \""+ command +"\" is not a valid command, please try again or type help to list available commands");
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
    private void list(){
        System.out.println(pControl.toString());
    }
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
    private void searchPID(int id){
        Patient tempPatient = null;
        for(int i=0; i<pControl.size();i++){
            if(pControl.get(i).getPatientId() == id){
                tempPatient = pControl.get(i);
                break;
            }
        }
        if(tempPatient==null){
            System.err.println("ERROR: Patient not found with id: " + id);
        }else{
            System.out.println(tempPatient.toString());
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