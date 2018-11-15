package patientmanagementsys;

/**
*
* @author Joao Pedro Haddad 2016220
*/
public class PatientNode<Patient> {

    /** The data value. */
    public Patient PatientData;
    /** The link */
    public PatientNode<Patient> next = null;

    /**
     * Construct a node with the given data value and link
     * @param data - The data value 
     * @param next - The link
     */
    public PatientNode(Patient PatientData, PatientNode<Patient> next) {
        this.PatientData = PatientData;
        this.next = next;
    }

    /**
     * Construct a node with the given data value
     * @param data - The data value 
     */
    public PatientNode(Patient PatientData) {
        this(PatientData, null);
    }
}
	
	