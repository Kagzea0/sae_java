package vue;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import modele.LectureMembre;

import java.io.File;
import java.io.IOException;

public class GridPaneAPLI extends GridPane {
    MenuBar menuBar;

    Menu menu;
    TextArea textArea;

    public GridPaneAPLI() throws IOException {

        menu = new Menu("Accueil");
        menuBar = new MenuBar(menu);
        this.add(menuBar,2,1,4,1);

        Separator separator1 = new Separator();
        this.add(separator1,2,2,4,2);

        textArea = new TextArea();
        this.add(textArea,2,7,4,15);

        Label label = new Label("Liste des membres de l'APLI et leur ville");
        this.add(label,2,5,4,1);

        File[] files = new File("Ressources").listFiles();

        for (int i = 0; i< LectureMembre.lectureMembre(files[1]).getMembres().size();i++){
            textArea.appendText(LectureMembre.lectureMembre(files[1]).getMembres().get(i) + " " + LectureMembre.lectureMembre(files[1]).getVilles().get(i) + "\n");
        }

        }



}
