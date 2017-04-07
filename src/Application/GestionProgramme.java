/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Model.Business.Factory;
import BackEnd.ConnectionPacket;
import Model.Business.Spectacle;
import java.util.Collection;

/**
 *La classe pour gérer les programmes de façon globale :
 *          -Afficher le programme global du festival
 *          -Afficher le programme pour chaque spectacle
 * @author nabem
 */
public class GestionProgramme {  
    
    public  static void main(String args[]) {
        ConnectionPacket.openConnection(null, null, null);
        Collection<Spectacle> listeSpectacle = Factory.getDAO().getSpectacles();
        
        for(Spectacle s : listeSpectacle) {
            System.out.println(s.toString());
        }
        
        ConnectionPacket.closeConnection();
    }
}
