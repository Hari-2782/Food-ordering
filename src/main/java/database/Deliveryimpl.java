package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import impl.Deliveryinterface;
import model.Delivery;

public class Deliveryimpl implements Deliveryinterface {

	

	private static final String SELECT_DELIVERYPERSON_BY_ID="select * from delivery where id=?";
	private static final String INSERT_DELIVERYPERSON_SQL="insert into delivery" + "(name, phone, email, address) values"+"(?,?,?,?);";
	private static final String SELECT_ALL_DELIVERYPERSON="SELECT * FROM delivery ";
	private static final String UPDATE_DELIVERYPERSON_SQL="update delivery set name=?,phone=?,email=?,address=? where id =?;";
	private static final String DELETE_DELIVERYPERSON_SQL="delete from delivery where id = ?;";
	private static final String COUNT_DELIVERYPERSON_SQL="SELECT COUNT(*) FROM Delivery";
	 
	public Deliveryimpl() {
		
	}
	@Override
	public Delivery getdetail(int id) throws SQLException {
		// TODO Auto-generated method stub
		Delivery d=null;
		try(Connection connection=Dbconnection.getDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DELIVERYPERSON_BY_ID)){
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet re = preparedStatement.executeQuery();

			while (re.next()) {
				
					String name =re.getString("name");
					String phone =re.getString("phone");
					 String email=re.getString("email") ;
					 String address=re.getString("address");
					 d=new Delivery(id, name, phone, email, address);
			}
		}catch (SQLException e) {
				printSQLException(e);
			}
		
		
		return d;
	}

	@Override
	public void adddelivery(Delivery d) throws SQLException{
		// TODO Auto-generated method stub
		try(Connection connection=Dbconnection.getDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DELIVERYPERSON_SQL)){

			preparedStatement.setString(1, d.getName());
			preparedStatement.setString(2, d.getPhone());
			preparedStatement.setString(3, d.getEmail());
			preparedStatement.setString(4, d.getAddress());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		
	}

	
	@Override
	public  ArrayList<Delivery> getdetails() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Delivery> dlist=new ArrayList<Delivery>();
		try(Connection connection=Dbconnection.getDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement( SELECT_ALL_DELIVERYPERSON)){
			ResultSet re = preparedStatement.executeQuery();
			while (re.next()) {
				 int id=re.getInt("id");
				String name =re.getString("name");
				String phone =re.getString("phone");
				 String email=re.getString("email") ;
				 String address=re.getString("address");
				 dlist.add(new Delivery(id, name, phone, email, address));
		}
			}catch (SQLException e) {
				printSQLException(e);
			}
		
		return dlist;
	}

	@Override
	public boolean updatedetails(Delivery d) throws SQLException {
		// TODO Auto-generated method stub
		boolean rowUpdated;
		try(Connection connection=Dbconnection.getDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DELIVERYPERSON_SQL)){
			
			preparedStatement.setString(1, d.getName());
			preparedStatement.setString(2, d.getPhone());
			preparedStatement.setString(3, d.getEmail());
			preparedStatement.setString(4, d.getAddress());
			preparedStatement.setInt(5, d.getID());
			rowUpdated = preparedStatement.executeUpdate() > 0;
			
		}
		return rowUpdated;
	}

	@Override
	public boolean delete(int id)throws SQLException  {
		// TODO Auto-generated method stub
		boolean rowDeleted;
		try(Connection connection=Dbconnection.getDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DELIVERYPERSON_SQL)){
			preparedStatement.setInt(1, id);
			rowDeleted = preparedStatement.executeUpdate() > 0;
		}
		return rowDeleted;
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
				
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_DELIVERYPERSON_SQL)){
			ResultSet re = preparedStatement.executeQuery();
			if (re.next()) {
                count = re.getInt(1);
            }
			
		}catch (SQLException e) {
			
		}
		return count;
		
	}


}
