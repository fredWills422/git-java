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
	private final String USERS_URI = "c:/bootcamp/java/fileiodemo/users.txt";
	
	public UserTextFile() {
		usersPath = Paths.get(USERS_URI);
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

	@Override
	public List<User> getAll() {
		if(users != null) {
			return users;
		}
		
		users = new ArrayList<>();
		
		if(Files.exists(usersPath)) {
			
			try {
				BufferedReader in = new BufferedReader(
									new FileReader(usersFile));
				
				String line= in.readLine();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
		
		return null;
	}

	@Override
	public boolean add(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User t) {
		// TODO Auto-generated method stub
		return false;
	}

}
