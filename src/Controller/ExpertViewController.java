/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Business.Factory;
import Model.Business.Numero;
import Model.DataAccessLayer.DAO;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


public class ExpertViewController extends Controller implements Initializable {

    private Collection<Numero> listeNumeros;
    
    /*          __
              .'  '.
             | STOP |
              '.__.'
                ||
                ||
                ||
              \\||///
           ^^^^^^^^^^^^^
    Ne pas décommenter le constructeur, car il n'est pas possible d'avoir 
    un constructeur dans un controleur javafx (en gros ça fait planter ma belle 
    application graphique) il faudrait faire un héritage pour mettre les méthodes
    communes, entre l'application console et graphique, dans une classe mère 
    mais pour l'instant le soucis c'est que ce controleur hérite déjà de quelqu'un
     et en java on peut pas faire d'héritage multiple!!! dès que j'ai la solution 
    je lui règle son compte
    */
    
    /*
    public ExpertViewController() {
        updateData();
    }
    */
    
    public Iterator<Numero> getNumerosIterator() {
        if (this.listeNumeros != null) {
            return this.listeNumeros.iterator();
        }
        return null;
    }
    
    public void commentaire(int codeNum, String com) {
        DAO dao = Factory.getDAO();
        dao.ajouteCommentairePourNumero(codeNum, com);
        updateData();
    }
    
    public void ajouteNote(int codeNum, int note) {
        DAO dao = Factory.getDAO();
        dao.ajouteNotePourNumero(codeNum, note);
        updateData();
    }
    
    public void valideNumero(int codeNum) {
        // TODO
    }
    
    public void updateData() {
        DAO dao = Factory.getDAO();
        this.listeNumeros = dao.getNumerosPourEvaluer();
    }
    
    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}