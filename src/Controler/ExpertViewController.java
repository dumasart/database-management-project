/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Business.Numero;
import Model.DataAccessLayer.DAO;

import java.net.URL;
import java.util.Collection;
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
class ExpertViewController implements Initializable {

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
    
    //public ExpertViewControler() {
    //    this.listeNumeros = nums;
    //}
    
    public void commentaire(int codeNum, String com) {
        DAO dao = new DAO();
        dao.ajouteCommentairePourNumero(codeNum, com);
    }
    
    public void ajouteNote(int codeNum, int note) {
        DAO dao = new DAO();
        dao.ajouteNotePourNumero(codeNum, note);
    }
    
    public void valideNumero(int codeNum) {
        // TODO
    }
    
    public void afficheNumeros() {
        //
    }
}
