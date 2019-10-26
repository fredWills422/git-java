package ui;

import java.sql.SQLException;
import java.util.List;

import business.User;
import business.Vendor;
import db.UserDB;
import db.VendorDB;
import util.Console;

public class PRSConsoleApp {
	static UserDB udb = new UserDB();
	static VendorDB vdb = new VendorDB();

	public static void main(String[] args) {
		
		System.out.println("Welcome to the PRS Console");
		
		
		int command = 0;
		while (command !=99) {
			command = Console.getInt(getMenuDisplay(),0,100);
			switch (command) {
			case 1:
				//list
				try {
					List<User> users = udb.list();
					System.out.println("List of users: ");
					for (User u: users) {
						System.out.println(u);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				break;
			case 2:
				//get
				int id = Console.getInt("User ID:");
				try {
					User u = udb.get(id);
					System.out.println("User retrieved: ");
					System.out.println(u);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				break;
			case 3:
				//add
				System.out.println("Add a user: ");
				String un = Console.getString("User name? ");
				String pw = Console.getString("Password? ");
				String fn = Console.getString("First name? ");
				String ln = Console.getString("Last name? ");
				String phn = Console.getString("Phone number? ");
				String email = Console.getString("User email? ");
				boolean isReviewer = Console.getBoolean("isReviewer (true/false)");
				boolean isAdmin = Console.getBoolean("isAdmin (true/false)");
				User u = new User(un, pw, fn, ln, phn, email, isReviewer, isAdmin);
				int rowCount = 0;
				rowCount = udb.addUser(u);
				System.out.println("User add, " +rowCount+ " rows affected.");
				break;
			case 4:
				//update
				//1- get id of the user we want to update
				System.out.println("Get a user");
				int uid = Console.getInt("User Id:");
				//2- get the user for the id entered
				u =getUser(uid);
				if(u==null) {
					//3- does the user exist? if not, error
					System.out.println("No user found for id: "+ uid);
				}else {
					//4- if user exists, prompt for new email address
					String newEmail= Console.getString("New email address?: ");
					//5- update the email address in user, update
					u.setEmail(newEmail);
					rowCount = udb.updateUser(u);
					if (rowCount==1) {
						System.out.println("User updated.");
					}else {
						System.out.println("Error");
					}
				}
				break;
			case 5:
				//delete
				//1- get id of the user we want to delete
				System.out.println("Get a user");
				uid = Console.getInt("User Id:");
				//2- get the user for the id entered
				u =getUser(uid);
				if(u==null) {
					//3- does the user exist? if not, error
					System.out.println("No user found for id: "+ uid);
				}else {
					rowCount = udb.deleteUser(u);
					if (rowCount==1) {
						System.out.println("User deleted.");
					}else {
						System.out.println("Error deleting user.");
					}
				}
				break;
				
			case 6:
				//list
				try {
					List<Vendor> vendors = vdb.list();
					System.out.println("List of vendors: ");
					for (Vendor v: vendors) {
						System.out.println(v);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				break;
			case 7:
				//get
				int vendorId = Console.getInt("Vendor ID:");
				try {
					Vendor v = vdb.get(vendorId);
					System.out.println("Vendor retrieved: ");
					System.out.println(v);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				break;
			case 8:
				//add 
				System.out.println("Add a vendor");
				//int vid = Console.getInt("Vendor Id?");
				String vendorCode = Console.getString("Vendor code? ");
				String vendorName = Console.getString("Vendor name? ");
				String vendorAddress = Console.getString("Address? ");
				String vendorCity = Console.getString("City? ");
				String vendorState = Console.getString("State? ");
				String vendorZip = Console.getString("zip? ");
				String vendorPhoneNumber = Console.getString("Vendor's phone number? ");
				String vendorEmail = Console.getString("Vendor's email? ");
				Vendor v = new Vendor(vendorCode, vendorName, vendorAddress, vendorCity, vendorState, vendorZip, vendorPhoneNumber, vendorEmail);
				rowCount = 0;
				rowCount = vdb.addVendor(v);
				System.out.println("User add, " +rowCount+ " rows affected.");
				break;
			case 9:
				//update
				//1- get id of the user we want to update
				System.out.println("Get a vendor");
				int vid = Console.getInt("Vendor Id:");
				//2- get the user for the id entered
				v =getVendor(vid);
				if(v==null) {
					//3- does the vendor exist? if not, error
					System.out.println("No vendor found for id: "+ vid);
				}else {
					//4- if vendor exists, prompt for new email address
					String vNewEmail= Console.getString("New email address?: ");
					//5- update the email address in user, update
					v.setEmail(vNewEmail);
					rowCount = vdb.updateVendor(v);
					if (rowCount==1) {
						System.out.println("Vendor updated.");
					}else {
						System.out.println("Error updating vendor.");
					}
				}
				break;
			case 10:
				//delete
				//1- get id of the vendor we want to delete
				System.out.println("Get a vendor");
				vid = Console.getInt("Vendor Id:");
				//2- get the vendor for the id entered
				v =getVendor(vid);
				if(v==null) {
					//3- does the vendor exist? if not, error
					System.out.println("No vendor found for id: "+ vid);
				}else {
					rowCount = vdb.deleteVendor(v);
					if (rowCount==1) {
						System.out.println("Vendor deleted.");
					}else {
						System.out.println("Error deleting vendor.");
					}
				}
				break;
				
			case 99:
				//exit
				break;
			default:
				System.out.println("Error. Invalid Command.");
				break;
			
			}
		}
		
		
		System.out.println("Bye");
	}
	private static String getMenuDisplay() {
		
		String str = "MENU\n"+
					 "1 - List Users\n"+
					 "2 - Get User\n"+
					 "3 - Add User\n"+
					 "4 - Update User\n"+
					 "5 - Delete User\n"+
					 "6 - List Vendors\n"+
					 "7 - Get Vendor\n"+
					 "8 - Add Vendor\n"+
					 "9 - Update Vendor\n"+
					 "10 - Delete Vendor\n"+
					 
					 "99 - Exit\n"+
					 "Command: ";
		return str;
	}
	private static User getUser(int id) {
		User u = null;
		try {
			u = udb.get(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	private static Vendor getVendor(int id) {
		Vendor v = null;
		try {
			v = vdb.get(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
}
