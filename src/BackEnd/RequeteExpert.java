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
    Getter bj;
    public RequeteExpert(){
        ResultSet b = bj.request(s);
        //il faut analyser le ResultSet
    }
}
