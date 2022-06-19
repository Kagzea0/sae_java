package modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LectureMembre {

    public static Membres lectureMembre(File file) throws IOException{
        Membres membres = new Membres();
        BufferedReader bufferEntree = new BufferedReader(new FileReader(file));
        String ligne ;
        StringTokenizer tokenizer ;
        do {
            ligne = bufferEntree.readLine ();
            if (ligne != null) {
                tokenizer = new StringTokenizer(ligne ," ");
                membres.ajoutMembreVille(tokenizer.nextToken(),tokenizer.nextToken());
            }
        }
        while (ligne != null );
        bufferEntree.close();
        return membres;
    }
}
