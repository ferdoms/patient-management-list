/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsys;

import helpers.Input;

/**
 *
 * @author fernandoms
 */
public class PatientManagementSys {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CommandLine cl= new CommandLine();
        cl.start();
        while(!cl.exit()){
            cl.awaitCommand();
        }
    }
    
}
