package modele;

import javafx.scene.Node;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static modele.LectureScenario.lectureScenario;

public class Scenario extends Node {

    List<String> vendeurs;
    List <String> acheteurs;

    public Scenario() {
        vendeurs = new ArrayList<>();
        acheteurs = new ArrayList<>();
    }

    public void ajoutVendeurAcheteur(String vendeur, String acheteur){
        vendeurs.add(vendeur);
        acheteurs.add(acheteur);

    }

    public List<String> getAcheteurs() {
        return acheteurs;
    }

    public List<String> getVendeurs() {
        return vendeurs;
    }



    public HashMap<String,ArrayList> dictionnaire(File fichier) throws IOException{ /* Hashmap qui nous renvoie pour chaque clef le vendeur et la liste de ses acheteurs*/
        Map<String, ArrayList> dictionary = new HashMap<>();
        for (int i = 0 ; i< lectureScenario(fichier).vendeurs.size(); i++){
            dictionary.put(lectureScenario(fichier).vendeurs.get(i),new ArrayList<>());
        }
        for (int i = 0 ; i< lectureScenario(fichier).vendeurs.size(); i++)
            if (dictionary.containsKey(lectureScenario(fichier).vendeurs.get(i))) {
                dictionary.get(lectureScenario(fichier).vendeurs.get(i)).add(lectureScenario(fichier).acheteurs.get(i));
            }
        return (HashMap<String, ArrayList>) dictionary;
    }

    public String affichageScenario(File fichierScenario) throws IOException{ /* méthode qui permet l'affichage du scenario */
        String str = "";
        Membres membres = new Membres();
        Distances distances = new Distances();
        for (int i = 0 ; i< lectureScenario(fichierScenario).vendeurs.size(); i++){
            str = str + (lectureScenario(fichierScenario).vendeurs.get(i) + " - " + lectureScenario(fichierScenario).acheteurs.get(i) + " / " + membres.getVille(lectureScenario(fichierScenario).vendeurs.get(i)) + " - " + membres.getVille(lectureScenario(fichierScenario).acheteurs.get(i))) + " : " + distances.getDistance(membres.getVille(lectureScenario(fichierScenario).vendeurs.get(i)),membres.getVille(lectureScenario(fichierScenario).acheteurs.get(i))) + " km" + "\n" ;
        }
        return str;
    }

    public List<String> getMultipleKeysByValue(HashMap<String, ArrayList> map, String value) {
        return map.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), value))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public int nombreDeParticipantsAuScenario(File file) throws IOException { /* méthode qui nous donne le nombre de membres impliqués dans le scénario*/
        ArrayList list = new ArrayList();
        for (int i =0 ; i < LectureScenario.lectureScenario(file).vendeurs.size(); i++){
            if (list.contains(lectureScenario(file).vendeurs.get(i))==false){
                list.add(LectureScenario.lectureScenario(file).vendeurs.get(i));
            }

        }
        for (int i =0 ; i < lectureScenario(file).acheteurs.size(); i++){
            if (list.contains(lectureScenario(file).acheteurs.get(i))==false){
                list.add(lectureScenario(file).acheteurs.get(i));
            }
        }
        return list.size();
    }


    public ArrayList parcours(HashMap<String,ArrayList> hashMap, List listeVendeur, List listeAcheteur, File file) throws IOException { /* méthode qui nous donne le parcours du scénario*/
        ArrayList list = new ArrayList();
        for (int i =0 ; i < listeVendeur.size(); i++){
            if (list.contains(listeVendeur.get(i))==false){
                Boolean bool = true;
                for (int j=0 ; j < listeVendeur.size(); j++){
                    if (hashMap.get(listeVendeur.get(j)).contains(listeVendeur.get(i))){
                        bool = false;
                    }
                }
                if (bool){
                    list.add(listeVendeur.get(i));
                }
            }

        }
        while (list.size()<nombreDeParticipantsAuScenario(file)){
            for (int i = 0; i < listeAcheteur.size(); i++){
                if (list.contains(listeAcheteur.get(i))==false){
                    Boolean bool = true;
                    for (int j = 0; j<getMultipleKeysByValue(hashMap, String.valueOf(listeAcheteur.get(i))).size(); j++){
                        if (list.contains(getMultipleKeysByValue(hashMap, String.valueOf(listeAcheteur.get(i))))==false){
                            bool = false;
                        }
                    }
                    if (bool){
                        list.add(listeAcheteur.get(i));
                    }
                }

            }
        }
        return  list;
    }



    public String toString() {
        return vendeurs + "\n" + acheteurs;
    }
}