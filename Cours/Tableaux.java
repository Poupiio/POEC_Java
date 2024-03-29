/**
 * Exemple sur les tableaux
 */

package cours_exercices.cours;

// Classe principale
public class Tableaux {
    public static void main(String[] args) {
    	// Declaration d'un tableau sans l'alimenter.
    	String[] t1 = new String[5];
        
    	// Affectation des valeurs à un tableau.
    	// Remarque : le premier indice du tableau est 0.
    	t1[0] = "chaine 1";
    	t1[1] = "chaine 2";
    	t1[2] = "chaine 3";
    	t1[3] = "chaine 4";
    	
		// Affichage d'une valeur d'un tableau.
    	System.out.println(t1[0]);
	        
		// Affichage d'une valeur non attribue d'un tableau (cela est égal à null).
		// Vouloir acceder à un index non inclus dans un tableau génère une exception.
    	System.out.println(t1[4]);
	        
		// Declaration d'un tableau sans declarer son nombre d'elements et alimente directement.
    	String[] tableau = { "Ain", "Aisne", "Allier" };
        
        // Parcours du tableau pour afficher les elements.
    	for (String elem : tableau) {
    		System.out.println(elem);
    	}
        
        // Tableau a deux dimensions.
    	String[][] t2 = new String[5][3];
    	t2[0][0] = "val 00";
    	t2[0][1] = "val 01";
    	t2[0][2] = "val 02";
    	t2[1][0] = "val 10";
    	t2[1][1] = "val 11";
    	t2[1][2] = "val 12";
    	t2[2][0] = "val 20";
    	t2[2][1] = "val 21";
    	t2[2][2] = "val 22";
    	t2[3][0] = "val 30";
    	t2[3][1] = "val 31";
    	t2[3][2] = "val 32";
    	t2[4][0] = "val 40";
    	t2[4][1] = "val 41";
    	t2[4][2] = "val 42";

        // Affichage des dimensions du tableau.
    	System.out.println("Longueur première dimension : " + t2.length);
    	System.out.println("Longueur deuxième dimension : " + t2[0].length);
    	
    	System.out.println();
        
        // Parcours du tableau pour afficher le contenu.
    	for (String[] elem : t2) {
    		for (String element : elem) {
    			System.out.println(element);
    		}
    	}
        
    	System.out.println();
    	
        // Equivalent avec boucle for standard.
    	for (int i = 0; i < t2.length; i++) {
    		for (int j = 0; j < t2[0].length; j++) {
    			System.out.println(t2[i][j]);
    		}
    	}
    }
}