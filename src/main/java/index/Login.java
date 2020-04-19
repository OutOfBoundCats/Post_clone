package index;



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

	//ComboBox TNS_ComboBox;
	@FXML // fx:id="fruitCombo"
	  public ComboBox<String> TNS_ComboBox;
		public	Button login_button;
		public TextField UserName;
		public PasswordField Password;
		
	public Login() {
		// TODO Auto-generated constructor stub
		//TNS_ComboBox.getItems().setAll(TNS);
		//TNS_ComboBox.getItems().setAll(TNS);
		
		
	}
	public void on() {
		//UserName.setRotate(1);
	    //login_button.setEnabled(false);;
		
		//TNS_ComboBox.getItems().setAll(TNS);
		String Com_Value=(String)TNS_ComboBox.getValue();
		System.out.println("Hello "+Com_Value);
		
	}
	
	public void OnLoginClick() {
		Window owner = login_button.getScene().getWindow();
		username=UserName.getText();
		password=Password.getText();
		TNS_String=TNS_ComboBox.getValue();
		Main.setPassword(password);
		Main.setUsername(username);
	    Main.setTNS_String(TNS_String);
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
		}
		
		
		
		
	}
	
	public void Initialize() {
		TNS_ComboBox.getItems().setAll(TNS);
		
	}

}
