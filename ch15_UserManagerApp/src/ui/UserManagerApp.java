package ui;

import java.util.List;

import business.User;
import database.DAO;
import database.UserTextFile;

public class UserManagerApp {

	private static DAO<User> usersFile = new UserTextFile();
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the User Manager\n");
		displayMenu();
		
		String choice = "";
		while (!choice.equalsIgnoreCase("exit")) {
			choice = Console.getString("Enter a command:");
			
			switch (choice) {
				case "list":
					displayAllUsers();
					break;
				case "add":
					addUser();
					break;
				case "delete":
					deleteUser();
					break;
				case "help":
					displayMenu();
					break;
				case "exit":
					System.out.println("Bye");
					break;
				default: 
					System.out.println("Invalid command");
					break;
			}
				
		}
		

	}

	private static void displayMenu() {
		System.out.println("COMMAND MENU");
		System.out.println("list    - List all users");
		System.out.println("add    - Add a user");
		System.out.println("delete    - Delete a user");
		System.out.println("help    - Show this menu");
		System.out.println("exit    - Exit this application");
	}
	
	private static void displayAllUsers() {
		System.out.println("USER LIST");
		
		List<User> users = usersFile.getAll();
		
		StringBuilder sb = new StringBuilder();
		for(User u: users) {
			sb.append(u.getId()+ "\t");
			sb.append(u.getUserName()+ "\t");
			sb.append(u.getPassword()+ "\t");
			sb.append(u.getFirstName()+ "\t");
			sb.append(u.getLastName()+ "\t");
			sb.append(u.getPhoneNumber()+ "\t");
			sb.append(u.getEmail()+ "\t");
			sb.append(u.isReviewer()+ "\t");
			sb.append(u.isAdmin()+ "\n");
		}
		System.out.println(sb);
	}
	
	private static void addUser() {
		
		String id = Console.getString("Enter product id: ");
		String userName = Console.getString("Enter user name: ");
		String password = Console.getString("Enter password: ");
		String firstName = Console.getString("Enter first name: ");
		String lastName = Console.getString("Enter last name: ");
		String phoneNumber = Console.getString("Enter phone number: ");
		String email = Console.getString("Enter your email: ");
		boolean isReviewer = Console.getBoolean("Are you a reviewer? (true/false)");
		boolean isAdmin = Console.getBoolean("Are you an administrator? (true/false)");
		
		User u = new User(id, userName, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin);
		boolean wasSuccessful = usersFile.add(u);
		
		if (wasSuccessful) {
			System.out.println("Successfully added " + userName);
			
		}else {
			System.out.println("Error ");
		}
	}
	
	private static void deleteUser() {
		String id = Console.getString("User id to delete: ");
		User u = usersFile.get(id);
		
		if(u != null) {
			usersFile.delete(u);
		}else {
			System.out.println("No product found for code " + id);
		}
		
	}
	
}
