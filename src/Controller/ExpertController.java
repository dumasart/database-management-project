/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Numero;
import Model.DataTransfertObject.EvaluationDAO;
import Model.DataTransfertObject.EvaluationDAOSQL;
import Model.DataTransfertObject.ExpertDAO;
import Model.DataTransfertObject.ExpertDAOSQL;
import Model.DataTransfertObject.NumeroDAO;
import Model.DataTransfertObject.NumeroDAOSQL;
import Model.Evaluation;
import Model.Expert;
import java.util.List;

/**
 * Classe mère pour les controleurs Experts
 * @author nomezing
 */
public class ExpertController extends MainController {
    
    /**
     * NumeroDAO utilisé pour récupérer la liste de numéros
     * à évaluer par l'expert
     */
    private NumeroDAO numeroDAO = new NumeroDAOSQL();
    
    /**
     * EvaluationDAO utilisé par le controleur expert pour 
     * ajouter des commentaires dans la base de données
     */
    private EvaluationDAO evaluationDAO = new EvaluationDAOSQL();  
     
    /**
     * L'expert qui s'est connecté à l'application 
     */
    private ExpertDAO expertDAO = new ExpertDAOSQL();
    
    
    private Expert expertConnecte;
    
    //List<Numero> listeNumero = numeroDAO.getNumeroByExpert(getExpertConnecte());
    
    
    
    public Expert getExpertConnecte() {
        if(expertConnecte == null) {
            int id = Integer.parseInt(this.getConnectedUser().getIdentifiant());
            expertConnecte = expertDAO.getExpertByID(id);
        }
        return expertConnecte;
    }
    
    /**
     * 
     * @return 
     */
    public List<Numero> getListeNumeros() {
        return numeroDAO.getNumeroByExpert(getExpertConnecte());
    }
        
    public void evaluerNumero(Numero numero, String commentaire, int note) {
        Evaluation eval = new Evaluation(getExpertConnecte().getId(), numero.getID(), commentaire, note);
        evaluationDAO.insert(eval, numero, getExpertConnecte());
    }
   
}
