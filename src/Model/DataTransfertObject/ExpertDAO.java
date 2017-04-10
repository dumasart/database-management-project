/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataTransfertObject;

import Model.Expert;
import Model.Numero;
import java.util.List;

/**
 *
 * @author romain
 */
public interface ExpertDAO {
    public boolean update(Expert expert);
    public boolean insert(Expert expert);
    public boolean delete(Expert expert);
    
    //TODO voir commentaire dans ExpertDAOSQL
    public List<Expert> getExpertsAvailable(List<Expert> listeExperts);

    /* Méthode pour récupérer un Expert à partir de sont numéro artiste */
    public Expert getExpertByID(int codeArtiste);
    
}
