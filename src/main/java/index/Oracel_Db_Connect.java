package index;

/**
 * @author praj4
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;

import com.itextpdf.layout.Document;

public class Oracel_Db_Connect implements database_connect {

	public Connection ConnectToDatabase(String username, String password, String TNS,Cust_Printer printer) {
		// TODO Auto-generated method stub
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection connection=DriverManager.getConnection(  
					"jdbc:oracle:thin:@"+TNS,username,password);  
			printer.cust_print("Database Connection Established", 0, 2);
			return connection;		
		}
		catch(Exception e){ 
			String error=e.toString();
			printer.cust_print("Error Establishing Database Connection :-> "+error, 0, 0);
			printer.cust_print("After exception", 0, 0);
			// e.printStackTrace(); 
		}
		return null;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
