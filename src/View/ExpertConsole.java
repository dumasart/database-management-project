/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ExpertConsoleController;
import Model.Numero;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nomezing
 */
public class ExpertConsole {
    
    
    private final ExpertConsoleController controller = new ExpertConsoleController();
    private final Scanner terminalInput = new Scanner(System.in);
    

    
    /**
     * Méthode pour démarrer l'application Expert
     */
    public void start() {
        // affiche la bannière
        mainHeader();
        // procédure de connection
        LoginConsole loginConsole = new LoginConsole();
        boolean identifyed;
        do {
            identifyed = loginConsole.readLoginAndPassword();
        } while (!identifyed);
        
        /* un fois connecté on execute le programme tant
            que l'utilisateur ne quitte pas */
        while (true) {
            Numero choisi = choixNumero();
            if ( choisi == null ) {
                System.exit(0);
            } else {
                saisirEvaluation(choisi);
            }
        }
    }
    
    
    /**
     * Fonction pour afficher un bannière au démarrage du programme
     */
    private void mainHeader() {
        System.out.println( "***************************************************************\n" +
                            "*        █████ █████  ████ █████ █ █   █  ███  █              *\n" +
                            "*        █     █     █       █   █ █   █ █   █ █              *\n" +
                            "*        ███   ███    ███    █   █ █   █ █████ █              *\n" +
                            "*        █     █         █   █   █  █ █  █   █ █              *\n" +
                            "*        █     █████ ████    █   █   █   █   █ █████          *\n" +
                            "*                                                             *\n" +
                            "*                       ████  █    █                          *\n" +
                            "*                       █   █ █    █                          *\n" +
                            "*                       █   █ █    █                          *\n" +
                            "*                       █   █ █    █                          *\n" +
                            "*                       ████   ████                           *\n" +
                            "*                                                             *\n" +
                            "*              ████ █ ████   ███  █    █ █████                *\n" +
                            "*             █     █ █   █ █   █ █    █ █                    *\n" +
                            "*             █     █ ████  █   █ █    █ ███                  *\n" +
                            "*             █     █ █   █ █ ▄ █ █    █ █                    *\n" +
                            "*              ████ █ █   █  ███   ████  █████                *\n" +
                            "*                              ▀                              *\n" +
                            "***************************************************************\n" +
                            "*     Application de saisie d'évaluations pour les expert     *\n" +
                            "***************************************************************\n" +
                            "* _|_  _   _. ._ _     _  _   _ ._ _   _  ._   _  | o _|_  _  *\n" +
                            "*  |_ (/_ (_| | | |   (_ (_) _> | | | (_) |_) (_) | |  |_ (/_ *\n" +
                            "*                                         |                   *\n" +
                            "***************************************************************\n"
        );
        
    }
   
    
    /**
     * Méthode pour choisir le numéro que l'expert va évaluer
     * @return le numéro du Numero selectionné
     */
    private Numero choixNumero() {
        System.out.println("");
        List<Numero> list = controller.getListeNumeros();
       
        if (list != null && !list.isEmpty()) {
            afficherlisteNumeros(list);
            int choice = Utils.lireEntier(0, list.size());

            return list.get(choice-1);
        } else {
            System.out.println("Vous n'avez aucun numéro à évaluer\n");
            return null;
        }
    }

    
    /**
     * Méthode d'affichage pour lister les numéros à évaluer
     * avec une numerotation pour que le choix d'utilisateur
     * @param count
     * @param it
     * @return 
     */
    private void afficherlisteNumeros(List<Numero> list) {
        int count=0;
        for(Numero num : list) {
            count++;
            System.out.println(count + ". " + num);
        }
        System.out.println("0. Quitter");
        System.out.println("----------------------------------------");
    }

    


    
    /**
     * Méthode pour saisir une évaluation pour un numero donné
     * @param numero le numero à évaluer
     */
    private void saisirEvaluation(Numero numero) {
        //TODO vérifier que la plage d'entier pour la note est cohérente par 
        // rapport à la base de données
        
        System.out.print("Saisir une note pour ce numero : ");
        int note = Utils.lireEntier(0, 10);

        //TODO vérifier la taille maximale d'un commentaire
        System.out.printf("Saisir le commentaire pour ce numero");
        String cmt = terminalInput.nextLine();

        /* demande confirmation à l'utilisateur avant d'enregistrer l'évaluation */
        System.out.println("Vous avez saisi l'évaluation suivante ");
        System.out.println("Note : "+note+"/10");
        System.out.println("Commentaire : " + cmt + "\n");
        System.out.print("Tapez 1 pour enregistrer votre évaluation, ou 0 pour annuler : ");
        int confirme = Utils.lireEntier(0,1);
        
        if (confirme == 1) {
            controller.evaluerNumero(numero, cmt, note);
        } else {
            System.out.println("Saisie d'évaluation annulée.");
        }
    }
}
