/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.Factory;
import Model.Business.Numero;
import Model.DataAccessLayer.DAO;

import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author nomezing
 */
public class ExpertViewController implements Initializable {

    @FXML
    ListView<String> listeNumero;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> l = FXCollections.observableArrayList("toto","tutu","tata");
        listeNumero.setItems(l);
        // TODO
    }    
    
    
    private Collection<Numero> listeNumeros;
    
    public ExpertViewController() {
        DAO dao = Factory.getDAO();
        this.listeNumeros = dao.getNumerosPourEvaluer();
    }
    
    public Iterator<Numero> getNumerosIterator() {
        if (this.listeNumeros != null) {
            return this.listeNumeros.iterator();
        }
        return null;
    }
    
    public void commentaire(int codeNum, String com) {
        DAO dao = Factory.getDAO();
        dao.ajouteCommentairePourNumero(codeNum, com);
    }
    
    public void ajouteNote(int codeNum, int note) {
        DAO dao = Factory.getDAO();
        dao.ajouteNotePourNumero(codeNum, note);
    }
    
    public void valideNumero(int codeNum) {
        // TODO
    }
}
