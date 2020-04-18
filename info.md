to get JavaFx working first download javaf from  
https://gluonhq.com/products/javafx/

then extract it in folder 
add every jar in lib folder to project lib folder 
then addd thoes jar by adding them under 

Project properties->java build path->add library->add user library->name it javafx->add all the jars from lib folder
then navigate to 
Windows->Preferences->Run Debug->String Substitution->new->
Add variable named PATH_TO_FX and add the path of actual extracted lib folder
then go to run configuration->arguments->VM arguments->add
--module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml
and save