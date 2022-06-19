package vue;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import modele.Distances;
import modele.LectureScenario;
import modele.Membres;
import modele.Scenario;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static modele.LectureScenario.lectureScenario;

public class TextAreaScenario1 extends GridPaneAPLI {
    TextArea textArea;
    Button bouton;

    TextArea textAreaParcours;
    TextAreaScenario1() throws IOException {

        textArea = new TextArea();
        Scenario scenario = new Scenario();
        File[] fichiersScenarios = new File("Scenario").listFiles();
        textArea.appendText(scenario.affichageScenario(fichiersScenarios[1]));
        this.add(textArea,8,4,4,10);
        bouton = new Button("<");
        this.add(bouton,0,0,2,1);
        menu.setText("Scénario 1.1");
        textAreaParcours = new TextArea();
        this.add(textAreaParcours, 8, 16, 4, 4);
        String str = "Parcours du scénario 1.1 : ";
        ArrayList listeScenario = scenario.parcours(scenario.dictionnaire(fichiersScenarios[1]), LectureScenario.lectureScenario(fichiersScenarios[1]).getVendeurs(), LectureScenario.lectureScenario(fichiersScenarios[1]).getAcheteurs(),fichiersScenarios[1]);
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
