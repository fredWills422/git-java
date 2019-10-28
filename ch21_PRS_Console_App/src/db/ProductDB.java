package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import business.Product;

public class ProductDB {

private Connection getConnection() throws SQLException{
		
		String dbUrl ="jdbc:mysql://localhost:3306/prs?useSSL=false";
		String username = "prs_user";
		String pwd = "sesame";
		Connection conn = DriverManager.getConnection(dbUrl,username,pwd);
		return conn;
		
	}
	
	public List<Product> list() throws SQLException{
		//statement instead of prepared statement
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT * FROM Product";
		List<Product> products = new ArrayList<>();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			//parse user row into user pojo
			Product p = createProductFromResultSet(rs);
			products.add(p);
			
		}
		rs.close();
		return products;
	}

	
	public Product get(int id) throws SQLException{
		
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT * FROM Product"
					+" WHERE ID = "+ id;
		Product product = null;
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			//parse user row into user pojo
			product = createProductFromResultSet(rs);
		}
		rs.close();
		return product;
	}
	
	public int addProduct(Product p) {
		//use switch statement to update make it possible for user to update one field at a time
		//pid, VendorID, PartNumber, Name, Price, Unit, PhotoPath
		int rowCount= 0;
		String sql = "insert into Product (vendorId, partNumber,"+
					 "name, price, unit, "+
					 "photoPath)" +
					 "VALUES(?, ?, ?, ?, ?, ?);";
		
		try (PreparedStatement ps = getConnection().prepareStatement(sql);){
			
			ps.setInt(1, p.getVendorId());
			ps.setString(2, p.getPartNumber());
			ps.setString(3, p.getName());
			ps.setDouble(4, p.getPrice());
			ps.setString(5, p.getUnit());
			ps.setString(6, p.getPhotoPath());
			
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}
	
	public int updateProduct(Product p) {
		int rowCount= 0;
		String sql = "UPDATE Product SET price = ? "
				   + "WHERE id = ?";
		
		try (PreparedStatement ps = getConnection().prepareStatement(sql);){
			ps.setDouble(1, p.getPrice());
			ps.setInt(2, p.getId());
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowCount;
		
	}
	
	
	public int deleteProduct(Product p) {
		int rowCount = 0;
		String sql = "Delete From Product Where id = ?";
		
		try (PreparedStatement ps = getConnection().prepareStatement(sql);){
			ps.setInt(1, p.getId());
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}
	
	
	//piD, VendorID, PartNumber, Name, Price, Unit, PhotoPath
	
	
	private Product createProductFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("Id");
		int vendorId = rs.getInt("vendorId");
		String partNumber = rs.getString("partNumber");
		String name = rs.getString("name");
		double price = rs.getDouble("Price");
		String unit = rs.getString("Unit");
		String photoPath = rs.getString("photoPath");
		Product p = new Product(id, vendorId, partNumber, name, price, unit, photoPath);
		return p;
	}	
	
}
