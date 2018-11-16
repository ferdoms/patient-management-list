package patientmanagementsys;

/**
*
* @author Joao Pedro Haddad 2016220
*/
public class Patient {
	private String fName;
	private String lName;
	private String ppsNumber;
	private String mobileNumber;
	private String email;
	private String city;
	private static Integer id = 100;
	private final int patientID;
	
	/**
	 *
	 * @constructor Patient 
	 */
	public Patient(String fName, String lName, String ppsNumber,String mobileNumber, String email, String city) {
		this.fName = fName;
		this.lName = lName;
		this.ppsNumber = ppsNumber;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.city = city;
		id = id+1;
		patientID = id;
	}
	/**
	 *
	 * @method setFname for passing information from user to system
	 */
	public void setFname(String fName) {
		this.fName = fName;
	}
	/**
	 *
	 * @method getFname to return patient`s first name stored in database
	 */
	public String getFname() {
		return this.fName;
	}
	/**
	 *
	 * @method setlName for passing information from user to system
	 */
	public void setLname(String lName) {
		this.lName = lName;
	}
	/**
	 *
	 * @method getLname to return patient`s last name stored in database
	 */
	public String getLname() {
		return this.lName;
	}
	
	public String getFullName() {
		return getFname() + " " + getLname();
	}
	/**
	 *
	 * @method setPpsNumber for passing information from user to system
	 */
	public void setPpsNumber(String ppsNumber) {
		this.ppsNumber = ppsNumber;
	}
	/**
	 *
	 * @method getPpsNumber to return patient`s pps number stored in database
	 */
	public String getPpsNumber() {
		return this.ppsNumber;
	}
	/**
	 *
	 * @method setMobileNumber for passing information from user to system
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/**
	 *
	 * @method getMobileNumber to return patient`s mobile number stored in database
	 */
	public String getMobileNumber() {
		return this.mobileNumber;
	}
	/**
	 *
	 * @method setEmail for passing information from user to system
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 *
	 * @method getEmail to return patient`s email stored in database
	 */
	public String getEmail() {
		return this.email;
	}
	/**
	 *
	 * @method setCity for passing information from user to system
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 *
	 * @method getCity to return patient`s city name stored in database
	 */
	public String getCity() {
		return this.city;
	}
	/**
	 *
	 * @method getPatientId to return Patient Id stored in database
	 */
	public int getPatientId() {
		return this.patientID;
	}
	public String toString() {
        return " Patient waiting list details:"
        	   +"\n _______________________________"
        		+ "\n \n Patient ID: " + getPatientId() 
                + "\n Full Name: " + getFullName() 
                + "\n City: " + getCity()
                + "\n PPS Number: " + getPpsNumber()
                + "\n Email: " + getEmail()
                + "\n Phone Number: " + getMobileNumber();         
    }
	public String resumePatient() {
        return getPatientId() + " - " + getFullName();         
    }
}
