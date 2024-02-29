/**
 * Exercices Stream
 * 
 * Creer 3 methodes pour les choses suivantes puis executez les dans le programme principal.
 * - Calcul et affiche le nombre de fois qu'un caractere apparait dans une chaine.
 * - Filtre et affiche les mots commencant par une lettre donnee.
 * - Converti une chaine representant une liste de nombres separes par un ;
 *   le resulat doit comporter ces nombres sur une longueur fixe de 4 caracteres et separer par une , 
 * - Mettre en majuscule chaque mot d'une phrase apres avoir supprime les espaces en trop dans celle-ci.
 */ 

package cours_exercices.exercices.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// Class ExStream
public class ExStream {
    
    public static void main(String[] args) {
    	// Calcul et affiche le nombre de fois qu'un caractere apparait dans une chaine.
    	List<String> maListe = new ArrayList<>();
        maListe.add("Je suis une chaîne de caractères.");

        Stream<String> stream = maListe.stream();

        // Filtre et affiche les mots commencant par une lettre donnee.
        stream
        	.filter(c -> c.startsWith("s"))
            .forEach(c -> System.out.println(c))
        ;
    	
    	// Converti et affiche une chaine representant une liste de nombres separe par un ;
    	// Le resultat doit comporter ces nombres sur une longueur fixe de 4 caracteres et separer par une ,
    	
    	// Met en majscule la premiere lettre d'un mot.
    	
    	// Met en majscule chaque mot d'une phrase apres avoir supprime les espaces en trop dans celle-ci.
    }
}
