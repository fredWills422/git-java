package ui;

import java.sql.SQLException;
import java.util.List;

import business.Product;
import business.User;
import business.Vendor;
import db.ProductDB;
import db.UserDB;
import db.VendorDB;
import util.Console;

public class PRSConsoleApp {
	static UserDB udb = new UserDB();
	static VendorDB vdb = new VendorDB();
	static ProductDB pdb = new ProductDB();

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
				int vid = Console.getInt("Vendor ID:");
				try {
					Vendor v = vdb.get(vid);
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
				vid = Console.getInt("Vendor Id:");
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
				
			case 11:
				//list
				try {
					List<Product> products = pdb.list();
					System.out.println("List of products: ");
					for (Product p: products) {
						System.out.println(p);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				break;
			case 12:
				//get
				id = Console.getInt("Product ID:");
				try {
					Product p = pdb.get(id);
					System.out.println("Product retrieved: ");
					System.out.println(p);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				break;
			case 13:
				//add 
				System.out.println("Add a product");
				int vendorId = Console.getInt("Vendor Id? ");
				String partNumber = Console.getString("Part number? ");
				String name = Console.getString("Name? ");
				double price = Console.getDouble("Price? ");
				String unit = Console.getString("Unit? ");
				String photoPath = Console.getString("Photo path? ");
				Product p = new Product(vendorId, partNumber, name, price, unit, photoPath);
				rowCount = 0;
				rowCount = pdb.addProduct(p);
				System.out.println("User add, " +rowCount+ " rows affected.");
				break;
			case 14:
				//update
				//1- get id of the product we want to update
				System.out.println("Get a product");
				id = Console.getInt("Product Id:");
				//2- get the product for the id entered
				p =getProduct(id);
				if(p==null) {
					//3- does the product exist? if not, error
					System.out.println("No product found for id: "+ id);
				}else {
					//4- if product exists, prompt for new price
					double pNewPrice= Console.getDouble("New product price? ");
					//5- update the price in product, update
					p.setPrice(pNewPrice);
					rowCount = pdb.updateProduct(p);
					if (rowCount==1) {
						System.out.println("Product updated.");
					}else {
						System.out.println("Error updating product.");
					}
				}
				break;
			case 15:
				//delete
				//1- get id of the product we want to delete
				System.out.println("Get a product");
				id = Console.getInt("Product Id:");
				//2- get the product for the id entered
				p =getProduct(id);
				if(p==null) {
					//3- does the product exist? if not, error
					System.out.println("No product found for id: "+ id);
				}else {
					rowCount = pdb.deleteProduct(p);
					if (rowCount==1) {
						System.out.println("Product deleted.");
					}else {
						System.out.println("Error deleting product.");
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
					 "11 - List Products\n"+
					 "12 - Get Product\n"+
					 "13 - Add Product\n"+
					 "14 - Update Product\n"+
					 "15 - Delete Product\n"+
					 
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
	private static Product getProduct(int id) {
		Product p = null;
		try {
			p = pdb.get(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
}
