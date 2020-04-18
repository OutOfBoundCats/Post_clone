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
	
	public Connection  ConnectToDatabase(String username,String password,int TNS_index,Cust_Printer printer);
	
	


}
