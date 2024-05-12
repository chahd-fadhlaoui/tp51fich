package tPfichier;

import java.io.*;

class Filtre implements FilenameFilter {
    private char lettre;

    public Filtre(char lettreDebut) {
        lettre = lettreDebut;
    }

    public boolean accept(File repFiltre, String nom) {
        File fichier = new File(repFiltre, nom);
        return nom.charAt(0) == lettre && fichier.isDirectory();
    }
}
