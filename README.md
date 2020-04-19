# Post_clone
 **Setting UP Project**

 1. **Get** JavaFX from https://gluonhq.com/products/javafx/ and extract it in folder.
 2. **Copy** every jar in lib folder to project lib folder 
 3. **Add** Thoes jars as user library **Project properties**->**java build path**->**add library**->**add user library**->**name it javafx**->**add all the jars from lib folde**
 4. Then Navigate to **Windows->Preferences->Run Debug->String Substitution->new->**
 5. Add variable named **PATH_TO_FX** and add the path of actual **extracted lib folder**.
 6. Then go to **run configuration->arguments->VM arguments->add** and add **"--module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml"**
 7. **SAVE**
