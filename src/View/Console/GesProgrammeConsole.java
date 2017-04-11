/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Console;

import Controller.GesProgrammeController;
import Model.Expert;
import Model.Numero;
import Model.Spectacle;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nomezing
 */
public class GesProgrammeConsole {
    
    private final GesProgrammeController controller = new GesProgrammeController();
    private final Scanner terminalInput = new Scanner(System.in);
    
    
    public void start() {
        // affiche la bannière d'accueil
        mainHeader();
        // pas d'authentification nécéssaire
        // affiche le programme du festival
        afficherListeSpectacle();
        //TODO ++
        /*debug de cette partie car au moins 3 exceptions sont levés et non traitées*/
        //afficherListeNumeroDesSpectacles();
        //afficherPlanDesNumerosAEvaluer();
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
                            "*             Application d'édition de programmes             *\n" +
                            "***************************************************************\n" +
                            "* _|_  _   _. ._ _     _  _   _ ._ _   _  ._   _  | o _|_  _  *\n" +
                            "*  |_ (/_ (_| | | |   (_ (_) _> | | | (_) |_) (_) | |  |_ (/_ *\n" +
                            "*                                         |                   *\n" +
                            "***************************************************************\n"
        );
        
    }

    /**
     * Méthode pour afficher la liste des spectacles du festival
     * ( Prévue à la base pour choisir un spectacle pour lequel on veut afficher les numéros)
     */
    private void afficherListeSpectacle() {
        List<Spectacle> spectacles;
        
        spectacles = controller.getAllSpectacles();
        
        if (spectacles != null) {
            int count=0;
            for (Spectacle sp : spectacles) {
                count++;
                StringBuilder sb =new StringBuilder();
                sb.append(count).append(". ").append(sp);
                System.out.print(sb);
            }

            System.out.println("0. Quitter");
            System.out.println("----------------------------------------");
        } else {
            System.out.println("Aucun spectacle n'est programmé");
        }
    }
    
    private void afficherListeNumeroDesSpectacles() {
        List<Spectacle> spectacles;
        
        System.out.println("Affichage du programme des Spectacles");
        try {
            spectacles = controller.getAllSpectacles(); //recuperer la liste des spectacles
            int i = 1;
            
            for(Spectacle spec : spectacles) {
                List<Numero> numerosDuSpectacle = controller.getNumerosBySpectacle(spec); //recuperer liste des numeros par spectacle
                for(Numero num : numerosDuSpectacle) {
                    System.out.println(i);
                    System.out.println(num.toString());
                    i++;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Pas de spectacle");
        }
    }
    
    private void afficherPlanDesNumerosAEvaluer() {
        List<Numero> numerosAEvaluer = controller.getNumerosAEvaluer();
        
        List<Expert> exps;
        
        
        int size = numerosAEvaluer.size();
        int numerosParJour = size / 2;
        List<Numero> listJ_1 = null;
        List<Numero> listJ_2 = numerosAEvaluer.subList(0, numerosParJour);
        
        if (size > 1) {
            listJ_1 = numerosAEvaluer.subList(numerosParJour + 1, size - 1);
        }
        
        if (!listJ_2.isEmpty()) {
            System.out.println("Affichage la planification des numéros à évaluer");
            System.out.println("\tDeux jours avant le Festival:");
            for (Numero n : listJ_2) {
                exps = controller.getExpertsNePasEvaluerNumero(n.getID());
                System.out.println("\t\tNuméro: " + n.getID() + " a besoin d'être évaluer par les experts: ");
                for (Expert e : exps) {
                    System.out.println("\t\t\tExpertID: " + e.getID() + " Nom: " + e.getNom() + " Prénom: " + e.getPrenom());
                }
            }
        }
        
        if (!listJ_1.isEmpty()) {
            System.out.println("\tUn jour avant le Festival");
            for (Numero n : listJ_1) {
                exps = controller.getExpertsNePasEvaluerNumero(n.getID());
                System.out.println("\t\tNuméro: " + n.getID() + " a besoin d'être évaluer par les experts: ");
                for (Expert e : exps) {
                    System.out.println("\t\t\tExpertID: " + e.getID() + " Nom: " + e.getNom() + " Prénom: " + e.getPrenom());
                }
            }
        }
        
    }
}
