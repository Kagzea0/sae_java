package modele;

import java.util.Map;

import static java.util.Map.entry;

public interface NomItem {
    final String [] NOM_ITEM_MENU = {"Scénario 0", "Scénario 1.1", "Scénario 1.2", "Scénario 2.1", "Scénario 2.2"};

    final Map <String, Integer> INDICES = Map.ofEntries(entry("Amiens",0), entry("Angers",1), entry("Biarritz",2), entry("Bordeaux",3), entry("Brest",4),entry("Calais",5), entry("Cherbourg",6), entry("Clermond_Fd",7), entry("Dijon",8),entry("Grenoble",9), entry("Le_Havre",10), entry("Lille",11),entry("Lyon",12),entry("Marseille",13),entry("Montpellier",14),entry("Nancy",15),entry("Nantes",16),entry("Nice",17),entry("Paris",18),entry("Perpignan",19),entry("Reims",20),entry("Rennes",21),entry("Rouen",22),entry("Saint-Etienne",23),entry("Strasbourg",24),entry("Toulouse",25),entry("Tours",26), entry("Vichy",27), entry("Velizy",28));
}
