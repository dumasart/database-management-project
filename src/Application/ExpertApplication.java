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
import Model.Business.User;
import java.util.Iterator;
/**
 * Exécutable de saisie des évaluations: un expert se connecte, chosit un 
 * des numéros qu'il doit évaluer, saisi la note ainsi que le commentaire
 * @author nomezing
 */

public class ExpertApplication {
    
    public static void main(String[] args) {
        Scanner terminalInput = new Scanner(System.in);

        while (Factory.getUser() == null) {    
            System.out.printf("ID: ");
            String username = terminalInput.nextLine();
            System.out.printf("Password: ");
            String password = terminalInput.nextLine();
            User user = Factory.getDAO().getUserByUserNameAndPassword(username, password);
            Factory.setUser(user);
        }
        
        ExpertViewController expCtrl = new ExpertViewController();
        
        
        System.out.println("---------------------------------------");
        Iterator<Numero> it = expCtrl.getNumerosIterator();
        if (it != null) {
            while (it.hasNext()) {
                Numero num = it.next();
                System.out.println(num);
            }

            int cond = 0;

            while (cond == 0) {
                System.out.printf("Choix le numero pour saisir des evalutations");

                int code = terminalInput.nextInt();

                System.out.printf("Saisir l'évaluation pour ce numero");

                int note = terminalInput.nextInt();

                expCtrl.ajouteNote(code, note);
                
                System.out.printf("Saisir le commentaire pour ce numero");
                
                String cmt = terminalInput.nextLine();
                
                expCtrl.commentaire(code, cmt);

                System.out.printf("Saisir 1 pour continuer, 0 pour quitter:");

                cond = terminalInput.nextInt();
            }
        }
    }
    
}
