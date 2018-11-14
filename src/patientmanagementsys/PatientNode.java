package patientmanagementsys;

/**
*
* @author Joao Pedro Haddad 2016220
*/
public class PatientNode<Patient> {
	public Patient patientData;
	public PatientNode <Patient> previous = null;
	public PatientNode <Patient> next = null;
	/**
	*
	* @constructor PatientNode
	* @param data >>> patient`s data
	* @param previous >>> to link to previous patient`s node
	* @param next >>> to link to next patient`s node
	*   
	*/
	public PatientNode(Patient data, PatientNode<Patient > previous, PatientNode<Patient > next) {
		this.patientData = data;
		this.previous = previous;
		this.next = next;
	}
	/**
	*
	* @constructor PatientNode
	* @param data >>> patient`s data
	*   
	*/	
	public PatientNode(Patient data) {
		this(data, null, null);
	}
}
	
	