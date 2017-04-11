/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataAccessLayer.ConnectionSQL;
import Model.Artiste;
import Model.DataTransfertObject.ArtisteDAO;
import Model.DataTransfertObject.ArtisteDAOSQL;
import Model.DataTransfertObject.EvaluationDAO;
import Model.DataTransfertObject.EvaluationDAOSQL;
import Model.DataTransfertObject.ExpertDAO;
import Model.DataTransfertObject.ExpertDAOSQL;
import Model.DataTransfertObject.SpectacleDAO;
import Model.DataTransfertObject.SpectacleDAOSQL;
import Model.Expert;
import Model.Numero;
import Model.Spectacle;
import Model.Theme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author nomezing
 */
public class OrganisateurController extends MainController {

    private ExpertDAO expertDAO = new ExpertDAOSQL();

    private ArtisteDAO artisteDAO = new ArtisteDAOSQL();

    private EvaluationDAO evaluationDAO = new EvaluationDAOSQL();

    private SpectacleDAO spectacleDAO = new SpectacleDAOSQL();

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
     * Quand l'organisateur ajoute un numero, l'application va proposer des
     * experts pour ce numéro par les étapes: 1. Récuppérer le thème du numéro
     * 2. Récuppérer les experts libres (qui n'ont pas validé suffit de 15
     * numéros) de ce thème: listeSpecialites 3. Récuppérer les experts libres
     * hors de ce thème: listeNonSpecialites 4. Si un de ces deux listes est
     * invalide (listeSpecialites.size() < 3 || listeNonSpecialites.size() < 2)
     * l'organisateur va saisir un jury pour ce numéro à la main 5. Si non
     * Associer ce numéro avec 3 experts de la listeSpecialites Associer ce
     * numéro avec 2 experts de la listeNonSpecialites
     *
     */
    public void ajouteNumero(Numero numero) {
        ConnectionSQL.savePoint();
        List<Expert> listeSpecialites = new ArrayList<Expert>(); // expert du même thème
        List<Expert> listeNonSpecialites = new ArrayList<Expert>(); // expert d'un theme différent
        Collection<Expert> listeExperts = expertDAO.getAllExpert();
        
        Theme theme = numero.getTheme();

        for (Expert exp : listeExperts) {
            if (exp.getThemes().contains(theme) && listeSpecialites.size() < 3) {
                if (exp.getNbrNumeros() < 15) {
                    listeSpecialites.add(exp);
                }
            } else {
                if (listeNonSpecialites.size() < 2) {
                    if (exp.getNbrNumeros() < 15) {
                        listeNonSpecialites.add(exp);
                    }
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
