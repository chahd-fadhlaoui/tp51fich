package tPfichier;

import java.io.*;
import static java.lang.System.*;
import java.util.Date;

import java.io.*;
import static java.lang.System.*;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
        out.println("Répertoire courant : " + System.getProperty("user.dir"));
        File rep = new File(".");
        out.println("Chemin relatif : " + rep.getPath());
        out.println("Chemin absolu : " + rep.getAbsolutePath());

        File[] roots = File.listRoots();
        for (File root : roots) {
            out.println("Racine : " + root);
        }

        File[] filesAndDirs = rep.listFiles();
        out.println("Liste des répertoires qui existent dans le répertoire courant:");
        for (File element : filesAndDirs) {
            if (element.isDirectory()) {
                out.println(element.getName() + "\t" + new Date(element.lastModified()) + "\t" + element.length() + " octets");
            }
        }

        out.println("Liste des fichiers qui existent dans le répertoire courant:");
        for (File element : filesAndDirs) {
            if (element.isFile()) {
                out.println(element.getName() + "\t" + new Date(element.lastModified()) + "\t" + element.length() + " octets");
            }
        }

        out.println("Liste des répertoires qui commencent par la lettre 'b':");
        File[] bDirectories = rep.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("b") && new File(dir, name).isDirectory();
            }
        });
        for (File bDir : bDirectories) {
            out.println(bDir.getName() + "\t" + new Date(bDir.lastModified()) + "\t" + bDir.length() + " octets");
        }
    }
}
