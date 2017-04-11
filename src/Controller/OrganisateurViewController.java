/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataAccessLayer.ConnectionSQL;
import Model.DataTransfertObject.*;
import Model.Artiste;
import Model.Theme;
import Model.Expert;
import Model.Numero;
import Model.Spectacle;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author nomezing
 */
public class OrganisateurViewController extends MainController implements Initializable {

    private ExpertDAO expertDAO = new ExpertDAOSQL();
    
    private ArtisteDAO artisteDAO = new ArtisteDAOSQL();
    
    private EvaluationDAO evaluationDAO = new EvaluationDAOSQL();
    
    private SpectacleDAO spectacleDAO = new SpectacleDAOSQL();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private Collection<Expert> listeExperts = expertDAO.getAllExpert();
    /**
     * 
     * @param expert : expert to add in the festival 
     */
    public void ajouteExpert(Expert expert) {
        ConnectionSQL.savePoint();
        expertDAO.insert(expert);
        ConnectionSQL.commit();
    }
    /**
     * 
     * @param artiste : to add to the festival 
     */
    public void ajouteArtiste(Artiste artiste) {
        ConnectionSQL.savePoint();
        artisteDAO.insert(artiste);
        ConnectionSQL.commit();
    }
    /**
     * 
     * @param spectacle : show to add to the festival 
     */
    public void ajouteSpectacle(Spectacle spectacle) {
        ConnectionSQL.savePoint();
        spectacleDAO.insert(spectacle);
        ConnectionSQL.commit();
    }
    
    public boolean ajouteNumeroASpectacle(Numero num, Spectacle spectacle, int heure) {
        int duree = spectacle.getFin() - spectacle.getDebut();
        
        // Garantit la durée des spectalces
        if ((duree + num.getDuree()) > 540) {
            return false;
        }
        
        return spectacleDAO.addNumero(spectacle, num, heure);
    }
    
    /**
     * Quand l'organisateur ajoute un numero, l'application va proposer des experts
     * pour ce numéro par les étapes:
     * 1. Récuppérer le thème du numéro
     * 2. Récuppérer les experts libres (qui n'ont pas validé suffit de 15 numéros)
     *    de ce thème: listeSpecialites
     * 3. Récuppérer les experts libres hors de ce thème: listeNonSpecialites
     * 4. Si un de ces deux listes est invalide (listeSpecialites.size() < 3 || listeNonSpecialites.size() < 2)
     *      l'organisateur va saisir un jury pour ce numéro à la main
     * 5. Si non
     *      Associer ce numéro avec 3 experts de la listeSpecialites
     *      Associer ce numéro avec 2 experts de la listeNonSpecialites
     *  
     */
    
    public void ajouteNumero(Numero numero) {
        ConnectionSQL.savePoint();
        List<Expert> listeSpecialites = new ArrayList<Expert>(); // expert du même thème
        List<Expert> listeNonSpecialites = new ArrayList<Expert>(); // expert d'un theme différent
        
        Theme theme = numero.getTheme();
        
        for(Expert exp : listeExperts) {
            if(exp.getThemes().contains(theme) && listeSpecialites.size() < 3) {
                if(exp.getNbrNumeros() < 15)
                    listeSpecialites.add(exp);
            } else {
                if(listeNonSpecialites.size() < 2) {
                    if(exp.getNbrNumeros() < 15)
                        listeNonSpecialites.add(exp);
                }
            }
        }
        
        if (listeSpecialites.size() < 3 || listeNonSpecialites.size() < 2) {
            ajouteExpertALaMain(numero);
        } else {
            for (int i = 0; i < listeSpecialites.size(); i++) {
                evaluationDAO.insert(numero, "" + listeSpecialites.get(i).getId());
                //Incrémenter le nombre de numéros
                listeSpecialites.get(i).ajouteNumero(numero);
                expertDAO.update(listeSpecialites.get(i));
            }
            for (int i = 0; i < listeNonSpecialites.size(); i++) {
                //Incrémenter le nombre de numéros
                listeNonSpecialites.get(i).ajouteNumero(numero);
                expertDAO.update(listeNonSpecialites.get(i));
            }
        }
        ConnectionSQL.commit();
    }
     
    private void ajouteExpertALaMain(Numero numero) {
        //TODO: Gérer l'ajout d'expert à la main
    }

}
