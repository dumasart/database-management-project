/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ExpertConsoleController;
import Model.Business.Numero;
import Model.Business.User;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author nomezing
 */
public class ExpertConsole {
    
    
    private ExpertConsoleController controller;
    private Scanner terminalInput;
    
    /**
     * Constructeur
     * Initialise le controlleur de vue et lez scanner utilisé pour la saisie
     * utilisateur
     */
    public ExpertConsole() {
        controller = new ExpertConsoleController();
        this.terminalInput = new Scanner(System.in);
    }
    
    
    /**
     * Méthode pour démarrer l'application Expert
     */
    public void start() {
        // affiche la bannière
        mainHeader();
        //TODO gérer l'authentification
        //LoginConsole loginConsole = new LoginConsole();
        //User user = loginConsole.readLoginAndPassword();
        while (true) {
            int choisi = choixNumero();
            if ( choisi == -1 ) {
                System.exit(0);
            } else {
                evaluerNumero(choisi);
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
     * @return le code numéro du Numero selectionné
     */
    private int choixNumero() {
        System.out.println("");
        Iterator<Numero> it = controller.getNumerosIterator();
        int count = 0;

        if (it != null && it.hasNext()) {
            count = listerLesNumeros(count, it);
            int choice = lireEntier(0, count);
            // TODO 
            /* vérifier que le code numéro correspond bien au numero selectionné 
                car a priori l'iterateur ne garantie pas la correspondance entre 
                l'ordre d'iteration et l'index dans la collection */
            return controller.getIDNumero(choice-1);

        } else {
            System.out.println("Vous n'avez aucun numéro à évaluer\n");
            return -1;
        }
    }

    
    /**
     * Méthode d'affichage pour lister les numéros à évaluer
     * avec une numerotation pour que le choix d'utilisateur
     * @param count
     * @param it
     * @return 
     */
    private int listerLesNumeros(int count, Iterator<Numero> it) {
        do {
            count++;
            Numero num = it.next();
            //TODO vérifier le résultat de l'affichage
            System.out.println(count + ". " + num);
        } while (it.hasNext());
        System.out.println("0. Quitter");
        System.out.println("----------------------------------------");
        return count;
    }

    
    /**
     * 
     * @param min
     * @param max
     * @return 
     */
    private int lireEntier(int min, int max) {
        int saisie;

        while (true) {
            System.out.print("Choisissez un numero entre "+min+ " et "+ max + " : ");
            saisie = Integer.parseInt(terminalInput.nextLine());
            if (saisie >=min && saisie <= max) {
                return saisie;
            } else {
                System.out.print("Choix incorrect. ");
            }
        }
    }

    
    /**
     * 
     * @param IDNumero 
     */
    private void evaluerNumero(int IDNumero) {
        //TODO vérifier que la plage d'entier pour la note est bonne
        
        System.out.print("Saisir une note pour ce numero : ");
        int note = lireEntier(0, 10);

        //TODO vérifier la taille maximale d'un commentaire
        System.out.printf("Saisir le commentaire pour ce numero");
        String cmt = terminalInput.nextLine();

        /* demande confirmation à l'utilisateur avant d'enregistrer l'évaluation */
        System.out.println("Vous avez saisi l'évaluation suivante ");
        System.out.println("Note : "+note+"/10");
        System.out.println("Commentaire : " + cmt+"\n");
        System.out.print("Tapez 1 pour enregistrer votre évaluation, ou 0 pour annuler : ");
        int confirme = lireEntier(0,1);
        
        if (confirme == 1) {
            controller.ajouteNote(IDNumero, note);
            controller.commentaire(IDNumero, cmt);           
        } else {
            System.out.println("Saisie d'évaluation annulée.");
        }
    }
}
