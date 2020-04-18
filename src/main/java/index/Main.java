package index;

import java.io.FileNotFoundException;
import java.net.URL;
import java.lang.*;

import com.itextpdf.layout.Document;
import java.sql.Connection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage; 

/**
 * @author praj4
 *
 */

public class Main extends Application{
	String[] TNS = {
			"DEV", 
			"STG", 
			"PROD", 
			"VCP"
			};
	
	@Override
    public void start(Stage stage) throws Exception{
		Main m=new Main();
		Class cls = m.getClass();
		URL url = cls.getResource("Login.fxml");
	      System.out.println("Value = " + url);
	      
	    stage.setTitle("RClone");
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:C:/Users/praj4/Desktop/SId/Post_clone/target/classes/Login.fxml")); 
        FXMLLoader Main_Screen_loader = new FXMLLoader();
        Main_Screen_loader.setLocation(new URL("file:C:/Users/praj4/Desktop/SId/Post_clone/target/classes/Main_Screen.fxml"));
        Scene scene=new Scene((Parent) loader.load());
        stage.setScene(scene);
        stage.show();
      
      
    }

		    
      
		
		  
	
	

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		
		// finds resource relative to the class location
	      
		
		Cust_Printer printer = null ;
		Document print = null;
		String username = null;
		String password = null;
		int TNS_index = 0;
		
		
		/**       UI             **/
		launch(args);
		
		
		try {
			//we create printer to which we can print to
			printer = new Cust_Printer();
			print=printer.Initialize_print();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception occured while initialising printer in main "+e);
			e.printStackTrace();
		}
		printer.cust_print("INSIDE MAIN", 0, 0);
		////Establish database connection
		//Creating object
		Oracel_Db_Connect Oracledb_Object=new Oracel_Db_Connect();
		//getting  db connection
		Connection db_connection=Oracledb_Object.ConnectToDatabase(username, password, TNS_index, printer);
		
		
		
	 
		
		
		
		
		
		
		//Has to at end
		print.close();
		
	}

}


