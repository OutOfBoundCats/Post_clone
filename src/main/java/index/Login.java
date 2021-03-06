package index;

import java.io.File;

/**
 * @author praj4
 *
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import com.itextpdf.layout.Document;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.stage.Window;
public class Login {

	static String[] TNS ;
	
	
	public static void setTNS(String[] tNS) {
		TNS = tNS;
	}

	public static String username;
	public static String password;
	public static String TNS_String;
	
	Dictionary TNS_Mapper_login = new Hashtable(); 
	
	public static Cust_Printer printer = null ;
	Document print = null;

	//ComboBox TNS_ComboBox;
	@FXML // fx:id="fruitCombo"
	  public ComboBox<String> TNS_ComboBox;
		public	Button login_button;
		public TextField UserName;
		public PasswordField Password;
		

	public void OnLoginClick() {
		Window owner = login_button.getScene().getWindow();
		username=UserName.getText();
		password=Password.getText();
		TNS_String=TNS_ComboBox.getValue();
		
		System.out.println(username+" "+password+" "+TNS_String);
		if(UserName.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Empty Username", "Please Enter Username");
		}else if(Password.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Empty password", "Please Enter Password");
		}if(TNS_ComboBox.getValue()== null) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Empty TNS details", "Please Enter TNS Details");
		}else if(UserName.getText().isEmpty()==false && Password.getText().isEmpty()==false && TNS_ComboBox.getValue()!= null) {
			UserName.setDisable(true);
			Password.setDisable(true);
			login_button.setDisable(true);
			TNS_ComboBox.setDisable(true);
			/** if VALUES ARE NOT NULL ESTABLISH DATABASE CONNECTION ADN START PRINTER  **/
			TNS_Mapper_login=Main.getTNS_Mapper();
			try {
				//we create printer to which we can print to
				printer = new Cust_Printer();
				printer.Initialize_print();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception occured while initialising printer in main "+e);
				e.printStackTrace();
			}
			System.out.println(TNS_Mapper_login.get(TNS_String).toString());
			printer.cust_print("INSIDE MAIN", 0, 0);
			////Establish database connection
			//Creating object
			Oracel_Db_Connect Oracledb_Object=new Oracel_Db_Connect();
			//getting  db connection
			Connection db_connection=Oracledb_Object.ConnectToDatabase(username, password, TNS_Mapper_login.get(TNS_String).toString(), printer);
			if(db_connection == null) {
				/***Uncomment below lines while using **/
				//AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Check details", "Error establishing databse connection.Please recheck the details entered.");
				//UserName.setDisable(false);
				//Password.setDisable(false);
				//login_button.setDisable(false);
				//TNS_ComboBox.setDisable(false);
				/**END **/
				
				/** Just For testing application this code exist so i can change screen eventhough database error**/
				UserName.setDisable(true);
				Password.setDisable(true);
				login_button.setDisable(true);
				TNS_ComboBox.setDisable(true);
				/**END **/
				
				
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					loadMain();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if(db_connection != null) {
				try {
					loadMain();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		
		
	}
	public  void loadMain() throws IOException {
		
		 ClassLoader classLoader = this.getClass().getClassLoader();
	      // Getting resource(File) from class loader
	      
	      
	      ///Finding the pat of file in resources folder
	      File MainFXML=new File(classLoader.getResource("Main_Screen.fxml").getFile());
	      System.out.println(MainFXML+" Found it ");
		Main.changeScence("file:"+MainFXML);
	}
	
	public void Initialize() {
		TNS_ComboBox.getItems().setAll(TNS);
		
	}

}
