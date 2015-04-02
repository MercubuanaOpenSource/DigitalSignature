import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionImpl implements IConnection {
public static Connection connection;
	public static void koneksi() {
		// TODO Auto-generated method stub
		 try{
			   Class.forName("com.mysql.jdbc.Driver");
			  } catch (ClassNotFoundException e) {
			   System.out.println("Where is your MySQL JDBC Driver?");
			   e.printStackTrace();
			   return;
			  }
			   
			  System.out.println("MySQL JDBC Driver Registered!");
			  Connection connection = null;
			 
			  
			  try{
			   connection = DriverManager
			     .getConnection("jdbc:mysql://localhost:3306/digsin","root", "");
			  } catch (SQLException e) {
			   System.out.println("Connection Failed! Check output console");
			   e.printStackTrace();
			   return;
			  }
			   
			  if (connection != null) {
			   System.out.println("You made it, take control your database now!");
			  } else {
			   System.out.println("Failed to make connection!");
			  }
			   
			 }
			 
			}
