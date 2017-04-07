/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Model.Business.Spectacle;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author milang
 */
public class ResultatsSpectacles extends ResultatRequete{
    private LinkedList<Spectacle> spectacles;

    ResultatsSpectacles() {
        this.spectacles = new LinkedList<Spectacle>();
    }
   
    
    public Collection<Spectacle> getSpectacles() {
        return this.spectacles;
    }
    
    // TO COMPLETE
}
