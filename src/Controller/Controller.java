/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 * Classe abstraite qui permet de définir un controlleur parent pour les 
 * controleurs de l'interface graphique
 * L'accès au controleur parent permet de gérer le changement d'affichage sur
 * la fentre principale (mère ou racine). Ainsi on change uniquement une partie
 * de la fenêtre plutôt que d'utiliser des pop-up ou de recharger entièrement 
 * le contenu de la fenetre.
 * @author nomezing
 */
abstract class Controller {
    
    //
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
