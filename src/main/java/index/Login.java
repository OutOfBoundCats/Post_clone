package index;

import java.awt.Button;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
public class Login {
	String[] TNS = {
			"DEV", 
			"STG", 
			"PROD", 
			"VCP"
			};

	//ComboBox TNS_ComboBox;
	@FXML // fx:id="fruitCombo"
	  private ComboBox<String> TNS_ComboBox;
	Button login_button;
	TextField UserName;
	public Login() {
		// TODO Auto-generated constructor stub
		//TNS_ComboBox.getItems().setAll(TNS);
		
	}
	public void on() {
		//UserName.setRotate(1);
	    //login_button.setEnabled(false);;
		TNS_ComboBox.getItems().setAll(TNS);
		
		String Com_Value=(String)TNS_ComboBox.getValue();
		System.out.println("Hello "+Com_Value);
		
	}

}
