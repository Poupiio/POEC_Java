/**
 * Exemple sur les atributs et les methodes static
 */

package cours_exercices.cours;

// Classe de test pour les attributs et methodes statiques
class Test {
    // Proprietes
	public static int a = 5;
	public static int b = 2;
    
    // Methode simple utilisant l'attribut statique de la classe
	// Methode static appelable sans creer un objet.
	public static void methodeSimple(int a, int b) {
		System.out.println("Methode simple utilisant l'attribut statique de la classe");
	}
    
}

// Classe principale
public class Statique {
    public static void main(String[] args) {
        // Acces a la methode static sans avoir a creer d'objet.
        // Comme pour l'appel d'une methode de la classe Math.
    	
    	Test.methodeSimple(10, 20);
    	
    	// Accès aux propriétés statiques de la classe Test
        System.out.println("a : " + Test.a);
        System.out.println("b : " + Test.b);
    }
}
