/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.GesProgrammeController;
import Model.Spectacle;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    private void afficherListeSpectacle() {
        List<Spectacle> spectacles;
        try {
            //TODO on a un problème une exception levée par la requête
            spectacles = controller.getAllSpectacles();
            int count=0;
            for (Spectacle sp : spectacles) {
                count++;
                /*
                StringBuilder sb =new StringBuilder();
                sb.append(((Integer)count).toString());
                sb.append(". ");
                sb.append(sp);*/
                System.out.print(count + ". ");
                System.out.print(sp);
            }
            
            System.out.println("0. Quitter");
            System.out.println("----------------------------------------");

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Aucun spectacle n'est programmé");
        }
    }
}
