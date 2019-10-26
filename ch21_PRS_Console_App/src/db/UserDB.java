package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import business.User;


public class UserDB {
	
	private Connection getConnection() throws SQLException{
		
		String dbUrl ="jdbc:mysql://localhost:3306/prs?useSSL=false";
		String username = "prs_user";
		String pwd = "sesame";
		Connection conn = DriverManager.getConnection(dbUrl,username,pwd);
		return conn;
		
	}
	
	public List<User> list() throws SQLException{
		//statement instead of prepared statement
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT * FROM User";
		List<User> users = new ArrayList<>();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			//parse user row into user pojo
			User u = createUserFromResultSet(rs);
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
			user = createUserFromResultSet(rs);
		}
		rs.close();
		return user;
	}
	
	public int addUser(User u) {
		//use switch statement to update make it possible for user to update one field at a time
		
		int rowCount= 0;
		String sql = "insert into user (userName, "+
					 "password, firstName, LastName, "+
					 "phoneNumber, email, isReviewer, "+
					 "isAdmin) VALUES "+
					 "(?, ?, ?, ?, ?, ?, ?, ?);";
		
		try (PreparedStatement ps = getConnection().prepareStatement(sql);){
			
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getPhoneNumber());
			ps.setString(6, u.getEmail());
			ps.setBoolean(7, u.isReviewer());
			ps.setBoolean(8, u.isAdmin());
			
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}
	
	public int updateUser(User u) {
		int rowCount= 0;
		String sql = "UPDATE User SET email = ? "
				   + "WHERE id = ?";
		
		try (PreparedStatement ps = getConnection().prepareStatement(sql);){
			ps.setString(1, u.getEmail());
			ps.setInt(2, u.getId());
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowCount;
		
	}
	
	
	public int deleteUser(User u) {
		int rowCount = 0;
		String sql = "Delete From User Where id = ?";
		
		try (PreparedStatement ps = getConnection().prepareStatement(sql);){
			ps.setInt(1, u.getId());
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}
	
	
	
	
	
	private User createUserFromResultSet(ResultSet rs) throws SQLException {
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
		return u;
	}
	
	
}
