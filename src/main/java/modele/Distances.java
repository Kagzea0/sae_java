package modele;

import javafx.scene.Node;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Distances extends Node {
    List<List> distances;

    public Distances(){
        distances = new ArrayList<>();
    }

    public void ajoutDistances(List distance){
        distances.add(distance);

    }

    public String getDistance(String ville1, String ville2) throws IOException { /* méthode qui nous donne la distance entre deux villes passées en paramètre */
        File[] files = new File("Ressources").listFiles();
        int i = NomItem.INDICES.get(ville1);
        int j = NomItem.INDICES.get(ville2);
        return String.valueOf(LectureDistances.lectureDistances(files[0]).getDistances().get(i).get(j+1));
    }

    public List<List> getDistances(){
        return distances;
    }

    public String toString(){
        return distances + "\n";
    }
}
