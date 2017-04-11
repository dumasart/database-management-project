/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataAccessLayer.ConnectionSQL;
import Model.Numero;
import Model.DataTransfertObject.EvaluationDAO;
import Model.DataTransfertObject.EvaluationDAOSQL;
import Model.DataTransfertObject.ExpertDAO;
import Model.DataTransfertObject.ExpertDAOSQL;
import Model.DataTransfertObject.NumeroDAO;
import Model.DataTransfertObject.NumeroDAOSQL;
import Model.Evaluation;
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
    NumeroDAO numeroDAO = new NumeroDAOSQL();
    
    /**
     * EvaluationDAO utilisé par le controleur expert pour 
     * ajouter des commentaires dans la base de données
     */
    EvaluationDAO evaluationDAO = new EvaluationDAOSQL();  
     
    /**
     * L'expert qui s'est connecté à l'application 
     */
    ExpertDAO expertDAO = new ExpertDAOSQL();
    
    
    /**
     * 
     * @return 
     */
    public List<Numero> getListeNumeros() {
        if (getConnectedUser() != null) {
            return numeroDAO.getNumeroNonEvalueByExpertID(getConnectedUser().getIdentifiant());
        } else {
            System.out.println("user est null");
        }
        return null;
    }
        
    public void evaluerNumero(Numero numero, String commentaire, int note) {
        Evaluation eval = new Evaluation(Integer.parseInt(getConnectedUser().getIdentifiant())
                , numero.getID(), commentaire, note);
        assert(eval!=null);
        
        ConnectionSQL.savePoint();
        //TODO vérifier la requête derière cet appel car ne semble pas fonctionner
        evaluationDAO.insert(eval, numero, getConnectedUser().getIdentifiant());
        ConnectionSQL.commit();
    }
   
}
