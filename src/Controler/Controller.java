/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

/**
 *
 * @author nomezing
 */
abstract class Controller {
    
    private Controller mainControler;
    
    /**
     * 
     * @param parent 
     */
    public void initOwner(MainWindowController parent) {
        this.mainControler=parent;
    }
    
    /**
     * 
     * @return 
     */
    Controller getMainControler() {
        return this.mainControler;
    }
}
