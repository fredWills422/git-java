public class Actor {
	
	private int id = 0;
	private String firstName = "";
	private String lastName = "";
	private String gender = "";
	private String birthDate = "";
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String toString() {
		String message = "ID: "+ id +"\n"
				+ "First name: " + firstName + "\n" 
				+ "Last name: " + lastName + "\n"
				+ "Gender: " + gender + "\n"
				+ "Birthdate: "+ birthDate;
		return message;
	}
	
}
