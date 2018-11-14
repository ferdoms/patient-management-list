/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsys;

/**
 *
 * @author fernandoms
 */
public class CommandLineTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CommandLine cl= new CommandLine();
        
        while(!cl.exit()){
            cl.start();
            cl.awaitCommand();
        }
    }
    
}
