package index;


/**
 * @author praj4
 *
 */

import java.sql.Connection;

import com.itextpdf.layout.Document;

public interface database_connect {
	
	String[] TNS = {
			"DEV", 
			"STG", 
			"PROD", 
			"VCP"
			};
	
	public Connection  ConnectToDatabase(String username,String password,String TNS,Cust_Printer printer);
	
	


}
