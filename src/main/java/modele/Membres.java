package modele;

import javafx.scene.Node;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Membres extends Node {
    List<String> membres;
    List <String> villes;

    public Membres(){
        membres = new ArrayList<>();
        villes = new ArrayList<>();
    }

    public String getVille(String string) throws IOException { /* méthode qui nous donne la ville du membre passé en parametre*/
        File[] file = new File("Ressources").listFiles();
        int i = LectureMembre.lectureMembre(file[1]).getMembres().indexOf(string);
        return String.valueOf(LectureMembre.lectureMembre(file[1]).getVilles().get(i));
    }

    public void ajoutMembreVille(String membre, String ville){
        membres.add(membre);
        villes.add(ville);
    }

    public List<String> getMembres(){
        return membres;
    }

    public List<String> getVilles(){
        return villes;
    }

    public String toString(){
        return membres +"\n" + villes;
    }
}
