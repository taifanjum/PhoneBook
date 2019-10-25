
public class Contact implements Comparable<Contact>{
	public  String name;
	public  String phoneNumber;
	public  String email;
	public  String address;
	public  String relationship;
	
	public Contact() {}
	
	public Contact(String name, String phoneNumber, String email, String address, String relationship) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.relationship = relationship;
	}
	
	
	public int compareTo(Contact c) {
		
		return this.name.compareTo(c.name);
	}
	
	public String toString() {
		return String.format(
				"\n========================\n"
				+ "Name: %s\n"
				+ "Phone Number: %s\n"
				+ "Email: %s\n"
				+ "Address: %s\n"
				+ "Relationship: %s\n"
				+ "========================\n", 
				name, phoneNumber, email, address, relationship);
	}
}

	
	
	
	
		


	
	

