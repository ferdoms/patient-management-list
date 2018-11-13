package patientmanagementsys;

public class Patient {
	private String fName;
	private String lName;
	private String ppsNumber;
	private String mobileNumber;
	private String email;
	private String city;
	private Integer patientId;
	
	public Patient(String fName, String lName, String ppsNumber,String mobileNumber, String email, String city, int patientId) {
		this.fName = fName;
		this.lName = lName;
		this.ppsNumber = ppsNumber;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.city = city;
		this.patientId = patientId;
	}
	
	public void setFname(String fName) {
		this.fName = fName;
	}
	
	private String getFname() {
		return this.fName;
	}
	
	public void setLname(String lName) {
		this.lName = lName;
	}
	
	private String getLname() {
		return this.lName;
	}
	
	public void setPpsNumber(String ppsNumber) {
		this.ppsNumber = ppsNumber;
	}
	
	private String getPpsNumber() {
		return this.ppsNumber;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	private String getMobileNumber() {
		return this.mobileNumber;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	private String getEmail() {
		return this.email;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	private String City() {
		return this.city;
	}
	
	private int getPatientId() {
		return this.patientId;
	}
}
