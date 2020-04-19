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
	public static String username;
	public static String password;
	public static String TNS_String;
	
	public static void setTNS_String(String tNS) {
		TNS_String = tNS;
	}




	public static void setUsername(String username) {
		Main.username = username;
	}


	public static void setPassword(String password) {
		Main.password = password;
	}



	@Override
    public void start(Stage stage) throws Exception{
		Main m=new Main();
		Class cls = m.getClass();
		URL url = cls.getResource("Login.fxml");
	      System.out.println("Value = " + url);
	      
	    stage.setTitle("RClone");
	    /*** Loading Login screen in memory **/
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:C:/Users/praj4/Desktop/SId/Post_clone/target/classes/Login.fxml")); 
        Login.setTNS(TNS);
        
       
        /*** Loading main screen in memory **/
        FXMLLoader Main_Screen_loader = new FXMLLoader();
        Main_Screen_loader.setLocation(new URL("file:C:/Users/praj4/Desktop/SId/Post_clone/target/classes/Main_Screen.fxml"));
        /*** Setting scene  **/
        Scene scene=new Scene((Parent) loader.load());
        stage.setScene(scene);
        /*** Displaying scene **/
        stage.show();
        System.out.println("In mainmethod "+username);
      
    }

		    
      
		
		  
	
	

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		
		// finds resource relative to the class location
	      
		
		Cust_Printer printer = null ;
		Document print = null;
		
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


