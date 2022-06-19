package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.LectureScenario;
import modele.Scenario;

import java.io.File;
import java.io.IOException;

public class ProjetAPLI extends Application{

    public void start(Stage stage) throws IOException {
        HBoxRoot root = new HBoxRoot();
        Scene scene = new Scene(root,950,380);
        stage.setScene(scene);
        stage.setTitle("Projet APLI");
        stage.show();

    }

    public static void main(String[] args){
        Application.launch(args);
    }

}
