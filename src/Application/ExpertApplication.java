/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Model.Business.Factory;
import java.util.Scanner;
import Controller.ExpertViewController;
import Model.Business.Numero;
import View.ExpertConsole;
import java.util.Iterator;
/**
 * Exécutable de saisie des évaluations: un expert se connecte, chosit un 
 * des numéros qu'il doit évaluer, saisi la note ainsi que le commentaire
 * @author nomezing
 */

public class ExpertApplication {
    
    public static void main(String[] args) {
        // crée un nouvelle console expert et lance le programme
        ExpertConsole ec = new ExpertConsole();
        ec.start();
    }    
}
