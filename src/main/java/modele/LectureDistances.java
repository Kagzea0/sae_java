package modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class LectureDistances {
    public static Distances lectureDistances (File fichier) throws IOException {
        Distances distances1 = new Distances();

        BufferedReader bufferEntree = new BufferedReader(new FileReader(fichier));
        String ligne ;
        StringTokenizer tokenizer ;
        do {
            ligne = bufferEntree.readLine ();
            if (ligne != null) {
                ArrayList arrayList = new ArrayList<>();
                tokenizer = new StringTokenizer(ligne ," ");
                for (int i =0; i<30; i++){
                    arrayList.add(tokenizer.nextToken());
                }
                distances1.ajoutDistances(arrayList);
            }
        }
        while (ligne != null );
        bufferEntree.close();
        return distances1;
    }
}
