package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import business.User;
import util.Console;

public class UserDB {
	
	private Connection getConnection() throws SQLException{
		
		String dbUrl ="jdbc:mysql://localhost:3306/prs?useSSL=false";
		String username = "prs_user";
		String pwd = "sesame";
		Connection conn = DriverManager.getConnection(dbUrl,username,pwd);
		return conn;
		
	}
	
	public List<User> list() throws SQLException{
		
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT * FROM User";
		List<User> users = new ArrayList<>();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			//parse user row into user pojo
			int id = rs.getInt("ID");
			String userName = rs.getString("userName");
			String password = rs.getString("password");
			String firstName = rs.getString("firstName");
			String lastName = rs.getString("lastName");
			String phoneNumber = rs.getString("phoneNumber");
			String email = rs.getString("email");
			boolean isReviewer = rs.getBoolean("isReviewer");
			boolean isAdmin = rs.getBoolean("isAdmin");
			User u = new User(id,userName, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin);
			users.add(u);
			
		}
		rs.close();
		return users;
	}
	
	public User get(int id) throws SQLException{
		
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT * FROM User"
					+" WHERE ID = "+ id;
		User user = null;
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			//parse user row into user pojo
			
			String userName = rs.getString("userName");
			String password = rs.getString("password");
			String firstName = rs.getString("firstName");
			String lastName = rs.getString("lastName");
			String phoneNumber = rs.getString("phoneNumber");
			String email = rs.getString("email");
			boolean isReviewer = rs.getBoolean("isReviewer");
			boolean isAdmin = rs.getBoolean("isAdmin");
			user = new User(id,userName, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin);
			
			
		}
		rs.close();
		return user;
	}
	
	public List<User> add() throws SQLException{
		
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT * FROM User";
		List<User> users = new ArrayList<>();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			
			int id = rs.getInt("ID");
			String userName = rs.getString("userName");
			String password = rs.getString("password");
			String firstName = rs.getString("firstName");
			String lastName = rs.getString("lastName");
			String phoneNumber = rs.getString("phoneNumber");
			String email = rs.getString("email");
			boolean isReviewer = rs.getBoolean("isReviewer");
			boolean isAdmin = rs.getBoolean("isAdmin");
			User u = new User(id,userName, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin);
			users.add(u);
			
		}
		rs.close();
		
		User user = null;
		int id = Console.getInt("Id: ",users.size(),(users.size()+1));
		String userName = Console.getString("userName: ");
		String password = Console.getString("password: ");
		String firstName = Console.getString("firstName: ");
		String lastName = Console.getString("lastName: ");
		String phoneNumber = Console.getString("phoneNumber: ");
		String email = Console.getString("email: ");
		boolean isReviewer = Console.getBoolean("isReviewer: ");
		boolean isAdmin = Console.getBoolean("isAdmin: ");
		user = new User(id,userName, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin);
		
		String sqlInsert = 
				"INSERT INTO User (id, userName, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin) "+
						"VALUES ('" +id+"', " +userName+ "', " +password+ "', " +firstName+ "', " +lastName+ "', " +phoneNumber+
						"', " +email+ "', " +isReviewer+ "', " +isAdmin;
		
		PreparedStatement ps = getConnection().prepareStatement(sqlInsert);
		
		ps.setInt(1, user.getId());
		ps.setString(2, user.getUserName());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getFirstName());
		ps.setString(5, user.getLastName());
		ps.setString(6, user.getPhoneNumber());
		ps.setString(7, user.getEmail());
		ps.setBoolean(8, user.isReviewer());
		ps.setBoolean(9, user.isAdmin());
		
		int rowCount = ps.executeUpdate();
		
		users.add(rowCount, user);
		return users;
		
	}
	
}
