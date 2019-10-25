import java.util.Scanner;

public class ContactList {
	
	private static ArrayBasedSortedList<Contact> List;
	
	public ContactList() {
		List = new ArrayBasedSortedList<Contact>();	
	}
	
	public void add(Contact c) {
		List.insert(c);
	}
	
	public String toString() {
		return List.toString();
		
	}

	public Contact find(String name){
		for (int i=0; i < List.size(); i++){
			Contact c = (Contact) List.get(i);
			if(c.name.equals(name))
				return c;
		}
		return null;
	}
	
	public boolean remove(Contact c) {
		return List.remove(c);
	}
	
	private int getChoice(int min, int max) {
		int choi = 0;
		while (choi > max || choi < min) {
			choi = in.nextInt();
			if (choi > max || choi < min)
				System.out.println("The integers must be between " 
							+ min + " to " + max);
			in.nextLine();	
		}
		return choi;
	}
	
	private int menu() {
		System.out.println("What would you like to do?");
		System.out.println("1. Add a contact");
		System.out.println("2. Edit a contact");
		System.out.println("3. Delete a contact");
		System.out.println("4. Display a contact");
		System.out.println("5. Display all contacts\n");
		
		int input = -1;
		while(input == -1) 
			input = getChoice(1, 5);
		return input;	
	}
	
	private int editContactMenu() {
		System.out.print(
				"\nWhat do you want to edit?\n"
				+ "1. Name\n"
				+ "2. Number\n"
				+ "3. Email\n"
				+ "4. Address\n"
				+ "5. Relationship\n"
				+ "6. Quit\n" 
			);
		int input = -1;
		while (input == -1) {
			input = getChoice(1, 6);
		}
		return input;
		
	}
	private void editContact(Contact c) {
		System.out.printf("%s\'s information\n", c.name); 
		System.out.print(c.toString());
		int choice = 0;
		while(choice != -1) {
			choice = editContactMenu();
			switch(choice) {
			case 1:
				String existingName = c.name;
				System.out.println("Name: ");
				c.name = in.nextLine();
				System.out.printf("Name changed from " + existingName + " to " + c.name);
				break;
			case 2:
				String existingNumber = c.phoneNumber;
				System.out.println("Phone Number: ");
				c.phoneNumber = in.nextLine();
				System.out.printf("Phone Number changed from " + existingNumber + " to " + c.phoneNumber);
				break;	
			case 3:
				String existingEmail = c.email;
				System.out.println("New Email: ");
				c.email = in.nextLine();
				System.out.printf("Email changed from " + existingEmail + " to " + c.email);
				break;
			case 4: 
				String existingAddress = c.address;
				System.out.println("New Address: ");
				c.address = in.nextLine();
				System.out.printf("Address changed from " + existingAddress + " to " + c.address);
				break;
			case 5:
				String existingRelationship = c.relationship;
				System.out.println("New relationship: ");
				c.relationship = in.nextLine();
				System.out.printf("Relationship changed from " + existingRelationship + " to " + c.relationship);
				break;	
			case 6:
				choice = -1;
				break;
			}
		}		
	}
	
	private Contact getContact() {
		System.out.println("Enter name: ");
		Contact c = find(in.nextLine());
		if ( c == null)
			System.out.println(" Contact not found");
		return c;
	}
	
	private Contact getNewContact() {
		Contact c = new Contact();
		//Get contact name
		while(c.name == null || c.name.length() == 0 ) {
			System.out.print("Name: ");
			c.name = in.nextLine();
			if(c.name.length() == 0)
				System.out.println("\nPlease enter a name of at leat one character. ");
			else if(find(c.name) != null)
			{
				System.out.println("Sorry that name is already in your contact list.");
				c.name = "";
			}
		}
		
		// Get contact phone number
		while(c.phoneNumber == null || c.phoneNumber.length() == 0 ) {
			System.out.print("Phone Number: ");
			c.phoneNumber = in.nextLine();
		}
		
		// Get email
		System.out.print("Email: ");
		c.email = in.nextLine();
		
		//get contact address
		System.out.print("Enter address: ");
		c.address = in.nextLine();
		
		// Get contact address 
		System.out.print("Relationship: ");
		c.relationship = in.nextLine();;
		
		return c;
	}
	
	private Scanner in = new Scanner(System.in);
	public void run() {	
		Contact c;
		int choice = -1;
		while ( choice != 6) {
		choice = menu();
		switch(choice) {
		case 1:
			c = getNewContact();
			add(c);
			break;
		case 2:
			c = getContact();
			if(c != null)
				editContact(c);
			break;
		case 3:
			System.out.println(
						remove(getContact()) ? " Deleted " : "Failed to delete: ");
			break;
		case 4:
			c = getContact();
			if(c != null)
				System.out.println(c);
			break;
		case 5:
			System.out.println(List.toString());
			break;
		case 6:
			break;
				
		}
		}
	}

}
