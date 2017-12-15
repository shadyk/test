package employee;

public class Employee {
	String firstname, lastname, universityDegree,dateOfEmployment,wifeName,wifeOccupation;
	int maritalStatusId,numberOfKids,yearsOfExperience;
	int employeeID;
		
	public Employee(int employeeID, String firstname, String lastname, int yearsOfExperience) {
		super();
		this.employeeID = employeeID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.yearsOfExperience = yearsOfExperience;
	}
	public Employee(String employeeID, String firstname, String lastname, String yearsOfExperience) {
		super();
		this.employeeID = Integer.parseInt(employeeID);
		this.firstname = firstname;
		this.lastname = lastname;
		this.yearsOfExperience = Integer.parseInt(yearsOfExperience);;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUniversityDegree() {
		return universityDegree;
	}
	public void setUniversityDegree(String universityDegree) {
		this.universityDegree = universityDegree;
	}
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public String getDateOfEmployment() {
		return dateOfEmployment;
	}
	public void setDateOfEmployment(String dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}
	public String getWifeName() {
		return wifeName;
	}
	public void setWifeName(String wifeName) {
		this.wifeName = wifeName;
	}
	public String getWifeOccupation() {
		return wifeOccupation;
	}
	public void setWifeOccupation(String wifeOccupation) {
		this.wifeOccupation = wifeOccupation;
	}
	public int getMaritalStatusId() {
		return maritalStatusId;
	}
	public void setMaritalStatusId(int maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}
	public int getNumberOfKids() {
		return numberOfKids;
	}
	public void setNumberOfKids(int numberOfKids) {
		this.numberOfKids = numberOfKids;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	public String toString() {
		return "id : " +this.employeeID + " \n fullname : " + this.firstname + " " + this.lastname;
		
	}	
}
