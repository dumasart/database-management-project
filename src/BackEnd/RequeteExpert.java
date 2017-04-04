/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.sql.ResultSet;

/**
 *
 * @author Geoffrey b2o
 */
public class RequeteExpert extends Requete{
    String s = "SELECT * FROM ArtisteExpert";
    public ResultSet getNumeros(){
        ResultSet b = Getter.request(s);
        //il faut analyser le ResultSet et renvoyer je ne sais quoi?
        return null;
    }
}
