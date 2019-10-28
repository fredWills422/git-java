package db;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import business.Vendor;

public class VendorDB {

private Connection getConnection() throws SQLException{
		
		String dbUrl ="jdbc:mysql://localhost:3306/prs?useSSL=false";
		String username = "prs_user";
		String pwd = "sesame";
		Connection conn = DriverManager.getConnection(dbUrl,username,pwd);
		return conn;
		
	}
	
	public List<Vendor> list() throws SQLException{
		//statement instead of prepared statement
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT * FROM Vendor";
		List<Vendor> vendors = new ArrayList<>();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			//parse user row into user pojo
			Vendor v = createVendorFromResultSet(rs);
			vendors.add(v);
			
		}
		rs.close();
		return vendors;
	}

	
	public Vendor get(int id) throws SQLException{
		
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT * FROM Vendor"
					+" WHERE ID = "+ id;
		Vendor vendor = null;
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			//parse user row into user pojo
			vendor = createVendorFromResultSet(rs);
		}
		rs.close();
		return vendor;
	}
	
	public int addVendor(Vendor v) {
		//use switch statement to update make it possible for user to update one field at a time
		
		int rowCount= 0;
		String sql = "insert into Vendor (code, name,"+
					 "address, city, state, "+
					 "zip, phoneNumber, email)" +
					 "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
		
		try (PreparedStatement ps = getConnection().prepareStatement(sql);){
			
			ps.setString(1, v.getCode());
			ps.setString(2, v.getName());
			ps.setString(3, v.getAddress());
			ps.setString(4, v.getCity());
			ps.setString(5, v.getState());
			ps.setString(6, v.getZip());
			ps.setString(7, v.getPhoneNumber());
			ps.setString(8, v.getEmail());
			
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}
	
	public int updateVendor(Vendor v) {
		int rowCount= 0;
		String sql = "UPDATE Vendor SET email = ? "
				   + "WHERE id = ?";
		
		try (PreparedStatement ps = getConnection().prepareStatement(sql);){
			ps.setString(1, v.getEmail());
			ps.setInt(2, v.getId());
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowCount;
		
	}
	
	
	public int deleteVendor(Vendor v) {
		int rowCount = 0;
		String sql = "Delete From Vendor Where id = ?";
		
		try (PreparedStatement ps = getConnection().prepareStatement(sql);){
			ps.setInt(1, v.getId());
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}
	
	
	
	
	
	private Vendor createVendorFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("ID");
		String code = rs.getString("code");
		String name = rs.getString("name");
		String address = rs.getString("address");
		String city = rs.getString("city");
		String state = rs.getString("state");
		String zip = rs.getString("zip");
		String phoneNumber = rs.getString("phoneNumber");
		String email = rs.getString("email");
		Vendor v = new Vendor(id, code, name, address, city, state, zip, phoneNumber, email);
		return v;
	}	
	
}
