package corriges.exercices.JDBC.Solution1.dao;

import java.sql.*;

import corriges.exercices.JDBC.Solution1.main.Constantes;

/**
 * Connexion a MySQL
 */
public class Connexion {
    /**
     * Connexion � MySQL avec ou sans base de donn�es
     * @param bdd Le nom de la base de donn�es (peut �tre null pour une connexion sans base)
     * @return la connexion si Ok
     * @throws Exception : message d'erreur personnalis� si besoin.
     */
    public static Connection connecterAvecBase(Boolean bdd) throws Exception {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            if (bdd) url += Constantes.MABDD;
            url += "?useSSL=false";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, "root", "");
        }
        catch (ClassNotFoundException | SQLException e) {
            String message = (bdd == true) ? "Connexion � la BDD (" + Constantes.MABDD + ") impossible." : "Connexion � MySQL impossible.";
            throw new Exception(message);
        }
    }
}
