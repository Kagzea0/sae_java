package vue;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import modele.Distances;
import modele.LectureScenario;
import modele.Membres;
import modele.Scenario;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TextAreaScenario2 extends GridPaneAPLI {
    TextArea textArea;
    Button bouton;

    TextArea textAreaParcours;

    TextAreaScenario2() throws IOException {
        textArea = new TextArea();
        Scenario scenario = new Scenario();
        File[] fichiersScenarios = new File("Scenario").listFiles();
        textArea.appendText(scenario.affichageScenario(fichiersScenarios[2]));
        this.add(textArea,8,4,4,10);
        bouton = new Button("<");
        this.add(bouton,0,0,2,1);
        menu.setText("Scénario 1.2");
        textAreaParcours = new TextArea();
        this.add(textAreaParcours, 8, 16, 4, 4);
        String str = "Parcours du scénario 1.2 : ";
        ArrayList listeScenario = scenario.parcours(scenario.dictionnaire(fichiersScenarios[2]), LectureScenario.lectureScenario(fichiersScenarios[2]).getVendeurs(), LectureScenario.lectureScenario(fichiersScenarios[2]).getAcheteurs(),fichiersScenarios[2]);
        int taille_liste =listeScenario.size();
        for (int i = 0; i< taille_liste; i++){
            str = str + listeScenario.get(i) + " - ";
        }
        int km = 0;
        Distances distances = new Distances();
        Membres membres = new Membres();
        for (int i = 1; i<taille_liste;i++){
            String distance = distances.getDistance( membres.getVille(String.valueOf(listeScenario.get(i-1))), membres.getVille(String.valueOf(listeScenario.get(i))));
            km = km + Integer.parseInt(distance);
        }
        str = str + "\n" + "Distance totale : " + km + " km";
        textAreaParcours.appendText(str);
    }
}
