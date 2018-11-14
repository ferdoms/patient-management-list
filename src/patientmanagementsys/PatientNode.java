package patientmanagementsys;

/**
*
* @author Joao Pedro Haddad 2016220
*/
class PatientNode {
	protected int patientData;
	protected PatientNode previous, next;

/**
*
* @constructor PatientNode for setting the logic when getting 
* patient`s data, previous or next patient node
*/
	public PatientNode(int dat, PatientNode prev, PatientNode nex) {
		this.patientData = dat;
		this.previous = prev;
		this.next = nex;
		patientData = 0;
		previous = null;
		next = null;
	}
	/**
	*
	* @method setPatientData will set data to patient node
	*/
	public void setPatientData(int dat) {
		this.patientData = dat;
	}
	/**
	*
	* @method setPatientPrevious will link patient node to previous 
	* node in line
	*/
	public void setPatientPrevious(PatientNode prev) {
		this.previous = prev;
	}
	/**
	*
	* @method setPatientPrevious will link patient node to next 
	* node in line
	*/
	public void setPatientNext(PatientNode nex) {
		this.next = nex;
	}
	
	/**
	*
	* @method getPatientData will return data from patient node
	*/
	public int getPatientData() {
		return patientData;
	}
	/**
	*
	* @method getPrevious will return link from previous node 
	* in the line
	*/
	public PatientNode getPrevious() {
		return previous;	
	}
	/**
	*
	* @method getPrevious will return link from next node in the line
	*/
	public PatientNode getNext() {
		return next;
		
	}
	
} 
