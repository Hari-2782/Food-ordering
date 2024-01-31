package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;


public class Usermethod {

	public static final Logger log = Logger.getLogger(Usermethod.class.getName());

	private static Connection connection;

	private static Statement statement;
	
	private static PreparedStatement pr;
	private static final String COUNT_CUSTOMER_SQL="SELECT COUNT(*) FROM customer";
	
	public boolean insertuser(String name, String phone, String email, String username, String password) {
		// TODO Auto-generated method stub
		boolean isSuccess = false ;
		try {
			 
			connection = Dbconnection.getDbConnection();
			
			statement= connection.createStatement();
         String sql = " Insert into customer values ('"+name+"', '"+phone+"' , '"+email+"' , '"+username+"' , '"+password+"')";
		
		int rs2 = statement.executeUpdate(sql);
		
		if(rs2 > 0 ) {
			isSuccess = true ;
		}
		else {
			isSuccess = false ;
		}

	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	return isSuccess ;
		
	}
	public boolean validate(String name,String pass){
		boolean status=false;
			
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = Dbconnection.getDbConnection();
			pr = connection.prepareStatement("select * from customer where username =? and password = ? ");
			
			pr.setString(1,name);
			pr.setString(2,pass);
	
			ResultSet rs=pr.executeQuery();
			status = rs.next();
	
	
		}catch(Exception e){
			System.out.println(e);
		}
			return status;
	}
	
	
//	public boolean adminValidate(String uname , String pass) {
//		
//		//boolean status;
//		
//		if(uname == "admin" && pass == "admin123") {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
	public  static int printcount() {
		int count=0;
		try(Connection connection=Dbconnection.getDbConnection();
				
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_CUSTOMER_SQL)){
			ResultSet re = preparedStatement.executeQuery();
			if (re.next()) {
                count = re.getInt(1);
            }
			
		}catch (SQLException e) {
			
		}
		return count;
		
	}
	

}
