/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.Factory;
import BackEnd.RequeteOrganisateur;
import Model.Business.Artiste;
import Model.Business.Enum_theme;
import Model.Business.Expert;
import Model.Business.Numero;
import Model.Business.Spectacle;
import Model.DataAccessLayer.DAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author nomezing
 */
public class OrganisateurViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private Collection<Expert> listeExperts;
    
    public OrganisateurViewController() {
        DAO dao = Factory.getDAO();
        this.listeExperts = dao.getAllExperts();
    }
    
    public void ajouteExpert(Expert expert) {
        DAO dao = Factory.getDAO();
        dao.ajouteExpert(expert);
    }
    
    public void ajouteArtiste(Artiste artiste) {
        DAO dao = Factory.getDAO();
        dao.ajouteArtiste(artiste);
    }
    
    public void ajouteSpectacle(Spectacle spectacle) {
        DAO dao = Factory.getDAO();
        dao.ajouteSpectacle(spectacle);
    }  
    
    public void ajouteNumero(Numero numero) {
        DAO dao = Factory.getDAO();
        dao.ajouteNumero(numero);
        
        ArrayList<Expert> liste1 = new ArrayList<>(); // expert du même thème
        ArrayList<Expert> liste2 = new ArrayList<>(); // expert d'un theme différent
        RequeteOrganisateur req = new RequeteOrganisateur();
        Enum_theme theme = numero.getTheme();
        
        for(Expert exp : listeExperts) {
            if(exp.getTheme().equals(theme) && liste1.size() < 3) {
                if(exp.getNbrNumeros() < 15)
                    liste1.add(exp);
            } else {
                if(liste2.size() < 2) {
                    if(exp.getNbrNumeros() < 15)
                        liste2.add(exp);
                }
            }
        }
        
        if (liste1.size() < 3 || liste2.size() < 2) {
            //TODO: Gérer l'ajout d'expert à la main
            System.out.println("Saisissez un jury à la main :");
        }
        
        for(int i = 0; i < liste1.size(); i++) {
            req.associeNumeroExpert(liste1.get(i), numero);
            //Incrémenter le nombre de numéros
            //MAJ BD
        }
        for(int j = 0; j < liste2.size(); j++) {
            req.associeNumeroExpert(liste2.get(j), numero);
        }
    }
    
    public void a() {
     
    }
    
    /**
     * Quand l'organisateur ajoute un numero, l'application va proposer des experts
     * pour ce numéro par les étapes:
     * 1. Récuppérer le thème du numéro
     * 2. Récuppérer les experts libres (qui n'ont pas validé suffit de 15 numéros)
     *    de ce thème: liste1
     * 3. Récuppérer les experts libres hors de ce thème: liste2
     * 4. Si un de ces deux listes est invalide (liste1.size() < 3 || liste2.size() < 2)
     *      l'organisateur va saisir un jury pour ce numéro à la main
     * 5. Si non
     *      Associer ce numéro avec 3 experts de la liste1
     *      Associer ce numéro avec 2 experts de la liste2
     *  
     */
}
