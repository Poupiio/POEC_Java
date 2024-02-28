/**
 * Exemple sur les enumerations
 */

package corriges.cours;

// Enumeration simple
// Avec enum on ne cree pas autant de constante qu'il y a de jours.
// On cree un ensemble de constantes affectees a un seul nom.
enum Jours { LUNDI, MARDI, MERCREDI }


// Enumeration
enum JourSemaine {
    // Constantes a mettre en premier et terminer par ";"
    LUNDI ("lu"), MARDI ("ma"), MERCREDI ("me"), JEUDI ("je"), VENDREDI ("ve"), SAMEDI ("sa"), DIMANCHE ("di");
    
    // Attribut
    private final String abrege;
    
    // Constructeur permettant d'attribuer l'abrevation
    private JourSemaine(String abrege) {
        this.abrege = abrege;
    }
    
    // Methode
    public String abreviation() {
        return this.abrege;
    }
}

// Classe sans enumerations
class SansEnum {
    // Attributs
    private static final int LUNDI = 0;
    private static final int MARDI = 1;
    private static final int MERCREDI = 2;

    // Methode
    public void methodeTest(int maDonnee) {
        if (maDonnee == LUNDI) System.out.println(LUNDI);
        if (maDonnee == MARDI) System.out.println(MARDI);
        if (maDonnee == MERCREDI) System.out.println(MERCREDI);
    }
}

// Classe principale
public class Enumerations {
    // Methode
    private void methodeTest(Jours quelJour) {
        switch (quelJour) {
            case LUNDI -> System.out.println(Jours.LUNDI); // retourne la valeur
            case MARDI -> System.out.println(Jours.MARDI);
            case MERCREDI -> System.out.println(Jours.MERCREDI.ordinal()); // retourne l'index de la valeur
            default -> System.out.println("Autre jour");
        }
    }

    // Methode principale
    public static void main(String[] args) {
        SansEnum se = new SansEnum();
        Enumerations e = new Enumerations();
        
        se.methodeTest(1);
        e.methodeTest(Jours.MARDI);
        e.methodeTest(Jours.MERCREDI);
        
        // Parcour toutes les valeurs de l'enumeration
        for (JourSemaine js : JourSemaine.values()) {
            System.out.println(js + " : " + js.abreviation());
        }
    }
}