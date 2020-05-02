package index;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.lang.*;

import com.itextpdf.layout.Document;
import java.sql.Connection;
import java.util.Dictionary;
import java.util.Hashtable;

import org.springframework.util.ResourceUtils;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
	public static Dictionary TNS_Mapper = new Hashtable(); 
	public static Stage MainScreen=null;
	public static Stage stage;
	
	
	public static Dictionary getTNS_Mapper() {
		return TNS_Mapper;
	}








	@Override
    public void start(Stage stage1) throws Exception{
		Main m=new Main();
		stage=stage1;
		
	      
	      ClassLoader classLoader = this.getClass().getClassLoader();
	      // Getting resource(File) from class loader
	      
	      
	      ///Finding the pat of file in resources folder
	      File configFile=new File(classLoader.getResource("RClone_Icon.png").getFile());
	      System.out.println(configFile+" Found it ");
	      
	     // Image icon=new Image("file:C:/Users/praj4/Desktop/SId/Post_clone/target/classes/RClone_Icon.png");
	      Image icon=new Image("file:"+configFile);
	      stage.getIcons().add(icon);
	     
	      
	    stage.setTitle("RClone");
	    /*** Loading Login screen in memory **/
		FXMLLoader loader = new FXMLLoader();
		File LoginFXML=new File(classLoader.getResource("Login.fxml").getFile());
	      System.out.println(LoginFXML+" Found it ");
        loader.setLocation(new URL("file:"+LoginFXML)); 
        Login.setTNS(TNS);
        
       
        /*** Setting scene  **/
        Scene scene=new Scene((Parent) loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        /*** Displaying scene **/
        stage.show();
        
      
    }
	
	public static void changeScence(String path) throws IOException {
//		MainScreen=new Stage();
//		MainScreen.setTitle("RCloe");
//		Image icon=new Image("file:C:/Users/praj4/Desktop/SId/Post_clone/target/classes/RClone_Icon.png");
//		MainScreen.getIcons().add(icon);
		FXMLLoader Main_Screen_loader = new FXMLLoader();
        Main_Screen_loader.setLocation(new URL(path));
        /*** Setting scene  **/
        Scene scene=new Scene((Parent) Main_Screen_loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        /*** Displaying scene **/
        stage.show();
		
		
	}

		    
      
		
		  
	
	

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		
		// finds resource relative to the class location
	      
		
		TNS_Mapper.put("DEV", "Dev_key");
		TNS_Mapper.put("STG", "STG_key");
		TNS_Mapper.put("PROD", "prd_ikey");
		TNS_Mapper.put("VCP", "VCP_key");
		
		Cust_Printer printer = null ;
		Document print = null;
		
		int TNS_index = 0;
		
		
		/**       UI             **/
		launch(args);
		
		
		
		//Has to at end
		Cust_Printer.getDocument().close();
		
	}

}


