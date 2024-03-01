package corriges.exercices.JDBC.Solution1.dao;

import corriges.exercices.JDBC.Solution1.interfaces.IClientDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import corriges.exercices.JDBC.Solution1.modele.Client;

/**
 * Gestion de la Table Clients dans la Base de donnees MySQL
 */
public class ClientDAO implements IClientDAO {
    /**
     * Lire tout le contenu de la table
     * @return une liste de JavaBean Client
     */
    @Override
    public List<Client> lire() {
        List<Client> lc = new ArrayList<>();

        try (Connection conn = Connexion.connecterAvecBase(true);
             ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Clients")) {
            
            while (rs.next()) {
                lc.add(new Client(
                        rs.getInt("id"), rs.getInt("Numero"),
                        rs.getString("nom"), rs.getString("prenom"),
                        rs.getString("email"), rs.getString("adresse")));
            }
        }
        catch (Exception e) {
            System.out.println("Erreur Client - Lire.");
            System.out.println(e);            
        }
        
        return lc;
    }
    
    /**
     * Lire un enregistrement de la table Clients par son id
     * @param id : numero de l'enregistrement dans la table
     * @return un JavaBean Utilisateur s'il existe
     */
    @Override
    public Client lireParId(Integer id) {
        Client c = null;
        
        try (Connection conn = Connexion.connecterAvecBase(true)) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Clients WHERE id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new Client(
                        rs.getInt("id"), rs.getInt("Numero"),
                        rs.getString("nom"), rs.getString("prenom"),
                        rs.getString("email"), rs.getString("adresse"));
            }

            rs.close();
        }
        catch (Exception e) {
            System.out.println("Erreur Client - LireParId.");
            System.out.println(e);            
        }
        
        return c;
    }
    
        /**
     * Lire un enregistrement de la table Clients par son numero
     * @param numero : numero de l'enregistrement dans la table
     * @return un JavaBean Utilisateur s'il existe
     */
    @Override
    public Client lireParNumero(Integer numero) {
        Client c = null;
        
        try (Connection conn = Connexion.connecterAvecBase(true)) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Clients WHERE numero = ?");
            ps.setInt(1, numero);
	    
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                c = new Client(
                    rs.getInt("id"), rs.getInt("Numero"),
                    rs.getString("nom"), rs.getString("prenom"),
                    rs.getString("email"), rs.getString("adresse"));
            }
	    
            rs.close();
        }
        catch (Exception e) {
            System.out.println("Erreur Client - LireParNumero.");
            System.out.println(e);            
        }
        
        return c;
    }
    
    /**
     * Lire un enregistrement de la table Clients par son numero
     * @param id : id de l'enregistrement 
     * @param numero : numero du client
     * @return un JavaBean Client s'il existe
     */
    @Override
    public Client chercheNumeroExistant(Integer id, Integer numero) {
        Client c = null;
        
        try (Connection conn = Connexion.connecterAvecBase(true)) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Clients WHERE id <> ? AND numero = ?");
            ps.setInt(1, id);
            ps.setInt(2, numero);
	    
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                c = new Client(
                    rs.getInt("id"), rs.getInt("Numero"),
                    rs.getString("nom"), rs.getString("prenom"),
                    rs.getString("email"), rs.getString("adresse"));
            }
	    
            rs.close();
        }
        catch (Exception e) {
            System.out.println("Erreur Articles - chercheNumeroExistant.");
            System.out.println(e);            
        }
        
        return c;
    }    
    
    /**
     * Suppression d'un client
     * @param id : numero de l'enregistrement dans la table
     * @return true si la suppression est Ok
     */
    @Override
    public boolean suppressionParId(Integer id) {
        try (Connection conn = Connexion.connecterAvecBase(true)) {
            // On supprime une occurrence
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Clients WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();

            // On "comble le trou" s'il y en a un
            // (ce qui n'est pas toujours souhaitable)
            ps = conn.prepareStatement("UPDATE Clients SET id = id-1 WHERE id > ?");
            ps.setInt(1, id);
            ps.executeUpdate();

            // On r�initialise l'auto_increment
            // (cela permettra au prochaine occurrence de suivre la plus grande valeur du champ auto incr�ment� enregistr� dans la table)
            ps = conn.prepareStatement("ALTER TABLE Clients AUTO_INCREMENT = 0");
            ps.executeUpdate();
            return true;
        }
        catch (Exception e) {
            System.out.println("Erreur Clients - SuppressionParId.");
            System.out.println(e);            
            return false;
        }
    }
    
    /**
     * Modifie un client
     * @param c : Un JavaBean Client
     * @return true si la modification est Ok
     */
    @Override
    public boolean modifier(Client c) {
        try (Connection conn = Connexion.connecterAvecBase(true)) {
            PreparedStatement ps = conn.prepareStatement("UPDATE Clients SET id = ?, numero = ?, nom = ?, prenom = ?, email = ?, adresse = ? WHERE id = ?");
            ps.setInt(1, c.getId());
            ps.setInt(2, c.getNumero());
            ps.setString(3, c.getNom());
            ps.setString(4, c.getPrenom());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getAdresse());
            ps.setString(7, c.getId().toString());
            ps.executeUpdate();
            return true;
	}
        catch (Exception e) {
            System.out.println("Erreur Clients - Modifier.");
            System.out.println(e);
            return false;
        }
    }
    
    /**
     * Creer un client
     * @param c : un JavaBean Client
     * @return true si la creation est Ok
     */
    @Override
    public boolean creer(Client c) {
        try(Connection conn = Connexion.connecterAvecBase(true)) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Clients VALUES (DEFAULT, ?, ?, ?, ?, ?)");
            ps.setInt(1, c.getNumero());
            ps.setString(2, c.getNom());
            ps.setString(3, c.getPrenom());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getAdresse());
            ps.executeUpdate();
            return true;
        }
        catch (Exception e) {
            System.out.println("Erreur Clients - Creer.");
            System.out.println(e);            
            return false;
        }
    }
    
    /**
     * Controle si les parametres sont correct
     * @param c : JavaBean Client
     * @return true si la verification est Ok
     */
    @Override
    public String validation(Client c) {
        if (c.getNumero() <= 0) return "Le numero doit etre un entier positif.";
        if ("".equals(c.getNom())) return "Le nom ne doit pas etre vide.";
        if ("".equals(c.getPrenom())) return "Le prenom ne doit pas etre vide.";
        if (c.getEmail() == null || "".equals(c.getEmail())) return "L'email ne doit pas etre vide.";
        if (!c.getEmail().contains("@")) return "L'email doit contenir un @.";
        if ("".equals(c.getAdresse())) return "L'adresse ne doit pas etre vide.";
        if (chercheNumeroExistant(c.getId(), c.getNumero()) != null) return "Le numero de l'article existe deja.";
        return "";
    }
}