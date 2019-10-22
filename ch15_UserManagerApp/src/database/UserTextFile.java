package database;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import business.User;

public class UserTextFile implements DAO<User> {
	
	private List<User> users = null;
	private Path usersPath = null;
	private File usersFile = null;
	private final String TAB= "\t";
	private final String USER_URI = "c:/bootcamp/java/fileiodemo/users.txt";
	
	public UserTextFile() {
		usersPath = Paths.get(USER_URI);
		usersFile = usersPath.toFile();
		users = this.getAll();
	}
	
	@Override
	public User get(String id) {
		for(User u: users) {
			if(u.getId().equals(id)) {
				return u;
			}
		}
		return null;
	}

	private boolean saveAll() {
		try(PrintWriter out = new PrintWriter(
						  new BufferedWriter(
						  new FileWriter(usersFile)))) {
			for(User u: users) {
				out.print(u.getId()+ TAB);
				out.print(u.getUserName()+TAB);
				out.print(u.getPassword()+TAB);
				out.print(u.getFirstName()+TAB);
				out.print(u.getLastName()+TAB);
				out.print(u.getPhoneNumber()+TAB);
				out.print(u.getEmail()+TAB);
				out.print(u.isReviewer()+TAB);
				out.println(u.isAdmin());
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<User> getAll() {
		if(users != null) {
			return users;
		}
		users = new ArrayList<>();
		if(Files.exists(usersPath)) {
			try (BufferedReader in = new BufferedReader(
									 new FileReader(usersFile))){
				String line= in.readLine();
				while (line!= null) {
					String[] fields = line.split(TAB);
					String id = fields[0];
					String userName = fields[1];
					String password = fields[2];
					String firstName = fields[3];
					String lastName = fields[4];
					String phoneNumber = fields[5];
					String email = fields[6];
					String isReviewer = fields[7];
					String isAdmin = fields[8];
					User u = new User(id, userName, password, firstName, lastName, phoneNumber, email, Boolean.parseBoolean(isReviewer), Boolean.parseBoolean(isAdmin));
					users.add(u);
					line = in.readLine();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else {
			System.out.println(usersPath.toAbsolutePath()+ " doesn't exist.");
			return null;
		}
		return users;
	}

	@Override
	public boolean add(User u) {
		users.add(u);
		return this.saveAll();
	}

	@Override
	public boolean update(User newUser) {
		User oldUser = this.get(newUser.getId());
		int i = users.indexOf(oldUser);
		users.remove(i);
		
		users.add(i,newUser);
		return this.saveAll();
	}

	@Override
	public boolean delete(User u) {
		users.remove(u);
		return false;
	}

}
