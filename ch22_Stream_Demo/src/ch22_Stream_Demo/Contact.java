package ch22_Stream_Demo;

public class Contact {

	private String name;
	private String email;
	private String phone;
	
	public Contact() {
		
	}
	

	public Contact(String name, String email, String phone) {
		super();
		this.name= name;
		this.email= email;
		this.phone = phone;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Contact [name=" + name + ", email=" + email + ", phone=" + phone + ", getName()=" + getName()
		+ ", getEmail()=" + getEmail() + ", getPhone()=" + getPhone() + ", getClass()=" + getClass()
		+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
