/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BackEnd.RequeteOrganisateur;
import Model.Artiste;
import Model.Theme;
import Model.Expert;
import Model.Numero;
import Model.Spectacle;
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
        //this.listeExperts = dao.getAllExperts();
    }
    
    public void ajouteExpert(Expert expert) {
        //dao.ajouteExpert(expert);
    }
    
    public void ajouteArtiste(Artiste artiste) {
        //dao.ajouteArtiste(artiste);
    }
    
    public void ajouteSpectacle(Spectacle spectacle) {
        //dao.ajouteSpectacle(spectacle);
    }  
    
    public void ajouteNumero(Numero numero) {
        //dao.ajouteNumero(numero);
        
        ArrayList<Expert> liste1 = new ArrayList<>(); // expert du même thème
        ArrayList<Expert> liste2 = new ArrayList<>(); // expert d'un theme différent
        RequeteOrganisateur req = new RequeteOrganisateur();
        Theme theme = numero.getTheme();
        
        for(Expert exp : listeExperts) {
            if(exp.getThemes().contains(theme) && liste1.size() < 3) {
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
            System.out.println("Saisissez un expert à la main :");
            if (liste1.size() < 3) {
                System.out.println("Voici la liste des experts :");
                req.getExpertsAvailable(liste1);
            }
        } else {

            for (int i = 0; i < liste1.size(); i++) {
                req.associeNumeroExpert(liste1.get(i), numero);
                //Incrémenter le nombre de numéros
                liste1.get(i).ajouteNumero(numero); // DONE ?
            }
            for (int j = 0; j < liste2.size(); j++) {
                req.associeNumeroExpert(liste2.get(j), numero);
                liste2.get(j).ajouteNumero(numero);
            }
        }
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
