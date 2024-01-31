package database;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import impl.Dishinterface;
import model.Dishe;

public class Dishimpl implements Dishinterface {
	
	private static final String SELECT_Dish_BY_ID="select * from dishe where id=?";
	private static final String INSERT_Dish_SQL="insert into dishe" + "(id,name, description, price, photo) values"+"(?,?,?,?,?);";
	private static final String SELECT_ALL_Dish="SELECT * FROM dishe ";
	private static final String UPDATE_Dish="update dishe set name=?,description=?,price=? where id =?;";
	private static final String DELETE_Dish="delete from dishe where id = ?;";
	private static final String COUNT_Dish="SELECT COUNT(*) FROM Dishe";

	@Override
	public void adddish(Dishe d) {
		// TODO Auto-generated method stub
		try(Connection connection=Dbconnection.getDbConnection();
				PreparedStatement p = connection.prepareStatement(INSERT_Dish_SQL)){
			connection.setAutoCommit(false);
			p.setString(2,d.getName());
			p.setString(3,d.getDesc());
			p.setBytes(5, d.getPhoto());
			p.setInt(1, d.getDishid());
			p.setFloat(4,d.getPrice());
			p.execute();
			connection.commit();
			}catch (SQLException e) {
				printSQLException(e);
			}
	}

	@Override
	public Dishe getdish(int id) throws SQLException {
	    Dishe d = null;
	    try (Connection connection = Dbconnection.getDbConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Dish_BY_ID)) {
	        preparedStatement.setInt(1, id);
	        //System.out.println(preparedStatement);
	        ResultSet re = preparedStatement.executeQuery();
	        while (re.next()) {
	            d = new Dishe();
	            d.setDishid(re.getInt(1));
	            d.setName(re.getString(2));
	            d.setDesc(re.getString(3));
	            d.setPrice(re.getFloat(4));

	            // Retrieve the photo from the database as a Blob
	            Blob photoBlob = re.getBlob(5);
	            if (photoBlob != null) {
	                // You can convert the Blob to a byte array and store it in your Dishe object
	                byte[] photoBytes = photoBlob.getBytes(1, (int) photoBlob.length());
	                d.setPhoto(photoBytes);
	            }
	        }
	    } catch (SQLException e) {
	        printSQLException(e);
	    }
	    return d;
	}


	@Override
	public ArrayList<Dishe> getdishes() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Dishe> l=new ArrayList<Dishe>();
		try(Connection connection=Dbconnection.getDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Dish)){
			ResultSet re = preparedStatement.executeQuery();
			while (re.next()) {
				  Dishe d=new Dishe();
				d.setName(re.getString(2));
				d.setDesc(re.getString(3));
				 d.setPrice(Float.parseFloat(re.getString(4)));
				 d.setDishid(Integer.parseInt(re.getString(1)));
				 Blob photoBlob = re.getBlob(5);
		            if (photoBlob != null) {
		                // You can convert the Blob to a byte array and set it in the Dishe object
		                byte[] photoBytes = photoBlob.getBytes(1, (int) photoBlob.length());
		                d.setPhoto(photoBytes);}
		            l.add(d);
				 }
			}catch (SQLException e) {
			printSQLException(e);
		}
	
		return l;
	}

	@Override
	public Dishe updatedish(int id, Dishe d) {
		// TODO Auto-generated method stub
		try(Connection connection=Dbconnection.getDbConnection();
				PreparedStatement p = connection.prepareStatement(UPDATE_Dish)){
			connection.setAutoCommit(false);
			p.setString(1,d.getName());
			p.setString(2,d.getDesc());
			//p.setString(3, d.getPhoto());
			p.setInt(4, id);
			p.setFloat(3,d.getPrice());
			p.execute();
			connection.commit();
			}catch (SQLException e) {
				printSQLException(e);
			}
		return d;
	}

	@Override
	public void removedishe(int id) {
		// TODO Auto-generated method stub
		try(Connection connection=Dbconnection.getDbConnection();
				PreparedStatement p = connection.prepareStatement(DELETE_Dish)){
			connection.setAutoCommit(false);
			p.setInt(1, id);
			p.executeUpdate();
			connection.commit();
		}catch (SQLException e) {
			printSQLException(e);
		
			
		}
	}
	private void printSQLException(SQLException ex) {
		// TODO Auto-generated method stub
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	public  static int printcount() {
		int count=0;
		try(Connection connection=Dbconnection.getDbConnection();
				
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_Dish)){
			ResultSet re = preparedStatement.executeQuery();
			if (re.next()) {
                count = re.getInt(1);
            }
			
		}catch (SQLException e) {
			
		}
		return count;
		
	}

}
